Let’s now make this **Docker Compose setup** launch both your **Spring Boot SOAP service (port 8080)** and **Ngrok tunnel**, so you can expose your local SOAP WSDL (`http://localhost:8080/ws/employees.wsdl`) to the internet securely.

```yaml
version: "3.9"

services:
  dsniper-employee-service:
    build:
      context: .
      dockerfile: Dockerfile
    container_name: dsniper-employee-soap
    ports:
      - "8080:8080"
    environment:
      - SERVER_PORT=8080
    networks:
      - soap_net
    healthcheck:
      test: ["CMD", "curl", "-f", "http://localhost:8080/ws/employees.wsdl"]
      interval: 15s
      timeout: 5s
      retries: 5
      start_period: 15s

  ngrok:
    image: ngrok/ngrok:latest
    container_name: dsniper-ngrok
    depends_on:
      dsniper-employee-service:
        condition: service_healthy
    restart: unless-stopped
    networks:
      - soap_net
    ports:
      - "4040:4040"   # Ngrok web inspector
    entrypoint:
      - /bin/sh
      - -c
      - |
        cat <<EOF > /tmp/ngrok.yml
        version: 2
        tunnels:
          soap:
            proto: http
            addr: dsniper-employee-soap:8080
            domain: peaceful-eagle-ai.ngrok-free.app
        EOF
        ngrok start --all --config /tmp/ngrok.yml --authtoken YOUR_NGROK_AUTHTOKEN_HERE

networks:
  soap_net:
    driver: bridge
```

---

### 🧩 Step-by-step usage guide

#### 1️⃣ Create a `Dockerfile` for your Spring Boot app

In the same project root (where your `pom.xml` is), create:

```dockerfile
# ===== Dockerfile =====
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/dsniper-employee-soap-service-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Then build your JAR:

```bash
  mvn clean package -DskipTests
```

---

#### 2️⃣ Start everything:

```bash
  docker-compose up --build
```

* This builds your Spring Boot SOAP service image.
* Runs it on port `8080` inside the Docker network.
* Once healthy, **Ngrok** will tunnel your local service to a public domain like:

  ```
  https://peaceful-eagle-ai-or-what-you-get.ngrok-free.app/ws/employees.wsdl
  ```

---

#### 3️⃣ Access your service:

* Local access → [http://localhost:8080/ws/employees.wsdl](http://localhost:8080/ws/employees.wsdl)
* Public access → your Ngrok domain (as above).
* Ngrok inspector → [http://localhost:4040](http://localhost:4040)

---

#### 4️⃣ Replace token & domain

In the `ngrok` service section:

```yaml
--authtoken YOUR_NGROK_AUTHTOKEN_HERE
domain: peaceful-eagle-ai-or-what-you-get.ngrok-free.app
```

➡ Replace with your **own authtoken** from [https://dashboard.ngrok.com](https://dashboard.ngrok.com) and set your own reserved subdomain if available.

---

#### 5️⃣ Verify everything is working

Run:

```bash
  curl http://localhost:8080/ws/employees.wsdl
```

Then:

```bash
  curl https://peaceful-eagle-ai.ngrok-free.app/ws/employees.wsdl
```

You should see the same XML WSDL output — that means your SOAP service is live on the internet 🎯

---

#### ✅ Bonus: Add .dockerignore

To keep your image light:

```bash
  target/
 .git/
 *.log
 *.md
```

---

```markdown
# 🧠 Synapse: Employee SOAP Service

> A fully functional **Spring Boot SOAP Web Service** built for learning, testing, and seamless integration with **Appian** or other low-code platforms.

---

## 🚀 Overview

**Synapse - Employee SOAP Service** provides a **complete SOAP API** to manage employees, handle file uploads/downloads, and demonstrate enterprise-ready SOAP architecture.  
It’s built to help **developers**, **Appian consultants**, and **integration engineers** gain hands-on experience with XML-based SOAP calls that can plug into any enterprise ecosystem.

---

## 🧩 Features

✅ Built with **Spring Boot + Spring Web Services (Spring-WS)**  
✅ Pure **XML-based SOAP** communication  
✅ **CRUD operations** for Employees  
✅ **Base64 file upload/download**  
✅ **Property-driven configuration** for flexibility  
✅ Designed for **Appian and external system integration**  
✅ Future-ready for **DB integration** and **CI/CD setup**

---

## 🗂 Project Structure

Synapse/
│── pom.xml
│
├── src/main/java/com/dsniper/employee/service/
│   │── EmployeeSoapServiceApplication.java
│   │── config/WebServiceConfig.java
│   │── endpoint/EmployeeEndpoint.java
│   │── model/Employee.java
│   │── service/EmployeeService.java
│   └── util/Base64Util.java
│
├── src/main/resources/
│   │── application.properties
│   └── employee.xsd


---

## ⚙️ Prerequisites

| Tool                 | Version | Purpose |
|----------------------|----------|----------|
| ☕ Java              | 8+       | Run the Spring Boot app |
| 🧱 Maven             | 3.6+     | Build and manage dependencies |
| 🧰 SoapUI / Postman  | Latest   | Test SOAP requests |
| 💾 curl / PowerShell | —        | CLI testing |

---

## 🛠 Configuration

Edit `src/main/resources/application.properties` as per your setup:

```properties
server.port=8080
soap.uri=/ws
employee.namespace=http://example.com/employee/ws
file.storage.location=./filestore
wsdl.portTypeName=EmployeeServicePort
wsdl.serviceName=EmployeeService
wsdl.locationUri=/ws
````

🟢 **Tip:** You can change `server.port` or `file.storage.location` anytime — the app auto-picks it up without recompilation.

---

## 🏗️ Build Lifecycle Commands

| Stage      | Description          | Command               |
| ---------- | -------------------- | --------------------- |
| 🧹 Clean   | Remove target folder | `mvn clean`           |
| ⚙️ Compile | Compile Java classes | `mvn compile`         |
| 🧪 Test    | Run unit tests       | `mvn test`            |
| 📦 Package | Create JAR           | `mvn package`         |
| 🚀 Run     | Start app            | `mvn spring-boot:run` |
| 🧩 Install | Install locally      | `mvn install`         |

---

## ▶ Quick Start

```bash
git clone https://github.com/DSniper/Synapse.git
cd Synapse
mvn clean install
mvn spring-boot:run
```

Or run directly:

```bash
java -jar target/synapse-employee-soap-service-1.0.0.jar
```

---

## 🌐 Endpoints & WSDL

| Description      | URL                                       |
| ---------------- | ----------------------------------------- |
| 🧾 WSDL          | `http://localhost:8080/ws/employees.wsdl` |
| 💬 SOAP Endpoint | `http://localhost:8080/ws`                |

**Namespace:**
`http://example.com/employee/ws`

---

## 🧪 Sample SOAP Requests

Use header:
`Content-Type: text/xml; charset=utf-8`

All calls go inside the standard SOAP envelope:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://example.com/employee/ws">
  <soapenv:Header/>
  <soapenv:Body>
    <!-- Your request body -->
  </soapenv:Body>
</soapenv:Envelope>
```

---

### 1️⃣ Get Employee Details

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://example.com/employee/ws">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:getEmployeeDetailsRequest>
      <ws:id>1</ws:id>
    </ws:getEmployeeDetailsRequest>
  </soapenv:Body>
</soapenv:Envelope>
```

---

### 2️⃣ Add Employee

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://example.com/employee/ws">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:addEmployeeRequest>
      <ws:id>3</ws:id>
      <ws:name>Rohit</ws:name>
      <ws:designation>Tester</ws:designation>
      <ws:salary>45000</ws:salary>
    </ws:addEmployeeRequest>
  </soapenv:Body>
</soapenv:Envelope>
```

---

### 3️⃣ Update Employee

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://example.com/employee/ws">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:updateEmployeeRequest>
      <ws:id>3</ws:id>
      <ws:name>Rohit</ws:name>
      <ws:designation>Senior Tester</ws:designation>
      <ws:salary>50000</ws:salary>
    </ws:updateEmployeeRequest>
  </soapenv:Body>
</soapenv:Envelope>
```

---

### 4️⃣ Delete Employee

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://example.com/employee/ws">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:deleteEmployeeRequest>
      <ws:id>3</ws:id>
    </ws:deleteEmployeeRequest>
  </soapenv:Body>
</soapenv:Envelope>
```

---

### 5️⃣ Upload Document (Base64)

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://example.com/employee/ws">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:uploadDocumentRequest>
      <ws:empId>1</ws:empId>
      <ws:fileName>resume.pdf</ws:fileName>
      <ws:fileContent>JVBERi0xLjQKJeLjz9MNCjEgMCBvYmoK...</ws:fileContent>
    </ws:uploadDocumentRequest>
  </soapenv:Body>
</soapenv:Envelope>
```

---

### 6️⃣ Download Document

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://example.com/employee/ws">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:downloadDocumentRequest>
      <ws:empId>1</ws:empId>
      <ws:fileName>resume.pdf</ws:fileName>
    </ws:downloadDocumentRequest>
  </soapenv:Body>
</soapenv:Envelope>
```

---

## 🧮 Test via curl

```bash
curl -X POST http://localhost:8080/ws \
     -H "Content-Type: text/xml" \
     -d @getEmployee.xml
```

---

## 🧠 Appian Integration

1. In Appian → **Connected Systems → Web Service**
2. Import WSDL:
   `http://<your-server>:8080/ws/employees.wsdl`
3. Appian auto-creates smart services for each SOAP operation.
4. Map the request & response data models.

---

## 🪶 File Storage

Files are stored under:

```
./filestore
```

Naming pattern:
`<employeeId>_<originalFileName>`

---

## 🧩 Troubleshooting

| Issue                            | Fix                                                       |
| -------------------------------- | --------------------------------------------------------- |
| ❌ `javax.servlet does not exist` | Add `javax.servlet-api` dependency (scope: provided)      |
| 🔁 Duplicate dependency warning  | Remove duplicate `spring-boot-starter-web-services` entry |
| ⚠️ Port 8080 busy                | Change `server.port`                                      |
| 📄 WSDL not found                | Verify `/ws/employees.wsdl` and ensure app is running     |
| 🧱 Upload failure                | Check permissions for `./filestore`                       |

---

## 🧭 Future Roadmap

| Phase       | Description                                           |
| ----------- | ----------------------------------------------------- |
| **Phase 2** | Integrate MySQL/PostgreSQL using Spring Data JPA      |
| **Phase 3** | Add structured XML logging and exception handling     |
| **Phase 4** | Add WS-Security and Basic Auth                        |
| **Phase 5** | Dockerize the service and add CI/CD pipeline          |
| **Phase 6** | Build REST wrapper over SOAP for hybrid APIs          |
| **Phase 7** | Connect to Appian via plug-ins or integration objects |

---

## ⚙️ Common Git Commands

| Action        | Command                                                 |
| ------------- | ------------------------------------------------------- |
| Clone repo    | `git clone <repo_url>`                                  |
| Pull latest   | `git pull origin main --rebase`                         |
| Stage changes | `git add .`                                             |
| Commit        | `git commit -m "Updated Employee service"`              |
| Push          | `git push origin main`                                  |
| Fix conflicts | `git merge --abort` → resolve → `git rebase --continue` |
| Tag           | `git tag v1.0` & `git push origin v1.0`                 |

---

## 💡 Author

**Buddy (a.k.a Daisy Singh)**
💼 *Lead Consultant | Appian & AI Innovator*
💬 *"Code lean, integrate clean."*
🌐 [GitHub: DSniper](https://github.com/DSniper)

---

## ⚖️ License

🪪 **Custom Restricted License**

This project is open for:

* ✅ Personal & educational use
* ✅ Contributions (PRs welcome)
* ❌ Commercial usage without permission

For commercial licensing or integrations, you can contact the author directly.

---

```

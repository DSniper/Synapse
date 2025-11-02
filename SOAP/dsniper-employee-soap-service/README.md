```markdown
# 🧠 dsniper-employee-soap-service

> A fully functional **Spring Boot SOAP Web Service** built for learning, testing, and integration with **Appian** or other low-code platforms.

---

## 🚀 Overview

This project provides a **complete SOAP API** to manage employees and handle file uploads/downloads, with an easy-to-configure setup via `application.properties`.

It’s ideal for:
- 🧩 **SOAP beginners**
- 🧑‍💻 **Appian developers**
- ⚙️ **Integration engineers**

Who want hands-on practice with **real XML-based SOAP calls** that integrate seamlessly with Appian or any external system.

---

## 🧩 Features

✅ Built with **Spring Boot + Spring Web Services (Spring-WS)**  
✅ Fully **XML-based SOAP** communication (no JSON)  
✅ **CRUD operations** for Employees  
✅ **File upload/download** using Base64  
✅ **Property-driven configuration** (port, WSDL URI, storage path, etc.)  
✅ Designed for **Appian integration**  

---

## 🗂 Project Structure

```

dsniper-employee-soap-service/
├── pom.xml
├── src/main/java/com/dsniper/employee/service/
│   ├── EmployeeSoapServiceApplication.java
│   ├── config/WebServiceConfig.java
│   ├── endpoint/EmployeeEndpoint.java  to build
│   ├── model/Employee.java
│   ├── service/EmployeeService.java
│   └── util/Base64Util.java  to build
└── src/main/resources/
├── application.properties
└── employee.xsd  

````

---

## ⚙️ Prerequisites

| Tool                 | Minimum Version | Purpose                         |
| -------------------- | --------------- | ------------------------------- |
| ☕ Java              | 8+              | Run the Spring Boot app         |
| 🧱 Maven             | 3.6+            | Build and dependency management |
| 🧰 SoapUI/Postman    | Latest          | Test SOAP requests              |
| 💾 curl / PowerShell | —               | Command-line testing            |

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

🟢 **Pro Tip:**
Change `server.port` or `file.storage.location` freely — the app auto-picks it up without recompilation.

---

## 🏗️ Build Lifecycle Commands

| Stage       | Description                    | Command               |
| ----------- | ------------------------------ | --------------------- |
| 🧹 Clean    | Deletes `target/` folder       | `mvn clean`           |
| 🔍 Validate | Checks for errors              | `mvn validate`        |
| ⚙️ Compile  | Compiles Java classes          | `mvn compile`         |
| 🧪 Test     | Runs JUnit tests               | `mvn test`            |
| 📦 Package  | Builds JAR                     | `mvn package`         |
| 🧩 Install  | Installs into local Maven repo | `mvn install`         |
| 🚀 Run      | Launches Spring Boot app       | `mvn spring-boot:run` |

---

## ▶ Quick Start

### Clone & Build

```bash
  git clone https://github.com/<your-username>/dsniper-employee-soap-service.git
cd dsniper-employee-soap-service
mvn clean install
```

### Run

```bash
mvn spring-boot:run
```

or directly via:

```bash
java -jar target/dsniper-employee-soap-service-1.0.0.jar
```

---

## 🌐 Endpoints & WSDL

| Description      | URL                                       |
| ---------------- | ----------------------------------------- |
| 🧾 WSDL          | `http://localhost:8080/ws/employees.wsdl` |
| 💬 SOAP Endpoint | `http://localhost:8080/ws`                |

🧩 **Namespace:**
`http://example.com/employee/ws`

---

## 🧪 Sample SOAP Requests

Use **Content-Type:**

```
text/xml; charset=utf-8
```

Wrap every call inside the standard SOAP envelope:

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

Decode Base64 → restore the file.

---

## 🧮 Test via curl

```bash
  curl -X POST http://localhost:8080/ws \
     -H "Content-Type: text/xml" \
     -d @getEmployee.xml
```

---

## ⚙️ Common Maven Fix Commands

If you face duplicate or missing dependency errors:

```bash
# Clean build artifacts
mvn clean

# Force dependency resolution
mvn dependency:purge-local-repository

# Verify dependency tree
mvn dependency:tree
```

> 🧩 Tip: Ensure only one `spring-boot-starter-web-services` dependency exists in your `pom.xml`.

---

## 🧠 Appian Integration Guide

1. In Appian → **Connected Systems → Web Service**
2. Import WSDL:
   `http://<your-server>:8080/ws/employees.wsdl`
3. Appian auto-creates smart services for each SOAP operation.
4. Map request & response to process variables.

---

## 🪶 File Storage

All uploaded files are saved in the directory:

```
./filestore
```

File naming pattern:

```
<employeeId>_<originalFileName>
```

---

## 🧩 Troubleshooting

| Issue                            | Fix                                                               |
| -------------------------------- | ----------------------------------------------------------------- |
| ❌ `javax.servlet does not exist` | Add `javax.servlet-api` dependency with `<scope>provided</scope>` |
| 🔁 Duplicate dependency warning  | Remove duplicate `spring-boot-starter-web-services` entry         |
| ⚠️ Port 8080 in use              | Edit `server.port` in `application.properties`                    |
| 📄 WSDL 404 error                | Ensure `/ws/employees.wsdl` exists and app is running             |
| 🧱 File upload failure           | Verify folder permissions for `./filestore`                       |

---

## 💡 Future Enhancements

* 🗄 Integrate with MySQL or PostgreSQL
* 🔒 Add WS-Security authentication
* 🧾 Generate Swagger-like docs for SOAP
* 📜 Include structured XML logging & audit trail

---

## 🧑‍💻 Author

**Buddy (a.k.a. Daisy)**
📘 *Lead Appian Consultant | Java & AI Innovator*
💬 *"Code lean, integrate clean."*



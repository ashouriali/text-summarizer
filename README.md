
---

# Text Summarizer

## **Overview**
A **Spring Boot** service for summarize texts, exposing:

**REST API** (documented via Swagger UI) <br />

---

## **Prerequisites**
Ensure these are installed before proceeding:

| Requirement    | Purpose                                   |  
|----------------|-------------------------------------------|  
| **Maven**      | Builds the project and manages dependencies |  
| **Docker**     | Runs the Mongo database container         |  
| **JDK/JRE 21** | Required to compile and run the application |  
| **Git**        | For cloning the repository                |  

---

## **Steps to Run the Project**

### **1. Set Up PostgreSQL Container**
Pull the Mongo db image

```
docker pull mongo
```
Run the container
```
docker run --name mongo-test \
-e MONGO_INITDB_ROOT_USERNAME=mongo_user \
-e MONGO_INITDB_ROOT_PASSWORD=123456 \
-e MONGO_INITDB_DATABASE=text_summarizer \
-p 27017:27017 \
-d mongo
```

### **2. Clone the project from github**
```
https://github.com/ashouriali/text-summarizer.git
```

### **3. Build the Project**
navigate to project directory
```
cd text-summarizer
```
build using Maven Wrapper (recommended)
```
./mvnw clean -DskipTests -B package
```

**💡 Why `mvnw`?**  
The Maven Wrapper ensures version compatibility—no need to install Maven separately!

### **4. Run the Application**
```
java -jar ./target/summarizer-0.0.1-SNAPSHOT.jar \
--spring.config.location=./src/main/resources/application.properties
```

---

## **Access Endpoints**
| Service               | URL                                      |  
|-----------------------|-----------------------------------------|  
| **REST API (Swagger)** | http://localhost:8080/swagger-ui/index.html |

---

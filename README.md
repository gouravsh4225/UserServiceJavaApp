# UserServiceJavaApp

A simple **Spring Boot** application for managing user operations like creating, retrieving, and listing users.

---

## 🚀 Features

- Create a new user
- Retrieve user details by ID
- Get a list of all users
- RESTful API structure
- Easy to extend and integrate

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Maven**
- **H2 Database** (in-memory, optional)

---

## 🧩 Project Structure

src/
 └── main/
     ├── java/
     │    └── com/
     │         └── example/
     │              └── userservice/
     │                   ├── controller/
     │                   ├── model/
     │                   ├── repository/
     │                   ├── service/
     │                   └── UserServiceJavaAppApplication.java
     └── resources/
          ├── application.properties



---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- Postman or curl (for testing APIs)

### Installation

Clone the repository:

```bash
git clone https://github.com/gouravsh4225/UserServiceJavaApp.git
cd UserServiceJavaApp


mvn clean install
mvn spring-boot:run

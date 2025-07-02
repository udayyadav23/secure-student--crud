🚀 Spring Boot CRUD App with Role-Based Access (MongoDB Atlas)
This project is a Spring Boot application that performs CRUD operations on MongoDB Atlas and implements role-based access control using Spring Security.

📌 Features
✅ Create, Read, Update, Delete (CRUD) operations

🔐 Role-based access (Admin, User, etc.)

🌍 MongoDB Atlas integration

⚙️ RESTful APIs with JSON

🔄 Basic Authentication or JWT (if added)

🛠️ Tech Stack
Java 17+

Spring Boot

Spring Security

Spring Data MongoDB

MongoDB Atlas

Maven

📁 Project Structure
src
├── main
│   ├── java
│   │   └── com.example.crudapp
│   │       ├── controller
│   │       ├── entity
│   │       ├── repository
│   │       ├── service
│   │       └── config/security
│   └── resources
│       └── application.properties
└── test
🔐 Roles Example
Admin: Full access to all CRUD operations

User: Restricted access (e.g., read-only or create)

⚙️ Setup Instructions
1. Clone the Repository
git clone https://github.com/udayyadav23/springboot-crud-role-based.git
cd springboot-crud-role-based
2. Set MongoDB URI
src/main/resources/application.properties:
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<dbname>?retryWrites=true&w=majority
spring.data.mongodb.database=<dbname>
3. Build and Run
bash
Copy
Edit
mvn clean install
mvn spring-boot:run
📬 Sample API Endpoints
Method	Endpoint	Role Access	Description
GET	/api/users	Admin	Get all users
POST	/api/users	Admin	Create user
GET	/api/users/{id}	Admin/User	Get user by ID
PUT	/api/users/{id}	Admin	Update user
DELETE	/api/users/{id}	Admin	Delete user

🧪 Testing
You can test APIs using Postman or curl

Make sure you authenticate with proper credentials for role-based access



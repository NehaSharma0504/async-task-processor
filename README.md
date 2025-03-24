# async-task-processor
🚀 Asynchronous Data Processing Pipeline
This project is a backend application built using Java (Spring Boot) that handles asynchronous task processing. It simulates a system where tasks are submitted, processed asynchronously, and their status can be queried.

📚 Table of Contents
Project Overview

Features

Prerequisites

Getting Started

API Endpoints

Database Setup

Running the Application

Unit Tests

Optional: RabbitMQ/Kafka Integration

Troubleshooting

🎯 Project Overview
This application provides RESTful APIs to:

Submit tasks with a name and a payload.

Retrieve a list of all submitted tasks.

Retrieve the status of a task by its unique ID.

Process tasks asynchronously and update their status.

✨ Features
Asynchronous Processing: Tasks are processed asynchronously to simulate time-consuming operations.

Task Status Management: Status is updated from PENDING → PROCESSING → COMPLETED or FAILED.

Database Persistence: Task metadata is stored in a relational database (PostgreSQL/MySQL).

Error Handling: Tasks that fail during processing are marked as FAILED.

Optional Messaging Integration: Supports RabbitMQ/Kafka for distributed task processing.

🛠️ Prerequisites
To run this application, ensure you have the following installed:

Java 17+ (Recommended)

Maven 3.8+

PostgreSQL/MySQL (Choose one)

Optional: RabbitMQ/Kafka (if required)

🚀 Getting Started
1. Clone the Repository
git clone https://github.com/NehaSharma0504/async-task-processor.git
cd asynchronous-data-pipeline
2. Configure Database
Set the database credentials in src/main/resources/application.properties:

properties
# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/task_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.datasource.driver-class-name=org.postgresql.Driver

# Optional: Use MySQL instead
 spring.datasource.url=jdbc:mysql://localhost:3306/task_db
 spring.datasource.username=your_db_username
 spring.datasource.password=your_db_password
 spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
🧩 API Endpoints
HTTP Method	Endpoint	Description
POST	/api/tasks/submit	Submit a new task
GET	/api/tasks	Retrieve all submitted tasks
GET	/api/tasks/{id}	Get status of a specific task

⚙️ Database Setup
1. Create Database
sql
CREATE DATABASE task_db;
2. Create tasks Table
sql
CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    payload TEXT NOT NULL,
    status VARCHAR(50) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
▶️ Running the Application
1. Build and Package
mvn clean package
2. Run the Application
java -jar target/asynchronous-data-pipeline-0.0.1-SNAPSHOT.jar
3. Access the Application
API Base URL: http://localhost:8080/api/tasks

🧪 Unit Tests
Run unit tests using Maven:
mvn test
📡 Optional: RabbitMQ/Kafka Integration
To enable message broker integration:

Update application.properties with the appropriate RabbitMQ/Kafka configuration.

Add RabbitMQ/Kafka dependencies in pom.xml.

Configure listeners to process tasks from the queue asynchronously.

🩺 Troubleshooting
Ensure the database is running and credentials are correct.

Check application logs for any errors:

If the application fails to start, ensure required ports (e.g., 8080) are free.


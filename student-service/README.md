# Microservices Demo

## Task 1 - Submodules Integration

This project demonstrates synchronous communication between two Spring Boot microservices.

### Services

- Course Service (Port 9090)
- Student Service (Port 9091)

### Communication

Student Service uses `RestTemplate` to call the Course Service over HTTP.

### Technologies

- Java 17
- Spring Boot
- Maven
- RestTemplate
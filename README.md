DeviceNote Assignment

This is a Spring Boot project for managing device notes.

Features
- Create notes for devices
- List notes by device
- H2 in-memory database
- REST API endpoints

Technologies
- Java 17
- Spring Boot 4.0.1
- Spring Data JPA
- H2 Database
- Liquibase

API Endpoints
- POST `/api/v1/devices/{deviceId}/notes` - Create a note
- GET `/api/v1/devices/{deviceId}/notes` - List notes

## How to Run
1. Clone the repo
2. Run `mvn spring-boot:run`
3. Access APIs via Postman or browser

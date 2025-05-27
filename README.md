# mailService_Backend

## Overview

**mailService_Backend** is a Spring Boot-based backend service that provides REST APIs for creating, storing, retrieving, and sending emails. This service manages email data persistence, allows for composing emails (including to multiple recipients), and facilitates sending both plain text and HTML emails.

## Features

- **Create Email**: Store email details (subject, body, recipients) in the database.
- **Retrieve Email**: Fetch stored email data by its unique ID.
- **Send Email**: Send emails to one or multiple recipients using the stored email data.
- **RESTful API**: Interact with the service via endpoints under `/api/email`.
- **JavaMail Integration**: Utilizes `JavaMailSender` for email delivery.
- **Spring Boot Architecture**: Built using Spring Boot, with standard practices for service, controller, and repository layers.

## API Endpoints

- `POST /api/email/create`: Store a new email. Requires an `EmailDto` (subject, body, recipients).
- `GET /api/email/get/{id}`: Retrieve email details by ID.
- `POST /api/email/send`: Send an email by providing its ID.

## Technology Stack

- Java
- Spring Boot
- Spring Data JPA
- JavaMailSender
- H2/Other SQL Database (configurable)

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/fanindra-k/mailService_Backend.git
   ```
2. **Configure Email Properties**
   - Set up your mail SMTP credentials in `application.properties`.

3. **Build and Run**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Test API**
   - Use Postman or curl to interact with the REST endpoints.

## Example `EmailDto` Payload

```json
{
  "subject": "Test Subject",
  "body": "This is a test email.",
  "to": ["recipient1@example.com", "recipient2@example.com"]
}
```

## Project Structure

- `controller/EmailController.java`: Exposes REST endpoints.
- `service/EmailService.java`: Email service interface.
- `serviceImpl/EmailServiceImpl.java`: Business logic for email operations.
- `repository/EmailRepository.java`: Data access layer.
- `entity/Email.java`: Email entity model.
- `dto/EmailDto.java`: Data transfer object for email operations.

## License

This project is licensed under the MIT License.

---
**Maintainer:** [fanindra-k](https://github.com/fanindra-k)

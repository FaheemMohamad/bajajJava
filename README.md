# Bajaj Java Challenge

Spring Boot application for the Bajaj hiring challenge that automatically generates a webhook and submits SQL solutions.

## 📥 Download JAR

**Direct Download Link:**
```
https://raw.githubusercontent.com/FaheemMohamad/bajajJava/main/bajaj-qualifier-1.0.0.jar
```

Or download from: [bajaj-qualifier-1.0.0.jar](https://github.com/FaheemMohamad/bajajJava/raw/main/bajaj-qualifier-1.0.0.jar)

## Project Structure
```
bajajJava/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── bajaj/
│       │           ├── BajajApplication.java
│       │           ├── model/
│       │           │   ├── WebhookRequest.java
│       │           │   ├── WebhookResponse.java
│       │           │   └── SolutionRequest.java
│       │           ├── service/
│       │           │   ├── WebhookService.java
│       │           │   └── SolutionService.java
│       │           └── runner/
│       │               └── StartupRunner.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

## Features
- ✅ Automatically sends POST request to generate webhook on startup
- ✅ Receives webhook URL and JWT access token
- ✅ Submits SQL query solution with JWT authentication
- ✅ No controllers/endpoints - fully automatic execution
- ✅ Uses RestTemplate for HTTP communication
- ✅ Comprehensive logging

## Configuration

Edit `src/main/resources/application.properties` to configure:

```properties
# User Details
user.name=Your Name
user.regNo=Your Registration Number
user.email=your.email@example.com

# SQL Query (Replace with your actual SQL query)
sql.query=SELECT * FROM users WHERE id = 1;
```

## How to Build

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build JAR
```bash
mvn clean package
```

The JAR file will be generated at: `target/bajaj-java-challenge.jar`

## How to Run

```bash
java -jar target/bajaj-java-challenge.jar
```

## How It Works

1. **On Startup**: Application automatically sends POST request to:
   ```
   POST https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA
   ```

2. **Receives Response**: Gets webhook URL and access token

3. **Submits Solution**: Sends SQL query to:
   ```
   POST https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA
   ```
   with JWT token in Authorization header

## Submission

- **GitHub Repository**: Include code and JAR file
- **JAR Download Link**: Provide raw GitHub link to JAR
- **Form**: https://forms.office.com/r/WFzAwgbNQb

## Notes

- Make sure to update `user.name`, `user.regNo`, and `user.email` in `application.properties`
- Replace `sql.query` with your actual SQL solution based on your registration number (odd/even)
- The application will exit after completing the submission

## License

This project is created for the Bajaj hiring challenge.

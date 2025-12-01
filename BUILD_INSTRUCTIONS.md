# Build Instructions

## Prerequisites
Maven is not currently installed on your system. You have two options:

### Option 1: Install Maven (Recommended)

1. Download Maven from: https://maven.apache.org/download.cgi
2. Extract to a folder (e.g., `C:\Program Files\Apache\maven`)
3. Add Maven's `bin` directory to your PATH environment variable
4. Restart your terminal
5. Run: `mvn clean package`

### Option 2: Use Maven Wrapper (if available)

If you have Maven wrapper files, you can use:
```bash
.\mvnw.cmd clean package
```

### Option 3: Build with IDE

1. Open the project in IntelliJ IDEA or Eclipse
2. Right-click on `pom.xml` → Run As → Maven build
3. Goals: `clean package`
4. Run

## After Building

The JAR file will be created at:
```
target/bajaj-java-challenge.jar
```

## Running the Application

```bash
java -jar target/bajaj-java-challenge.jar
```

## Before Running - IMPORTANT!

**Update `src/main/resources/application.properties` with:**

1. Your actual name, registration number, and email:
```properties
user.name=Your Actual Name
user.regNo=Your Registration Number
user.email=your.email@example.com
```

2. Your SQL query solution (based on your regNo - odd or even):
```properties
sql.query=YOUR_ACTUAL_SQL_QUERY_HERE
```

## Quick Start Commands

```bash
# 1. Build the project (after installing Maven)
mvn clean package

# 2. Run the application
java -jar target/bajaj-java-challenge.jar
```

## Testing Locally

Before submitting, test that:
1. ✓ Application starts without errors
2. ✓ Webhook is generated successfully
3. ✓ SQL solution is submitted with JWT token
4. ✓ Check logs for success messages

## Troubleshooting

**Maven not found:**
- Install Maven or use an IDE
- Make sure Maven is in your system PATH

**Build errors:**
- Ensure Java 17 or higher is installed
- Run `java -version` to check

**Runtime errors:**
- Check `application.properties` configuration
- Verify your internet connection
- Check API endpoints are accessible

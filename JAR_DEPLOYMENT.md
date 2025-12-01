# JAR File Deployment Guide

## Building the JAR File

Since Maven is not installed on your system, you have these options:

### Option 1: Install Maven and Build

1. **Download Maven:**
   - Visit: https://maven.apache.org/download.cgi
   - Download the Binary zip archive

2. **Install Maven:**
   ```powershell
   # Extract to C:\Program Files\Apache\maven
   # Add to PATH: C:\Program Files\Apache\maven\bin
   ```

3. **Build the JAR:**
   ```powershell
   cd e:\project\bajajJava
   mvn clean package
   ```

4. **Verify JAR created:**
   ```powershell
   ls target\*.jar
   ```
   You should see: `target/bajaj-java-challenge.jar`

### Option 2: Use an IDE (IntelliJ IDEA / Eclipse)

1. Open project in IDE
2. Right-click on `pom.xml`
3. Run Maven goal: `clean package`
4. JAR will be in `target/bajaj-java-challenge.jar`

### Option 3: Use Online Build (GitHub Actions)

If you commit and push to GitHub, you can set up GitHub Actions to build automatically.

## Making JAR Available on GitHub

Once the JAR is built:

### Step 1: Copy JAR to root (optional but recommended)
```powershell
Copy-Item target\bajaj-java-challenge.jar .\bajaj-qualifier-1.0.0.jar
```

### Step 2: Commit and Push
```powershell
git add bajaj-qualifier-1.0.0.jar
git commit -m "Add JAR file for submission"
git push origin main
```

### Step 3: Get Raw GitHub URL

Your JAR will be available at:
```
https://raw.githubusercontent.com/FaheemMohamad/bajajJava/main/bajaj-qualifier-1.0.0.jar
```

Or if you keep it in target:
```
https://raw.githubusercontent.com/FaheemMohamad/bajajJava/main/target/bajaj-java-challenge.jar
```

## Testing the JAR

Before submitting, test it:

```powershell
java -jar bajaj-qualifier-1.0.0.jar
```

## Alternative: GitHub Releases

You can also create a GitHub Release:

1. Go to your repository on GitHub
2. Click "Releases" → "Create a new release"
3. Upload `bajaj-qualifier-1.0.0.jar`
4. Get the download URL from the release assets

## Current Status

- ✅ Project structure created
- ✅ Code implemented
- ✅ .gitignore updated to allow JAR files
- ⏳ **Next: Build the JAR file using one of the methods above**
- ⏳ **Then: Commit and push to GitHub**

## Quick Commands Summary

```powershell
# Build (after installing Maven)
mvn clean package

# Copy to root with proper name
Copy-Item target\bajaj-java-challenge.jar .\bajaj-qualifier-1.0.0.jar

# Add to git
git add bajaj-qualifier-1.0.0.jar

# Commit
git commit -m "Add executable JAR file"

# Push
git push origin main
```

Your JAR will then be accessible at:
**https://raw.githubusercontent.com/FaheemMohamad/bajajJava/main/bajaj-qualifier-1.0.0.jar**

# Setup Guide

## Required tools
- JDK 17
- Apache Maven
- Git
- Jenkins
- Apache Tomcat 10.1+

## Local validation
Run from the project root:

```text
java -version
mvn -version
git --version
mvn clean
mvn test
mvn package
```

The generated WAR should be:

```text
target/student-feedback-portal.war
```

## Tomcat
Copy the WAR into Tomcat's `webapps` directory and start Tomcat. The application URL is:

```text
http://localhost:8081/student-feedback-portal/
```

The health endpoint is:

```text
http://localhost:8081/student-feedback-portal/health
```

The Jenkinsfile contains a Windows-local deployment path placeholder. Update `TOMCAT_WEBAPPS` to the actual Tomcat `webapps` directory on the Jenkins machine before running the deployment stage.

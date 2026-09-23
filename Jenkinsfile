pipeline {
    agent any

    environment {
        APP_NAME = 'student-feedback-portal'
        TOMCAT_WEBAPPS = "C:\\TomCat\\apache-tomcat-10.1.44-windows-x64\\apache-tomcat-10.1.44\\webapps"
        TOMCAT_URL = 'http://localhost:8081/student-feedback-portal/health'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                bat 'if exist "%TOMCAT_WEBAPPS%\\%APP_NAME%.war" del /Q "%TOMCAT_WEBAPPS%\\%APP_NAME%.war"'
                bat 'if exist "%TOMCAT_WEBAPPS%\\%APP_NAME%" rmdir /S /Q "%TOMCAT_WEBAPPS%\\%APP_NAME%"'
                bat 'copy /Y "target\\%APP_NAME%.war" "%TOMCAT_WEBAPPS%\\%APP_NAME%.war"'
            }
        }

        stage('Health Check') {
            steps {
                bat 'powershell -NoProfile -Command "Start-Sleep -Seconds 5; $r=Invoke-WebRequest -Uri \'%TOMCAT_URL%\' -UseBasicParsing; if ($r.StatusCode -ne 200 -or $r.Content.Trim() -ne \'OK\') { exit 1 }; Write-Host \'Health check passed\'"'
            }
        }
    }

    post {
        success {
            echo 'CI/CD pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check the stage logs and restore the last successful WAR if required.'
        }
    }
}

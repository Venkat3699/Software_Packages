###  Jenkins Parallel Pipelines for Maven Project
pipeline {
    agent any
    tools {
        maven 'maven3.8.5'
        jdk 'java17'
    }
    options {
        timestamps()
    }
    stages {
        stage('CheckOut Code') {
            steps {
                git 'https://github.com/your-username/your-repo-name.git'
            }
        }
        stage('Test and SonarQube Analysis Report') {
            parallel {
                stage('Test') {
                    steps {
                        sh 'mvn test'
                    }
                },
                stage('Build') {
                    steps {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }
        stage ('Build and Trivy Scan') {
            parallel {
                stage('Build') {
                    steps {
                        sh 'mvn clean package'
                    }
                }
                stage('Trivy Scan') {  // Scan the current package for vulnerabilities
                    steps {
                        sh 'trivy scan --severity=CRITICAL, HIGH, MEDIUM, LOW --output =trivy-report.json'
                    }
                }
            }
        }
    }
}
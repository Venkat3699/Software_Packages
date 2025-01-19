@Library('Github_Shared_Library')_ 
pipeline {
    agent any
    tools {
        maven 'maven3.8.5'
    }
    stages {
        stage('CheckOut Code') {
            steps {
                cicd.gitHubRepo("master", "https://github.com/Venkat3699/maven-web-application.git")
            }
        } 

        stage('Unit Test') {
            steps {
                cicd("Test")
            }
        } 

        stage('SonarQube Analysis Report') {
            steps {
                cicd("Sonar")
            }
        }

        stage('Build the package') {
            steps {
                cicd("Package")
            }
        }

        stage('Upload artifact to Nexus') {
            steps {
                cicd("Deploy")
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    sshagent(['37d38c8c-1fbf-48a6-ae04-ee8dc0fd9b87']) {    // Install SSH agent Plugin and then create syntax
                        cicd.DeployToTomcat("172.31.42.1")
                    }
                }
            }
        }
    }

}
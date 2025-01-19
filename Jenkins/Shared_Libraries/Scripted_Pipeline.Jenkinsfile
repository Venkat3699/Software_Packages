@Library('Github_Shared_Library')_      // Provide the Library name we have provided in the Library creation
node {
    stage('Checkout Code') {
        cicd.gitHubRepo("master", "https://github.com/Venkat3699/maven-web-application.git")
    }

    stage('Unit Test'){
        cicd("Test")
    }

    stage('SonarQube Analysis'){
        cicd("Sonar")
    }

    stage('Build Package'){
        cicd("Package")
    }

    stage('Upload artifact to Nexus'){
        cicd("Deploy")
    }
    stage ('Deploy to Tomcat using SSH agent') {
        sshagent(['37d38c8c-1fbf-48a6-ae04-ee8dc0fd9b87']) {    // Install SSH agent Plugin and then create syntax
           cicd.DeployToTomcat("172.31.42.1")
        }
    }
}
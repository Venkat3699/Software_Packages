def gitHubRepo(branchName, repoUrl)
{
    git "branch: ${branchName} url: ${repoUrl}"
}

def call(String mavenGoal) {
    if ("${mavenGoal}" == "Clean") {
        sh "mvn clean"
    }
    else if ("${mavenGoal}" == "Compile") {
        sh "mvn compile"
    }
    else if ("${mavenGoal}" == "Test") {
        sh "mvn test"
    }
    else if ("${mavenGoal}" == "Package") {
        sh "mvn package"
    }
    else if ("${mavenGoal}" == "Deploy") {
        sh "mvn deploy"
    }
    else if ("${mavenGoal}" == "Sonar") {
        sh "mvn sonar:sonar"
    }
}

def DeployToTomcat(ip) {
    sh "sudo scp -o StrictHostKeyChecking=no target/maven-web-application.war ubuntu@${ip}:/opt/apache-tomcat-9.0.60/webapps"
}




stage ('Deploy to Tomcat using SSH agent') {
        sshagent(['37d38c8c-1fbf-48a6-ae04-ee8dc0fd9b87']) {    // Install SSH agent Plugin and then create syntax
            sh "sudo scp -o StrictHostKeyChecking=no target/maven-web-application.war ubuntu@172.65.4.3:/opt/apache-tomcat-9.0.60/webapps"      // Make sure check your tomcat private IP and Tomcat webapps path
        }
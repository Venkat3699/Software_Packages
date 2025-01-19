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

def deployToTomcat(ip) {
    sh "sudo scp -o StrictHostKeyChecking=no target/maven-web-application.war ubuntu@${ip}:/opt/apache-tomcat-9.0.60/webapps"
}

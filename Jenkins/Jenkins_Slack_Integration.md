### Jenkins Integration with Slack
Jenkins can be integrated with Slack to send notifications and updates to team members. This integration allows team members to stay informed about the status of their builds and deployments.

#### Requirements
- Create an Account in Slack, Url is: https://slack.com/
- Create a channel in Slack, where you want to send notifications from Jenkins.
- Create a Jenkins instance, if not installed already.
- Install the Slack Notification plugin, if not installed already.
- Configure the Slack Notification plugin in the Jenkins instance.

#### Steps in Slack 
- Go to the Slack channel where you want to send notifications from Jenkins. Name: Jenkins-Notifications.

- Click on our profile name -> Click on Settings & administrations -> Click on Manage apps -> Search for Jenkins CI -> Click on Jenkins CI -> Click on Add to Slack -> Select Channel Name "Jenkins-Notifications" in Post to channel -> Click on Add Jenkins CI Integration. 

- Follow the given instructions to complete the integration with your Jenkins server.

#### Steps in Jenkins
- Go to Manage Jenkins -> Click on Plugins -> Click on Available -> Search for Slack Notification -> Click on Install without restart.
- Go to Manage Jenkins -> Click on Configure System -> Scroll down to the Slack Notification section -> Workspace: "it is given in Slack setup steps in Team Subdomain" -> Click on Credentials -> Click on Jenkins -> Click on Add Credentials -> Select Secret text -> Enter your Slack API token provided in that steps -> Default channel: "#Jenkins-Notifications" -> Click on Test Connection -> Click on Save.

#### Steps in Jenkinsfile
```
pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                sendSlackNotifications("STARTED")
                git 'https://github.com/your-repo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn deploy'
            }
        }
    }
    post {
        success {
            sendSlackNotifications(currentBuild.result)
        }
        failure {
            sendSlackNotifications(currentBuild.result)
        }
    }
}//pipeline closing

def sendSlackNotifications(String buildStatus = 'STARTED') {
  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESS'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"

  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    colorName = 'YELLOW'
    colorCode = '#FFFF00'
  } else if (buildStatus == 'SUCCESS') {
    colorName = 'GREEN'
    colorCode = '#00FF00'
  } else {
    colorName = 'RED'
    colorCode = '#FF0000'
  }

  // Send notifications
  slackSend (color: colorCode, message: summary, channel: "citibank-project")
}

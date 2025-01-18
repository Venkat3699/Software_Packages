#### Pre-requisites:
- Launch New instance for Jenkins Slave 
- Install Java 17 on the Jenkins Slave      # Make sure same version of Java is installed on Jenkins Master
```
sudo apt update
sudo apt install openjdk-17-jdk
java --version
```
- Install Git on the Jenkins Slave
```
sudo apt update
sudo apt install -y git
```
- Create a Directory in the Slave and Copy the Path
```
mkdir slave1
cd slave1
pwd
/home/ubuntu/slave1/             # Copy this path
```

### In Jenkins Dashboard 
- Go to Manage Jenkins -> Click on Nodes -> Click on New Node -> Provide Node Name: Slave1 -> Enable the Permanent agent -> Click on Create
- Description: Jenkins Slave Node
- Number of Executors: 2        # Based on our requirement we can increase and decrease the value while creating
- Remote root directory: /home/ubuntu/slave1/
- Labels: Slave1        # Remember this label, we will use this label in pipelines
- Usage: Use this node as much as possible
- Launch method: Launch agent via SSH
    - Host: <Slave-Instance-Public IP>
    - Credentials: Jenkins Slave Credentials
        - Click on Add Credentials -> Select SSH Username with private key -> Username: Ubuntu -> Private key: Jenkins Slave Private Key -> ID: Jenkins Slave Credentials
    - Host key verification strategy: Manually trusted key verification strategy
- Availability: keep this agent online as much as possible
- Click on Save 

- Click on Slave1 -> click on Logs -> Check the logs for any errors 

### Create a pipeline for Jenkins Slave Node
- Go to Jenkins Dashboard -> New Item -> Pipeline -> Provide Pipeline Name: Slave1-Pipeline -> Click on OK
- In the pipeline script, add the following code
```
pipeline {
    agent {
            label 'Slave1'
        }
    tools {
        maven 'maven3.8.5'
    }
    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('CheckOut Code') {
            steps {
                git branch: 'main', credentialsId: 'be624cd2-9c43-4b67-a251-6272a5367973', url: 'https://github.com/Venkat3699/maven-web-application.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
### Scripted and Declarative Pipeline
- ***Scripted Pipeline***: This type of pipeline is defined using a Groovy script. It allows you to define a build process using a series of steps and commands. 
- ***Declarative Pipeline***: This type of pipeline is defined using a Groovy script with a specific syntax. It allows you to define a build process using a series of steps and commands with a more declarative syntax.

### Scripted Pipeline Syntax
```
node ('master') {
    stage('Clone') {
        git 'https://github.com/username/repository.git'
    }
    stage('Build') {
        sh 'mvn clean package'
    }
    stage('SonarScan') {
        sh 'mvn sonar:sonar'
    }
    stage('Deploy Artifact to Nexus') {
        sh 'mvn deploy'
    }
}
```

### Declarative Pipeline Syntax
```
pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/username/repository.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('SonarScan') {
            steps {
                sh 'mvn sonar:sonar'
            }
            }
        stage('Deploy Artifact to Nexus') {
            steps {
                sh 'mvn deploy'
            }
        }
    }
}
```
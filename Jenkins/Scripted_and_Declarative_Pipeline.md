### Scripted and Declarative Pipeline
- ***Scripted Pipeline***: This type of pipeline is defined using a Groovy script. It allows you to define a build process using a series of steps and commands. 
- ***Declarative Pipeline***: This type of pipeline is defined using a Groovy script with a specific syntax. It allows you to define a build process using a series of steps and commands with a more declarative syntax.

#### Difference between Scripted and Declarative Pipeline:
- **Scripted Pipeline**: It is written in a Groovy script and uses the `node` and `stage` keywords to define the pipeline. It is more flexible and allows for more complex logic, but can be harder to read and maintain. 
- **Declarative Pipeline**: It is written in a more concise and readable format, using the `pipeline` keyword and a `stages` block to define the pipeline. It is easier to read and maintain, but has some limitations in terms of complexity and flexibility. 

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


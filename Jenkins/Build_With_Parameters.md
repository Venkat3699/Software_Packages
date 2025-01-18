### Build With Parameters in Jenkins
- Jenkins is a popular CI/CD tool that allows you to build your project with parameters. You can define parameters in your Jenkinsfile, and then pass them as input when running the pipeline. This allows you to customize the build process based on the input parameters. 

- Here's an example of how you can build with parameters in Jenkins:
```
pipeline {
    agent any
    parameters {
        string(name: 'BRANCH_NAME', description: 'Enter the branch name')
        string(name: 'BUILD_TYPE', description: 'Enter the build type')
        }
    stages {
        stage('Build') {
            steps {
                sh "echo Building ${params.BRANCH_NAME} with ${params.BUILD_TYPE} build type"
            }
        }
    }
}
```

- In this example, we define two parameters: `BRANCH_NAME` and `BUILD_TYPE`. We then use these parameters in the `sh` step to print a message with the branch name and build type.

### Build With Parameters in Jenkinsfile
```
pipeline {
    agent any
    parameters {
        choice choices: ['dev', 'qa', 'prod'], description: 'Select the environment', name: 'BRANCH_NAME'
    }
    stages {
        stage('Checkout code') {
            steps {
                git branch: '${params.BRANCH_NAME}', credentialsId: 'be624cd2-9c43-4b67-a251-6272a5367973', url: 'https://github.com/Venkat3699/maven-web-application.git'
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean package -Dmaven.test.skip=true -Denv=${params.ENV}" 
            }
        }
    }
}
```
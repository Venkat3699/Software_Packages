### Upstream and Downstream Jobs
- Upstream jobs are the jobs that run before the current job. They are used to prepare the environment for the current job. For example, if you have a job that builds a Docker image, the upstream job might be a job that creates the Dockerfile. 
- Downstream jobs are the jobs that run after the current job. They are used to build upon the output of the current job. For example, if you have a job that builds a Docker image , the downstream job might be a job that pushes the image to a registry.

### Declarative Pipeline for Upstream and Downstream Jobs
1. Pipeline_Name: Test_Pipeline
```
pipeline {
    agent any
    stages {
        stage('Build Docker Image') {
            steps {
                git 'https://github.com/your-username/your-repo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
```
- Create another pipeline that uses the first pipeline as an upstream job and this pipeline as a downstream job. This pipeline will run after the first pipeline has completed.
2. Pipeline_Name: Test_Pipeline_Downstream
```
pipeline {
    agent any
    stages {
        stage('git clone') {
            steps {
                git 'https://github.com/your-username/your-repo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Tiggger the Job') {
            steps {
                build job: 'Test_Pipeline'
            }
        }
    }
}
```
- In the second pipeline, we use the `build` step to trigger the first pipeline as an upstream job. The `build` step takes a `job` parameter, which is the name of the pipeline to be triggered. The `job` parameter can also take a `parameters` parameter, which is a map of parameters to be passed to the upstream job.
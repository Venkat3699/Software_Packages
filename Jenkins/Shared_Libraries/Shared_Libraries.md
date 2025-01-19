### Shared Libraries in Jenkins
- Jenkins Shared Library is the concept of having common pipeline code in the version control system that can be used across multiple Jenkins jobs. Infact multiple teams can use the same shared library. This is a powerful feature of Jenkins that allows you to write code once and reuse it across multiple projects.


#### Directory Structure
- The directory structure for a shared library in Jenkins is as follows:
- `src/`: This directory contains the source code for the shared library.
- `lib/`: This directory contains the compiled library files.
- `vars/`: This directory contains the variable definitions for the shared library.
- `resources/`: This directory contains any additional resources required by the shared library.
- `Jenkinsfile`: This file contains the pipeline script that defines the shared library.
- `README.md`: This file contains information about the shared library, including its purpose, usage,
and any dependencies required.

#### Add Github Shared Library to Jenkins
- Go to Manage Jenkins -> Configure System -> Global Pipeline Libraries -> Add a new library -> Name: Github_Shared_Library -> Default branch: master -> Source code management -> Git -> Repository URL: https:// github.com/your-username/your-repo-name.git -> Credentials: Add a new credential -> Username: your-username -> Password: your-password -> Add -> Save.

- Now you can use the shared library in your Jenkinsfile by calling the library function. For example:


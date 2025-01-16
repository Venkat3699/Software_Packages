## Jenkins
- Jenkins is an Open Source automation server that can be used to automate various tasks such as building, testing, and deploying software. It can be used to automate the deployment of a web application to a cloud platform such as AWS. Jenkins can be integrated with various tools such as Git, Maven, and Docker to automate the deployment process. 

### Introduction in 2 lines each
1. ***Continuous Integration***: Continuous Integration is the process of automatically building and testing the application every time when ever the developer push the code into the version control system. This helps to catch the bugs early and make the development process faster.
2. ***Continuous Delivery***: Continuous Delivery is the process of manual approch to deploy the application into Production after completion of build and test process. 
3. ***Continuous Deployment***: Continuous Deployment is the process of automatic deployment of the application into production after completion of build and test process. 

### Difference Between Poll SCM, Build Tigger and GitHub Webhook
- ***Poll SCM***: It checks repository for the changes at fixed interval and intiate build according to the changes found in the repository. 
- ***Build Trigger***: Build triggers can be used to automatically start builds based on time, source code changes, or other events. 
- ***GitHub Webhook***: GitHub Webhook is a service that allows you to receive notifications when certain events occur on GitHub. You can use this service to trigger a build in Jenkins when a push event occurs on GitHub.

## Jenkins Directory Structure
- ***Jenkins Home***: This is the root directory of the Jenkins installation. It contains the configuration files, plugins, and other data. 
- ***Jenkins Workspace***: This is the directory where the Jenkins build process takes place. It contains the source code, build artifacts, and other files related to the build process.
- ***Jenkins Jobs***: This is the directory where the Jenkins job configurations are stored. It contains the job definitions, build scripts, and other files related to the job configurations.
- ***Jenkins Plugins***: This is the directory where the Jenkins plugins are stored. It contains the plugin configurations, plugin scripts, and other files related to the plugins.
- ***Jenkins Logs***: This is the directory where the Jenkins logs are stored. It contains the build logs, error logs, and other files related to the build process.
- ***Jenkins Users***: This is the directory where the Jenkins user configurations are stored. It contains the user definitions, user permissions , and other files related to the user configurations.

### Jenkins Job Types
- ***Freestyle Project***: This is the most basic type of Jenkins job. It allows you to define a build process using a series of steps. 
- ***Maven Project***: This type of job is specifically designed for Maven projects. It allows you to define a build process using Maven commands. 
- ***Multi-Configuration Project***: This type of job allows you to define multiple build configurations for a single job. 
- ***Pipeline Project***: This type of job allows you to define a build process using a pipeline script. 

## Difference between restart and safeRestart in detailed
- ***Restart***: This option will restart the Jenkins server and all the jobs will be lost. This option should be used with caution as it will delete all the jobs and configurations. 
- ***SafeRestart***: This option will restart the Jenkins server and all the jobs will be preserved. This option is safer than the restart option as it will not delete any jobs or configurations. 
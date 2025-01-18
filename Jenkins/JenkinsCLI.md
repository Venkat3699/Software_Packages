### JenkinsCLI
Jenkins CLI is a command-line tool that allows you to interact with Jenkins from the command line. It provides a way to automate Jenkins tasks, such as building and deploying projects, without having to us the Jenkins web interface.

#### Download and Install Jenkins CLI
To download and install Jenkins CLI, follow these steps:
- http://< Jenkins PublicIP >:8080/cli/     # Execute this in the browser
- Click on jenkins-cli.jar and download it
- Create a New Folder on your local Desktop as "Jenkins-CLI"
- Copy the downloaded jenkins-cli.jar file into the newly created folder
- Open Putty/Gitbash, navigate to the folder where you copied the jenkins-cli.jar file

### Here you can Execute the Jenkins CLI commands:
```
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -webSocket -auth admin:admin123 help  
```
- Here 3.109.211.229 is Jenkins Server PublicIP and admin:admin123 is Jenkins Login Credentials Username: admin and Password: admin123/Jenkins token we can use

#### Jenkins Token Creation steps:
- Go to Jenkins Dashboard
- Click on Manage Jenkins
- Click on Users
- Click on the username you want to create a token
- Click on Configure on LEFTSIDE
- Scroll down to the API TOKEN
- Click on Generate API Token
- Copy the generated token and use it in Jenkins CLI commands

-  To see list all the plugins installed in Jenkins Server 
```
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket list-plugins 
```
- To see list all the jobs in Jenkins Server
```
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket -list-jobs
```
1. Shell Script to see list all the jobs in Jenkins Server, the file name as: "displayJobs.sh"
```
echo "Displaying the jobs in the Jenkins Server"
echo "-----------------------------------------"
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket list-jobs 
```
- To Execute the shell script in that Jenkins CLI folder Path
```
./displayJobs.sh or sh displayJobs.sh
```

2. To Build a Job in Jenkins Server, the file name as: "buildJob.sh"
```
echo "Building the job in the Jenkins Server"
echo "-----------------------------------------"
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket build "Declarative-pipeline"
```
- To Execute the shell script in that Jenkins CLI folder Path
```
./buildJob.sh or sh buildJob.sh
```

3. To Delete a Job in Jenkins Server, the file name as: "deleteJob.sh"
```
echo "Deleting the job in the Jenkins Server"
echo "-----------------------------------------"
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket delete-job "Declarative-pipeline"
```
- To Execute the shell script in that Jenkins CLI folder Path
```
./deleteJob.sh or sh deleteJob.sh
```

4. To Get the List of job Names Dynamically to tigger the build, the file name as: "buildJobDynamic.sh"
```
echo "Displaying the jobs in the Jenkins Server"
echo "-----------------------------------------"
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket list-jobs 
echo " "
echo "Please Enter the Job Name which one you want to tigger"
echo "--------------------------------------------------"
read jobName
echo "Building the job name as: $jobName"
echo "-----------------------------------------"
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket build "$jobName"
```
- To Execute the shell script in that Jenkins CLI folder Path
```
./buildJobDynamic.sh or sh buildJobDynamic.sh
```
- Please Enter the Job Name which one you want to trigger the build
- Ex: Declarative-pipeline

5. Dumb the Job defination xml to stdout using shell script, THe file name as: "getJobconfiguration.sh"
```
echo "Please Enter the Job Name which one you want to Configuration?"
read jobName
echo "Getting the job configuration of $jobName"
echo "-----------------------------------------"
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket get-job "$jobName" > $jobName.xml
```
- To Execute the shell script in that Jenkins CLI folder Path
```
./getJobconfiguration.sh or sh getJobconfiguration.sh
```
- Please Enter the Job Name which one you want to Configuration?
- Ex: Declarative-pipeline
- The job configuration will be dumped to the file name as: Declarative-pipeline.xml in the same folder path.

6. To Create a new job from the above xml in Jenkins Server, the file name as: "createJob.sh"
```
echo "Please Enter the Job Name which one you want to Create?"
read jobName
echo "Creating the job name as: $jobName"
echo "-----------------------------------------"
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket create-job "$jobName" < $jobName.xml
```
- To Execute the shell script in that Jenkins CLI folder Path
- Please Enter the Job Name which one you want to Create?
- Ex: testcli
- The job will be created in the Jenkins Server with the name as: testcli

7. If We have any Parameters in the job, we can pass the parameters using the above shell script, the file name as: "buildJobWithParam.sh"
```
echo "Please Enter the Job Name which one you want to tigger"
read jobName
echo "Building the job name as: $jobName"
echo "-----------------------------------------"
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket build "$jobName" -p BranchName=development
```
- To Execute the shell script in that Jenkins CLI folder Path
```
./buildJobWithParam.sh or sh buildJobWithParam.sh
```
- Please Enter the Job Name which one you want to tigger
- Ex: testcli
- The job will be triggered with the parameter as: BranchName=development

8. Diplay the Version of Jenkins, the file name as: "Version.sh"
```
echo "Jenkins Version is: "
java -jar jenkins-cli.jar -s 3.109.211.229:8080 -auth admin:admin123 -webSocket version 
```
- To Execute the shell script in that Jenkins CLI folder Path
```
./Version.sh or sh Version.sh
```

9. Maintain all the Scripts in one script file, if we need to select the perticular script it will execute that Shell Script only, the file name as: "main.sh"
```
echo "1) Display Jobs"
echo "2) Build the Job"
echo "3) Delete the Job"
echo "4) Create the Job"
echo "5) Display Version"

echo "Please Enter the Option Number to execute the script"
read action
case $action in
1) displayJobs.sh ;;
2) buildJob.sh ;;
3) deleteJob.sh ;;
4) createJob.sh ;;
5) Version.sh ;;
*) echo "Please Enter the Valid Option";;
esac
```
- To Execute the shell script in that Jenkins CLI folder Path
```
./main.sh or sh main.sh
```
- Please Enter the Option Number to execute the script
- Ex: 1
- The script will execute the displayJobs.sh script, it will display all the jobs in the Jenkins server.
- Ex: 5
- The script will execute the Version.sh script, it will display the Jenkins Version.

10. Instead of hardcoding the Jenkins server URL, Jenkins username and Jenkins password in the shell script, we can use the environment variables to get the values from the Jenkins server. The file name as: "jenkinsConfig.txt"
```
JENKINS_URL=3.109.211.229:8080
JENKINS_USERNAME=admin
JENKINS_PASSWORD=admin123 or JENKINS_TOKEN=11ffcceb4t5sd789gf65sdxc3
```
- To read the environment variables from the file in the "displayJobEnv.sh"
```
echo "Displaying the jobs in the Jenkins Server"
echo "-----------------------------------------"
jenkinsUrl='grep JENKINS_URL jenkinsConfig.txt | cut -d '=' -f2'
jenkinsUsername='grep JENKINS_USERNAME jenkinsConfig.txt | cut -d '=' -f2'
jenkinsPassword='grep JENKINS_PASSWORD jenkinsConfig.txt | cut -d '=' -f2'
jenkinsToken='grep JENKINS_TOKEN jenkinsConfig.txt | cut -d '=' -f2'

java -jar jenkins-cli.jar -s $jenkinsUrl -auth $jenkinsUsername:$jenkinsPassword -webSocket list-jobs 
```
- To Execute the Script in Jenkins CLI folder Path
```
sh displayJobEnv.sh
```
- It will take the variables from the Jenkinsconfig.txt and Display the jobs in the Jenkins server.
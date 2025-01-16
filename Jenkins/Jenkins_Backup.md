### Jenkins Backup
Jenkins backup is a critical task to ensure that your Jenkins configuration and data are safe in case of a disaster or accidental deletion. Here are the steps to create a Jenkins backup:
#### Step-1
- Login to your Jenkins server as an administrator. 
- Go to the Jenkins dashboard and click on the "Manage Jenkins" link.
- Click on the "Manage Plugins" link.
- Install "Thin Backup" plugin.
#### Step-2
- Go to the Jenkins dashboard and click on the "Manage Jenkins" link.
- Scroll down to the " Thin Backup" section.
- Click on the "Thin Backup" button.
#### Step-3 Configuring Backup Settings
- In the "Thin Backup" configuration page, you can configure the backup settings as follows:
1. **Backup directory**: Specify the directory where you want to store the backup files. This directory should be outside of the Jenkins home directory to avoid any potential data loss.
```
cd /var/lib/jenkins
mkdir jenkins_backup
chown -R jenkins:jenkins jenkins_backup
cd jenkins_backup
pwd
```
- Copy the Path and paste it in the Backup directory field in the Thin Backup configuration page.
2. **Backup frequency**: Choose how often you want to create a backup. You can select from the following options: Daily, Weekly, Monthly, or Custom.
- Backup schedule for full backup: Choose the time and frequency for the full backup. it take full backup of all data.
- Backup schedule for diffrential backup: Choose the time and frequency for the differential backup. it take only any updated files are there in the jenkins home directory.
```
Ex: * * * * *   (or) Specific time period as per your requirement
```
3. **Max number of backup sets**: Specify the maximum number of backup sets you want to keep. This will help you manage the disk space used by the backups.
```
Ex: 5 (or) any number as per your requirement
```
- Click on the check boxes for the required backup settings and click on the "Save" button.
#### Step-4
- After configuring the backup settings, click on the "Backup" button to create the initial backup.
- The backup process may take some time depending on the size of your Jenkins data.
- Once the backup is complete, you can verify the backup by checking the backup directory. You should see the backup files with the following naming convention: `jenkins_backup_<timestamp>.zip` or in normal time stamp format.

## Jenkins Backup into AWS S3 Bucket
To backup Jenkins into AWS S3 Bucket, you can use the "Thin Backup" plugin along with the "AWS S3" plugin. Here are the steps to configure the backup settings:
#### Step-1
- Install the "AWS S3" plugin from the Jenkins plugin manager.
#### Step-2
- create an S3 bucket in the aws console
- create an IAM role with the necessary permissions to access the S3 bucket 
    - Go to IAM Console -> click on Roles -> create Role -> select AWS services -> EC2 -> Next -> S3 full access -> Next -> Role Name: Jenkins-S3 -> Review -> Create Role
- Attach the IAM role to the Jenkins server


#### Step-3
- Connect Jenkins server with putty/gitbash
- Create a tar file for all the files in the jenkins home directory
```
tar -zcvf jenkins-backup.tar.gz /var/lib/jenkins/
```
- Install awscli in the jenkins server
```
sudo apt install -y python3-pip
sudo pip3 install awscli
```
- Copy the Jenkins Backup tar file into s3 bucket
```
aws s3 cp jenkins-backup.tar.gz s3://<s3-bucket-name>/jenkins-backup.tar.gz
```

#### Step-4
- Create new Jenkins server and get the backup files from the s3 bucket
- Pre-requisites
    - New Instance for Jenkins
    - Install Jenkins on the new instance
    - Configure awscli
    - Attach the IAM S3 role
    - Restore the backup files from the s3 bucket
        ```
        aws s3 cp s3://<s3-bucket-name>/jenkins-backup.tar.gz /home/ubuntu
        ```
    - Extract the tar file
        ```
        tar -zxvf jenkins-backup.tar.gz -C /
        ```
    - Login to Jenkins Server and see the all backup jobs


## Jenkins Backup into S3 Bucket using Pipeline
1. Go to Manage Jenkins -> Click on Manage Plugins -> Available -> Search for "S3 Plugin Schedule" -> Install without restart
2. Go to Manage Jenkins -> Configure System -> S3 Plugin Schedule -> Provide name, Access key and Secret Key -> Apply and Save
3. Create a New job -> name: Jenkins_backup -> Pipeline -> ok
4. In the Jenkinsfile, add the following code in the build-in node:
```
pipeline {
    agent {
        label 'Built-In'
    }
    stages {
        stage('Jenkins Backup') {
            steps {
                sh '''
                cd /var/lib/
                tar -zcvf jenkins-backup.tar.gz jenkins   // zip ${WORKSPACE}/jenkinsBackup.zip jenkins
                '''
            }
        }
        stage('Upload to S3') {
            steps {
                script {
                    // Generate the code from the pipeline Syntax and Paste it here, for this steps are mentioned below
                }
            }
        }
    }
}
```
5. Go to Pipeline Syntax -> Search for s3 upload ->Provide the details as:
```
s3profile: jenkinsbackup 
file to upload click on "Add" 
source: " *.tar.gz" (or) "*.zip" 
destination: <S3 bucket name> 
Storage Class: STANDARD 
region: ap-south-1 
```
-> Click on Generate Script
6. Copy the script and paste it in the Jenkinsfile, and build the pipeline.
7. Check the S3 Bucket for the backup files.
8. To restore the backup files, follow the steps mentioned above in the "Restore Jenkins Backup from S3 Bucket
    - install Aws Cli
    - Copy the backup file from S3 bucket to the instance
    - Extract the tar file or zip file
    - Check all the files are restored successfully
    - copy the Specific job (deleted job) from the backup folder to the jenkins home directory.
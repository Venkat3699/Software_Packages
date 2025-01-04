# Pre-requisites
----------------
1. SonarQube requires atleast 2gb of RAM
2. Java Installation

# Installation Commands
=======================
#### update the system repository list.
   ```
   sudo apt update
   sudo apt upgrade -y
   ```
#### Install Java
   ```
   sudo apt install openjdk-17-jdk -y
   java --version
   ```
#### Install Wget and Unzip
   ```
   sudo apt-get install -y wget unzip
   ```
#### Download SonarQube using the URL
   ```
   sudo wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.2.77730.zip -P /opt
   ```
#### Unzip the downloaded archive.
   ```
   sudo unzip /opt/sonarqube-9.9.2.77730.zip -d /opt
   ```
#### Move the files to the **/opt/sonarqube** directory.
   ```
   sudo mv /opt/sonarqube-9.9.2.77730 /opt/sonar
   ```
#### Delete the downloaded archive
   ```
   rm -rf sonarqube-9.9.2.77730.zip
   ```
#### Create a system user along with the group for SonarQube
   ```
    sudo useradd sonar
   ```
#### Give Sonar user permissions to the **/opt/sonarqube** directory.
  ```
    sudo chown -R sonar:sonar /opt/sonar
  ```
#### Give Sudo Privillages to sonarQube User (Under Root User name)
   ```
    sudo vi /etc/sudoers
    sonar   ALL=(ALL:ALL) NOPASSWD:ALL
   ```
#### Write a Service for SonarQube
   - Create a systemd service unit file for SonarQube. Create a file named **/etc/systemd/system/sonar.service** and add the following content:
     ```
         [Unit]
         Description=SonarQube service
         After=network.target
         
         [Service]
         Type=forking
         User=sonar
         ExecStart=/opt/sonar/bin/linux-x86-64/sonar.sh start
         ExecStop=/opt/sonar/bin/linux-x86-64/sonar.sh stop
         Restart=always
         LimitNOFILE=65536
        
         [Install]
         WantedBy=multi-user.target
    ```  
#### Start the SonarQube service.
   ```
    sudo systemctl start sonar
   ```
#### Check the status of the service.
   ```
    sudo systemctl status sonar
   ```
#### Enable the service to start automatically at boot.
   ```
    sudo systemctl enable sonar
   ```
#### Verify if the Sonarqube server is functioning properly.
   ```
    curl http://<Public Ip>:9000
   ```
    





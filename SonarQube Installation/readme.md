# Pre-requisites
----------------
1. SonarQube requires atleast 2gb of RAM
2. Java Installation

# Installation Commands
=======================
1. Login as Root user
   ```
   sudo su -
   ```
2. update the system repository list.
   ```
   apt-get update
   ```
3. Install Java
   ```
   apt-get install openjdk-11-jdk -y
   java --version
   ```
4. Install Wget and Unzip
   ```
   apt-get install -y wget unzip
   ```
5. Download SonarQube using the URL
   ```
   sudo wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.2.77730.zip
   ```
6. Unzip the downloaded archive.
   ```
   unzip /opt/sonarqube-9.9.2.77730.zip
   ```
7. Move the files to the **/opt/sonarqube** directory.
   ```
   sudo mv /opt/sonarqube-9.9.2.77730 /opt/sonar
   ```
8. Delete the downloaded archive
   ```
   rm -rf 9.9.8.100196.zip
   ```
9. Create a system user along with the group for SonarQube
    ```
    useradd sonar
    ```
10. Give Sonar user permissions to the **/opt/sonarqube** directory.
    ```
    chown sonar:sonar /opt/sonarqube-9.9.8.100196 -R
    chmod -R 775 /opt/sonarqube-9.9.8.100196
    ```
11. Give Sudo Privillages to sonarQube User (Under Root User name)
    ```
    sudo vi /etc/sudoers
    sonar   ALL=(ALL:ALL) NOPASSWD:ALL
    ```
12. Write a Service for SonarQube
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
    
13. Start the SonarQube service.
    ```
    systemctl start sonarqube
    ```
14. Check the status of the service.
    ```
    systemctl status sonarqube
    ```
15. Enable the service to start automatically at boot.
    ```
    systemctl enable sonarqube
    ```
16. Verify if the Sonarqube server is functioning properly.
    ```
    curl http://127.0.0.1:9000
    ```
    





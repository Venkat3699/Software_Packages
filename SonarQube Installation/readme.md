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
   wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.6.1.59531.zip
   ```
6. Unzip the downloaded archive.
   ```
   unzip -q sonarqube-9.6.1.59531.zip
   ```
7. Move the files to the **/opt/sonarqube** directory.
   ```
   sudo mv sonarqube-9.6.1.59531 /opt/sonarqube
   ```
8. Delete the downloaded archive
   ```
   rm sonarqube-9.6.1.59531.zip
   ```
9. Create a system user along with the group for SonarQube
    ```
    useradd sonar
    ```
10. Give Sudo Privillages to sonarQube User (Under Root User name)
    ```
    visudo
    sonar ALL=(ALL:ALL) NOPASSWD:ALL
    ```
11. Give Sonar user permissions to the **/opt/sonarqube** directory.
    ```
    chown sonar:sonar /opt/sonarqube -R
    chmod -R 775 /opt/sonarqube
    ```
    ```
    su - sonar
    ```
12. Start the SonarQube service.
    ```
    systemctl start sonarqube
    ```
13. Check the status of the service.
    ```
    systemctl status sonarqube
    ```
14. Enable the service to start automatically at boot.
    ```
    systemctl enable sonarqube
    ```
15. Verify if the Sonarqube server is functioning properly.
    ```
    curl http://127.0.0.1:9000
    ```
    





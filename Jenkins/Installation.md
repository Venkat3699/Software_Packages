### Jenkins Installation
1. Install JAVA
```
sudo apt-get update
sudo apt install openjdk-17-jre -y
java --version
javac --version
```
2. Add Jenkins APT Repository
```
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
```
```
echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc]" \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
```
3. Install Jenkins
```
sudo apt update
sudo apt install jenkins -y
```
4. Start Jenkins Service
```
sudo systemctl enable jenkins
sudo systemctl start jenkins
sudo systemctl status jenkins
```
5. Configure Firewall Rules for Jenkins
```
sudo ufw enable
sudo ufw allow 8080/tcp
sudo ufw reload
sudo ufw status
```

6. Finish Jenkins Initial Setup
    - http://<Public-IP>:8080

- You will get the page similar to what we have below prompting you to provide the Administrator’s password. As per the instructions, the password is located in the file:

```
sudo cat /var/lib/jenkins/secrets/initialAdminPassword 
```
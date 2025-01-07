Java is installed on your system:
```
sudo apt update
sudo apt install default-jdk -y
java -version
```
- Open your /etc/profile.d/maven.sh:
```
sudo vim /etc/profile.d/maven.sh
```
- Add the following lines at the end
```
export JAVA_HOME=/usr/lib/jvm/default-java
export M2_HOME=/opt/maven
```
- Use the chmod command to make the maven.sh file executable:
```
sudo chmod +x /etc/profile.d/maven.sh
```
- Save the file and reload it
```
source /etc/profile.d/maven.sh
```
- Verify the Installation
```
java -version
```


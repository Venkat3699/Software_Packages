### Java, Git, Maven Installation Steps
##### Step 1: Install Prerequisites
- Apache Maven requires Java. Ensure that Java is installed on your system:
```
sudo apt-get update
sudo apt-get install wget -y
sudo wget https://download.oracle.com/otn/java/jdk/11.0.25%2B9/60e5d03cc24a4e1c8ab5d29303dbe066/jdk-11.0.25_linux-aarch64_bin.tar.gz
sudo mv jdk-11.0.25_linux-aarch64_bin.tar.gz /usr/local/
sudo tar -xvzf /usr/local/jdk-11.0.25_linux-aarch64_bin.tar.gz
```
- Open your /etc/profile.d/maven.sh:
```
sudo vim /etc/profile.d/maven.sh
```
- Add the following lines at the end
```
export JAVA_HOME=/usr/local/jdk-11.0.25
export PATH=$JAVA_HOME/bin:$PATH
```
- check java version
```
java -version
```
##### Step 2: Install Git
```
sudo apt-get update
sudo apt-get install git -y
git --version
```
##### Step 3: Install Maven
- Download the Maven binary tarball from the official Apache Maven website:
```
sudo wget https://downloads.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip
sudo mv apache-maven-3.9.6-bin.zip /opt
cd /opt
sudo apt install unzip  # Install unzip if not already installed
sudo unzip apache-maven-3.9.6-bin.zip
sudo rm /opt/apache-maven-3.9.6-bin.zip
```
- This will create a directory /usr/local/apache-maven-3.9.6.
- Open your /etc/profile.d/maven.sh:
```
sudo vim /etc/profile.d/maven.sh
```
- Add the following lines at the end
```
export JAVA_HOME=/usr/local/jdk-11.0.25
export PATH=$JAVA_HOME/bin:$PATH
export M2_HOME=/opt/apache-maven-3.9.6
export PATH=$M2_HOME/bin:$PATH
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
mvn -version
```

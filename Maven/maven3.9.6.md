### Maven Installation
Step 1: Install Prerequisites
- Apache Maven requires Java. Ensure that Java is installed on your system:
```
sudo apt-get update
sudo apt-get install wget -y
sudo wget https://download.oracle.com/otn/java/jdk/11.0.25%2B9/60e5d03cc24a4e1c8ab5d29303dbe066/jdk-11.0.25_linux-aarch64_bin.tar.gz
sudo mv jdk-11.0.25_linux-aarch64_bin.tar.gz /usr/local/
sudo tar -xvzf /usr/local/jdk-11.0.25_linux-aarch64_bin.tar.gz

sudo vim ~/.bashrc
export JAVA_HOME=/usr/local/jdk-11.0.25
export PATH=$JAVA_HOME/bin:$PATH
source ~/.bashrc
java -version
```
Step 2: Install Maven
- Download the Maven binary tarball from the official Apache Maven website:
```
sudo wget https://downloads.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip
sudo mv apache-maven-3.9.6-bin.zip /usr/local/
cd /usr/local/
sudo apt install unzip  # Install unzip if not already installed
sudo unzip apache-maven-3.9.6-bin.zip
sudo rm /usr/local/apache-maven-3.9.6-bin.zip
```
- This will create a directory /usr/local/apache-maven-3.9.6.
- Open your ~/.bashrc file:
```
sudo vim ~/.bashrc
```
- Add the following lines at the end
```
export M2_HOME=/usr/local/apache-maven-3.9.6
export PATH=$M2_HOME/bin:$PATH
```
- Save the file and reload it
```
source ~/.bashrc
```
- Verify the Installation
```
mvn -v
```

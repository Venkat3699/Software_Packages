```
sudo apt-get update
sudo apt-get install wget -y
```
- Download the Tarball Visit the Oracle JDK 17 Downloads page and download the jdk-17.0.13_linux-aarch64_bin.tar.gz file.
```
sudo wget https://download.oracle.com/otn/java/jdk/17.0.13%2B10/00d8a0bf05cc4f9087f2bb0f5191ea34/jdk-17.0.13_linux-aarch64_bin.tar.gz
```
- Extract the Tarball Extract the tarball to a directory of your choice
```
tar -xvzf jdk-17.0.13_linux-aarch64_bin.tar.gz -C /usr/local/
```
- Update Environment Variables Add the JDK to your PATH and set JAVA_HOME
```
sudo vim ~/.bashrc
```
- Add the following lines:
```
export JAVA_HOME=/usr/local/jdk-17.0.13
export PATH=$JAVA_HOME/bin:$PATH
```
- Save and close the file, then reload it:
```
source ~/.bashrc
```
- Verify the Installation Confirm the Java version
```
java -version
```

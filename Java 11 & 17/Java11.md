```
sudo apt-get update
sudo apt-get install wget -y
```
- Download the Tarball
```
sudo wget https://download.oracle.com/otn/java/jdk/11.0.25%2B9/60e5d03cc24a4e1c8ab5d29303dbe066/jdk-11.0.25_linux-aarch64_bin.tar.gz
```
- Move the downloaded file to /usr/local/ for system-wide installation
```
sudo mv jdk-11.0.25_linux-aarch64_bin.tar.gz /usr/local/
```
- Extract the Tarball
```
sudo tar -xvzf /usr/local/jdk-11.0.25_linux-aarch64_bin.tar.gz
```
- Set Environment Variables
```
sudo vim ~/.bashrc
```
- Add the following lines at the end:
```
export JAVA_HOME=/usr/local/jdk-11.0.25
export PATH=$JAVA_HOME/bin:$PATH
```
- Save and close the file, then reload it:
```
source ~/.bashrc
```
- Verify the Installation
```
java -version
```
```
sudo update-alternatives --config java
sudo update-alternatives --config javac
```
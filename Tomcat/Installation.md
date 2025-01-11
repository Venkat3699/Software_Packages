## Installation of Tomcat9 on Ubuntu Server
Tomcat9 is a popular open-source web server that can be used to deploy Java-based web applications . Here's how to install Tomcat9 on Ubuntu Server:
### Step 1: Update the Package List
```
sudo apt update
sudo apt install default-jdk -y
sudo groupadd tomcat
sudo useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
cd /tmp
curl -O https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.34/bin/apache-tomcat-10.1.34.tar.gz
sudo mkdir /opt/tomcat
sudo tar xzvf apache-tomcat-10*tar.gz -C /opt/tomcat --strip-components=1
sudo usermod -aG tomcat ubuntu
sudo chgrp -R tomcat /opt/tomcat
sudo chmod -R g+r /opt/tomcat/conf
sudo chmod g+x /opt/tomcat/conf
sudo chown -R tomcat webapps/ work/ temp/ logs
sudo update-java-alternatives -l
/usr/lib/jvm/java-1.21.0-openjdk-amd64
```
### Optional Steps
```
sudo vim /etc/sudoers
```
```
root    ALL=(ALL:ALL) ALL
tomcat  ALL=(ALL:ALL) NOPASSWD:ALL
```

### Step 2: Configure the Tomcat Service
```
sudo vim /etc/systemd/system/tomcat.service
```
- Add the following configuration lines to the file. Remember to adjust the JAVA_HOME variable to your system’s path:

```
[Unit]
Description=Apache Tomcat Web Application Container
After=network.target

[Service]
Type=forking
User=tomcat
Group=tomcat
Environment="JAVA_HOME=/usr/lib/jvm/java-1.21.0-openjdk-amd64"
Environment="CATALINA_HOME=/opt/tomcat"
Environment="CATALINA_PID=/opt/tomcat/temp/tomcat.pid"
Environment="CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC"
ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh

[Install]
WantedBy=multi-user.target
```

```
sudo systemctl daemon-reload
sudo systemctl start tomcat
sudo systemctl status tomcat
```
### Configure the Firewall
```
sudo ufw allow 8080/tcp
```
### Set Up Web Management Interface
```
sudo vim /opt/tomcat/conf/tomcat-users.xml
```
- Next, add the following line to the file to set up the user and role configurations:
```
<tomcat-users>

    <role rolename="admin-gui"/>
    <role rolename="manager-gui"/>
    <user username="admin" password="passw0rd" roles="manager-gui,admin-gui"/>

</tomcat-users>
```
- For Manager app:
```
sudo vim /opt/tomcat/webapps/manager/META-INF/context.xml
```
- Comment the below lines like this:
```
<!--  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
  allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" /> -->
```

- For Host Manager app:
```
sudo vim /opt/tomcat/webapps/host-manager/META-INF/context.xml
```
- Comment the below lines like this:
```
<!--  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
  allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" /> -->
```


### To access the Tomcat Server, use the following URL in your web browser: 
- http://<your_domain_or_IP_address>:8080/
- http://<your_domain_or_IP_address>:8080/manager/html
- http://<your_domain_or_IP_address>:8080/host-manager/html
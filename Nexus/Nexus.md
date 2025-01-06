# Install Nexus Repository Manager on Ubuntu 22.04
---------------------------------------------------

## Installing Java OpenJDK 8
```
sudo apt update
sudo apt install openjdk-8-jdk -y
java -version
```
## Setting up System
- To install Nexus, you will need to create a new dedicated Linux user with a valid shell and also need to set up the max open files for both hard and soft limits to '65536'.
- Run the following command to create a new dedicated user for the Nexus with the name 'nexus'
```
sudo useradd -d /opt/nexus -s /bin/bash nexus
sudo passwd nexus
```
- Next, set the ulimit to '65536' using the below command. This will only affect the system on the current system temporarily. To make it permanent, you can create a new config file that you will do in the next step.
```
ulimit -n 65536
```
- TO set up ulimit permanently, create a new config file '/etc/security/limits.d/nexus.conf' using vim/nano editor.
```
sudo vim /etc/security/limits.d/nexus.conf
```
- Add the following configuration to the file. In this example, you are setting up ulimit for specific user 'nexus' with the value '65536'.
```
nexus - nofile 65536
```
## Installing Nexus Repository Manager
- Download the Nexus Repository Manager package via the wget command as below. If the download process is finished, you will see the file 'nexus-3.41.1-01-unix.tar.gz' on your current working directory.
```
wget https://download.sonatype.com/nexus/3/nexus-3.41.1-01-unix.tar.gz
```
- Now extract the file 'nexus-3.41.1-01-unix.tar.gz' via the tar command below. And you should get two directories, the 'nexus-3.41.1-01' and 'sonatype-work'.
```
tar xzf nexus-3.41.1-01-unix.tar.gz
```
- Next, move those extracted directories to '/opt' using the following command. The Nexus package directory will be '/opt/nexus' and the Nexus working directory will be '/opt/sonatype-work'.
```
mv nexus-3.41.1-01 /opt/nexus
mv sonatype-work /opt/
```
- change the ownership of both directories to the user and group 'nexus' via the chown command below.
```
chown -R nexus:nexus /opt/nexus /opt/sonatype-work
```
- Open the file '/opt/nexus/bin/nexus.rc' using vim editor.
```
sudo vim /opt/nexus/bin/nexus.rc
```
- Uncomment the option 'run_as_user' and change the value to 'nexus'. With this configuration, you will be running the Nexus application as the system user 'nexus'. Save the file and exit the editor when you are done.
```
run_as_user="nexus"
```
- open the config file '/etc/nexus/bin/nexus.vmoptions' using the nano editor to set up the max heap memory for Nexus.
```
sudo vim /etc/nexus/bin/nexus.vmoptions
```
- Change the default max memory heap for your Nexus installation in the following options. You can change the size to '1024m' based on the memory that you have on your server.
```
-Xms1024m
-Xmx1024m
-XX:MaxDirectMemorySize=1024m
```
  Save the file and exit the editor when you are completed.
- Now, edit the config file '/opt/sonatype-work/nexus3/etc/nexus.properties' using the vim editor.
```
sudo vim /opt/sonatype-work/nexus3/etc/nexus.propertie
```
- Uncomment the option 'application-host' option and change the value to '127.0.0.1'. This means that you will be running the Nexus on localhost or IP address '127.0.0.1' and Save the file and exit the editor.
```
application-host=127.0.0.1
```
### Running Nexus as SystemD Service
- Running Nexus with systemd service file, allows you to manage the nexus process via the systemctl command.
- Now, create a new service file '/etc/systemd/system/nexus.service' using nano editor.
```
sudo /etc/systemd/system/nexus.service
```
- Add the following configuration to the file. and Save the file and exit the editor when you are done.
```
[Unit]
Description=nexus service
After=network.target

[Service]
Type=forking
LimitNOFILE=65536
ExecStart=/opt/nexus/bin/nexus start
ExecStop=/opt/nexus/bin/nexus stop
User=nexus
Restart=on-abort

[Install]
WantedBy=multi-user.target
```
- Run the following command to reload the sytemd manager and apply a new service file for Nexus.
```
sudo systemctl daemon-reload
sudo systemctl start nexus.service
sudo systemctl enable nexus.service
sudo systemctl status nexus.service
```

# Running Nexus with Reverse Proxy
```
sudo apt install nginx
sudo systemctl is-enabled nginx
sudo systemctl status nginx
```
- create a new server block configuration '/etc/nginx/sites-available/nexus' using nano/vim editor.
```
upstream nexus3 {
  server 127.0.0.1:8081;
}

server {
    listen 80;
    server_name nexus.howtoforge.local;    # This is the domain name (nexus.howtoforge.local)

    location / {
        proxy_pass http://nexus3/;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        proxy_set_header Host $http_host;

        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forward-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forward-Proto http;
        proxy_set_header X-Nginx-Proxy true;

        proxy_redirect off;
    }
}
```
- Run the following command to activate the server block configuration for Nexus by creating a symlink of the config file to the 'sites-enabled' directory. Then, verify the Nginx configuration to make sure Nginx is configured properly.
```
sudo ln -s /etc/nginx/sites-available/nexus /etc/nginx/sites-enabled/
sudo nginx -t
```
- command to restart the Nginx service and apply the new server block configuration for Nexus.
```
sudo systemctl restart nginx
```
- At this point, the Nexus Repository manager is running under the Nginx reverse proxy. And it's accessible via the domain name of your installation.
- Open the web browser and visit the domain name of your Nexus installation (i.e: http://nexus.howtoforge.local). And you should get the default Nexus page.
- The default admin password for Nexus is stored at the file '/opt/sonatype-work/nexus3/admin.properties' with the default username admin.
- Back to your terminal and run the following command to get the default password for Nexus login. Then, copy the default password for Nexus.
```
cat /opt/sonatype-work/nexus3/admin.properties
```

Ref: https://www.howtoforge.com/how-to-install-nexus-repository-manager-on-ubuntu-22-04/











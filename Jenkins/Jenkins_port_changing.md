### Port Changing for Jenkins
- To change the port for Jenkins, you can follow these steps:
1. Connect to Jenkins Server using putty/gitbash
2. Go to Jenkins Service path: 
    ```
    cd /usr/lib/systemd/system
    ```
3. Here Open Jenkins service file using any editor like nano or vim
    ```
    vim jenkins.service
    ```
4. Change the port number in the file, for example, from 8080 to 9889 in
    ```
    Environment="JENKINS_PORT=9889"
    ```
5. Save the file and Exit
6. Reload the daemon to apply the changes and restart the service
    ```
    systemctl daemon-reload
    systemctl restart jenkins
    systemctl status jenkins
    ```
7. Now you can access Jenkins on the new port number, for example, http://your-jenkins-server:9889 

### Here we can also change the Jenkins Home directory default path also
- Directory where Jenkins stores its configuration and workspaces
    ```
    Environment="JENKINS_HOME=/var/lib/jenkins"
    WorkingDirectory=/var/lib/jenkins
    ```

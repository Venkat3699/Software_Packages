Steps to set up Sonarqube Server
--------------------------------

Create AWS Ec2 instance(Instance type must be >= t2.small) and login using ec2-user

Enable port 9000 in the respective security group/instance

Install Java 17 as the root user
      Step_1: ``` sudo -i ``` #Changing as root user
      Step_2: Download the Java 17 rpm using the below command
              wget https://download.oracle.com/java/17/archive/jdk-17.0.12_linux-x64_bin.rpm
      Step_3: rpm -i jdk-17_linux-x64_bin.rpm

Download Sonarqube from the below URL into /opt folder.
  -> cd /opt
  -> sudo wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.1.69595.zip

unzip sonarqube
  -> sudo unzip sonarqube-9.9.1.69595.zip

Create a user and add it as owner to opt/sonarqube-9.9.1.69595 folder
  -> sudo useradd sonaradmin
  -> sudo passwd sonaradmin
  -> sudo chown -R sonaradmin:sonaradmin sonarqube-9.9.1.69595 

Switch as sonaradmin user
  -> su sonaradmin

Start the sonar
  -> sh /opt/sonarqube-9.9.1.69595/bin/linux-x86-64/sonar.sh start

Now you can access Sonarqube from the browser
 -URL: http://Public-IP:9000

Default Sonarqube credentials 
 Username: admin
 Password: admin

==> After login change the default password for Best practice 

===> For Latest Releases:
REF: https://binaries.sonarsource.com/?prefix=Distribution/sonarqube/
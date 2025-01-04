1. Connect to SonarQube Server using Putty/GitBash
2. Execute the below commands where you have installed SonarQube
   ```
   sysctl vm.max_map_count
   sysctl fs.file-max
   ulimit -n
   ulimit -u
   ```
3. Create the PostgreSQL database in same server or another server. commands are in this folder: Postgres SQL DB Server
4. Go to the **conf** file. the command is:
   ```
   cd /opt/sonar/conf
   ```
5. Go to that directory and Edit the ***sonar.properties*** file:
   ```
   vim sonar.properties
   ```
6. UnComment the give below lines and also change the values
   ```
   sonar.jdbc.username=rishikumar
   sonar.jdbc.username=passw0rd
   ```
   - In PostgreSQL, Uncomment the give below lines and also change to:
   - PostgreSQL installed on same sonarqube server:
   ```
   sonar.jdbc.url=jdbc:postgresql://localhost/employees
   ```
   - PostgreSQL installed on another server:
   ```
   sonar.jdbc.url=jdbc:postgresql://< public IP of your Postgresql server>/employees
   ```
   - In Web server uncomment the below line
   ```
   sonar.web.host=0.0.0.0
   ```
7. Restart the sonarQube server
   ```
    sudo systemctl restart sonar
   ```
8.  check the status of sonarqube
    ```
     sudo systemctl status sonar
    ```










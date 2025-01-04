On Linux Server UBUNTU
----------------------
### Switch to root user
``` 
sudo su -
```

### Update the server
```
sudo apt-get update
sudo apt install gnupg2 wget nano -y
```
### Add the PostgreSQL 16 repository
```
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
```
### Import the repository signing key
```
curl -fsSL https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo gpg --dearmor -o /etc/apt/trusted.gpg.d/postgresql.gpg
```
### Update the package list
```
sudo apt update
```
### Install PostgreSQL 16 and contrib modules
```
sudo apt install postgresql-16 postgresql-contrib-16 -y
```
### Start and enable PostgreSQL service
```
sudo systemctl start postgresql
sudo systemctl enable postgresql
```
### Allow PostgreSQL port through the firewall
```
sudo ufw allow 5432/tcp
```
### Check the version and ensure it's Postgresql 16
```
psql --version
```
### Switch to PostgeSql user
```
sudo -u postgres psql
```
### Set password for the postgreSQL user
```
\password postgres
```
### Create a user in PostgreSQL
```
create user rishikumar with encrypted password 'passw0rd';
```
### create a database in PostgreSQL
```
create database employees;
```
### Grant all the privilleges to the user rishikumar to employees database
```
Grant all the privilleges on database employees to rishikumar;
```
### To quit the postgreSQL client
```
\q
```
### Search for the pg_hba.conf 
```
find / - name pg_hba.conf
```
### Goto that path (this is example)
```
sudo vim /etc/postgresql/16/main/pg_hba.conf
```
### Replace IPv4 address and authentication method as follows
IPv4 local connections:
host  all  all  127.0.0.1/32  ident
```
IPv4 local connections:
host  all  all  0.0.0.0/0  md5
```
### Search for the postgresql.conf 
```
find / - name postgresql.conf
```
### Goto that path (this is example)
```
sudo vim /etc/postgresql/16/main/postgresql.conf
```
#### Go to connection Settings --> In listen addressess = 'localhost' change to
```
listen addressess = '*'
```
### Restart database
```
sudo systemctl restart postgresql
sudo systemctl status postgresql
```

### To access the above database we need to install "sql-workbench". Download this "sql-workbench" the document URL is
```
https://www.sql-workbench.eu/downloads.html
```
### We need to install some jdbc drivers to access the database. 
- for that the URL is
```
https://mvnrepository.com/
```
- In search box, search for "postgre sql jdbc driver"
- Click on your required version for the driver
- Download the jar file in the Files Section of the version

### Open the "sql-workbench"
- Click on manage drivers below:
  - select postgreSQL
  - upload the downloaded postgre SQL jdbc driver
  - Provide Database name
  - Provide URL as
    ```
    jdbc:postgresql://PublicIp of sonarQube:5432/employees
    ```
  - Username as " rishikumar " 
  - Password as " passw0rd "
  - Click on " Test", to check the connection
  - Now insert some data for the reference


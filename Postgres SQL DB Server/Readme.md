On Linux Server UBUNTU
----------------------
### Switch to root user
``` sudo su - ```

### Update the server
``` apt-get update ```

### Ubuntu includes PostgreSQL by default. To install PostgreSQL on Ubuntu, use the apt (or other apt-driving) command: {simple way}
``` apt install postgresql ``` 

# PostgreSQL Apt Repository
### The PostgreSQL Apt Repository supports the current versions of Ubuntu:
- noble (24.04, LTS)
- mantic (23.10, non-LTS)
- jammy (22.04, LTS)
- focal (20.04, LTS)
### on the following architectures:
- amd64
- arm64 (LTS releases only)
- ppc64el (LTS releases only)
- s390x (LTS releases only)

### Automated repository configuration:
```
sudo apt install -y postgresql-common
sudo /usr/share/postgresql-common/pgdg/apt.postgresql.org.sh
```

### To manually configure the Apt repository, follow these steps:
```
sudo apt install curl ca-certificates
sudo install -d /usr/share/postgresql-common/pgdg
sudo curl -o /usr/share/postgresql-common/pgdg/apt.postgresql.org.asc --fail https://www.postgresql.org/media/keys/ACCC4CF8.asc
sudo sh -c 'echo "deb [signed-by=/usr/share/postgresql-common/pgdg/apt.postgresql.org.asc] https://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
sudo apt update
sudo apt -y install postgresql
```
### Initialise the database and enable automatic start
```
/usr/pgsql-16/bin/postgresql-16-setup initdb
systemctl enable postgresql-16
systemctl start postgresql-16
systemctl status postgresql-16
```
### Switch to PostgeSql user
```
sudo su - postges
```
### Start PostgreSQL CLI
```
Psql
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
cd /var/lib/pgsql/16/data/pg_hba.conf
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
cd /var/lib/pgsql/16/data/postgresql.conf
```
#### Go to connection Settings --> In listen addressess = 'localhost' change to
```
listen addressess = '*'
```
### Restart database
systemctl restart postgresql-16
systemctl status postgresql-16






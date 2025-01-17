## Jenkins Security
### Create Users in Jenkins
#### If we are using the any LDAP Server for the users, so we don't need to create users in Jenkins. However, we can create users in Jenkins if we want to use the Jenkins built-in user management system. To create a user in Jenkins, follow these steps:
- Assume these are the Users we need to create:
1. Developers
    - Rishi
    - Kiran
2. DevOps 
    - Sekhar
    - Venkat

--> Go to Manage Jenkins -> Manage Users -> Create User -> Enter the details of the user as:
```
Username: Rishi
Password: rishi123
confirm password: rishi123
Full Name: Rishi
Email Address: rishi@flash.com
```
```
Username: Kiran
Password: kiran123
confirm password: kiran123
Full Name: Kiran
Email Address: kiran@flash.com
```
```
Username: Sekhar
Password: sekhar123
confirm password: sekhar123
Full Name: Sekhar
Email Address: sekhar@flash.com
```
```
Username: Venkat
Password: venkat123
confirm password: venkat123
Full Name: Venkat
Email Address: venkat@flash.com
```
- After creations of Users, we need to login to Jenkins with the created user credentials and check if we are able to login successfully or not.
- After successful login, we need to check if we are able to access the Jenkins dashboard or not. If we are able to access the dashboard, then we are done with the creation of users in Jenkins. Here we are having the admin access to the Jenkins dashboard.

#### Configure Global Security
- Install the Jenkins plugin "Role Based Authorization Strategy Plugin" from the Jenkins plugin manager.
- Go to Manage Jenkins -> click on Security -> Select "Role-Based Authorization Strategy" in the authorization -> Apply and Save.
- Logout and Login Once again 
- Go to Manage Jenkins -> click on Security 
##### Click on manage and Assign Roles 
- In Global Roles ->
```
Role add: Developer -> click on Add
Role add: DevOps -> click on Add
```
- Select the Permissions you need to provide for the roles
- In Item roles ->
```
Role add: Developer -> pattern: Developer.* -> click on Add
Role add: DevOps -> pattern: DevOps.* -> click on Add
```
#####  Click on Assign Roles on the Left side
- In Global Roles -> Click on Add User -> Provide name as: Rishi -> click on Add -> Select the Role as: Developer
- In Global Roles -> Click on Add User -> Provide name as: Kiran -> click on Add -> Select the Role as: Developer
- In Global Roles -> Click on Add User -> Provide name as: Sekhar -> click on Add -> Select the Role as: DevOps
- In Global Roles -> Click on Add User -> Provide name as: Venkat -> click on Add -> Select the Role as: DevOps.

- Click on Apply and Save
- Login as Users credentials and check if we are able to access the Jenkins dashboard or not. If we are able to access the dashboard, check your access with the given permissions or not.

### OR
- Go to Manage Jenkins -> Configure Global Security -> Select "Project-Based Matrix Authorization Strategy" as the authorization strategy.
- Click on Add users -> Enter the Usernames and assign the permissions to that users by clicking on the checkbox.
- For Developers -> Select the checkbox for "Overall/Read" and Job and View permissions as per the requirement.
- For DevOps -> Select the checkbox for admin permissions or any relevent permissions we can provide as per the requirement.
- Save the changes.
#### Provide access on Specific Project for the users
- Go to the specific project(click on project name) for which you want to provide access to the users.
- Go to Configure -> in General tab -> click on "Enable project-based security" -> click on add user -> enter the username (Rishi) -> Provide the required permissions and save the changes.
- Same way we can provide access to the kiran user on the specific project.

### Difference between Role-Based Authorization Strategy, Project-Based Matrix Authorization Strategy and Matrix-Based Authorization Strategy
- ***Role-Based Authorization Strategy***: This is the most secure and flexible way to manage permissions in Jenkins. It allows you to define roles and assign permissions to those roles. You can then assign roles to users. This way, you can manage permissions at a high level and make changes easily.
- ***Project-Based Matrix Authorization Strategy***: This strategy is similar to the Role-Based Authorization Strategy, but it allows you to manage permissions at a project level. You can define roles and assign permissions to those roles, and then assign those roles to users for specific projects.
- ***Matrix-Based Authorization Strategy***: This strategy is the most basic way to manage permissions in Jenkins. It allows you to assign permissions directly to users. This way, you can manage permissions at a low level, but it can be time-consuming and error-prone.

### Jenkins Master Slave Architecture
- Jenkins Master Slave Architecture is a distributed architecture where one Jenkins instance acts as the master and multiple instances act as slaves. The master instance is responsible for managing the build process, while the slave instances are responsible for executing the build process. This architecture is useful for large-scale projects where multiple build processes need to be executed concurrently. 

1. Why we need Master Slave Architecture?
- We need Master Slave Architecture because it allows us to distribute the build process across multiple machines, which can improve the build speed and efficiency. It also allows us to scale the build process horizontally, which means we can add more slave instances as needed to handle increased build traffic. 

2. How many slaves can a master have in your recent Project?
- In my recent project, I had 5 slaves connected to the master instance. This allowed me to execute 5 build processes concurrently, which significantly improved the build speed and efficiency. 

3. Tell me why you need 5 slaves in your recent project? 
- I needed 5 slaves in my recent project because the build process was computationally intensive and required a lot of resources. By distributing the build process across 5 slave instances, I was able to utilize the available resources more efficiently and complete the build process faster. 

4. If you have Jenkins master server with high configuration, why you need master slave architecture?
- Even if I have a Jenkins master server with high configuration, I still need the master slave architecture because it allows me to scale the build process horizontally. This means I can add more slave instances as needed to handle increased build traffic, which can improve the build speed and efficiency.
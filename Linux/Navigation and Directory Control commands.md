### mkdir (make directory)
- **mkdir DevOps**: Creates a new directory named "DevOps" in the current working directory.
- **mkdir -v DevOps**: Creates a new directory named "DevOps" in the current working directory and displays the directory creation process in verbose mode. 
- **mkdir -p DevOps/linux/git**: Creates a new directory named "DevOps" in the current working directory, and then creates the sub directories "linux" and "git" within it. If any of the parent directories do not exist, they will be created as well.
- **mkdir -m 755 DevOps**: Creates a new directory named "DevOps" in the current working directory with permissions set to 755 (owner has read, write, and execute permissions, group has read and execute permissions, and others have read and execute permissions). 
- **mkdir -v -m 755 DevOps**: Creates a new directory named "DevOps" in the current working directory with permissions set to 755 and displays the directory creation process in verbose mode.
- **mkdir -p -m 755 DevOps/linux/git**: Creates a new directory named "DevOps" in the current working directory with permissions set to 755, and then creates the sub directories "linux" and "git" within it. If any of the parent directories do not exist, they will be created as well. 

### tree
- **tree**: Displays the directory structure of the current working directory in a tree format.
- **tree -a**: Displays the directory structure of the current working directory in a tree format, including hidden files. 
- **tree -d**: Displays the directory structure of the current working directory in a tree format, only showing directories.
- **tree -f**: Displays the directory structure of the current working directory in a tree format, showing the full path of each file. 
- **tree -L 2**: Displays the directory structure of the current working directory in a tree format, only showing the first two levels of the directory hierarchy.
- **tree -L 2 -a**: Displays the directory structure of the current working directory in a tree format, only showing the first two levels of the directory hierarchy, including hidden files.
- **tree -I node_modules**: Displays the directory structure of the current working directory in a tree format, excluding the "node_modules" directory and its contents. 

### ls (list)
- **ls**: Displays the contents of the current working directory. 
- **ls -a**: Displays the contents of the current working directory, including hidden files. 
- **ls -l**: Displays the contents of the current working directory in a long format, showing file permissions, ownership, and timestamps. 
- **ls -l -h**: Displays the contents of the current working directory in a long format, showing file permissions, ownership, and timestamps, and also displaying file sizes in human-readable format. 
- **ls -r**: Displays the contents of the current working directory in reverse order. 
- **ls -r -a**: Displays the contents of the current working directory in reverse order, including hidden files.
- **ls -r -l**: Displays the contents of the current working directory in reverse order, in a long format, showing file permissions, ownership, and timestamps.
- **ls -r -l -h**: Displays the contents of the current working directory in reverse order, in a long format, showing file permissions, ownership, and timestamps, and also displaying file sizes in human-readable format. 
- **ls -ltr**: Displays the contents of the current working directory in a long format, showing file permissions, ownership, and timestamps, and sorting the output by timestamp in descending order.
- **ls -i**: Displays the contents of the current working directory, showing the inode number of each file.
- **ls -f**: Displays the contents of the current working directory, showing the full path of each file. 

### yum (Yellowdog Updater Modified)
- **yum**: Installs or updates packages on a Red Hat-based system. 
- **yum install package_name**: Installs a package on a Red Hat-based system.
- **yum update**: Updates all packages on a Red Hat-based system. 
- **yum list all**: Lists all packages available on a Red Hat-based system. 
- **yum list installed**: Lists all installed packages on a Red Hat-based system.
- **yum list updates**: Lists all available package updates on a Red Hat-based system.
- **yum remove package_name**: Removes a package from a Red Hat-based system.
Ex: `yum remove nodejs`
- **yum search keyword**: Searches for packages on a Red Hat-based system based on a keyword. 
Ex: `yum search nodejs`
- **yum info package_name**: Displays detailed information about a package on a Red Hat-based system.
Ex: `yum info nodejs`
- **yum clean all**: Cleans the yum cache on a Red Hat-based system.
Ex: `yum clean all` 
- **yum check-update**: Checks for available updates on a Red Hat-based system. 
Ex: `yum check-update`
- **yum history**: Displays the history of yum transactions on a Red Hat-based system.
Ex: `yum history`
- **yum history info**: Displays detailed information about a yum transaction on a Red Hat-based system.
Ex: `yum history info 1`
- **yum history undo**: Undoes a yum transaction on a Red Hat-based system.
Ex: `yum history undo 1`

### apt (advanced package tool)
- **apt**: Installs or updates packages on a Debian-based system.
Ex: `apt update && apt install nodejs`
- **apt update**: Updates the package index on a Debian-based system.
Ex: `apt update`
- **apt install package_name**: Installs a package on a Debian-based system.
Ex: `apt install nodejs`
- **apt remove package_name**: Removes a package from a Debian-based system.
Ex: `apt remove nodejs`
- **apt search keyword**: Searches for packages on a Debian-based system based on a keyword.
Ex: `apt search nodejs`
- **apt show package_name**: Displays detailed information about a package on a Debian-based system.
Ex: `apt show nodejs`
- **apt autoremove**: Removes unnecessary packages on a Debian-based system.
Ex: `apt autoremove`
- **apt autoclean**: Cleans the apt cache on a Debian-based system.
Ex: `apt autoclean`
- **apt list --upgradable**: Lists all upgradable packages on a Debian-based system.
Ex: `apt list --upgradable`
- **apt list --installed**: Lists all installed packages on a Debian-based system.
Ex: `apt list --installed`

### cd (change directory)
- **cd**: Changes the current working directory.
Ex: `cd DevOps`
- **cd ~**: Changes to the user's home directory.
Ex: `cd ~`
- **cd ..**: Changes to the parent directory.
Ex: `cd ..`
- **cd /**: Changes to the root directory.
Ex: `cd /`
- **cd /path/to/directory**: Changes to a specific directory.
Ex: `cd /home/user/Documents`
- **cd -**: Changes to the previous directory.
Ex: `cd -`

### pwd (print working directory)
- **pwd**: Displays the current working directory.
Ex: `pwd`
- **pwd -P**: Displays the canonical path of the current working directory.
Ex: `pwd -P` 
- **pwd -L**: Displays the logical path of the current working directory.
Ex: `pwd -L`

### rmdir (remove directory)
- **rmdir**: Removes an empty directory. 
Ex: `rmdir DevOps`
- **rmdir -p /path/to/directory**: Removes a directory and its contents recursively.
Ex: `rmdir -p /home/user/Documents`

### rm (remove file)
- **rm**: Removes a file.
Ex: `rm file.txt`
- **rm -i**: Prompts for confirmation before removing a file.
Ex: `rm -i file.txt`
- **rm -r**: Removes a directory and its contents recursively.
Ex: `rm -r /home/user/Documents`
- **rm -rf**: Removes a directory and its contents recursively, forcing removal without prompting.
Ex: `rm -rf /home/user/Documents`
- **rm -v**: Displays the files being removed.
Ex: `rm -v file.txt`
- **rm -i -v**: Prompts for confirmation and displays the files being removed.
Ex: `rm -i -v file.txt`
- **rm -r -v**: Removes a directory and its contents recursively, displaying the files being removed.
Ex: `rm -r -v /home/user/Documents`
- **rm -rf -v**: Removes a directory and its contents recursively, forcing removal without prompting and displaying the files being removed.
Ex: `rm -rf -v /home/user/Documents`
- **rm -i -r -v**: Prompts for confirmation, removes a directory and its contents recursively, and displays the files being removed.
Ex: `rm -i -r -v /home/user/Documents`

## Difference between Linux and DOS navigation commands
Linux and DOS have different navigation commands. Here are some key differences:
| Command in Linux | Command in DOS | Description |
| --- | --- | --- |
| `cd` | `cd` | Changes the current directory. |
| `cd ~` | `cd ~` | Changes to the user's home directory. |
| `cd ..` | `cd ..` | Changes to the parent directory. |
| `cd /` | `cd \` | Changes to the root directory. |
| `pwd` | `cd` (without arguments) | Displays the current working directory. |
| `rmdir` | `rmdir` | Removes an empty directory. |
| `rm` | `del` | Removes a file. |
| `mkdir` | `mkdir` | Creates a new directory. |
| `ls` | `dir` | Lists the files and directories in the current directory. |
| `cp` | `copy` | Copies a file. |
| `mv` | `move` | Moves or renames a file. |
| `touch` | `type` | Creates a new empty file. |
| `cat` | `type` | Displays the contents of a file. |
| `echo` | `echo` | Displays a message or a string. |
| `man` | `help` | Displays the manual for a command. |
| `history` | `history` | Displays a list of previously executed commands. |
| `!` | `!` | Recalls the last command. |
| `!!` | `!!` | Recalls the last command and executes it. |
| `^` | `^` | Recalls the last command and executes it with the first word changed to the next argument. |
| `!$` | `!$` | Recalls the last command and executes it with the last word changed to the next argument. |

## Interview Questions and Answers (in 1line) in this Navigate Linux File System topic:
1. **What is the difference between `cd` and `pwd` commands?**
- `cd` changes the current directory, while `pwd` displays the current working directory.
2. **How do you remove a directory and its contents recursively?**
- Use the `rm -r` command.
3. **What is the purpose of the `man` command?**
- Displays the manual for a command.
4. **How do you recall the last command in the terminal?**
- Use the `!` command.
5. **What is the difference between `rm` and `rmdir` commands?**
- `rm` removes a file, while `rmdir` removes an empty directory.
6. **How do you create a new directory?**
- Use the `mkdir` command.
7. **What is the purpose of the `history` command?**
- Displays a list of previously executed commands.
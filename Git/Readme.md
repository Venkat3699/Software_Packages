## Git
Git is a Opensource version control system. It is used to track changes in source code over time. It is a distributed system, meaning that every developer working on a project has a full copy of the entire project history.

## GitHub 
GitHub is a web-based platform for version control and collaboration. It allows users to host and share code with others, track changes, and collaborate on projects. GitHub is built on top of Git and provides a user-friendly interface for managing repositories, tracking changes, and collaborating with others. 

## Git Commands:
- **git config**: This command is used to set or change configuration settings for your local repository. For example, you can use it to set your name and email address, which are used to identify you as the author of commits.
- **git config --global**: This command is used to set or change configuration settings for your global repository. For example, you can use it to set your name and email address, which are used to identify you as the author of commits. The --global option means that the setting will be applied to all repositories on your computer.
Ex: `git config --global user.name "Your Name"` and `git config --global user.email "your_email@example.com"`
- **git config --local**: This command is used to set or change configuration settings for your local repository. For example , you can use it to set your name and email address, which are used to identify you as the author of commits. The --local option means that the setting will be applied only to the current repository. 
Ex: `git config --local user.name "Your Name"` and `git config --local user.email "your_email@example.com"`
- **git config --global --list**: This command is used to list all the configuration settings for your global repository. This can be useful for seeing what settings are currently in effect.
Ex: `git config --global --list` and `git config --local --list`
- **git init**: Initializes a new Git repository. This command is used to create a new Git repository in the current directory. It creates a new .git directory in the current directory, which contains all the necessary files to manage the repository.
Ex: `git init`
- **.gitignore**: This is a file that contains a list of files and directories that you want Git to ignore. This can be useful for ignoring files that are not important for the project, such as temporary files or compiled code.
Ex: `touch .gitignore` and then add the files you want to ignore in the file.
Ex: `echo "file1.txt" >> .gitignore` and `echo "file2.txt" >> .gitignore`
- **git add**: Adds files to the staging area. This command is used to add files to the staging area, which is a temporary area where Git stores files before they are committed to the repository.
Ex: `git add file.txt` or `git add .` to add all files in the current directory.
- **git commit**: Commits changes to the repository. This command is used to commit changes to the repository. It takes a commit message as an argument, which describes the changes made in the commit.
Ex: `git commit -m "Added new feature"` 
here -m is: message
- **git rm --cached**: This command is used to remove a file from the staging area. It removes the file from the staging area, but does not delete it from the local repository. This is useful for removing files that are no longer needed, but still want to keep a record of them in the repository.
Ex: `git rm --cached file.txt`
- **git log**: Displays a log of all commits made to the repository. This command is used to display a log of all commits made to the repository. It shows the commit hash, author, date, and message for each commit.
Ex: `git log` or `git log --oneline` to display a one-line log. 
- **git commit -v**: Displays the diff of the changes made in the commit. This command is used to display the diff of the changes made in the commit. It shows the changes made in the commit, including the added, modified, and deleted lines. 
Ex: `git commit -v` or `git commit -v -a` to display the diff of all files in the commit.
- **git remote -v**: Displays the URL of the remote repository. This command is used to display the URL of the remote repository. It shows the URL of the remote repository, which is used to connect to the remote repository. 
Ex: `git remote -v`
- **git remote add**: Adds a new remote repository. This command is used to add a new remote repository. It takes the name of the remote repository and its URL as arguments.
Ex: `git remote add origin https://github.com/user/repository.git` and `git remote add Projectname https://github.com/user/repository.git`
- **git push**: Pushes changes to the remote repository. This command is used to push changes to the remote repository. It takes the name of the remote repository and the branch to push as arguments.
Ex: `git push origin master` or `git push Projectname master`
- **git pull**: Pulls changes from the remote repository. This command is used to pull changes from the remote repository. It takes the name of the remote repository and the branch to pull as arguments.
Ex: `git pull origin master` or `git pull Projectname master`
- **git fetch**: Fetches changes from the remote repository. This command is used to fetch changes from the remote repository. It takes the name of the remote repository as an argument.
Ex: `git fetch origin` or `git fetch Projectname`
- **git clone**: Clones a repository from a remote repository. This command is used to clone a repository from a remote repository. It takes the URL of the remote repository as an argument.
Ex: `git clone https://github.com/user/repository.git`
- **git branch**: Creates a new branch in the repository. This command is used to create a new branch in the repository. It takes the name of the branch as an argument. 
Ex: `git branch feature/new-feature` or `git branch -m feature/new-feature` to rename a branch.
- **git branch -a**: Displays a list of all branches in the repository. This command is used to display a list of all branches in the repository. It shows the name of each branch, including the current branch.
Ex: `git branch -a` or `git branch -a --all` to display all branches in the repository.
- **git checkout**: Switches to a different branch or file. This command is used to switch to a different branch or file. It takes the name of the branch or file as an argument. 
Ex: `git checkout feature/new-feature` or `git checkout file.txt`
- **git branch -d**: Deletes a branch. This command is used to delete a branch. It takes the name of the branch as an argument. 
Ex: `git branch -d feature/new-feature`
- **git branch -m**: Renames a branch. This command is used to rename a branch. It takes the old and new names of the branch as arguments. 
Ex: `git branch -m feature/new-feature feature/new-feature-renamed`
- **git branch -D**: Deletes a branch and its history. This command is used to delete a branch and its history. It takes the name of the branch as an argument.
Ex: `git branch -D feature/new-feature`
- **git merge**: Merges changes from one branch into another. This command is used to merge changes from one branch into another. It takes the name of the branch to merge as an argument.
Ex: `git merge feature/new-feature` or `git merge --no-ff feature/new-feature` to merge without fast-forwarding.
- **git rebase**: Rebases changes from one branch onto another. This command is used to rebase changes from one branch onto another. It takes the name of the branch to rebase as an argument.
Ex: `git rebase feature/new-feature` or `git rebase --interactive feature/new-feature ` to rebase interactively.
- **git cherry-pick**: Applies changes from one commit to another. This command is used to apply changes from one commit to another. It takes the hash of the commit to cherry-pick as an argument.
Ex: `git cherry-pick 1234567890abcdef` or `git cherry-pick -n 1234567890abcdef` to cherry-pick without committing. 
- **git reset**: Resets the current branch to a previous commit. This command is used to reset the current branch to a previous commit. It takes the hash of the commit to reset to as an argument.
Ex: `git reset 1234567890abcdef` or `git reset --hard 1234567890abcdef` to reset hard.
- **git revert**: Reverts changes made in a previous commit. This command is used to revert changes made in a previous commit. It takes the hash of the commit to revert as an argument. 
Ex: `git revert 1234567890abcdef` or `git revert -n 1234567890abcdef` to revert without committing.
- **git stash**: Saves changes to a temporary area. This command is used to save changes to a temporary area. It takes the name of the stash as an argument.
Ex: `git stash` or `git stash save "Temporary changes"` to save changes with a message.
- **git stash pop**: Applies changes from a temporary area. This command is used to apply changes from a temporary area. It takes the name of the stash as an argument.
Ex: `git stash pop` or `git stash pop stash@{0}` to apply changes from the first stash.
- **git stash drop**: Deletes a stash. This command is used to delete a stash. It takes the name of the stash as an argument. 
Ex: `git stash drop` or `git stash drop stash@{0}` to delete the first stash.
- **git stash list**: Displays a list of all stashes. This command is used to display a list of all stashes . It shows the name of each stash, including the current stash.
Ex: `git stash list` or `git stash list --all` to display all stashes
- **git stash -a**: Applies all stashes. This command is used to apply all stashes. It takes no arguments. 
Ex: `git stash -a` or `git stash -a --all` to apply all stashes.
- **git squash**: Squashes multiple commits into one. This command is used to squash multiple commits into one. It takes the hash of the commit to squash as an argument.
Ex: `git squash 1234567890abcdef` or `git squash -n 1234567890abcdef` to squash without committing.
- **git tag**: Creates a new tag in the repository. This command is used to create a new tag in the repository. It takes the name of the tag as an argument.
Ex: `git tag v1.0` or `git tag -a v1.0 -m "Release 1.0"` to create a new tag with a message.

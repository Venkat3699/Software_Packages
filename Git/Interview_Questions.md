### Git Interview Questions and Answers in 2 line for each question
1. What is Git?
Answer: Git is a version control system that helps you track changes made to your code over time.
2. What is the difference between Git and GitHub?
Answer: Git is a version control system, while GitHub is a web-based platform that hosts and manages Git repositories.
3. What is the purpose of the `git add` command?
Answer: The `git add` command stages changes in your working directory to be committed to the repository.
4. What is the purpose of the `git commit` command?
Answer: The `git commit` command commits changes in the staging area to the repository.
5. What is the difference between `git fetch` and `git pull`?
Answer: `git fetch` retrieves data from a remote repository, while `git pull` retrieves data from a remote repository and merges it with your local repository. 
6. How do you check logs in git?
Answer: You can check logs in git using the command `git log`. 
7. How do you revert changes in git?
Answer: You can revert changes in git using the command `git revert`.
8 What is the difference between `git reset` and `git revert`?
Answer: `git reset` resets the current branch head to the specified state, while `git revert` creates a new commit that undoes the changes made by the previous commit. 
9. How do you merge two branches in git?
Answer: You can merge two branches in git using the command `git merge`. 
10. What is the difference between `git merge` and `git rebase`?
Answer: `git merge` merges two branches by creating a new commit, while `git rebase` replays the changes from one branch onto the other branch. 
11. How do you create a new branch in git?
Answer: You can create a new branch in git using the command `git branch`.
12. How we can retrive the delete branch in git?
Answer: You can retrieve the deleted branch in git using the command `git checkout -b <branch _name> <commit_hash>`.
13. How do you delete a branch in git?
Answer: You can delete a branch in git using the command `git branch -d <branch_name>`.
14. What is .gitignore file in git?
Answer: .gitignore file is used to specify intentionally untracked files to git. 
15. How to manage, some files not move into the git repository?
Answer: You can manage some files not move into the git repository by using .gitignore file.
16. How to create a new tag in git?
Answer: You can create a new tag in git using the command `git tag <tag_name> <commit_hash>`.
17. How to delete a tag in git?
Answer: You can delete a tag in git using the command `git tag -d <tag_name >`.
18. What is git Hard, soft and mixed resets, explain each?
Answer: **Git hard reset**: It resets the current branch head to the specified state and discards all changes since then. 
Ex: `git reset --hard <commit_hash>` 
**Git soft reset**: It resets the current branch head to the specified state and preserves all changes since the specified state.
Ex: `git reset --soft <commit_hash>`
**Git mixed reset**: It resets the current branch head to the specified state and preserves all changes since the specified state, but discards changes in the working directory.
Ex: `git reset --mixed <commit_hash>`
19. How to ammend changes in git?
Answer: You can amend changes in git using the command `git commit --amend`. 
20. How to stash changes in git?
Answer: You can stash changes in git using the command `git stash`. 
21. Can you explain the git stash workflow with example?
Answer: Yes, the git stash workflow is as follows:
- `git stash`: Stashes the changes in the working directory and removes them from the working directory.
- `git stash list`: Lists all the stashed changes.
- `git stash apply`: Applies the stashed changes to the working directory.
- `git stash pop`: Applies the stashed changes to the working directory and removes the stash from
the stash list.
22. How to cherry pick a commit in git?
Answer: You can cherry pick a commit in git using the command `git cherry-pick <commit _hash>`. 
23. How to reword a commit in git?
Answer: You can reword a commit in git using the command `git commit --amend -m <new _commit _message>`.
24. How to squash commits in git?
Answer: You can squash commits in git using the command `git re squash <commit_hash>.. HEAD`.
25. How to create a new repository in git?
Answer: You can create a new repository in git using the command `git add .` and ` git commit -m "initial commit"`.
26. How to clone a repository in git?
Answer: You can clone a repository in git using the command `git clone <repository_url>`.
27. How to push changes to a remote repository in git?
Answer: You can push changes to a remote repository in git using the command `git push <remote _name> <branch_name>`.
28. How to pull changes from a remote repository in git?
Answer: You can pull changes from a remote repository in git using the command `git pull <remote _name> <branch_name>`.
29. How to add a remote repository in git?
Answer: You can add a remote repository in git using the command `git remote add <remote_name> <repository_url>`.
30. How to remove a remote repository in git?
Answer: You can remove a remote repository in git using the command `git remote remove <remote_name>`.
31. How to rename a remote repository in git?
Answer: You can rename a remote repository in git using the command `git remote rename <old_remote_name> <new_remote_name>`.
32. How to fetch changes from a remote repository in git?
Answer: You can fetch changes from a remote repository in git using the command `git fetch <remote_name>`.
33. How to merge two branches in git?
Answer: You can merge two branches in git using the command `git merge <branch_name>`. 
34. How to resolve conflicts in git?
Answer: You can resolve conflicts in git by using the command `git status` to see the conflicts, `git add <file>` to stage the resolved conflicts, and `git commit` to commit the resolved conflicts. 
35. Can you explain what kind of conflicts you have faced while merging the branch?
Answer: Yes, there are three types of conflicts you can face while merging a branch in git:
- **Content conflicts**: These occur when the same line of code has been modified in both branches.
- **Merge conflicts**: These occur when the same line of code has been modified in both branches,
but the changes are different.
- **Binary conflicts**: These occur when the same binary file has been modified in both branches. 
36. How to resolve content conflicts in git?
Answer: You can resolve content conflicts in git by using the command `git status` to see the conflicts, `git add <file>` to stage the resolved conflicts, and `git commit` to commit the resolved conflicts.
37. How can we check the conflicts by using the git status command?
Answer: You can check the conflicts by using the command `git status` with the option `--no-commit` to see the conflicts without committing them.

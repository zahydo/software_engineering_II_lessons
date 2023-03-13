# GIT Introduction
Git is a popular version control system that is widely used by developers to manage and track changes to their codebase. It allows you to keep track of different versions of your code, collaborate with others on a project, and roll back changes if necessary. In this lesson, we'll cover some basic Git concepts, how to install Git, and some basic Git commands.

## Basic Git Concepts

Before we dive into the commands, let's cover some basic Git concepts that you'll need to understand to use Git effectively.

## Repository
A repository is a central location where your Git project is stored. It contains all the files and directories that make up your project, as well as the history of changes that have been made to those files.

## Commit
A commit is a snapshot of your code at a specific point in time. When you make a commit, you're essentially creating a record of the changes you've made since the last commit. Each commit has a unique identifier, called a SHA-1 hash, that you can use to refer to it later.

## Branch
A branch is a separate line of development that allows you to work on different features or bug fixes without affecting the main codebase. When you create a branch, you're essentially creating a copy of the main codebase that you can work on independently. Once you've finished working on a branch, you can merge it back into the main codebase.

## Installing Git
To install Git, follow these steps:

- Go to the Git website and download the version of Git that is appropriate for your operating system.

- Follow the installation instructions for your operating system.

- Once Git is installed, open a terminal or command prompt and type `git --version` to verify that Git is installed correctly.

## Basic Git Commands
Now that you have Git installed, let's go over some basic Git commands that you'll need to know to use Git.

**git init**

The `git init` command is used to initialize a new Git repository. To use this command, navigate to the directory where you want to create your Git repository and run `git init`.

**git clone**

The `git clone` command is used to create a copy of an existing Git repository. To use this command, navigate to the directory where you want to clone the repository and run `git clone <repository URL>`.

**git add**

The `git add` command is used to add files to the staging area. The staging area is a temporary storage area where you can add files that you want to commit. To add a file to the staging area, run `git add <file>`.

**git commit**

The `git commit` command is used to create a new commit. When you run git commit, Git will open your default text editor so that you can enter a commit message. To create a commit with a message, run `git commit -m "<commit message>"`.

**git push**

The `git push` command is used to upload your changes to a remote Git repository. To push your changes, run `git push <remote> <branch>`. For example, if your remote repository is named origin and your branch is named main, you would run git push origin main.

**git pull**

The `git pull` command is used to download changes from a remote Git repository. To pull changes, run `git pull <remote> <branch>`. For example, if your remote repository is named origin and your branch is named main, you would run git pull origin main.

**git status**

The `git status` command shows you which files have been modified, which files are staged and ready to be committed, and which files are not being tracked by Git. It's a useful command to run frequently to keep track of your changes. To run `git status`, simply type git status in your terminal.

**git branch**

The `git branch` command is used to manage Git branches. To list all branches in your repository, run git branch. To create a new branch, run `git branch <branch name>`. To switch to a different branch, run `git checkout <branch name>`. To create a new branch and switch to it at the same time, run `git checkout -b <branch name>`.

**git merge**

The `git merge` command is used to merge two branches together. To merge one branch into another, first switch to the branch that you want to merge into (e.g. git checkout main), then run `git merge <branch to merge>`. Git will automatically merge the changes from the other branch into the current branch.

**git log**

The `git log` command is used to view the commit history of your Git repository. Running git log will show you a list of all the commits that have been made, along with their commit message, author, date, and SHA-1 hash.

**git remote**

The `git remote` command is used to manage the remote Git repositories that your local repository is connected to. To list all remote repositories, run git remote. To add a new remote repository, run `git remote add <remote name> <remote URL>`. To remove a remote repository, run`git remote rm <remote name>`.

## Conclusion
In this lesson, we've covered some basic Git concepts, how to install Git, and some essential Git commands that you'll need to know to use Git effectively. Remember that Git is a powerful tool, but it can also be complex. Take the time to learn it properly, and don't be afraid to ask for help or consult the official Git documentation if you run into problems. Good luck!

### [Git Branching Playground](https://learngitbranching.js.org/)


---
[Back to Index](../README.md)
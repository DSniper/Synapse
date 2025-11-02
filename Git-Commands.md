# 🧠 Git Command Guide for Projects

A complete, practical guide to using **Git** — from the first clone to resolving complex merge conflicts.
This document ensures every contributor can collaborate seamlessly and confidently.

---

## 📥 1. Clone the Repository

```bash
# Clone using HTTPS
git clone https://github.com/username/repository.git

# Clone using SSH
git clone git@github.com:username/repository.git

# Move into the project directory
cd repository
```

---

## 🏗️ 2. Initialize a New Repository (if starting fresh)

```bash
git init
```

---

## 🧭 3. Configure Git (Only Once)

```bash
git config --global user.name "Your Name"
git config --global user.email "youremail@example.com"
git config --global core.editor "code --wait"   # Optional: set VS Code as default editor
```

To verify:

```bash
git config --list
```

---

## 🌿 4. Branch Management

```bash
# List all branches
git branch -a

# Create a new branch
git branch feature/new-feature

# Switch to a branch
git checkout feature/new-feature

# Create and switch in one command
git checkout -b feature/new-feature

# Delete a branch
git branch -d feature/old-feature
```

---

## 💾 5. Track and Commit Changes

```bash
# Check the status of your changes
git status

# Add a specific file
git add filename.ext

# Add all changes
git add .

# Commit changes
git commit -m "Your clear, concise commit message"
```

---

## 🔄 6. Pull Updates from Remote

```bash
# Pull latest updates from main branch
git pull origin main
```

If you want to rebase (cleaner history):

```bash
git pull --rebase origin main
```

---

## 🚀 7. Push Your Changes

```bash
# Push current branch to remote
git push origin branch-name
```

If the branch is new:

```bash
git push -u origin branch-name
```

---

## 🧩 8. Merge or Rebase

### Merge:

```bash
# Switch to target branch (e.g., main)
git checkout main

# Merge your branch
git merge feature/new-feature
```

### Rebase:

```bash
# On your feature branch
git checkout feature/new-feature

# Rebase onto main for clean history
git rebase main
```

---

## ⚔️ 9. Resolving Merge Conflicts

When a conflict occurs:

```bash
# Check conflicting files
git status
```

Edit conflicting files manually — look for:

```
<<<<<<< HEAD
Your changes
=======
Incoming changes
>>>>>>> branch-name
```

After fixing:

```bash
# Mark as resolved
git add filename.ext

# Continue the merge or rebase
git merge --continue
# or
git rebase --continue
```

If you want to abort:

```bash
git merge --abort
# or
git rebase --abort
```

---

## 🧹 10. Undoing and Fixing Mistakes

```bash
# Undo last commit but keep changes
git reset --soft HEAD~1

# Undo last commit and discard changes
git reset --hard HEAD~1

# Revert a specific commit
git revert <commit-hash>

# Remove file from staging
git reset HEAD filename.ext
```

---

## 🔍 11. View History and Logs

```bash
# Commit history
git log --oneline --graph --decorate --all

# View specific file history
git log filename.ext

# View changes in a commit
git show <commit-hash>
```

---

## 🧠 12. Sync Forked Repository (if applicable)

```bash
# Add upstream remote
git remote add upstream https://github.com/original/repository.git

# Fetch upstream updates
git fetch upstream

# Merge or rebase
git merge upstream/main
# or
git rebase upstream/main
```

---

## 🔐 13. Stashing (Save Temporary Work)

```bash
# Stash current changes
git stash

# List all stashes
git stash list

# Apply latest stash
git stash apply

# Drop latest stash
git stash drop
```

---

## 🧭 14. Remote Management

```bash
# View remotes
git remote -v

# Add a remote
git remote add origin https://github.com/username/repository.git

# Change remote URL
git remote set-url origin https://github.com/new/repo.git

# Remove remote
git remote remove origin
```

---

## 🧾 15. Common Shortcuts & Tips

| Action                       | Command                                |
| ---------------------------- | -------------------------------------- |
| See file differences         | `git diff`                             |
| Show last commit details     | `git show`                             |
| Check which branch you’re on | `git branch`                           |
| Delete remote branch         | `git push origin --delete branch-name` |
| Rename branch                | `git branch -m old-name new-name`      |

---

## ✅ 16. Best Practices

* Always pull before starting new work.
* Commit small, atomic changes with clear messages.
* Never push directly to `main` (use Pull Requests).
* Use `git rebase` to keep commit history clean.
* Review conflicts carefully — never blindly overwrite.

---

### 🧠 Need Help?

```bash
git help <command>
# Example
git help commit
```

---

* **Created for:** `Synapse Project`
* **Maintainer:** Daisy Manmohan Singh

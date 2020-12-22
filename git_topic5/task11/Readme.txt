- создал веб проект

- выполнил в командной строке (проиндексировал): git add 
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git add --all
warning: LF will be replaced by CRLF in task11/src/main/webapp/WEB-INF/web.xml.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in task11/src/main/webapp/index.jsp.
The file will have its original line endings in your working directory


- посмотрел статус добавленных файлов : git status
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git status
On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   ../.gitignore
        new file:   pom.xml
        new file:   src/main/webapp/WEB-INF/web.xml
        new file:   src/main/webapp/index.jsp


- выполнил в командной строке (добавил в рабочую директорию) : git commit -a -m "Commit 1"
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git commit -a -m "Commit 1"
[main 8657652] Commit 1
 4 files changed, 82 insertions(+)
 create mode 100644 task11/pom.xml
 create mode 100644 task11/src/main/webapp/WEB-INF/web.xml
 create mode 100644 task11/src/main/webapp/index.jsp
 
 
- выполнил в командной строке (записал рабочую директорию в гит) : git push origin main
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git push origin main
Enumerating objects: 13, done.
Counting objects: 100% (13/13), done.
Delta compression using up to 6 threads
Compressing objects: 100% (8/8), done.
Writing objects: 100% (11/11), 1.50 KiB | 384.00 KiB/s, done.
Total 11 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To https://github.com/yurkobrisk/temp_topic5.git
   afb3f54..8657652  main -> main
   
   
- выполнил в командной строке (посмотреть отчет о коммитах) : git log
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git log
commit 8657652b053c07ed2a89016787fdb978982e678b (HEAD -> main, origin/main, origin/HEAD)
Author: Yury Korziuk <yurko@tut.by>
Date:   Tue Dec 22 14:44:33 2020 +0300

    Commit 1

commit afb3f54c685e1ef4446fd7556812bed75e6f0d00
Author: Yury <yurkobrisk@gmail.com>
Date:   Tue Dec 22 12:33:48 2020 +0300

    Initial commit
	
	
- показать все ветки (локальные и удаленные) : git branch -av
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11/src/main/webapp (main)
$ git branch -av
* main                8657652 Commit 1
  remotes/origin/HEAD -> origin/main
  remotes/origin/main 8657652 Commit 1
	
- создать еще один бранч : git branch secondary
- показать все ветки : git branch -av
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11/src/main/webapp (main)
$ git branch -av
* main                8657652 Commit 1
  secondary           8657652 Commit 1
  remotes/origin/HEAD -> origin/main
  remotes/origin/main 8657652 Commit 1
  
- переключение на другую ветку : git checkout secondary
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11/src/main/webapp (main)
$ git checkout secondary
Switched to branch 'secondary'

yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11/src/main/webapp (secondary)
$ git branch -av
  main                8657652 Commit 1
* secondary           8657652 Commit 1
  remotes/origin/HEAD -> origin/main
  remotes/origin/main 8657652 Commit 1

- изменил файл pom.xml в ветке secondary и проиндексировал его командой git add pom.xml 
- посмотрел статус
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (secondary)
$ git status
On branch secondary
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   pom.xml
		
- сделал комит из ветки secondary git commit -a -m pom.xml
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (secondary)
$ git commit -a -m pom.xml
[secondary 1059ac4] pom.xml
 1 file changed, 7 insertions(+), 2 deletions(-)

- в Idea при выборе в качестве активной ветки main загружается не измененный файл pom.xml
- там же при выборе в качестве активной ветки secondary открывается ИЗМЕНЕННЫЙ файл pom.xml


- запушил комит в удаленный репозиторий git push origin secondary
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (secondary)
$ git push origin secondary
Enumerating objects: 7, done.
Counting objects: 100% (7/7), done.
Delta compression using up to 6 threads
Compressing objects: 100% (4/4), done.
Writing objects: 100% (4/4), 457 bytes | 228.00 KiB/s, done.
Total 4 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
remote:
remote: Create a pull request for 'secondary' on GitHub by visiting:
remote:      https://github.com/yurkobrisk/temp_topic5/pull/new/secondary
remote:
To https://github.com/yurkobrisk/temp_topic5.git
 * [new branch]      secondary -> secondary
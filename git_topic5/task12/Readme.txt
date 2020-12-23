- в удаленном репозитории (https://github.com/yurkobrisk/temp_topic5) два бранча :
	main (первоначальная версия pom.xml)
	secondary (изменен pom.xml файл)

- что предполагается сделать :
	изменить активную ветку на main
	внести изменения в файл pom.xml
	зафиксировать изменения в активной ветке
	слить ветки в одну 
	запушить изменения в удаленный репозиторий

yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (secondary)
$ git checkout main
Switched to branch 'main'
Your branch is up to date with 'origin/main'.

добавил в pom.xml
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.22</version>
    </dependency>
	
проиндексировал изменения
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git add pom.xml

посмотрел статус
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git status
On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   pom.xml
		
добавил в локальный репозиторий
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git commit -a -m "Commit 3. Changed pom.xml on branch main"
[main 2fd055a] Commit 3. Changed pom.xml on branch main
 1 file changed, 5 insertions(+)

объединил изменения из двух разных веток в одну
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git merge secondary
Auto-merging task11/pom.xml
Merge made by the 'recursive' strategy.
 task11/pom.xml | 9 +++++++--
 1 file changed, 7 insertions(+), 2 deletions(-)
 
 запушил изменения в удаленный репозиторий
 yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git push origin main
Enumerating objects: 14, done.
Counting objects: 100% (14/14), done.
Delta compression using up to 6 threads
Compressing objects: 100% (8/8), done.
Writing objects: 100% (8/8), 925 bytes | 231.00 KiB/s, done.
Total 8 (delta 2), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (2/2), completed with 1 local object.
To https://github.com/yurkobrisk/temp_topic5.git
   8657652..8c52ec9  main -> main

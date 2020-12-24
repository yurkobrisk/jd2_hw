- в удаленном репозитории (https://github.com/yurkobrisk/temp_topic5) бранч main 

- что предполагается сделать :
	внести изменения в файл jsp
	сохранить измения локально и запушить в репозиторий
	выполнить откат изменений

изменил pom.xml : удалил часть кода :
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
	
проиндексировал изменения
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git add pom.xml

добавил в локальный репозиторий
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git commit -a -m "Commit 5. Deleted Junit block"
[main 70e6611] Commit 5. Deleted Junit block
 1 file changed, 6 deletions(-)
 
сохранил в удаленный репозиторий
yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git push origin main
Enumerating objects: 7, done.
Counting objects: 100% (7/7), done.
Delta compression using up to 6 threads
Compressing objects: 100% (4/4), done.
Writing objects: 100% (4/4), 395 bytes | 197.00 KiB/s, done.
Total 4 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To https://github.com/yurkobrisk/temp_topic5.git
   8c52ec9..70e6611  main -> main
   
неожиданно понял что изменения были некорректными и хочу вернуться к предыдущему комиту
открываю в браузере git, нахожу коммит к которому хочу вернуться и копирую его хэш код
в командной строке в git bash ввожу :
git reset --hard 8c52ec91b36fa507d138a4133aad61e3ea57bdf6

yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git reset --hard 8c52ec91b36fa507d138a4133aad61e3ea57bdf6
HEAD is now at 8c52ec9 Merge branch 'secondary' into main

yurko@DESKTOP-2LASRCJ MINGW64 /d/temp_topic5/task11 (main)
$ git push --force
Total 0 (delta 0), reused 0 (delta 0), pack-reused 0
To https://github.com/yurkobrisk/temp_topic5.git
 + 70e6611...8c52ec9 main -> main (forced update)

и в локальном репозитории и в удаленном теперь предыдущая версия файла pom.xml
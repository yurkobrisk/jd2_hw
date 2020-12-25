- в командной строке в директории D:\jd2_hw\tomcat_topic4 выполнил команду: 
d:\jd2_hw\tomcat_topic4>mvn archetype:generate

- выбрал архетип : maven-archetype-webapp 
- прописал парметры проекта :
	groupId: jd2_hw.tomcat_topic4.task8
	artifactId: task8
	version: 1.0-SNAPSHOT
	package: jd2_hw.tomcat_topic4.task8

- проект создался, результат командной строки : 
[INFO] Using following parameters for creating project from Archetype: maven-archetype-webapp:1.4
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: jd2_hw.tomcat_topic4.task8
[INFO] Parameter: artifactId, Value: task8
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: jd2_hw.tomcat_topic4.task8
[INFO] Parameter: packageInPathFormat, Value: jd2_hw/tomcat_topic4/task8
[INFO] Parameter: package, Value: jd2_hw.tomcat_topic4.task8
[INFO] Parameter: groupId, Value: jd2_hw.tomcat_topic4.task8
[INFO] Parameter: artifactId, Value: task8
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Project created from Archetype in dir: d:\jd2_hw\tomcat_topic4\task8
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

- открыл проект в Idea

- создал папку tomcat_topic4/task8/src/main/webapp/META-INF и в ней context.xml с параметрами :
	<Context
			path="/task8"
			docBase="task8"
			reloadable="true"
	/>
	
- проверил что в файле настроек сервера Tomcat (файл $CATALINA_BASE/conf/server.xml) присутствуют следующие параметры :
	<Host name="localhost"  appBase="webapps"
		unpackWARs="true" autoDeploy="true">
	...
	
	</Host>
	
- собрал проект mvn  clean install

- переписал файл task8.war из папки target в D:\java\apache-tomcat-9.0.41\webapps
- установил приложение на Tomcat сервер
- в браузере по адресу : http://localhost:8080/task8/ открывается веб приложение с содержимым : Hello World! Task8 here!

- залил в гит

p.s. при добавлении в server.xml в раздел Host --> copyXML="true"  , происходит копирование context.xml файла из каталога META-INF веб приложения в каталог %CATALINA_HOME%/conf/Catalina/localhost/ и он переименовывается в - имя_веб_приложения.xml
- в командной строке в директории D:\jd2_hw\tomcat_topic4 выполнил команду: 
d:\jd2_hw\tomcat_topic4>mvn archetype:generate

- выбрал архетип : org.apache.maven.archetypes:maven-archetype-webapp (An archetype which contains a sample Maven Webapp project.) 
- прописал парметры проекта :
	groupId: jd2_hw.tomcat_topic4.task9
	artifactId: task9
	version: 1.0-SNAPSHOT
	package: jd2_hw.tomcat_topic4.task9

- проект создался, результат командной строки : 
[INFO] Using following parameters for creating project from Archetype: maven-archetype-webapp:1.4
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: jd2_hw.tomcat_topic4.task9
[INFO] Parameter: artifactId, Value: task9
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: jd2_hw.tomcat_topic4.task9
[INFO] Parameter: packageInPathFormat, Value: jd2_hw/tomcat_topic4/task9
[INFO] Parameter: package, Value: jd2_hw.tomcat_topic4.task9
[INFO] Parameter: groupId, Value: jd2_hw.tomcat_topic4.task9
[INFO] Parameter: artifactId, Value: task9
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Project created from Archetype in dir: d:\jd2_hw\tomcat_topic4\task9
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

- собрал проект : выполнил команду в консоли : mvn clean install

- открыл проект в Idea

- добавил раздел

	<developers>
	<developer>
		<name>Yury Korziuk</name>
		<email>yurko@tut.by</email>
	</developer>
	</developers>

- добавил плагин tomcat-maven-plugin в раздел плагины
	
	<plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>tomcat-maven-plugin</artifactId>
      <version>1.1</version>
      <configuration>
        <url>http://localhost:8080/manager/text</url>
        <server>myserver</server>
        <path>/task9</path>
      </configuration>
    </plugin>
	
- добавил в файл D:\java\apache-maven-3.6.3\conf\settings.xml :
    <server>
      <id>myserver</id>
      <username>tomcat</username>
      <password>tomcat</password>
    </server>	

- собрал проект : выполнил команду в консоли : mvn clean install
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

- задеплоить проект : выполнил команду в консоли : mvn tomcat:redeploy
...
[INFO] --- tomcat-maven-plugin:1.1:redeploy (default-cli) @ task9 ---
[INFO] Deploying war to http://localhost:8080/task9
[INFO] OK - Приложение успешно развёрнуто в контекстном пути [/task9]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

	в окне сервера tomcat появилось сообщение : 
	... Deploying web application archive [D:\java\apache-tomcat-9.0.41\webapps\task9.war]
    ... Deployment of web application archive [D:\java\apache-tomcat-9.0.41\webapps\task9.war] has finished in [38]
	
	в D:\java\apache-tomcat-9.0.41\webapps записался task9.war и выполнилась распаковка его в директорию \task9
	
	в браузере открывается веб приложение по адресу : http://localhost:8080/task9/
	
- остановка веб приложения на сервере : выполнил команду в консоли : mvn tomcat:stop
...
[INFO] --- tomcat-maven-plugin:1.1:stop (default-cli) @ task9 ---
[INFO] Stopping application at http://localhost:8080/task9
[INFO] OK - Остановлено приложение по пути контекста [/task9]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

	в браузере веб приложение по адресу : http://localhost:8080/task9/ не доступно. В менеджере приложений видно что task9 не запущен.
	
- вывод статистики об установленных веб приложениях на сервер Tomcat : выполнил команду в консоли : mvn tomcat:list
...
[INFO] --- tomcat-maven-plugin:1.1:list (default-cli) @ task9 ---
[INFO] Listing applications at http://localhost:8080/manager/text
[INFO] OK - Список приложений для виртуального хоста [localhost]
[INFO] /task8:stopped:0:task8
[INFO] /:running:0:ROOT
[INFO] /task9:stopped:0:task9
[INFO] /tomcat-quickstart-1.0-SNAPSHOT:running:0:tomcat-quickstart-1.0-SNAPSHOT
[INFO] /examples:running:0:examples
[INFO] /host-manager:running:0:host-manager
[INFO] /manager:running:1:manager
[INFO] /tomcat-quickstart:running:0:tomcat-quickstart
[INFO] /docs:running:0:docs
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

- вывод информации о сервер Tomcat : выполнил команду в консоли : mvn tomcat:info
...
[INFO] --- tomcat-maven-plugin:1.1:info (default-cli) @ task9 ---
[INFO] Listing server information at http://localhost:8080/manager/text
[INFO] OK - Server info
[INFO] Tomcat Version: [Apache Tomcat/9.0.41]
[INFO] OS Name: [Windows 10]
[INFO] OS Version: [10.0]
[INFO] OS Architecture: [amd64]
[INFO] JVM Version: [11+28]
[INFO] JVM Vendor: [Oracle Corporation]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

- запуск веб приложения на сервере : выполнил команду в консоли : mvn tomcat:start
...
[INFO] --- tomcat-maven-plugin:1.1:start (default-cli) @ task9 ---
[INFO] Starting application at http://localhost:8080/task9
[INFO] OK - Запущено приложение по пути контекста [/task9]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

- вывод информации о всех текущих сессиях веб приложения : выполнил команду в консоли : mvn tomcat:sessions
...
[INFO] ------------------< jd2_hw.tomcat_topic4.task9:task9 >------------------
[INFO] Building task9 Maven Webapp 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:sessions (default-cli) @ task9 ---
[INFO] Listing session information for application at http://localhost:8080/task9
[INFO] OK - Информация о сеансах приложения по пути контекста [/task9]
[INFO] Стандартный максимальный период неактивного сеанса: [30] минут
[INFO] Неактивные [15 - <16] минут: [1] сеанс(ов)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

- удаление веб приложения из сервера Tomcat : выполнил команду в консоли : mvn tomcat:undeploy
...
[INFO] --- tomcat-maven-plugin:1.1:undeploy (default-cli) @ task9 ---
[INFO] Undeploying application at http://localhost:8080/task9
[INFO] OK - Удалено приложение по пути контекста [/task9]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

	в окне сервера : Undeploying context [/task9]
	
	из D:\java\apache-tomcat-9.0.41\webapps удалился task9.war и директория \task9

	в браузере веб приложение по адресу : http://localhost:8080/task9/ не доступно
	
- выполнил команду в консоли : mvn tomcat:list
...
[INFO] --- tomcat-maven-plugin:1.1:list (default-cli) @ task9 ---
[INFO] Listing applications at http://localhost:8080/manager/text
[INFO] OK - Список приложений для виртуального хоста [localhost]
[INFO] /task8:stopped:0:task8
[INFO] /:running:0:ROOT
[INFO] /tomcat-quickstart-1.0-SNAPSHOT:running:0:tomcat-quickstart-1.0-SNAPSHOT
[INFO] /examples:running:0:examples
[INFO] /host-manager:running:0:host-manager
[INFO] /manager:running:1:manager
[INFO] /tomcat-quickstart:running:0:tomcat-quickstart
[INFO] /docs:running:0:docs
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------


- залил в гит
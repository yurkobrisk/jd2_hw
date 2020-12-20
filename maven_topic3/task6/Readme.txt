- в командной строке в директории D:\jd2_hw\maven_topic3 выполнил команду: mvn archetype:generate
- выбрал архетип и версию по дефолту
- добавил параметры проекта :
	groupId, Value: jd2_hw.maven_topic3
	artifactId, Value: task6
	version, Value: 1.0-SNAPSHOT
	package, Value: jd2_hw.maven_topic3
- проект создался, результат командной строки : BUILD SUCCESS
- собрал проект выполнив в командной строке: mvn clean install
- открыл проект в Idea
- добавил раздел

	<developers>
	<developer>
		<name>Yury Korziuk</name>
		<email>yurko@tut.by</email>
	</developer>
	</developers>

- добавил тип архива pom, для создания многомодульного проекта
	  <packaging>pom</packaging>

- в командной строке в директории D:\jd2_hw\maven_topic3 выполнил команду: mvn archetype:generate
- выбрал архетип и версию по дефолту
- добавил параметры проекта :
	groupId, Value: jd2_hw.maven_topic3.task6
	artifactId, Value: moduleJar
	version, Value: 1.0-SNAPSHOT
	package, Value: jd2_hw.maven_topic3.task6
	
- в командной строке в директории D:\jd2_hw\maven_topic3 выполнил команду: d:\jd2_hw\maven_topic3\task6>mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
- добавил параметры проекта :
	groupId, Value: jd2_hw.maven_topic3.task6
	artifactId, Value: moduleWar
	version, Value: 1.0-SNAPSHOT
	package, Value: jd2_hw.maven_topic3.task6

- добавил в родительский файл pom.xml расширенную зависимость от MySql :
	<dependencyManagement>
	<dependencies>
		<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>8.0.22</version>
		</dependency>
	</dependencies>
	</dependencyManagement>

- добавил в дочерние файлы pom.xml зависимости от MySql :
	<dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
    </dependency>

- проверил проект в командной строке mvn validate . Все модули впорядке
- собрал проект mvn  clean install
- залил в гит
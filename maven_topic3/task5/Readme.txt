- в командной строке в директории D:\jd2_hw\maven_topic3 выполнил команду: mvn archetype:generate
- выбрал архетип и версию по дефоту
- добавил параметры проекта :
	groupId, Value: jd2_hw.maven_topic3
	artifactId, Value: task5
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
- выбрал архетип и версию по дефоту
- добавил параметры проекта :
	groupId, Value: jd2_hw.maven_topic3.task5
	artifactId, Value: moduleJar
	version, Value: 1.0-SNAPSHOT
	package, Value: jd2_hw.maven_topic3.task5
	
- в командной строке в директории D:\jd2_hw\maven_topic3 выполнил команду: d:\jd2_hw\maven_topic3\task5>mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
- добавил параметры проекта :
	groupId, Value: jd2_hw.maven_topic3.task5
	artifactId, Value: moduleWar
	version, Value: 1.0-SNAPSHOT
	package, Value: jd2_hw.maven_topic3.task5

- проверил проект в коммандной строке mvn validate . Все модули впорядке
- собрад проект mvn  clean install
- залил в гит
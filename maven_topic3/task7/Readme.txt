- в командной строке в директории D:\jd2_hw\maven_topic3 выполнил команду: 
d:\jd2_hw\maven_topic3>mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp -DartifactId=task7 -DgroupId=jd2_hw.maven_topic3 -Dversion=1.0-SNAPSHOT -Dpackage=jd2_hw.maven_topic3

- проект создался, результат командной строки : BUILD SUCCESS

- открыл проект в Idea
- добавил раздел

	<developers>
	<developer>
		<name>Yury Korziuk</name>
		<email>yurko@tut.by</email>
	</developer>
	</developers>

- добавил build plugin для компилирования проекта в версии 1.8
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<version>3.8.1</version>
		<configuration>
			<source>1.8</source>
			<target>1.8</target>
		</configuration>
	</plugin>


- запустил компиляцию и тест в командной строке по отдельности mvn comppile, mvn test

- собрал проект mvn  clean install
- залил в гит
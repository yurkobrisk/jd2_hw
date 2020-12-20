- в командной строке в директории D:\jd2_hw\maven_topic2 выполнил команду mvn archetype:generate
- выбрал архетип и версию по дефоту
- добавил параметры проекта :
	groupId, Value: jd2_hw.maven_topic2
	artifactId, Value: task4
	version, Value: 1.0-SNAPSHOT
	package, Value: jd2_hw.maven_topic2
- проект создался, результат командной строки : BUILD SUCCESS
- открыл проект в Idea
- добавил : 
	<description>different fases of project lifecicle </description>

	<developers>
		<developer>
			<name>Yury Korziuk</name>
			<email>yurko@tut.by</email>
		</developer>
	</developers>
	
- добавил профили для запуска :
	компиляция в java 11
	компиляция в java 1.8
	компиляция без ресурсов, без тестов, без очистки
- компиляция из командной строки с использованием профилей : mvn install -P skipClean, skipTest, skipResources, jd11

- залил в гит
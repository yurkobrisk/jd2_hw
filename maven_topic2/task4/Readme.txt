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

- выполнил команду :

    mvn pre-clean.
    mvn clean. Удаляет все файлы которые получились от предыдущей сборки
    mvn post-clean.

    mvn validate. Результат : проверка проекта на доступность и корректность + предыдущие этапы ЖЦ
    [INFO] ---------------------< jd2_hw.maven_topic2:task4 >----------------------
    [INFO] Building task4 1.0-SNAPSHOT
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

    mvn compile. Результат : компиляция кода + предыдущие этапы ЖЦ
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ task4 ---
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] skip non existing resourceDirectory d:\jd2_hw\maven_topic2\task4\src\main\resources
    [INFO]
    [INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ task4 ---
    [INFO] Changes detected - recompiling the module!
    [INFO] Compiling 1 source file to d:\jd2_hw\maven_topic2\task4\target\classes
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

    mvn test. Результат : запуск тестов + предыдущие этапы ЖЦ
    ...
    [INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ task4 ---
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] skip non existing resourceDirectory d:\jd2_hw\maven_topic2\task4\src\test\resources
    [INFO]
    [INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ task4 ---
    [INFO] Changes detected - recompiling the module!
    [INFO] Compiling 1 source file to d:\jd2_hw\maven_topic2\task4\target\test-classes
    [INFO]
    [INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ task4 ---
    [INFO]
    [INFO] -------------------------------------------------------
    [INFO]  T E S T S
    [INFO] -------------------------------------------------------
    [INFO] Running jd2_hw.maven_topic2.AppTest
    [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.045 s - in jd2_hw.maven_topic2.AppTest
    [INFO]
    [INFO] Results:
    [INFO]
    [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
    [INFO]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

    mvn package.  Результат : упаковка скомпилированного кода в архив + предыдущие этапы ЖЦ
    ...
    [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ task4 ---
    [INFO] Building jar: d:\jd2_hw\maven_topic2\task4\target\task4-1.0-SNAPSHOT.jar
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

    mvn install. Результат : установка упакованного кода в локальный репозиторий + предыдущие этапы ЖЦ
    ...
    [INFO] --- maven-install-plugin:2.5.2:install (default-install) @ task4 ---
    [INFO] Installing d:\jd2_hw\maven_topic2\task4\target\task4-1.0-SNAPSHOT.jar to d:\java\.m2\repository\jd2_hw\maven_topic2\task4\1.
    0-SNAPSHOT\task4-1.0-SNAPSHOT.jar
    [INFO] Installing d:\jd2_hw\maven_topic2\task4\pom.xml to d:\java\.m2\repository\jd2_hw\maven_topic2\task4\1.0-SNAPSHOT\task4-1.0-S
    NAPSHOT.pom
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

    mvn pre-site
    mvn site - генерация проектной документации

- залил в гит
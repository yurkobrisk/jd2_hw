- в командной строке в директории D:\jd2_hw\maven_topic2 выполнил команду mvn archetype:generate
- выбрал архетип и версию по дефоту
- добавил параметры проекта :
	groupId, Value: jd2_hw.maven_topic2
	artifactId, Value: task2
	version, Value: 1.0-SNAPSHOT
	package, Value: jd2_hw.maven_topic2
- проект создался, открыл его в Idea
- создал java class Arithmetic
- создал для него тест ArithmeticTest
- в командной строке выполнил команду mvn clean install : выполнились очистка, компиляция, тесты, упаковка и инсталл в репозиторий локальный 
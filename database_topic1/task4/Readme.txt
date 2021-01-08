- Добавить liquibase в секцию pluguns:

<groupId>org.liquibase</groupId>
<artifactId>liquibase-maven-plugin</artifactId>
<version>4.2.2</version>

- Добавить атрибуты для liquibase:

<configuration>
  <changeLogFile>changelog.xml</changeLogFile>
  <outputChangeLogFile>changelog.xml</outputChangeLogFile>
  <url>jdbc:mysql://localhost:3306/listexpenses?serverTimezone=UTC</url>
  <username>root</username>
  <password>root</password>
</configuration>

- Cгенерировал changelog: mvn liquibase:generateChangeLog

- Посмотрел статус базы: mvn liquibase:status
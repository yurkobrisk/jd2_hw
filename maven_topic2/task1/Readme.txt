- установить переменную среды JAVA_HOME : 
	set JAVA_HOME=d:\java\jdk-11 

- установить переменную PATH :
	set PATH=%PATH%;%JAVA_HOME%\bin
	
- установить путь к папке maven :
	set M2_HOME=D:\java\apache-maven-3.6.3
	
- установить переменную PATH для maven :
	set PATH=%PATH%;D:\java\apache-maven-3.6.3\bin
	
- проверка корректности установки maven :
	C:\Users\yurko>mvn --version
	Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
	Maven home: D:\java\apache-maven-3.6.3\bin\..
	Java version: 11, vendor: Oracle Corporation, runtime: d:\java\jdk-11
	Default locale: ru_RU, platform encoding: Cp1251
	OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
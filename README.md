# LabWeb

LabWeb is a web service designed by Zemise for LabCentral, used to search for laboratory inventory
items and their respective locations

#### Requirements
* Java 17 JDK or newer
* Git
* Maven
* mysql 8 or newer

#### run
create mysql database
```bash
create database labweb_test;
```

fill application.yml
```yml
  datasource:
    url: jdbc:mysql://yourhost:3306/labweb_test?
    username: username
    password: password
```

#### Compiling from source
```bash
mvn clean package
mvn package docker:build
```



# Gunclock for Spring Boot 

* install

    $ git clone https://github.com/gunman-vagabond/GunclockSpringBoot.git
    $ cd GunclockSpringBoot
    $ mvn install  (or $ mvnw install)

* start

    $ mvnw spring-boot:run  [--define server.port=8080]

* web

    http://localhost:8080/gunclocks

* build jar / run jar

    $ mvnw clean package  (or $mvn install)
    $ cd target
    $ java -jar Gunclock-0.0.1-SNAPSHOT.jar  [--server.port=8080]


package net.projectsync.redis.service.postconstructpredestroy;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class DatabaseService {

    private boolean connectionOpen = false;

    public DatabaseService() {
        System.out.println("1 - DatabaseService constructor");
    }

    @PostConstruct
    public void openConnection() {
        System.out.println("2 - @PostConstruct - Opening database connection");
        // Simulate opening a database connection
        connectionOpen = true;
        System.out.println("    Database connection established");
    }

    public void performDatabaseOperation() {
        if (!connectionOpen) {
            throw new IllegalStateException("Database connection not available");
        }
        System.out.println("Performing database operation...");
    }

    // Stop the application to test this method or press Ctrl+C
    @PreDestroy
    public void closeConnection() {
        System.out.println("3. @PreDestroy - Closing database connection");
        // Simulate closing the database connection
        connectionOpen = false;
        System.out.println("    Database connection closed");
    }
}
/*
"C:\Program Files\Amazon Corretto\jdk17.0.7_7\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.3\lib\idea_rt.jar=54987:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.3\bin" -Dfile.encoding=UTF-8 -classpath D:\dev\github\springdataredis\target\classes;C:\Users\Mohan\.m2\repository\org\springframework\boot\spring-boot-starter-data-redis\2.7.5\spring-boot-starter-data-redis-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\springframework\boot\spring-boot-starter\2.7.5\spring-boot-starter-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\springframework\boot\spring-boot\2.7.5\spring-boot-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.7.5\spring-boot-autoconfigure-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.7.5\spring-boot-starter-logging-2.7.5.jar;C:\Users\Mohan\.m2\repository\ch\qos\logback\logback-classic\1.2.11\logback-classic-1.2.11.jar;C:\Users\Mohan\.m2\repository\ch\qos\logback\logback-core\1.2.11\logback-core-1.2.11.jar;C:\Users\Mohan\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.17.2\log4j-to-slf4j-2.17.2.jar;C:\Users\Mohan\.m2\repository\org\apache\logging\log4j\log4j-api\2.17.2\log4j-api-2.17.2.jar;C:\Users\Mohan\.m2\repository\org\slf4j\jul-to-slf4j\1.7.36\jul-to-slf4j-1.7.36.jar;C:\Users\Mohan\.m2\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;C:\Users\Mohan\.m2\repository\org\yaml\snakeyaml\1.30\snakeyaml-1.30.jar;C:\Users\Mohan\.m2\repository\org\springframework\data\spring-data-redis\2.7.5\spring-data-redis-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\springframework\data\spring-data-keyvalue\2.7.5\spring-data-keyvalue-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\springframework\data\spring-data-commons\2.7.5\spring-data-commons-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-tx\5.3.23\spring-tx-5.3.23.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-oxm\5.3.23\spring-oxm-5.3.23.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-aop\5.3.23\spring-aop-5.3.23.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-context-support\5.3.23\spring-context-support-5.3.23.jar;C:\Users\Mohan\.m2\repository\io\lettuce\lettuce-core\6.1.10.RELEASE\lettuce-core-6.1.10.RELEASE.jar;C:\Users\Mohan\.m2\repository\io\netty\netty-common\4.1.84.Final\netty-common-4.1.84.Final.jar;C:\Users\Mohan\.m2\repository\io\netty\netty-handler\4.1.84.Final\netty-handler-4.1.84.Final.jar;C:\Users\Mohan\.m2\repository\io\netty\netty-resolver\4.1.84.Final\netty-resolver-4.1.84.Final.jar;C:\Users\Mohan\.m2\repository\io\netty\netty-buffer\4.1.84.Final\netty-buffer-4.1.84.Final.jar;C:\Users\Mohan\.m2\repository\io\netty\netty-transport-native-unix-common\4.1.84.Final\netty-transport-native-unix-common-4.1.84.Final.jar;C:\Users\Mohan\.m2\repository\io\netty\netty-codec\4.1.84.Final\netty-codec-4.1.84.Final.jar;C:\Users\Mohan\.m2\repository\io\netty\netty-transport\4.1.84.Final\netty-transport-4.1.84.Final.jar;C:\Users\Mohan\.m2\repository\io\projectreactor\reactor-core\3.4.24\reactor-core-3.4.24.jar;C:\Users\Mohan\.m2\repository\org\reactivestreams\reactive-streams\1.0.4\reactive-streams-1.0.4.jar;C:\Users\Mohan\.m2\repository\org\springframework\boot\spring-boot-starter-web\2.7.5\spring-boot-starter-web-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\springframework\boot\spring-boot-starter-json\2.7.5\spring-boot-starter-json-2.7.5.jar;C:\Users\Mohan\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.13.4.2\jackson-databind-2.13.4.2.jar;C:\Users\Mohan\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.13.4\jackson-annotations-2.13.4.jar;C:\Users\Mohan\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.13.4\jackson-core-2.13.4.jar;C:\Users\Mohan\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.13.4\jackson-datatype-jdk8-2.13.4.jar;C:\Users\Mohan\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.13.4\jackson-datatype-jsr310-2.13.4.jar;C:\Users\Mohan\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.13.4\jackson-module-parameter-names-2.13.4.jar;C:\Users\Mohan\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\2.7.5\spring-boot-starter-tomcat-2.7.5.jar;C:\Users\Mohan\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.68\tomcat-embed-core-9.0.68.jar;C:\Users\Mohan\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\9.0.68\tomcat-embed-el-9.0.68.jar;C:\Users\Mohan\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.68\tomcat-embed-websocket-9.0.68.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-web\5.3.23\spring-web-5.3.23.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-beans\5.3.23\spring-beans-5.3.23.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-webmvc\5.3.23\spring-webmvc-5.3.23.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-context\5.3.23\spring-context-5.3.23.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-expression\5.3.23\spring-expression-5.3.23.jar;C:\Users\Mohan\.m2\repository\redis\clients\jedis\3.8.0\jedis-3.8.0.jar;C:\Users\Mohan\.m2\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;C:\Users\Mohan\.m2\repository\org\apache\commons\commons-pool2\2.11.1\commons-pool2-2.11.1.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-core\5.3.23\spring-core-5.3.23.jar;C:\Users\Mohan\.m2\repository\org\springframework\spring-jcl\5.3.23\spring-jcl-5.3.23.jar net.projectsync.redis.SpringDataRedisExampleApplication

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.5)

2025-09-10 11:42:30.957  INFO 4012 --- [           main] n.p.r.SpringDataRedisExampleApplication  : Starting SpringDataRedisExampleApplication using Java 17.0.7 on home-desktop with PID 4012 (D:\dev\github\springdataredis\target\classes started by Mohan in D:\dev\github\springdataredis)
2025-09-10 11:42:30.960  INFO 4012 --- [           main] n.p.r.SpringDataRedisExampleApplication  : No active profile set, falling back to 1 default profile: "default"
2025-09-10 11:42:31.416  INFO 4012 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2025-09-10 11:42:31.417  INFO 4012 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2025-09-10 11:42:31.436  INFO 4012 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 4 ms. Found 0 Redis repository interfaces.
2025-09-10 11:42:31.569  INFO 4012 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2025-09-10 11:42:31.570  INFO 4012 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2025-09-10 11:42:31.572  INFO 4012 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 2 ms. Found 0 Redis repository interfaces.
2025-09-10 11:42:32.162  INFO 4012 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 9292 (http)
2025-09-10 11:42:32.170  INFO 4012 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-09-10 11:42:32.170  INFO 4012 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.68]
2025-09-10 11:42:32.255  INFO 4012 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-09-10 11:42:32.255  INFO 4012 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1240 ms
1 - DatabaseService constructor
2 - @PostConstruct - Opening database connection
    Database connection established
2025-09-10 11:42:33.070  INFO 4012 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 9292 (http) with context path ''
2025-09-10 11:42:33.084  INFO 4012 --- [           main] n.p.r.SpringDataRedisExampleApplication  : Started SpringDataRedisExampleApplication in 2.484 seconds (JVM running for 2.824)
3. @PreDestroy - Closing database connection
    Database connection closed

Process finished with exit code 130

*/
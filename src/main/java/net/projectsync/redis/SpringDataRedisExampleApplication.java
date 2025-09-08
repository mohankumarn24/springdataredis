package net.projectsync.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringDataRedisExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisExampleApplication.class, args);
    }
}

/* STEPS:
- Double click on ./Redis-x64-3.0.504/redis-server.exe to start Redis
    -- https://github.com/microsoftarchive/redis/releases
    -- https://www.youtube.com/watch?v=4_bwialzt1M
- View data in 'Another Redis Desktop Manager' client
 */
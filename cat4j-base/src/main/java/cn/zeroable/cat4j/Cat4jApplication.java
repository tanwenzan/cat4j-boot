package cn.zeroable.cat4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Cat4jApplication 启动器.
 *
 * @author tanwenzan
 * @version 12/23/23 6:03 PM
 * @since 0.0.1
 */
@SpringBootApplication
@EnableCaching
public class    Cat4jApplication {
    public static void main(String[] args) {
        SpringApplication.run(Cat4jApplication.class, args);
    }
}
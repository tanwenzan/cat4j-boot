package cn.zeroable.cat4j;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Cat4jApplication 启动器.
 *
 * @author zeroable
 * @version 12/23/23 6:03 PM
 * @since 0.0.1
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"cn.zeroable.cat4j"})
@EnableCaching
@EnableEncryptableProperties
public class Cat4jApplication {
    public static void main(String[] args) {
        // 当前启动类
        log.info("Cat4jApplication starting...");
        // 启动SpringBoot
        SpringApplication.run(Cat4jApplication.class, args);
        log.info("Cat4jApplication started...");
    }
}
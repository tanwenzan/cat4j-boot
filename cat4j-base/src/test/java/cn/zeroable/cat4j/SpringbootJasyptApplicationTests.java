package cn.zeroable.cat4j;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 2023/12/25 10:53
 * @see
 * @since 0.0.1
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootJasyptApplicationTests {

    @Qualifier("stringEncryptor")
    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void encrypt() {
        String url = encryptor.encrypt("jdbc:mysql://192.168.158.131:3306/cat4j_bi?useSSL=false&serverTimezone=GMT%2B8&useUnicode=true&character_set_server=utf8mb4");
        String name = encryptor.encrypt("zeroable");
        String password = encryptor.encrypt("zeroable2020");
        System.out.println("database url: " + url);
        System.out.println("database name: " + name);
        System.out.println("database password: " + password);
    }

    @Test
    public void redisEncrypt() {
        String host = encryptor.encrypt("127.0.0.1");
        String port = encryptor.encrypt("6379");
        System.out.println("redis host: " + host);
        System.out.println("redis port: " + port);
    }
}

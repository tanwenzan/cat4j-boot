package cn.zeroable.cat4j.core.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author tanwenzan
 * @version 2023/12/25 11:30
 * @see
 * @since 0.0.1
 */
@Configuration
public class EncryptionConfig {

    @Value("${jasypt.encryptor.password}")
    private String password;

    @Value("${jasypt.encryptor.algorithm:PBEWITHHMACSHA512ANDAES_256}")
    private String algorithm;

    @Value("${jasypt.encryptor.key-obtention-iterations:1000}")
    private String keyObtentionIterations;

    @Value("${jasypt.encryptor.pool-size:1}")
    private String poolSize;

    @Value("${jasypt.encryptor.provider-name:SunJCE}")
    private String providerName;

    @Value("${jasypt.encryptor.provider-class-name:null}")
    private String providerClassName;

    @Value("${jasypt.encryptor.salt-generator-classname:org.jasypt.salt.RandomSaltGenerator}")
    private String saltGeneratorClassName;

    @Value("${jasypt.encryptor.iv-generator-classname:org.jasypt.iv.RandomIvGenerator}")
    private String ivGeneratorClassName;

    @Value("${jasypt.encryptor.string-output-type:base64}")
    private String stringOutputType;

    @Bean("stringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(algorithm);
        config.setKeyObtentionIterations(keyObtentionIterations);
        config.setPoolSize(poolSize);
        config.setProviderName(providerName);
        String providerClassName = "null".equals(this.providerClassName) ? null : this.providerClassName;
        config.setProviderClassName(providerClassName);
        config.setSaltGeneratorClassName(saltGeneratorClassName);
        config.setIvGeneratorClassName(ivGeneratorClassName);
        config.setStringOutputType(stringOutputType);
        encryptor.setConfig(config);
        return encryptor;
    }
}

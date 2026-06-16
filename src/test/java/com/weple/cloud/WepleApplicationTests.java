package com.weple.cloud;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WepleApplicationTests {

    @Autowired
    @Qualifier("jasyptStringEncryptor")
    private StringEncryptor jasypt;

    @Test
    void 대칭키_암호화_테스트() {

        String plainText = "my-secret-db-password";

        String encryptedText = jasypt.encrypt(plainText);

        System.out.println("Encrypted Result:");
        System.out.println(encryptedText);
    }
}
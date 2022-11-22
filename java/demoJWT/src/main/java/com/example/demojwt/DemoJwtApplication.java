package com.example.demojwt;

import com.example.demojwt.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class DemoJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJwtApplication.class, args);
    }

}

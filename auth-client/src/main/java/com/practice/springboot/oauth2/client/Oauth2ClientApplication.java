package com.practice.springboot.oauth2.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 * fail
 * @author Luo Bao Ding
 * @since 2018/5/24
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class Oauth2ClientApplication  {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientApplication.class, args);
    }

}

package com.practice.springboot.oauth2.client_credentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 下面文档不全，所以本demo还通过
 * ===========
 * https://stackoverflow.com/questions/37534073/spring-boot-oauth2-client-credentials
 *
 *
 * @author Luo Bao Ding
 * @since 2018/5/24
 */
@SpringBootApplication
public class ClientCredentialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientCredentialsApplication.class, args);
    }

    @Bean(name = "OAuth")
    @ConfigurationProperties(prefix="datasource.oauth")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}

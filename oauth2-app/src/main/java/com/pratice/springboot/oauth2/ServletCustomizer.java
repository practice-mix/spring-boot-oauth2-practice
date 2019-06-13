package com.pratice.springboot.oauth2;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author Luo Bao Ding
 * @since 2018/5/24
 */
@Configuration
public class ServletCustomizer {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory>customizer(){
        return factory -> factory.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/unauthenticated"));
    }
}

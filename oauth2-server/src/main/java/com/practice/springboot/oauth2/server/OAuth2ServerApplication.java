package com.practice.springboot.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * cmd test :
 * $  curl acme:acmesecret@localhost:8080/oauth/token -d grant_type=client_credentials
 * <p>
 * $ curl acme:acmesecret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=eae14f0f-e07c-4a64-9d79-e8d20183d7ba
 *
 * @author Luo Bao Ding
 * @since 2018/5/24
 */
@SpringBootApplication
@EnableAuthorizationServer
@RestController
@EnableDiscoveryClient
public class OAuth2ServerApplication /*extends WebSecurityConfigurerAdapter*/ {

    @RequestMapping({"/user", "/me"})
    public String user() {
        return "Jack";
    }

/*
    @EnableResourceServer
    @Configuration
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/me").authorizeRequests().anyRequest().authenticated();
        }
    }
*/

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**").authorizeRequests()
//                .antMatchers("/", "/login**", "/webjars/**", "/error**")
//                .permitAll().anyRequest().authenticated()
//                .and().exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
//                .and().logout().logoutSuccessUrl("/").permitAll()
//                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//        ;
//
//    }
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }
}

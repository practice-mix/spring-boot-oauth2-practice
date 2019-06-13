package com.practice.springboot.oauth2.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * @author Luo Bao Ding
 * @since 2018/5/24
 */
@EnableOAuth2Sso
@SpringBootApplication
@RestController
public class SsoApplication extends WebSecurityConfigurerAdapter {
 /*   @Bean
    public AuthoritiesExtractor authoritiesExtractor(OAuth2RestOperations template) {

        return map -> {
            String url = (String) map.get("organizations_url");
            List<Map<String, Object>> organizations = template.getForObject(url, List.class);
            if (organizations.stream().anyMatch(org -> "spring-projects".equals(org.get("login")))) {
                return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
            }
            throw new BadCredentialsException("Not in Spring Projects organization");
        };
    }
*/
    @Bean
    public OAuth2RestTemplate template(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(resource, clientContext);
    }
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
//    note :  "/login**" do not include  "/login"
        http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**", "/error**","/unauthenticated").permitAll().anyRequest()
                .authenticated().and().logout().logoutSuccessUrl("/").permitAll().and().csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // @formatter:on
    }

    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }
}

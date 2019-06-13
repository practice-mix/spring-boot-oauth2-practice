package com.practice.springboot.oauth2.client;

import com.practice.springboot.oauth2.client.model.AuthRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Luo Bao Ding
 * @since 2018/5/24
 */
@FeignClient(name = "auth-server")
public interface AccessTokenFeign {

    @RequestMapping(path = "/oauth/token")
    Object oauthToken(AuthRequest request);

}

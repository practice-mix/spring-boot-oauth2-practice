package com.practice.springboot.oauth2.client;

import com.practice.springboot.oauth2.client.model.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private AccessTokenFeign accessTokenFeign;

    @RequestMapping(path = "/oauth/token")
    public Object oauthToken() {
        AuthRequest request = new AuthRequest();
        request.setClientId("acme");
        request.setClientSecret("acmesecret");
        request.setGrantType("client_credentials");
        return accessTokenFeign.oauthToken(request);
    }

}
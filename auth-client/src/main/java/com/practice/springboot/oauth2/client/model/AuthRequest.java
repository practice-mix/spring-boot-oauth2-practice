package com.practice.springboot.oauth2.client.model;

import java.io.Serializable;

/**
 * @author Luo Bao Ding
 * @since 2018/5/24
 */
public class AuthRequest implements Serializable {

    private static final long serialVersionUID = 7020654553151433504L;


    private String clientId;
    private String clientSecret;
    private String grantType;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}

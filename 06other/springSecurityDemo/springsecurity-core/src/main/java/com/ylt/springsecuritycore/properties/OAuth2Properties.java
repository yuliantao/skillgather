package com.ylt.springsecuritycore.properties;

/**
 * @author yuliantao
 * @create 2018-12-21 23:48
 * @description 功能描述
 */
public class OAuth2Properties {

    private String jwtSigningKey ="ylt";

    private  OAuth2ClientProperties[] clients ={};

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }

    public String getJwtSigningKey() {
        return jwtSigningKey;
    }

    public void setJwtSigningKey(String jwtSigningKey) {
        this.jwtSigningKey = jwtSigningKey;
    }
}

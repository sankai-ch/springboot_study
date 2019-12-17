package com.example.demo.common.token;

/**
 * @author SanKai
 * @since 2019-11-11
 */
public class TokenProvider {

    private static final String AUTHORITES_KEY = "auth";

    private static final String LOGIN_TYPE_KEY = "login_type";

    private String              secretKey;

    private long                tokenValidityInSeconds;

    private long                tokenValidityInSecondsForRememberMe;

}

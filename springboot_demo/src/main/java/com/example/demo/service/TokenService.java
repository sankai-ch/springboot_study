package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.dataobject.UserDO;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author SanKai
 * @since 2019-11-06
 */
@Service
@Deprecated
public class TokenService {
    public String getToken(UserDO userDO) {
        Date start = new Date();
        Long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
//        token = JWT.create().withAudience(String.valueOf(userDO.getId())).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(userDO.getPassword()));
        System.out.println(token);
        return token;
    }
}

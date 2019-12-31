package com.example.demo.common.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.demo.common.annotation.PassToken;
import com.example.demo.common.core.biz.ErrorCode;
import com.example.demo.common.error.BizCoreException;
import com.example.demo.dataobject.UserDO;
import com.example.demo.jpa.UserJpaDAO;
import com.example.demo.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author SanKai
 * @since 2019-11-06
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserJpaDAO userJpaDAO;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("x-auth-token");

        String url = request.getRequestURI();
        log.info("RequestUrl is:" + url + " ，Token String is :" + token);
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Method method = handlerMethod.getMethod();

        //检查是否有passToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        } else {
            if (token == null) {
                throw new BizCoreException("此接口需要登录", ErrorCode.APP_NEED_LOGIN);
            }
            //获取token中的userId
            String userId = null;
            System.out.println("token: " + token);
            try {
                userId = JWT.decode(token).getAudience().get(0);
            } catch (JWTDecodeException j) {
                throw new RuntimeException("401");
            }
            System.out.println(userId);
            System.out.println(Long.valueOf(userId));

            Long id = Long.valueOf(userId);
            UserDO userDO = userJpaDAO.getOne(id);
//            UserDO userDO = userJpaDAO.findById(Long.valueOf(userId)).get();
            System.out.println(userDO);

            if (userDO == null) {
                throw new BizCoreException(ErrorCode.USER_NOT_EXIST);
            }

            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userDO.getPassword())).build();
            jwtVerifier.verify(token);
            return true;
        }

        return true;
    }
}

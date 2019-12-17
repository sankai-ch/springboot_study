package com.example.demo.common.config;

import com.example.demo.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author SanKai
 * @since 2019-11-11
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor authenticationInterceptor = new LoginInterceptor();
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/user/**");
    }
}

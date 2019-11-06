package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.core.RestCommonResult;
import com.example.demo.dataobject.UserDO;
import com.example.demo.form.UserForm;
import com.example.demo.manager.UserManager;
import com.example.demo.service.TokenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author SanKai
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/user/api")
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/add")
    @ApiOperation(value = "添加用户", notes = "添加用户接口")
    public RestCommonResult<Boolean> createUser(@RequestBody @Valid UserForm form) {
        return new RestCommonResult<>(userManager.createUser(form));
    }

    @GetMapping("/findByName")
    @ApiOperation(value = "按用户名查找用户", notes = "查找用户")
    public RestCommonResult<List<UserDO>> findById(@RequestParam @Valid String name) {
        return new RestCommonResult<>(userManager.findByName(name));
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录", notes = "登录")
    public RestCommonResult<Boolean> login(@RequestParam String name, @RequestParam String password) {
        JSONObject jsonObject = new JSONObject();
        UserDO userDO = userManager.findOne(2L);
        String token = tokenService.getToken(userDO);
        jsonObject.put("token", token);

        return new RestCommonResult<>(userManager.login(name, password));
    }

}

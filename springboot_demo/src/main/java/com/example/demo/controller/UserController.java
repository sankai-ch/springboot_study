package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.annotation.PassToken;
import com.example.demo.common.core.RestCommonResult;
import com.example.demo.common.core.biz.ErrorCode;
import com.example.demo.common.error.BizCoreException;
import com.example.demo.common.shiro.JWTUtil;
import com.example.demo.dataobject.UserDO;
import com.example.demo.form.UserForm;
import com.example.demo.jpa.UserJpaDAO;
import com.example.demo.manager.UserManager;
import com.example.demo.service.AsyncService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @author SanKai
 * @since 2019-11-06
 */

@RestController
@RequestMapping("/user/api")
@Slf4j
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserJpaDAO userJpaDAO;

    @Autowired
    private AsyncService asyncService;
//    @Autowired
//    private TokenService tokenService;

    @PostMapping("/add")
    @PassToken
    @ApiOperation(value = "添加用户", notes = "添加用户接口")
    public RestCommonResult<Boolean> createUser(@RequestBody @Valid UserForm form) {
        return new RestCommonResult<>(userManager.createUser(form));
    }

    @GetMapping("/findByName")
    @ApiOperation(value = "按用户名查找用户", notes = "查找用户")
    public RestCommonResult<UserDO> findById(@Valid @RequestParam String name) {
        return new RestCommonResult<>(userManager.findByName(name));
    }

    @GetMapping("/login")
    @PassToken
    @ApiOperation(value = "登录", notes = "登录")
    public RestCommonResult login(@RequestParam String username, @RequestParam String password) {

        JSONObject jsonObject = new JSONObject();
        String detailPassword = DigestUtils.md5DigestAsHex(password.getBytes());

        UserDO userDO = userJpaDAO.findByUsernameAndPassword(username, detailPassword);
        if (userDO == null) {
            throw new BizCoreException(ErrorCode.USER_NOT_EXIST);
        }
        if (userDO.getPassword().equals(password)) {
            return new RestCommonResult(JWTUtil.sign(userDO.getUsername(), userDO.getPassword()));
        }

//        String token = tokenService.getToken(userDO);
//        jsonObject.put("token", token);

        return new RestCommonResult(userManager.login(username, detailPassword));
    }

    @GetMapping("/hasLogin")
    public RestCommonResult<String> hasLogin() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            System.out.println("已经验证过了");
            return new RestCommonResult<>(RestCommonResult.DEFAULT_SUCCESS_CODE);
        }
        System.out.println("没有进行验证");
        return new RestCommonResult<>(RestCommonResult.DEFAULT_ERROR_CODE);
    }

    @RequestMapping("/sync")
    public String createUser() {
        log.info("==========处理注册=========");
        this.asyncService.addUser();
        log.info("==========完成输出OK==========");
        return "OK!";
    }


    @RequestMapping("/sync2")
    public String createUser2() {
        log.info("==========处理注册2==========");
        this.asyncService.addUser2();
        log.info("==========完成输出OK==========");
        return "OK!";
    }

}

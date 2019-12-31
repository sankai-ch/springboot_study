package com.example.demo.manager;

import com.example.demo.common.core.biz.ErrorCode;
import com.example.demo.common.error.BizCoreException;
import com.example.demo.dataobject.UserDO;
import com.example.demo.form.UserForm;
import com.example.demo.jpa.UserJpaDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author SanKai
 * @since 2019-11-06
 */
@Service
@Slf4j
public class UserManager {

    @Autowired
    private UserJpaDAO userJpaDAO;

    public Boolean createUser(UserForm form) {
        UserDO user = userJpaDAO.findByUsername(form.getUsername());
        if (!StringUtils.isEmpty(user)) {
            throw new BizCoreException(ErrorCode.USER_EXIST);
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(form.getUsername());
//        userDO.setDescription(form.getDescription());
        String securityPass = DigestUtils.md5DigestAsHex(form.getPassword().getBytes());
        userDO.setPassword(securityPass);
        userJpaDAO.save(userDO);
        return true;
    }

    public UserDO findByName(String username) {

        UserDO userDOS = userJpaDAO.findByUsername(username);
        if (userDOS == null) {
            throw new BizCoreException(ErrorCode.USER_NOT_EXIST);
        }
        return userDOS;
    }

    public Boolean login(String username, String password) {
        String pass = DigestUtils.md5DigestAsHex(password.getBytes());
        UserDO userDO = userJpaDAO.findByUsernameAndPassword(username, password);
        if (userDO == null) {
            throw new BizCoreException(ErrorCode.USER_NOT_EXIST);
        }
        return true;
    }

}

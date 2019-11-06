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
        UserDO userDO = new UserDO();
        userDO.setName(form.getName());
        userDO.setDescription(form.getDescription());
        String securityPass = DigestUtils.md5DigestAsHex(form.getPassword().getBytes());
        userDO.setPassword(securityPass);
        userJpaDAO.save(userDO);
        return true;
    }

    public List<UserDO> findByName(String name) {
        List<UserDO> userDOS = userJpaDAO.findByName(name);
        return userDOS;
    }

    public Boolean login(String name, String password) {
        String pass = DigestUtils.md5DigestAsHex(password.getBytes());
        UserDO userDO = userJpaDAO.findByNameAndAndPassword(name, pass);
        if (userDO == null) {
            throw new BizCoreException(ErrorCode.USER_NOT_EXIST);
        }
        return true;
    }

    public UserDO findOne(Long id){
        UserDO userDO = userJpaDAO.getOne(id);
        return userDO;
    }
}

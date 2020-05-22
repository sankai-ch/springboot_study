package com.example.demo.common.shiro;

import com.example.demo.dataobject.UserDO;
import com.example.demo.jpa.UserJpaDAO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author SanKai
 * @since 2020-01-04
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserJpaDAO userJpaDAO;

    Map<String, String> userMap = new HashMap<>(16);

    {
        userMap.put("sankai", "b1cfd2a4d0d660aa60d110a50e91b160");
        super.setName("customRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userName = (String) principalCollection.getPrimaryPrincipal();

        //从数据库或者缓存中获取角色数据
        Set<String> roles = getRoleByUserName(userName);
        Set<String> permissions = getPermissionByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionByUserName(String userName) {
        Set<String> sets = new HashSet<>();
        sets.add("user:delete");
        sets.add("user:add");
        sets.add("user:update");
        return sets;
    }

    private Set<String> getRoleByUserName(String userName) {
        Set<String> sets = new HashSet<>();
        sets.add("admin");
        sets.add("user");
        return sets;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //1、从主体传过来的认证信息中，获得用户名
        String userName = (String) authenticationToken.getPrincipal();

        //2、通过用户名到数据库中获取凭证
        String password = getPasswordByUsername(userName);

        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("sankai", password, "customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("sankai"));

        return authenticationInfo;
    }

    private String getPasswordByUsername(String userName) {
        UserDO userDO = userJpaDAO.findByUsername(userName);
        if (userDO != null) {
            return userDO.getPassword();
        }
        return null;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "sankai");
        System.out.println(md5Hash);
    }
}

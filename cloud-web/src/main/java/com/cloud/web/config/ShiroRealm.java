package com.cloud.web.config;

import com.cloud.common.entity.TblAuthPermission;
import com.cloud.common.entity.TblAuthUser;
import com.cloud.web.fegin.AuthUserFeginService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义令牌
 *
 * @author
 * @create 2017-11-21 17:11
 **/
public class ShiroRealm extends AuthorizingRealm {
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthUserFeginService authUserFeginService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        UsernamePasswordToken utoken = (UsernamePasswordToken) authcToken;//获取用户输入的token
        String username = utoken.getUsername();
        logger.info("开始时间为{}",System.currentTimeMillis());
        TblAuthUser user = authUserFeginService.findByNickName(username);
        logger.info("结束时间为{}",System.currentTimeMillis());
        return new SimpleAuthenticationInfo(user, user.getPswd(), this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        logger.info("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        TblAuthUser token = (TblAuthUser) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        logger.info("开始时间为{}",System.currentTimeMillis());
        List<TblAuthPermission> permissions = authUserFeginService.findUserPermissionByNickName(token.getNickname());
        logger.info("结束时间为{}",System.currentTimeMillis());
        //实际开发，当前登录用户的角色和权限信息是从数据库来获取的，我这里写死是为了方便测试
        Set<String> roleSet = new HashSet<>();
        if ("admin".equals(token.getNickname())) {
            roleSet.add("admin");
            info.setRoles(roleSet);
        }
        //根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissionSet = new HashSet<String>();
        permissions.forEach(tblAuthPermission -> {
            permissionSet.add(tblAuthPermission.getCode());
        });

        info.setStringPermissions(permissionSet);
        return info;
    }


}
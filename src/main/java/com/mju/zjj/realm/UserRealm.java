package com.mju.zjj.realm;

import com.mju.zjj.pojo.Permissions;
import com.mju.zjj.pojo.Role;
import com.mju.zjj.pojo.User;
import com.mju.zjj.service.RoleService;
import com.mju.zjj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-04 08:33
 **/
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
//    授权
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("执行授权中");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject subject=SecurityUtils.getSubject();

        User user = (User) subject.getPrincipal();//(User) principals.getPrimaryPrincipal();

        try {
            Set<Role> roles = (Set<Role>)userService.getRoles(user.getId()).getData();
            for (Role role : roles) {
                authorizationInfo.addRole(role.getName());//角色存储
                Set<Permissions> set=roleService.getPermissions(role.getId());
                for(Permissions permissions :set){
                    authorizationInfo.addStringPermission(permissions.getName());//权限存储
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }


    @Override
//    认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("执行了认证");
        //获取当前用户
        UsernamePasswordToken userToken=(UsernamePasswordToken)token;
        User user = (User) userService.getUserByName(userToken.getUsername()).getData();
        if(user ==null){
            log.info("no no no ");
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(user.getSalt()),"UserRealm");
    }
}

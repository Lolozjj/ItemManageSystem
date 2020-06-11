package com.mju.zjj.service.Impl;

import com.mju.zjj.mapper.UserMapper;
import com.mju.zjj.pojo.Choose;
import com.mju.zjj.pojo.Role;
import com.mju.zjj.pojo.User;
import com.mju.zjj.service.UserService;
import com.mju.zjj.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 15:11
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public Result insert(User user) {
        if (getUserByName(user.getName()).getData() != null) {
            return Result.error("name is exist");
        }
        try {
            user.setSalt(new Random().nextInt(2000) + "");//设置盐值
            Object result = new SimpleHash(
                    "MD5",
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),
                    2
            );//通过SimpleHash得到MD5加密过的密文密码，此处要与UserRealm的认证，以及ShiroConfig的HashedCredentialsMatcher配合使用
            user.setPassword(result.toString());
            userMapper.insert(user);
            return Result.succees("insert ok");
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error1");
        }

    }

    @Override
    public Result delete(Long id) {
        log.info("删除id为：" + id + " 的用户");
        try {
            int user = userMapper.delete(id);
            return Result.succees("delete ok");
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result update(User user) {
        log.info("修改id为：" + user.getId() + " 的用户");
        try {
            User old = (User) (getUserByName(user.getName()).getData());
            if (!old.getPassword().equals(user.getPassword())) {
                log.info(old.getPassword());
                log.info(user.getPassword());
                user.setSalt(new Random().nextInt(2000) + "");//设置盐值
                Object result = new SimpleHash(
                        "MD5",
                        user.getPassword(),
                        ByteSource.Util.bytes(user.getSalt()),
                        2
                );//通过SimpleHash得到MD5加密过的密文密码，此处要与UserRealm的认证，以及ShiroConfig的HashedCredentialsMatcher配合使用
                user.setPassword(result.toString());
            }
            userMapper.update(user);
            return Result.succees("modif ok");
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getUserByName(String name) {
        log.info("请求搜寻用户信息：" + name);
        try {
            User user = userMapper.getUserByName(name);
            if (user != null) {
                return Result.succees(user);
            } else {
                return Result.error("no exist the user");
            }
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getAll() {
        log.info("获得所有用户信息");
        try {
            Set<User> users = userMapper.getAll();
            return Result.succees(users);
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getAllChoose() {
        log.info("获得所有任课信息");
        try {
            Set<Choose> users = userMapper.getAllChoose();
            return Result.succees(users);
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getUserByExample(User Example) {
        log.info("按模板查询用户信息");
        try {
            Set<User> users = userMapper.getUserByExample(Example);
            return Result.succees(users);
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getRoles(Long id) {
        try {
            Set<Role> roles = userMapper.getRoles(id);
            return Result.succees(roles);
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result login(HttpServletResponse response, String name, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);//执行登陆
//            Cookie cookie = new Cookie("session", token.toString());
//            cookie.setHttpOnly(true);
//            cookie.setMaxAge(60 * 60 * 12);
//            cookie.setPath("/");
//            response.addCookie(cookie);

            return Result.succees(userMapper.getUserByName(name));
        } catch (UnknownAccountException e) {
            return Result.error("用户不存在");
        } catch (IncorrectCredentialsException e) {
            return Result.error("密码错误了");
        }
    }

    @Override
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.succees("logout ok");
    }
}

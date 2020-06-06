package com.mju.zjj.service;

import com.mju.zjj.pojo.Role;
import com.mju.zjj.pojo.User;
import com.mju.zjj.utils.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 15:10
 **/

public interface UserService {
    public Result insert(User user);

    public Result delete(Long id);

    public Result update(User user);

    public Result getUserByName(String name);

    public Result getAll();

    public Result getUserByExample(User Example);

    public Result getRoles(Long id);

    public Result login(HttpServletResponse response,String name, String password);

    public Result logout();


}

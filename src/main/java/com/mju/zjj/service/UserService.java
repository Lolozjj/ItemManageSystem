package com.mju.zjj.service;

import com.mju.zjj.pojo.Role;
import com.mju.zjj.pojo.User;
import com.mju.zjj.utils.Result;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 15:10
 **/

public interface UserService {
    public Result insert(User user);

    public Result getUserByName(String name);

    public Result getRoles(Long id);

    public Result login(String name,String password);

    public Result logout();


}

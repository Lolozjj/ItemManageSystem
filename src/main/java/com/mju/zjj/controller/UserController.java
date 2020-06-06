package com.mju.zjj.controller;

import com.mju.zjj.pojo.User;
import com.mju.zjj.service.UserService;
import com.mju.zjj.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 15:13
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public Result insert(@RequestBody User user){
        return userService.insert(user);
    }

    @GetMapping(value = "/get")
    public Result getUserByName(@Param("name") String name){
        return userService.getUserByName(name);
    }

    @GetMapping(value = "/role/{id}")
    public Result insert(@PathVariable("id") Long id){
        return userService.getRoles(id);
    }

    @PostMapping(value = "/login")
    public Result login(String name,String password){
        return userService.login(name,password);
    }

    @PostMapping(value = "/logout")
    public Result logout(){
        return userService.logout();
    }

    @GetMapping(value = "/noauth")
    public Result unauthorized (){
        return Result.error("无授权，无法访问");
    }

    @GetMapping(value = "/nologin")
    public Result noLogin(){return Result.error("请先登录");}
}

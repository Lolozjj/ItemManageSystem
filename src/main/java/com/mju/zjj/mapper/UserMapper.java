package com.mju.zjj.mapper;

import com.mju.zjj.pojo.Choose;
import com.mju.zjj.pojo.Role;
import com.mju.zjj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 15:06
 **/
@Mapper
public interface UserMapper {
    public int insert(User user);

    public Set<User> getAll();

    public Set<User> getUserByExample(User Example);

    public Set<Choose> getAllChoose();

    public int delete(Long id);

    public int update(User user);

    public User getUserByName(String name);

    public Set<Role> getRoles(Long id);

}

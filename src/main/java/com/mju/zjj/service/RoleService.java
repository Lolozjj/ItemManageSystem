package com.mju.zjj.service;

import com.mju.zjj.pojo.Permissions;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 23:11
 **/
public interface RoleService {
    public Set<Permissions> getPermissions(Long id);
}

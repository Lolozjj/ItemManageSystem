package com.mju.zjj.service.Impl;

import com.mju.zjj.mapper.RoleMapper;
import com.mju.zjj.pojo.Permissions;
import com.mju.zjj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 23:12
 **/
@Service
public class RoleServiceImpl  implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Set<Permissions> getPermissions(Long id) {
        return roleMapper.getPermissions(id);
    }
}

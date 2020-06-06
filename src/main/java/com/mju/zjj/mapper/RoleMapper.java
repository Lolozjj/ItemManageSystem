package com.mju.zjj.mapper;

import com.mju.zjj.pojo.Permissions;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 23:12
 **/
@Mapper
public interface RoleMapper {
    public Set<Permissions> getPermissions(Long id);
}

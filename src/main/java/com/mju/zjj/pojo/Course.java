package com.mju.zjj.pojo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 00:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long id;
    private String name;
    private Integer hour;
    Set<User> users;
    Set<Chapter> chapters;
}

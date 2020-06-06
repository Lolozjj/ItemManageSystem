package com.mju.zjj.pojo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer age;
}

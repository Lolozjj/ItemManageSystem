package com.mju.zjj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 08:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    private Long id;
    private String name;
    private String difficulty;
    private Course course;
    private Set<Item> items;
}

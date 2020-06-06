package com.mju.zjj.service;

import com.mju.zjj.pojo.Course;
import com.mju.zjj.utils.Result;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 00:46
 **/
public interface CourseServie {
    public Result insert(Course course);

    public Result delete(Long id);

    public Result modif(Course course);

    public Result find(Course course);
}

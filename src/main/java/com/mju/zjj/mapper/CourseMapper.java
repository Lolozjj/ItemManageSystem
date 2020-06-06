package com.mju.zjj.mapper;

import com.mju.zjj.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 00:26
 **/
@Mapper
public interface CourseMapper {
    public int insert(Course course);

    public int delete(Long id);

    public int modif(Course course);

    public Set<Course> find(Course course);
}

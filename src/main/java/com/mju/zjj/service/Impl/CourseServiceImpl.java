package com.mju.zjj.service.Impl;

import com.mju.zjj.mapper.CourseMapper;
import com.mju.zjj.pojo.Course;
import com.mju.zjj.service.CourseServie;
import com.mju.zjj.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 00:46
 **/
@Service
@Slf4j
public class CourseServiceImpl implements CourseServie {

    private CourseMapper courseMapper;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper){
        this.courseMapper=courseMapper;
    }

    @Override
    public Result insert(Course course) {
        try {
            courseMapper.insert(course);
            log.info("新增课程信息："+course.toString());
            return Result.succees("insert ok");
        }
        catch (Exception e){
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result delete(Long id) {
        try {
            courseMapper.delete(id);
            log.info("删除课程信息："+id.toString());
            return Result.succees("delete ok");
        }
        catch (Exception e){
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result modif(Course course) {
        try {
            courseMapper.modif(course);
            log.info("修改课程信息："+course.toString());
            return Result.succees("modification ok");
        }
        catch (Exception e){
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result find(Course course) {
        try {
            log.info("查询课程信息："+course.toString());
            return Result.succees(courseMapper.find(course));
        }
        catch (Exception e){
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result findByUser(Long id) {
        try {
            log.info("查询用户的课程信息：");
            return Result.succees(courseMapper.findByUser(id));
        }
        catch (Exception e){
            log.error(e.toString());
            return Result.error("error");
        }
    }
}

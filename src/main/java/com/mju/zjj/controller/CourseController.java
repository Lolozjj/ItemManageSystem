package com.mju.zjj.controller;

import com.mju.zjj.pojo.Course;
import com.mju.zjj.service.CourseServie;
import com.mju.zjj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 00:54
 **/
@RestController
@RequestMapping
public class CourseController {
    @Autowired
    private CourseServie courseServie;


    @PostMapping(value = "/courses")
    public Result insert(@RequestBody  Course course) {
        return courseServie.insert(course);
    }

    @DeleteMapping(value = "/courses/{id}")
    public Result delete(@PathVariable(value = "id") Long id) {
        return courseServie.delete(id);
    }

    @PutMapping(value = "/courses/{id}")
    public Result modif(@PathVariable(value = "id") Long id,@RequestBody Course course) {
        course.setId(id);
        return courseServie.modif(course);
    }
    @GetMapping(value = "/courses")
    public Result find(Course course) {
        return courseServie.find(course);
    }

    @GetMapping(value = "/courses/{id}")
    public Result findByUser(@PathVariable(value = "id") Long id){
        return courseServie.findByUser(id);
    }

}

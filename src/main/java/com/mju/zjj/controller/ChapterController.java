package com.mju.zjj.controller;

import com.mju.zjj.pojo.Chapter;
import com.mju.zjj.service.ChapterService;
import com.mju.zjj.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 09:54
 **/
@RestController
@RequestMapping
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @PostMapping(value = "/chapters")
    public Result insert(@RequestBody Chapter chapter){
        return chapterService.insert(chapter);
    }

    @DeleteMapping(value = "/chapters/{id}")
    public Result delete(@PathVariable(value = "id") Long id){
        return chapterService.delete(id);
    }

    @PutMapping(value = "/chapters")
    public Result modif(@RequestBody Chapter chapter){
        return chapterService.modif(chapter);
    }

    @GetMapping(value = "/chapters/{id}")
    public Result get(@PathVariable(value = "id") Long id){
        return chapterService.getChapterByCourse(id);
    }
}

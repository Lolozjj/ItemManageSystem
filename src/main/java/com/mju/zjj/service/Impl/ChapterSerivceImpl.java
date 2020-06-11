package com.mju.zjj.service.Impl;

import com.mju.zjj.mapper.ChapterMapper;
import com.mju.zjj.mapper.ItemMapper;
import com.mju.zjj.pojo.Chapter;
import com.mju.zjj.service.ChapterService;
import com.mju.zjj.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 09:43
 **/
@Service
@Slf4j
public class ChapterSerivceImpl implements ChapterService {

    private ChapterMapper chapterMapper;
    private ItemMapper itemMapper;

    @Autowired
    public ChapterSerivceImpl(ChapterMapper chapterMapper,ItemMapper itemMapper){
        this.itemMapper=itemMapper;
        this.chapterMapper=chapterMapper;
    }
    @Override
    public Result insert(Chapter chapter) {
        try {
            chapterMapper.insert(chapter);
            log.info("新增章节信息："+chapter.toString());
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
            itemMapper.deleteByChapter(id);
            chapterMapper.delete(id);
            log.info("删除章节信息："+id.toString());
            return Result.succees("delete ok");
        }
        catch (Exception e){
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result modif(Chapter chapter) {
        try {
            chapterMapper.modif(chapter);
            log.info("修改课程信息："+chapter.toString());
            return Result.succees("modification ok");
        }
        catch (Exception e){
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getChapterByCourse(Long id) {
        try {
            Set<Chapter> chapters = chapterMapper.getChapterByCourse(id);
            log.info("获取课程的章节信息："+chapters.toString());
            return Result.succees(chapters);
        }
        catch (Exception e){
            log.error(e.toString());
            return Result.error("error");
        }
    }
}

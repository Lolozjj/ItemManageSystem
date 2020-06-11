package com.mju.zjj.service;

import com.mju.zjj.pojo.Chapter;
import com.mju.zjj.utils.Result;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 09:43
 **/
public interface ChapterService {
    public Result insert(Chapter chapter);

    public Result delete(Long id);

    public Result modif(Chapter chapter);

    public Result getChapterByCourse(Long id);
}

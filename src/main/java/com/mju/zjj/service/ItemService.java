package com.mju.zjj.service;

import com.mju.zjj.pojo.Course;
import com.mju.zjj.pojo.Item;
import com.mju.zjj.utils.Result;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 15:45
 **/
public interface ItemService {
    public Result insert(Item Item);

    public Result delete(Long id);

    public Result modif(Item Item);

    public Result getItemByChapter(Long id);

    public Result getItemByExampleAndChapter(Item item);

    public Result getTypeSumByChapters(List chapters);

    public Result GeneratingTestPapers(List<Long> chapterIdList, Map<String, Integer> titleTypeIntegerMap) throws Exception;

    ResponseEntity downloadTest(String fileName) throws Exception;
}

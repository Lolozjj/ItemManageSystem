package com.mju.zjj.controller;

import com.mju.zjj.pojo.Chapter;
import com.mju.zjj.pojo.Course;
import com.mju.zjj.pojo.Item;
import com.mju.zjj.pojo.Paper;
import com.mju.zjj.service.ItemService;
import com.mju.zjj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 15:51
 **/
@RestController
@RequestMapping
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/items")
    public Result insert(@RequestBody Item item){
        return itemService.insert(item);
    }

    @DeleteMapping(value = "items/{id}")
    public Result delete(@PathVariable(value = "id") Long id){
        return itemService.delete(id);
    }

    @PutMapping(value = "items/{id}")
    public Result modif(@PathVariable(value = "id") Long id,@RequestBody Item item){
        item.setId(id);
        return itemService.modif(item);
    }

    @GetMapping(value = "/items/{id}")
    public Result getItemByChapter(@PathVariable(value = "id") Long id){
        return itemService.getItemByChapter(id);
    }

    @PostMapping(value = "/typeSum")
    public Result getTypeSumByChapters(@RequestBody List<Integer> chapters){
        return itemService.getTypeSumByChapters(chapters);
    }

    @GetMapping(value = "/items")
    public Result getItemByExampleAndChapter(Long id,String content,String answer,String type,Integer selectNum,Integer score,Long chapterId){
        Item item=new Item();
        item.setId(id);
        item.setContent(content);
        item.setAnswer(answer);
        item.setType(type);
        item.setSelectSum(selectNum);
        item.setScore(score);
        Chapter chapter = new Chapter();
        chapter.setId(chapterId);
        item.setChapter(chapter);
        return itemService.getItemByExampleAndChapter(item);
    }

    @PostMapping("/Test")
    Result GeneratingTestPapers2(@RequestBody Paper paper)throws Exception{
        List<Long> chapterIdList=paper.getChapterIdList();
        Map<String, Integer> titleTypeIntegerMap=new HashMap<>();
        List<String> types = paper.getTypes();
        List<Integer> sums = paper.getSums();

        for(int i=0;i<types.size();i++){
            titleTypeIntegerMap.put(types.get(i),sums.get(i));
        }
        System.out.println(titleTypeIntegerMap);
        return itemService.GeneratingTestPapers(chapterIdList,titleTypeIntegerMap);
//        System.out.println(paper);
//        return null;
    }

//    @PostMapping(value = "/zjj")
//    ResponseEntity zjj(@RequestBody Map<String,Integer> m)throws Exception{
////        List<Long> chapterIdList=paper.getChapterIdList();
////        Map<String, Integer> titleTypeIntegerMap=paper.getItemTypeIntegerMap();
////        return itemService.GeneratingTestPapers(chapterIdList,titleTypeIntegerMap);
//        System.out.println(m);
//        return null;
//    }
    @GetMapping("/downloadTest")
    ResponseEntity downloadTest(String fileName) throws Exception {
        System.out.println(fileName+"=====================");
        return itemService.downloadTest(fileName);
    }
}

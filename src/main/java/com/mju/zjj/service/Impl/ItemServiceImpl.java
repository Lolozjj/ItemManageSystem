package com.mju.zjj.service.Impl;

import com.mju.zjj.mapper.ItemMapper;
import com.mju.zjj.pojo.Chapter;
import com.mju.zjj.pojo.Item;
import com.mju.zjj.pojo.TypeSum;
import com.mju.zjj.service.ItemService;
import com.mju.zjj.utils.Result;
import com.mju.zjj.utils.WorderToNewWordUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 15:46
 **/

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private ItemMapper itemMapper;

    @Autowired
    WorderToNewWordUtils worderToNewWordUtils;

    private final String inputUrl = "src/main/resources/test.docx";

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public Result insert(Item Item) {
        try {
            itemMapper.insert(Item);
            log.info("新增题目信息：" + Item.toString());
            return Result.succees("insert ok");
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result delete(Long id) {
        try {
            itemMapper.delete(id);
            log.info("删除题目信息：" + id.toString());
            return Result.succees("delete ok");
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result modif(Item Item) {
        try {
            itemMapper.modif(Item);
            log.info("修改题目信息：" + Item.toString());
            return Result.succees("modification ok");
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getItemByChapter(Long id) {
        try {
            Set<Item> chapters = itemMapper.getItemByChapter(id);
            log.info("获取章节的题目信息：" + chapters.toString());
            return Result.succees(chapters);
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getItemByExampleAndChapter(Item item) {
        try {
            Set<Item> chapters = itemMapper.getItemByExampleAndChapter(item);
            log.info("选取章节的题目信息：" + chapters.toString());
            return Result.succees(chapters);
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result getTypeSumByChapters(List chapters) {
        try {
            Set<TypeSum> typeSums = itemMapper.getTypeSumByChapters(chapters);
            log.info("选取章节的题型及其数量：" + typeSums.toString());
            return Result.succees(typeSums);
        } catch (Exception e) {
            log.error(e.toString());
            return Result.error("error");
        }
    }

    @Override
    public Result GeneratingTestPapers(List<Long> chapterIdList, Map<String, Integer> titleTypeIntegerMap)  throws Exception {
        String[] chineseSum = {"零、", "一、", "二、", "三、", "四、", "五、", "六、", "七、", "八、", "九、", "十、"};
        Map<String, String> replaceMap = new HashMap<String, String>();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM");
        String date = sim.format(new Date());
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        if (Integer.valueOf(month) >= 2 && Integer.valueOf(month) <= 7) {
            Integer temp = Integer.valueOf(year) - 1;
            replaceMap.put("time", temp.toString() + "-" + year);
            replaceMap.put("count", "二");
        } else {
            Integer temp = Integer.valueOf(year) + 1;
            replaceMap.put("time", year + "-" + temp.toString());
            replaceMap.put("count", "一");
        }

//        System.out.println(chapterIdList);
        List<Item> totalTest = new ArrayList<>();
        int c = 1;
        int sum = 1;
        for (Map.Entry<String, Integer> entry : titleTypeIntegerMap.entrySet()) {
            replaceMap.put("type" + c, chineseSum[c] + entry.getKey());//word替换添加
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
            int needSum = entry.getValue();
            List<Item> list = itemMapper.getItemOne(chapterIdList, entry.getKey());
            Collections.shuffle(list);
            List<Item> items = list.subList(0, needSum);
            totalTest.addAll(items);

            String titleContent = new String();
            for (Item i : items
            ) {
                titleContent+=sum+"、"+i.getContent()+"\n\n";
                sum++;
            }
            replaceMap.put("title"+c,titleContent);
            c++;
        }

        String fileName="JAVA"+System.currentTimeMillis()+".docx";
        String fileUrl="src/main/resources/word/"+fileName;
        replaceMap.put("lesson","JAVA");
        WorderToNewWordUtils.changWord(inputUrl, fileUrl, replaceMap, null);

        return Result.succees(fileName);
    }

    @Override
    public ResponseEntity downloadTest(String fileName) throws Exception {
        String fileUrl ="src/main/resources/word/"+fileName;

        FileSystemResource fileSystemResource = new FileSystemResource(fileUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=" + fileName);
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(fileSystemResource.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(fileSystemResource.getInputStream()));
    }
}

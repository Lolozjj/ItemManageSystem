package com.mju.zjj.mapper;

import com.mju.zjj.pojo.Chapter;
import com.mju.zjj.pojo.Item;
import com.mju.zjj.pojo.TypeSum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 10:44
 **/
@Mapper
public interface ItemMapper {
    public int insert(Item item);

    public int delete(Long id);

    public int deleteByChapter(Long chapterId);

    public int modif(Item item);

    public Set<Item> getItemByChapter(Long id);

    public Set<Item> getItemByExampleAndChapter(Item item);

    public Set<TypeSum> getTypeSumByChapters(List chapters);

    /*
    根据章节范围、itemType返回满足题目id,用于生成试卷
     */
    public List<Item> getItemOne(List chapters,String typename);
}

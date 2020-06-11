package com.mju.zjj.mapper;

import com.mju.zjj.pojo.Chapter;
import com.mju.zjj.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 08:58
 **/
@Mapper
public interface ChapterMapper {
    public int insert(Chapter chapter);

    public int delete(Long id);

    public int modif(Chapter chapter);

    public Set<Chapter> getChapterByCourse(Long id);

}

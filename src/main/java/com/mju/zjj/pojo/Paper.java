package com.mju.zjj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-09 15:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
    private List<Long> chapterIdList;
    private List<String> types;
    private List<Integer> sums;
//    private Map<String,Integer> itemTypeIntegerMap;
}

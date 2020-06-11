package com.mju.zjj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-07 10:30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String content;
    private String answer;
    private String type;
    private Integer selectSum;
    private Integer score;
    private Timestamp createTime;
    private String orgin;
    private Chapter chapter;
}

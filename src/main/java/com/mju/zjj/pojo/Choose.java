package com.mju.zjj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-08 14:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choose {
    private Long id;
    private Long userId;
    private String userName;
    private Long courseId;
    private String courseName;
}

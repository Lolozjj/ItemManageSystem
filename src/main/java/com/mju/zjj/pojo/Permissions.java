package com.mju.zjj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 23:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permissions {
    private Long id;
    private String name;
    private String des;
}

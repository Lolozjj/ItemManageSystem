package com.mju.zjj.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 15:17
 **/

@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    @Getter
    private boolean succeed;
    @Getter
    private T data;
    @Getter
    private String error;

    public static<T> Result succees(T data){
        return new Result(true,data,null);
    }

    public static <T> Result error(String error){
        return new Result(false,null,error);
    }
}

package com.yilan.utils;

import com.yilan.annotation.MapperCell;

/**
 * Created by Administrator on 2016-11-10.
 */
public class Tuser {
    @MapperCell(cellName = "用户姓名")
    private String name;
    @MapperCell(cellName = "门户id")
    private String epId;

    @Override
    public String toString() {
        return "Tuser{" +
                "name='" + name + '\'' +
                ", epId='" + epId + '\'' +
                '}';
    }
}

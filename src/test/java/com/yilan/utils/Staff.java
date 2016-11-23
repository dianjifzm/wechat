package com.yilan.utils;

import com.yilan.annotation.MapperCell;

/**
 * Created by Administrator on 2016-11-16.
 */
public class Staff {
    @MapperCell(cellName = "USERID")
    public String userid;
    @MapperCell(cellName = "STAFFNAME")
    public String staffname;
    @MapperCell(cellName = "FLAG")
    public String flag;
    @MapperCell(cellName = "DEPTCODE")
    public String deptcode;
    @MapperCell(cellName = "ORGCODE")
    public String orgcode;
    @MapperCell(cellName = "DEPTNAME")
    public String deptname;
    @MapperCell(cellName = "OA_DEPTNAME")
    public String OAdeptname;

}

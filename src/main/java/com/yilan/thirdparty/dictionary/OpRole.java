package com.yilan.thirdparty.dictionary;

/**
 * Created by Administrator on 2016-11-23.
 */
public enum OpRole {
    customerCode(1,"客户代码"),
    counterCode(2,"柜员代码"),
    agentCode(3,"经纪人代码");

    private int code;
    private String desc;

    OpRole(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return code+"";
    }
}

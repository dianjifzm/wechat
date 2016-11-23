package com.yilan.thirdparty.dictionary;

/**
 * Created by Administrator on 2016-11-23.
 */
public enum OperationChannel {
    phone(1,"电话委托"),
    card(2,"刷卡委托"),
    hotkey(3,"热键委托"),
    online(4,"网上委托");

    private int code;
    private String desc;

    OperationChannel(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    @Override
    public String toString() {
        return code+"";
    }
}

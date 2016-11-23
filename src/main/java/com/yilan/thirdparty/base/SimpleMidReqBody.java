package com.yilan.thirdparty.base;

/**
 * Created by Administrator on 2016-11-23.
 */
public class SimpleMidReqBody implements MidReqBody{
    private int code;
    private String data;

    public SimpleMidReqBody(int code, String data) {
        this.code = code;
        this.data = data;
    }

    @Override
    public int getBusinessCode() {
        return code;
    }

    @Override
    public int getBodyLength() {
        return this.midserialize().length();
    }

    @Override
    public String midserialize() {
        String d = data.replace("|","&#124;");
        return code+"|"+d+"|";
    }

    public static void main(String[] args) {
//        int b = 0X7C;
        char c = 0X7C;
        System.out.println(c);
    }
}

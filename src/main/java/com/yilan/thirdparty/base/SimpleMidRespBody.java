package com.yilan.thirdparty.base;

/**
 * Created by Administrator on 2016-11-23.
 */
public class SimpleMidRespBody implements MidRespBody{
    private String date;

    @Override
    public void decode(String str) {
        setDate(str);
    }

    public String getDate() {
        return date;
    }

    public SimpleMidRespBody setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "SimpleMidRespBody{" +
                "date='" + date + '\'' +
                '}';
    }
}

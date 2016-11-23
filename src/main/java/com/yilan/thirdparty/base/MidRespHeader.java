package com.yilan.thirdparty.base;

/**
 * Created by Administrator on 2016-11-22.
 */
public class MidRespHeader {
    private String headerLength; //头长度
    private String bodyLength; //数据域长度
    private String crcCode; //CRC校验码
    private String version = "KDGATEWAY1.2"; //版本号
    private String returnCode; //返回码
    private String returnMsg; //返回信息
    private String chunk; //后续包标记
    private String colums; //应答字段数
    private String records; //应答记录数
    private String businessCode; //原请求功能号
    private String sequence ; //请求包序列号
    private String optional2 ; //保留字段2

    public String getHeaderLength() {
        return headerLength;
    }

    public MidRespHeader setHeaderLength(String headerLength) {
        this.headerLength = headerLength;
        return this;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public MidRespHeader setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
        return this;
    }

    public String getCrcCode() {
        return crcCode;
    }

    public MidRespHeader setCrcCode(String crcCode) {
        this.crcCode = crcCode;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public MidRespHeader setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public MidRespHeader setReturnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public MidRespHeader setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
        return this;
    }

    public String getChunk() {
        return chunk;
    }

    public MidRespHeader setChunk(String chunk) {
        this.chunk = chunk;
        return this;
    }

    public String getColums() {
        return colums;
    }

    public MidRespHeader setColums(String colums) {
        this.colums = colums;
        return this;
    }

    public String getRecords() {
        return records;
    }

    public MidRespHeader setRecords(String records) {
        this.records = records;
        return this;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public MidRespHeader setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
        return this;
    }

    public String getSequence() {
        return sequence;
    }

    public MidRespHeader setSequence(String sequence) {
        this.sequence = sequence;
        return this;
    }

    public String getOptional2() {
        return optional2;
    }

    public MidRespHeader setOptional2(String optional2) {
        this.optional2 = optional2;
        return this;
    }

    @Override
    public String toString() {
        return "MidRespHeader{" +
                "headerLength='" + headerLength + '\'' +
                ", bodyLength='" + bodyLength + '\'' +
                ", crcCode='" + crcCode + '\'' +
                ", version='" + version + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", chunk='" + chunk + '\'' +
                ", colums='" + colums + '\'' +
                ", records='" + records + '\'' +
                ", businessCode='" + businessCode + '\'' +
                ", sequence='" + sequence + '\'' +
                ", optional2='" + optional2 + '\'' +
                '}';
    }
}

package com.yilan.thirdparty.base;


import com.yilan.thirdparty.dictionary.OpRole;
import com.yilan.thirdparty.dictionary.OperationChannel;
import org.apache.commons.lang3.StringUtils;

/**
 * 请求包头
 * Created by Administrator on 2016-11-22.
 */
public class MidReqHeader {
    private String headerLength; //头长度
    private String bodyLength; //数据域长度
    private String crcCode; //CRC校验码
    public final String VERSION = "KDGATEWAY1.2"; //版本号
    private String userCode; //用户代码
    private String opSite; //操作站点
    private String openBranch; //开户分支
    private OperationChannel opChannel; //操作渠道
    private String sessionId; //会话序号
    private OpRole optional1; //保留字段1
    private String optional2; //保留字段2
    private String optional3; //保留字段3

    public String getHeaderLength() {
        return headerLength;
    }

    public MidReqHeader setHeaderLength(String headerLength) {
        this.headerLength = headerLength;
        return this;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public MidReqHeader setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
        return this;
    }

    public String getCrcCode() {
        return crcCode;
    }

    public MidReqHeader setCrcCode(String crcCode) {
        this.crcCode = crcCode;
        return this;
    }

    public String getVERSION() {
        return VERSION;
    }

    public String getUserCode() {
        return userCode;
    }

    public MidReqHeader setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public String getOpSite() {
        return opSite;
    }

    public MidReqHeader setOpSite(String opSite) {
        this.opSite = opSite;
        return this;
    }

    public String getOpenBranch() {
        return openBranch;
    }

    public MidReqHeader setOpenBranch(String openBranch) {
        this.openBranch = openBranch;
        return this;
    }

    public OperationChannel getOpChannel() {
        return opChannel;
    }

    public MidReqHeader setOpChannel(OperationChannel opChannel) {
        this.opChannel = opChannel;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public MidReqHeader setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public OpRole getOptional1() {
        return optional1;
    }

    public MidReqHeader setOptional1(OpRole optional1) {
        this.optional1 = optional1;
        return this;
    }

    public String getOptional2() {
        return optional2;
    }

    public MidReqHeader setOptional2(String optional2) {
        this.optional2 = optional2;
        return this;
    }

    public String getOptional3() {
        return optional3;
    }

    public MidReqHeader setOptional3(String optional3) {
        this.optional3 = optional3;
        return this;
    }

    public String midSerialize(){
        String midStr =StringUtils.trimToEmpty(headerLength)+"|"+
        StringUtils.trimToEmpty(bodyLength)+"|"+
        StringUtils.trimToEmpty(crcCode)+"|"+
        StringUtils.trimToEmpty(VERSION)+"|"+
        StringUtils.trimToEmpty(userCode)+"|"+
        StringUtils.trimToEmpty(opSite)+"|"+
        StringUtils.trimToEmpty(openBranch)+"|"+
        StringUtils.trimToEmpty(opChannel==null?"":opChannel.toString())+"|"+
        StringUtils.trimToEmpty(sessionId)+"|"+
        StringUtils.trimToEmpty(optional1==null?"":optional1.toString())+"|"+
        StringUtils.trimToEmpty(optional2)+"|"+
        StringUtils.trimToEmpty(optional3)+"|";
        //如果前台数据字符串中含有’|’字符或中文字符中有0X7C，则转义成’&#124;’发往后台
        return midStr;
    }
}

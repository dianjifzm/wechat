package com.yilan.thirdparty.utils;

import com.yilan.thirdparty.base.MidRespBody;
import com.yilan.thirdparty.base.MidRespHeader;
import com.yilan.thirdparty.base.SimpleMidRespBody;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016-11-23.
 */
public class MidUtils {

    private static Logger logger = LoggerFactory.getLogger(MidUtils.class);
    public static void midDeserialize(MidRespHeader header, MidRespBody body, String midStr){
        String hLen = StringUtils.left(midStr,4);
        String headStr = StringUtils.left(midStr,Integer.valueOf(hLen));
        System.out.println(headStr);
        String[] head =StringUtils.splitPreserveAllTokens(headStr,"\\|");//这里会多出最后一项的空白字符串

        if(head.length>11){
            header.setHeaderLength(head[0]);
            header.setBodyLength(head[1]);
            header.setCrcCode(head[2]);
            header.setVersion(head[3]);
            header.setReturnCode(head[4]);
            header.setReturnMsg(head[5]);
            header.setChunk(head[6]);
            header.setColums(head[7]);
            header.setRecords(head[8]);
            header.setBusinessCode(head[9]);
            header.setSequence(head[10]);
            header.setOptional2(head[11]);
        }else{
            logger.error("mid包头解包出错："+midStr);
        }

        body.decode(StringUtils.substring(midStr,Integer.valueOf(hLen)));
    }

    public static boolean noLogin(int bsnCode){
        if(bsnCode==100||bsnCode/100==2||bsnCode==301){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String m = "0061|0000000026|507b4d80|KDGATEWAY1.2|0|22222222|0|1|1|100|||WORKSKEY|A833A58C11E105B0|";
        MidRespHeader header = new MidRespHeader();
        SimpleMidRespBody body = new SimpleMidRespBody();
        MidUtils.midDeserialize(header,body,m);
        logger.info(header.toString());
        logger.info(body.toString());
    }
}

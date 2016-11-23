package com.yilan.thirdparty.serialization;

import com.yilan.thirdparty.base.MidReqBody;
import com.yilan.thirdparty.base.MidReqHeader;
import com.yilan.thirdparty.dictionary.OpRole;
import com.yilan.thirdparty.dictionary.OperationChannel;
import com.yilan.thirdparty.utils.MidUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端发送请求给MID的时候第一层调用
 * Created by Administrator on 2016-11-22.
 */
public class MidEncoder extends ChannelOutboundHandlerAdapter {
    private static Logger logger	= LoggerFactory.getLogger(MidDecoder.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        MidReqBody body = (MidReqBody) msg;
        logger.info("MidEncoder :　"+body.midserialize());
        //增加Mid请求头部
        MidReqHeader header = new MidReqHeader();
        header.setBodyLength(formatInt(body.getBodyLength(),4));
        int bsnCode = body.getBusinessCode();
        header.setOptional1(OpRole.customerCode);
        if(!MidUtils.noLogin(bsnCode)){
            //如果是要登录的交易，则送三要素
//            header.setUserCode();
//            header.setOpenBranch();
//            header.setSessionId();
        }
        header.setHeaderLength(formatInt(header.midSerialize().length()+4,4));
        logger.info("=====================发送mid============================");
        logger.info(header.midSerialize()+body.midserialize());
        // 执行下一个OutboundHandler
        super.write(ctx, header.midSerialize()+body.midserialize(), promise);
    }

    private String formatInt(int src,int len){
        String str = String.valueOf(src);
        return StringUtils.leftPad(str,len,'0');
    }

}

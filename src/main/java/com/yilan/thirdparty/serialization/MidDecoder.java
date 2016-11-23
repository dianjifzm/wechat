package com.yilan.thirdparty.serialization;

import com.yilan.thirdparty.base.MidRespHeader;
import com.yilan.thirdparty.base.SimpleMidRespBody;
import com.yilan.thirdparty.utils.MidUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016-11-22.
 */
public class MidDecoder extends ChannelInboundHandlerAdapter {
    private static Logger logger	= LoggerFactory.getLogger(MidEncoder.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("MidEncoder : msg's " + msg);
        String m = (String)msg;
        MidRespHeader header = new MidRespHeader();
        SimpleMidRespBody body = new SimpleMidRespBody();
        MidUtils.midDeserialize(header,body,m);

        // 通知执行下一个InboundHandler
        ctx.fireChannelRead(body);

    }
}

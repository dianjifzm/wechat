package com.yilan.thirdparty;

import com.yilan.thirdparty.base.SimpleMidReqBody;
import com.yilan.vo.UserVo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016-11-21.
 */
public class SubReqClientHandler extends ChannelInboundHandlerAdapter {
    private Logger log = LoggerFactory.getLogger(SubReqClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("socket激活，连接上MID");
//        ctx.write(new UserVo().setUserId(1).setName("zhujiahao"));
        //socket激活连接后，立刻签入mid系统,调用ctx.write(msg) 将传递到ChannelOutboundHandler。
        ctx.write(new SimpleMidReqBody(100,""));
        //ctx.write()方法执行后，需要调用flush()方法才能令它立即执行。
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("收到的信息："+msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("channelReadComplete....");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("发生异常！");
    }
}

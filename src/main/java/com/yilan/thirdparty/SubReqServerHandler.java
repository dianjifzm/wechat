package com.yilan.thirdparty;

import com.yilan.vo.UserVo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Administrator on 2016-11-21.
 */
@ChannelHandler.Sharable
public class SubReqServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        System.out.println("server====="+msg);
        ctx.writeAndFlush(login(1));
        /*UserVo user = (UserVo) msg;
        if("zhujiahao".equalsIgnoreCase(user.getName())){
            System.out.println("====="+user);
            ctx.writeAndFlush(login(user.getUserId()));
        }*/
    }

    //用户登录
    private UserVo login(int userid){
        UserVo user = new UserVo();
        user.setUserId(userid);
        user.setName("朱家浩");
        user.setCellPhone("13088872545");
        return user;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();//发生异常，关闭链路
    }
}

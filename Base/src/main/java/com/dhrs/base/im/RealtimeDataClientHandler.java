package com.dhrs.base.im;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RealtimeDataClientHandler  extends SimpleChannelInboundHandler<RealtimeData> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RealtimeData msg) throws Exception {
        System.out.println("---------------------");
        System.out.print( ctx.channel().id());
        System.out.print( msg);
        System.out.println(ctx.isRemoved());
        System.out.println(ctx.channel().isOpen());
        System.out.println(ctx.channel().isActive());
        System.out.println(ctx.channel().isRegistered());
        System.out.println(ctx.channel().isWritable());
        System.out.println("---------------------");

    }
}

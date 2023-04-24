package com.dhrs.base.im;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RealtimeDataHandler  extends SimpleChannelInboundHandler<RealtimeData> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RealtimeData message) throws Exception {
        // 处理实时数据，例如将数据保存到数据库或发送给其他客户端
    }
}


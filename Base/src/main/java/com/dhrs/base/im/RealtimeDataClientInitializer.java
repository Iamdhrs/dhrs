package com.dhrs.base.im;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;

public class RealtimeDataClientInitializer  extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LengthFieldPrepender(2));
        pipeline.addLast(new RealtimeDataEncoder());
        pipeline.addLast(new RealtimeDataClientHandler());
    }
}

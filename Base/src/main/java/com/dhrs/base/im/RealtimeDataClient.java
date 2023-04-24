package com.dhrs.base.im;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public class RealtimeDataClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new RealtimeDataClientInitializer());

            ChannelFuture f = b.connect("localhost", 8888).sync();
            f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        ByteBuf request = Unpooled.copiedBuffer("Hello, Netty!", CharsetUtil.UTF_8);
                        future.channel().writeAndFlush(request);
                    } else {
                        Throwable cause = future.cause();
                        cause.printStackTrace();
                    }
                }
            });
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}

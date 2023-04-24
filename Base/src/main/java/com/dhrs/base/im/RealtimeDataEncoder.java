package com.dhrs.base.im;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class RealtimeDataEncoder  extends MessageToByteEncoder<RealtimeData> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RealtimeData message, ByteBuf out) throws Exception {
        out.writeShort(message.getType());
        out.writeBytes(message.getData());
    }
}

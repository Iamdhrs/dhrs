package com.dhrs.base.im;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class RealtimeDataDecoder extends LengthFieldBasedFrameDecoder {
    public RealtimeDataDecoder() {
        super(65535, 0, 2, 0, 2);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        int length = in.readableBytes();
        if (length < 6) {
            return null;
        }

        int type = in.readUnsignedShort();
        byte[] data = new byte[length - 2];
        in.readBytes(data);

        RealtimeData message = new RealtimeData();
        message.setType(type);
        message.setData(data);

        return message;
    }
}

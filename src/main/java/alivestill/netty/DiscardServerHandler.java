package alivestill.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ((ByteBuf)msg).release();
        ByteBuf in = (ByteBuf)msg;
        try {
//            while (in.isReadable()) {
//                System.out.print((char)in.readByte());
//                System.out.flush();
//            }
            long currentTimeMills = (in.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMills));
            ctx.close();
        } finally {
//            ReferenceCountUtil.release(msg);
            in.release();
        }
    }

//    @Override
//    public void channelActive(final ChannelHandlerContext ctx) {
//        final ByteBuf time = ctx.alloc().buffer(4);
//        time.writeInt((int)(System.currentTimeMillis() / 1000L + 2208988800L));
//
//        final ChannelFuture f = ctx.writeAndFlush(time);
//        f.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                assert f == future;
//                ctx.close();
//            }
//        });
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

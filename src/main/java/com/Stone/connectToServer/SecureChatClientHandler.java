package com.Stone.connectToServer;

import com.Stone.connectToServer.packets.ToClient.LoginPacket;
import com.Stone.connectToServer.packets.ToClientPacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * Created by Wed on 08.02.16.
 */
public class SecureChatClientHandler extends SimpleChannelInboundHandler<ToClientPacket> {

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {

        ctx.writeAndFlush(new com.Stone.connectToServer.packets.ToServer.LoginPacket());

    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ToClientPacket msg) {
        if(Server.Initialize()==null) {
            if (msg instanceof LoginPacket) {
                if (((LoginPacket) msg).isAllOk)
                    new Server(ctx.channel());
            }
        }else
        {
            Server.Initialize().addPacket(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
         cause.printStackTrace();
         ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Server Disconnect");
        if(Server.Initialize()!=null)
            Server.Initialize().close();
        super.channelInactive(ctx);
    }
}
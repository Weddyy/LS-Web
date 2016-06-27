package com.Stone.connectToServer.packets.ToClient;

import com.Stone.connectToServer.packets.ToClientPacket;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 08.03.16.
 */
public class STSInfo extends ToClientPacket {

    public boolean rem;

    public void get(ByteBuf buffer) {
        rem=buffer.readBoolean();
    }
}

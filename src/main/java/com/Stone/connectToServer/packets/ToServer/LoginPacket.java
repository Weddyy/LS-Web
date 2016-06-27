package com.Stone.connectToServer.packets.ToServer;

import com.Stone.connectToServer.packets.ToServerPacket;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 08.02.16.
 */
public class LoginPacket extends ToServerPacket {

    public int getId() {
        return 21;
    }

    public void send(ByteBuf buffer) {
        buffer.writeShort(13);
    }
}

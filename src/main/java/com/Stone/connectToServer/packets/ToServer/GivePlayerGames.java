package com.Stone.connectToServer.packets.ToServer;

import com.Stone.connectToServer.packets.ToServerPacket;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 19.02.16.
 */
public class GivePlayerGames extends ToServerPacket {
    String serverId;
    long playerId;

    public GivePlayerGames(String serverId, long playerId) {
        this.serverId = serverId;
        this.playerId = playerId;
    }

    public int getId() {
        return 53;
    }

    public void send(ByteBuf buffer) {

        buffer.writeLong(playerId);
        buffer.writeInt(serverId.getBytes().length);
        buffer.writeBytes(serverId.getBytes(Charset.forName("UTF-8")));

    }
}

package com.Stone.connectToServer.packets.ToServer;

import com.Stone.connectToServer.packets.ToServerPacket;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 09.02.16.
 */
public class GiveGame extends ToServerPacket {
    boolean onlyOne;
    int gameId;

    public GiveGame(boolean onlyOne, int gameId) {
        this.onlyOne = onlyOne;
        this.gameId = gameId;
    }

    public int getId() {
        return 52;
    }

    public void send(ByteBuf buffer) {

        buffer.writeInt(gameId);
        buffer.writeBoolean(onlyOne);

    }
}

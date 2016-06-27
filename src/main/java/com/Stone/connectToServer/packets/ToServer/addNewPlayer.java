package com.Stone.connectToServer.packets.ToServer;

import com.Stone.DAO.LoginDB;
import com.Stone.connectToServer.packets.ToServerPacket;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 23.02.16.
 */
public class addNewPlayer extends ToServerPacket {
    LoginDB login;
    public addNewPlayer(LoginDB log) {
        login=log;
    }

    public int getId() {
        return 54;
    }

    public void send(ByteBuf buffer) {

        buffer.writeLong(login.getLolId());
        buffer.writeInt(login.getLolServer().getBytes().length);
        buffer.writeBytes(login.getLolServer().getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(login.getLolNick().getBytes().length);
        buffer.writeBytes(login.getLolNick().getBytes(Charset.forName("UTF-8")));
    }
}

package com.Stone.connectToServer.packets;

import com.Stone.connectToServer.packets.ToClient.LoginPacket;
import com.Stone.connectToServer.packets.ToClient.STSInfo;
import com.Stone.connectToServer.packets.ToClient.addGame;

/**
 * Created by Wed on 09.02.16.
 */
public class ToClientWorker {

    public static ToClientPacket parse(int id)
    {
        switch (id)
        {
            case 1:
                return new LoginPacket();
            case 11:
                return new addGame();
            case 13:
                return new STSInfo();
            default: return null;
        }
    }
}

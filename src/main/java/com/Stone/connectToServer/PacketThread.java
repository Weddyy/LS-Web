package com.Stone.connectToServer;


import com.Stone.connectToServer.packets.ToClient.STSInfo;
import com.Stone.connectToServer.packets.ToClient.addGame;
import com.Stone.connectToServer.packets.ToClientPacket;

/**
 * Created by Wed on 10.02.16.
 */
public class PacketThread extends Thread {

    private boolean isStart=true;

    public void Stop()
    {
        isStart=false;
    }

    @Override
    public void run()
    {
        ToClientPacket packet;
        while (isStart)
        {
            packet = Server.Initialize().getPacket();
            if(packet!=null)
            {
                if(packet instanceof addGame)
                {
                    addGame game=(addGame) packet;
                    Server._games.put(String.valueOf(game.game.getGameId())+"_"+game.game.getServerId(),game.game);
                }else if(packet instanceof STSInfo)
            {
                Server.STSStatus =((STSInfo) packet).rem;
            }
            }else
            try {
                Thread.sleep(50);
            }catch (InterruptedException e){}
        }
    }
}

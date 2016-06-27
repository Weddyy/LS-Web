package com.Stone.connectToServer;

import com.Stone.DAO.DAOUtils;
import com.Stone.connectToServer.packets.ToClientPacket;
import com.Stone.model.GamesModel.Game;
import com.Stone.model.GamesModel.Summoner;
import com.Stone.model.User;

/**
 * Created by Wed on 19.02.16.
 */
public class GamesThread extends Thread {

    private boolean isStart=true;

    public void Stop()
    {
        isStart=false;
    }

    @Override
    public void run()
    {
        DAOUtils.getInizialise().getAllPlayers();
        while (isStart)
        {
            User user;
            for(Game g : Server._games.values())
            {
                for(Summoner s : g.getSummoners())
                {
                    user = DAOUtils.getInizialise().findAddressByIDListOnly(s.getPlayerId(),g.getServerId());
                    if(user!=null)
                    {
                        if(!user._games.containsKey(g.getGameKey()))
                            user._games.put(g.getGameKey(),g);
                    }
                }
            }
            try {
                Thread.sleep(60000);
            }catch (InterruptedException e){}
        }
    }
}
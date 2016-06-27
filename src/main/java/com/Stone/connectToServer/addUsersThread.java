package com.Stone.connectToServer;

import com.Stone.DAO.LoginDB;
import com.Stone.connectToServer.packets.ToServer.addNewPlayer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Wed on 23.02.16.
 */
public class addUsersThread extends Thread {

    private boolean isStart=true;

    public void Stop()
    {
        isStart=false;
    }

    public static List<LoginDB> _logins=new CopyOnWriteArrayList<>();

    @Override
    public void run()
    {
        while (isStart)
        {
            if(_logins.size()!=0 && Server.Initialize().getChanel()!=null)
            {
                for(LoginDB log:_logins)
                {
                    Server.Initialize().getChanel().write(new addNewPlayer(log));
                    _logins.remove(log);
                }
                Server.Initialize().getChanel().flush();
            }else
                try {
                    Thread.sleep(30000);
                }catch (InterruptedException e){}
        }
    }
}
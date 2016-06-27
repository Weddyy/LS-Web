package com.Stone.connectToServer;

import com.Stone.connectToServer.packets.ToClientPacket;
import com.Stone.connectToServer.packets.ToServer.GiveGame;
import com.Stone.model.GamesModel.*;
import io.netty.channel.Channel;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Wed on 12.02.16.
 */
public class Server {
    private static Server thisServer;
    private PacketThread packetThread;
    public List<ToClientPacket> _packets= Collections.synchronizedList(new LinkedList<ToClientPacket>());
    static public Map<String,Game> _games=new ConcurrentHashMap<>();
    static public Map<Long,Champion> _champions;
    static public Map<Integer,Rune> _runes;
    static public Map<Integer,Massterys> _masterys;
    static public Map<Long,Spell> _spells=new ConcurrentHashMap<>();
    Channel chanel=null;
    public static int _lastId=0;
    public static boolean STSStatus=false;

    public static int getLastId() {
        return _lastId;
    }

    public static void setLastId(int lastId) {
        if(lastId>_lastId)
            _lastId = lastId;
    }

    public Server(Channel c)
    {
        thisServer =this;
        chanel=c;
        packetThread=new PacketThread();
        packetThread.start();
        c.writeAndFlush(new GiveGame(false,getLastId()+1));
    }

    public void addPacket(ToClientPacket packet)
    {
        _packets.add(packet);
    }

    public ToClientPacket getPacket()
    {
        ToClientPacket p=null;
        if (_packets.size() != 0) {
            p = _packets.get(0);
            _packets.remove(0);
        }
        return p;
    }

    public static Server Initialize()
    {
        return thisServer;
    }

    public Channel getChanel()
    {
        return chanel;
    }

    public void close()
    {
        packetThread.Stop();
        chanel=null;
        _packets.clear();
        thisServer=null;
        STSStatus=false;
    }

}

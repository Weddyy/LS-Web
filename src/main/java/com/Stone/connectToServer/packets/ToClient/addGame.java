package com.Stone.connectToServer.packets.ToClient;

import com.Stone.connectToServer.Server;
import com.Stone.connectToServer.packets.ToClientPacket;
import com.Stone.model.GamesModel.Game;
import com.Stone.model.GamesModel.Summoner;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 12.02.16.
 */
public class addGame extends ToClientPacket {

    public Game game;

    public void get(ByteBuf buffer) {
        game =new Game();
        game.setId(buffer.readInt());

        Server.setLastId(game.getId());

        game.setGameId(buffer.readLong());

        int countBytes=buffer.readInt();
        byte[] b=new byte[countBytes];
        buffer.readBytes(b);

        game.setServerId(new String(b, Charset.forName("UTF-8")));

        game.setDisable(buffer.readBoolean());

        if(game.isDisable())
            return;
        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        game.setCryptKey(new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        game.setGameMode(new String(b, Charset.forName("UTF-8")));

        countBytes=buffer.readInt();
        b=new byte[countBytes];
        buffer.readBytes(b);

        game.setGamteType(new String(b, Charset.forName("UTF-8")));

        game.setGameDate(buffer.readLong());
        game.setMapId(buffer.readLong());

        int countPlayers=buffer.readInt();

        for(int i=0;i<countPlayers;i++)
        {
            Summoner s =new Summoner();

            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);

            s.setName(new String(b, Charset.forName("UTF-8")));

            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);

            s.setRune(new String(b, Charset.forName("UTF-8")));

            countBytes=buffer.readInt();
            b=new byte[countBytes];
            buffer.readBytes(b);

            s.setMasstery(new String(b, Charset.forName("UTF-8")));

            s.setChampionId(buffer.readLong());
            s.setPlayerId(buffer.readLong());
            s.setSpell1(buffer.readLong());
            s.setSpell2(buffer.readLong());
            s.setTeadId(buffer.readLong());

            game.getSummoners().add(s);
        }

    }
}

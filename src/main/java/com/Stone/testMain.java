package com.Stone;

import com.Stone.model.GamesModel.Game;
import com.Stone.model.GamesModel.Summoner;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Wed on 31.01.16.
 */
public class testMain {
    public static void main(String[] s)
    {
        Map<String,Game> g=new ConcurrentHashMap();

        for(int i=0;i<1000;i++)
        {
            Game ga=new Game();
            ga.setServerId("123");
            for(int b=0;b<10;b++)
            {
                Summoner sa=new Summoner();
                sa.setPlayerId(123456);
                ga.getSummoners().add(sa);
            }

            g.put("a"+i,ga);
        }

        try {
            File theFile = new File("games.wed");
            if (theFile.exists())
                theFile.delete();
            FileOutputStream fout = new FileOutputStream("games.wed");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(g);
            oos.close();

        }catch (Exception e){e.printStackTrace();}

        g.clear();

        File theFile = new File("games.wed");
        if (!theFile.exists())
            return;
        try {
        FileInputStream fout = new FileInputStream("games.wed");
        ObjectInputStream oos1 = new ObjectInputStream(fout);

        Map<String ,Game> gas = (ConcurrentHashMap<String, Game>) oos1.readObject();
        for (Game ggr:gas.values()) {
            g.put(ggr.getGameKey(),ggr);
        }
        oos1.close();
    }catch (Exception e){e.printStackTrace();}
    }

}

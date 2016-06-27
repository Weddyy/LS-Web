package com.Stone;

import com.Stone.connectToServer.Server;
import com.Stone.model.GamesModel.Game;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Wed on 19.02.16.
 */
public class ClassSave {

    public static void save()
    {
        try {
            File theFile = new File("games.wed");
            if (theFile.exists())
                theFile.delete();
            FileOutputStream fout = new FileOutputStream("games.wed");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(Server._games);
            oos.close();

        }catch (Exception e){e.printStackTrace();}
    }

    public static void load()
    {
        File theFile = new File("games.wed");
        if (!theFile.exists())
            return;
        try {
            FileInputStream fout = new FileInputStream("games.wed");
            ObjectInputStream oos1 = new ObjectInputStream(fout);

            Server._games = (ConcurrentHashMap<String, Game>) oos1.readObject();
            oos1.close();
        }catch (Exception e){e.printStackTrace();}
    }

}

package com.Stone;

import com.Stone.API.MainClass;
import com.Stone.connectToServer.Client;
import com.Stone.connectToServer.GamesThread;
import com.Stone.connectToServer.Server;
import com.Stone.connectToServer.addUsersThread;

public class Main {

    public static void main()
    {

        Server._champions = MainClass.getChampions();
        Server._runes = MainClass.getRunes();
        Server._masterys = MainClass.getMast();
        new addUsersThread().start();
        new Client().start();
        new GamesThread().start();
    }
}

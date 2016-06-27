package com.Stone.model.GamesModel;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Wed on 19.02.16.
 */
public class Game implements Serializable {
    String serverId,cryptKey,gameMode,gamteType,gameKey,gameDate;
    long mapId,gameId;
    int Id;
    boolean disable=false;

    public boolean isDisable()
    {
        return disable;
    }

    public void setDisable(boolean dis)
    {
        disable=dis;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    List<Summoner> summoners=new ArrayList<>();

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
        gameKey=String.valueOf(gameId)+"_"+serverId;
    }

    public String getCryptKey() {
        return cryptKey;
    }

    public void setCryptKey(String cryptKey) {
        this.cryptKey = cryptKey;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGamteType() {
        return gamteType;
    }

    public void setGamteType(String gamteType) {
        this.gamteType = gamteType;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public List<Summoner> getSummoners() {
        return summoners;
    }

    public String getGameKey() {
        return gameKey;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(long time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        this.gameDate = df.format(new Date(time));
    }
}

package com.Stone.model;

import com.Stone.model.PlayerModel.Masteries;
import com.Stone.model.PlayerModel.Rune;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wed on 04.02.16.
 */
public class Player {
    boolean isBot;
    int spell1Id,spell2Id,profileIconId,championId,teamId,summonerId;
    String summonerName;
    List<Masteries> masteries=new ArrayList<>();
    List<Rune> rune=new ArrayList<>();

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public int getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(int spell1Id) {
        this.spell1Id = spell1Id;
    }

    public int getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(int spell2Id) {
        this.spell2Id = spell2Id;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(int summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public List<Masteries> getMasteries() {
        return masteries;
    }

    public List<Rune> getRune() {
        return rune;
    }
}

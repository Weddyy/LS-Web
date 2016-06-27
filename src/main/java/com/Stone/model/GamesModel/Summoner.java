package com.Stone.model.GamesModel;

import com.Stone.API.MainClass;
import com.Stone.connectToServer.Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wed on 19.02.16.
 */
public class Summoner implements Serializable {
    String name;
    long playerId,championId,teadId;
    Map<Rune,Integer> _rune=new HashMap<>();
    List<MasterySet> _mastery=new ArrayList<>();
    Spell spell1,spell2;

    public long getTeadId() {
        return teadId;
    }

    public void setTeadId(long teadId) {
        this.teadId = teadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRune(String rune) {
        String[] runes=rune.split(";");
        int id;
        for(String s:runes) {
            String[] parseRune = s.split(":");
            try{
                if (parseRune.length != 2)
                    continue;
                id = Integer.parseInt(parseRune[0]);
            if (!Server._runes.containsKey(id))
                continue;
            _rune.put(Server._runes.get(id),Integer.parseInt(parseRune[1]));

            }catch (Exception e){e.printStackTrace();}
        }
    }

    public void setMasstery(String masstery) {
        String[] runes=masstery.split(";");
        int id;
        for(String s:runes) {
            String[] parseRune = s.split(":");
            try{
                if (parseRune.length != 2)
                    continue;
                id = Integer.parseInt(parseRune[0]);
                if (!Server._masterys.containsKey(id))
                    continue;
                MasterySet set=new MasterySet();
                set.set_mast(Server._masterys.get(id));
                set.setCount(Integer.parseInt(parseRune[1]));
                _mastery.add(set);

            }catch (Exception e){e.printStackTrace();}
        }
    }

    public Map<Rune, Integer> get_rune() {
        return _rune;
    }

    public List<MasterySet> get_masterys() {
        return _mastery;
    }

    public Spell getSpell1() {
        return spell1;
    }

    public void setSpell1(long spell1) {
        this.spell1 = MainClass.getSpell(spell1);
    }

    public Spell getSpell2() {
        return spell2;
    }

    public void setSpell2(long spell2) {
        this.spell2 = MainClass.getSpell(spell2);
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }
}

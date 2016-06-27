package com.Stone.API;

import com.Stone.model.GamesModel.Champion;
import com.Stone.model.GamesModel.Massterys;
import com.Stone.model.GamesModel.Rune;
import com.Stone.model.GamesModel.Spell;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Wed on 04.02.16.
 */
public class JSONParser {

    public static long getCharID(String msg)
    {
        JSONObject obj = new JSONObject(msg);
        String name = (String) obj.keys().next();
        return obj.getJSONObject(name).getLong("id");
    }

    public static String getGameVersion(String msg)
    {
        return msg.split("\"")[1];
    }

    public static Map<Long,Champion> loadlAllChampions(String msg) {

        Map<Long,Champion> _map=new ConcurrentHashMap();

        JSONObject obj = new JSONObject(msg);
        JSONObject listBans=obj.getJSONObject("data");

        Iterator keys = listBans.keys();
            while (keys.hasNext()) {
                Champion c=new Champion();

                String name = (String) keys.next();
                c.setName(name);

                JSONObject cham=listBans.getJSONObject(name);
                c.setId(Long.parseLong(cham.getString("key")));
                JSONObject image=cham.getJSONObject("image");
                c.setImg(image.getString("full"));

                _map.put(c.getId(),c);

            }


        return _map;
    }

    public static Map<Integer,Rune> loadlAllRuns(String msg) {

        Map<Integer,Rune> _runes=new ConcurrentHashMap();

        JSONObject obj = new JSONObject(msg);
        JSONObject listBans=obj.getJSONObject("data");

        Iterator keys = listBans.keys();
        while (keys.hasNext()) {
            Rune c=new Rune();

            String name = (String) keys.next();

            JSONObject cham=listBans.getJSONObject(name);
            c.setId(cham.getInt("id"));
            c.setName(cham.getString("name"));
            c.setDesc(cham.getString("description"));
            JSONObject image=cham.getJSONObject("image");
            c.setImg(image.getString("full"));

            JSONObject r=cham.getJSONObject("rune");
            c.setTier(r.getString("tier"));

            _runes.put(c.getId(),c);

        }


        return _runes;
    }

    public static Map<Integer,Massterys> loadAllMastery(String msg) {

        Map<Integer,Massterys> _mastery=new ConcurrentHashMap();

        JSONObject obj = new JSONObject(msg);
        JSONObject listBans=obj.getJSONObject("data");

        Iterator keys = listBans.keys();
        while (keys.hasNext()) {
            Massterys c=new Massterys();

            String name = (String) keys.next();

            JSONObject cham=listBans.getJSONObject(name);
            c.setId(cham.getInt("id"));
            c.setName(cham.getString("name"));
            c.setDesc(cham.getJSONArray("description").get(0).toString());
            JSONObject image=cham.getJSONObject("image");
            c.setImg(image.getString("full"));
            c.setX(image.getInt("x"));
            c.setY(image.getInt("y"));
            c.setTree(cham.getString("masteryTree"));
            _mastery.put(c.getId(),c);
        }


        return _mastery;
    }

    public static Spell loadSpell(String msg) {

        Spell s=new Spell();

        JSONObject obj = new JSONObject(msg);
        s.setId(obj.getLong("id"));
        s.setName(obj.getString("name"));
        s.setDesc(obj.getString("description"));
        JSONObject image=obj.getJSONObject("image");
        s.setImg(image.getString("full"));

        return s;
    }

}

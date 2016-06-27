package com.Stone.API;

import com.Stone.connectToServer.Server;
import com.Stone.model.GameInfo;
import com.Stone.model.GamesModel.Champion;
import com.Stone.model.GamesModel.Massterys;
import com.Stone.model.GamesModel.Rune;
import com.Stone.model.GamesModel.Spell;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Wed on 03.02.16.
 */
public class MainClass {


    public static String lastGameVersion="";
    private static String API="NotForGit";

    public enum Server
    {
        NA1,RU,TR1,KR,BR1,LA1,LA2,EUN1,OC1,EUW1,PBE1,LOLKING
    }

    private static String getServerURL(Server ser,String url)
    {
        switch (ser)
        {
            case NA1:
                return url.replace("{[0]}","na").replace("{[1]}","NA1");
                
            case RU:
                return url.replace("{[0]}","ru").replace("{[1]}","RU");
            
            case TR1:
                return url.replace("{[0]}","tr").replace("{[1]}","TR1");
            
            case KR:
                return url.replace("{[0]}","kr").replace("{[1]}","KR");
            
            case BR1:
                return url.replace("{[0]}","br").replace("{[1]}","BR1");
            
            case LA1:
                return url.replace("{[0]}","lan").replace("{[1]}","LA1");
            
            case LA2:
                return url.replace("{[0]}","las").replace("{[1]}","LA2");
            
            case EUN1:
                return url.replace("{[0]}","eune").replace("{[1]}","EUN1");
            
            case OC1:
                return url.replace("{[0]}","oce").replace("{[1]}","OC1");
            
            case EUW1:
                return url.replace("{[0]}","euw").replace("{[1]}","EUW1");
            case LOLKING:
                return url.replace("{[0]}","replays.lolking.net").replace("{[1]}","RU");
            
            default:
                return "";
        }
    }

/*
* <option>NA</option>
                                <option>EUW</option>
                                <option>EUNE</option>
                                <option>KR</option>
                                <option>OCE</option>
                                <option>BR</option>
                                <option>LAN</option>
                                <option>LAS</option>
                                <option>RU</option>
                                <option>TR</option>
* */
    public static long getUserID(String nickName,String ser)
    {
        Server s;
        if(ser.equals("NA"))
            s=Server.NA1;
        else if(ser.equals("EUW"))
            s=Server.EUW1;
        else if(ser.equals("EUNE"))
            s=Server.EUN1;
        else if(ser.equals("OCE"))
            s=Server.OC1;
        else if(ser.equals("BR"))
            s=Server.BR1;
        else if(ser.equals("LAN"))
            s=Server.LA1;
        else if(ser.equals("LAS"))
            s=Server.LA2;
        else if(ser.equals("RU"))
            s=Server.RU;
        else if(ser.equals("TR"))
            s=Server.TR1;
        else return 0;

            try {
            nickName=nickName.replace(" ","");
            URL url = new URL(getServerURL(s,"https://{[0]}.api.pvp.net/api/lol/{[0]}/v1.4/summoner/by-name/"+nickName+"?api_key=") + API);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return 0L;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String tet = "";
            String output;
            while ((output = br.readLine()) != null) {
                tet += output;
            }

            conn.disconnect();

            return JSONParser.getCharID(tet);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return 0L;
    }

    public static String getVersionClient()
    {
        try {
            URL url = new URL("https://global.api.pvp.net/api/lol/static-data/na/v1.2/versions?api_key=" + API);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return "6.3.1";
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String tet = "";
            String output;
            while ((output = br.readLine()) != null) {
                tet += output;
            }

            conn.disconnect();

            return JSONParser.getGameVersion(tet);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "6.3.1";
    }

    public static Map<Long,Champion> getChampions()
    {
        try {
            lastGameVersion=getVersionClient();
            URL url = new URL("http://ddragon.leagueoflegends.com/cdn/"+lastGameVersion+"/data/en_US/champion.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String tet = "";
            String output;
            while ((output = br.readLine()) != null) {
                tet += output;
            }

            conn.disconnect();

            return JSONParser.loadlAllChampions(tet);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

    public static Map<Integer,Rune> getRunes()
    {
        try {
            lastGameVersion=getVersionClient();
            URL url = new URL("https://global.api.pvp.net/api/lol/static-data/ru/v1.2/rune?locale=en_US&version="+lastGameVersion+"&runeListData=image&api_key="+API);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String tet = "";
            String output;
            while ((output = br.readLine()) != null) {
                tet += output;
            }

            conn.disconnect();

            return JSONParser.loadlAllRuns(tet);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

    public static Map<Integer,Massterys> getMast()
    {
        try {
            lastGameVersion=getVersionClient();
            URL url = new URL("https://global.api.pvp.net/api/lol/static-data/ru/v1.2/mastery?locale=en_US&version="+lastGameVersion+"&masteryListData=all&api_key="+API);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String tet = "";
            String output;
            while ((output = br.readLine()) != null) {
                tet += output;
            }

            conn.disconnect();

            return JSONParser.loadAllMastery(tet);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

    public static Spell getSpell(long id)
    {
        if(com.Stone.connectToServer.Server._spells.containsKey(id))
            return com.Stone.connectToServer.Server._spells.get(id);

        try {
            URL url = new URL("https://global.api.pvp.net/api/lol/static-data/ru/v1.2/summoner-spell/"+id+"?locale=en_US&version="+lastGameVersion+"&spellData=image&api_key="+API);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String tet = "";
            String output;
            while ((output = br.readLine()) != null) {
                tet += output;
            }

            conn.disconnect();
            Spell s= JSONParser.loadSpell(tet);
            com.Stone.connectToServer.Server._spells.put(s.getId(),s);
            return s;

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }


}

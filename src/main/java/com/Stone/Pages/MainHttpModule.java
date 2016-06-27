package com.Stone.Pages;

import com.Stone.connectToServer.Server;
import com.Stone.model.GamesModel.Game;
import com.Stone.model.GamesModel.Summoner;
import com.Stone.model.JSModel.MainRequestForm;
import com.Stone.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Wed on 26.02.16.
 */
public class MainHttpModule extends WebHttpModule {

    public String getGameImg(Game g){
        return getGameImg(g,true);
    }

    public String getGameImg(Game g,boolean isNeedButton) {
        String m= "  <div class=\"col-sm-6 col-md-4\">" +
                "    <div class=\"login_wrapper\">" +
                "      <div id=\"img_see\">";
        String fTeam="";
        String sTeam="";

        for (Summoner sum:g.getSummoners())
        {
            if(sum.getTeadId()==100)
            {
                fTeam+="<div id=\"img_see_olol\" style=\"background-image: url(";
                fTeam+="http://ddragon.leagueoflegends.com/cdn/6.3.1/img/champion/"+ Server._champions.get(sum.getChampionId()).getImg();
                fTeam+="\"></div>";
            }else
            if(sum.getTeadId()==200)
            {
                sTeam+="<div id=\"img_see_olol\" style=\"background-image: url(http://ddragon.leagueoflegends.com/cdn/6.3.1/img/champion/";
                sTeam+=Server._champions.get(sum.getChampionId()).getImg();
                sTeam+="\"></div>";
            }
        }

        m+=fTeam+""+sTeam;
        m+="</div><div class=\"caption\">" +
            "<p><h1>" +
            "Date "+g.getGameDate()+"<br>" +
            "Game Mode "+g.getGameMode()+"<br>" +
            "Server "+g.getServerId()+"<br>" +
            "Game Type "+g.getGamteType()+"<br>" +
            "</h1></p>";
        if(isNeedButton)
            m+=       "        <p style=\"text-align: right;margin-right: 10px;\">" +
                "<a href=\"/see/"+g.getGameKey()+"\" class=\"btn button\" role=\"button\" onclick=\"return openPage('/see/"+g.getGameKey()+"','/see/"+g.getGameKey()+"/1');\">Open</a>" +
                "</p>";

        m+="</div></div></div>";

        return m;
    }

    public void reLoadLogin(MainRequestForm requestForm)
    {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        requestForm.setLogin((o instanceof User)?Login.LOGIN:Login.NO_LOGIN);
    }
}

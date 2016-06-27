package com.Stone.Pages;

import com.Stone.connectToServer.Server;
import com.Stone.model.GamesModel.*;
import com.Stone.model.JSModel.MainRequestForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Wed on 22.02.16.
 */
@Controller
public class see extends MainHttpModule{

    @ResponseBody
    @RequestMapping(value="/see/{gameKey}/1", method = RequestMethod.GET)
    public MainRequestForm getSeeGameJS (HttpServletRequest request, HttpServletResponse response, @PathVariable("gameKey") String platform) {
        MainRequestForm f=new MainRequestForm();
        reLoadLogin(f);
        f.setBody("Game not found");
        if(Server._games.containsKey(platform))
           {
               Game g=Server._games.get(platform);
               if(g!=null)
               {
                    String retValue=getGameImg(g,false).replace("col-sm-6 col-md-4","col-md-4 col-md-offset-4");

                   String blueTeam="";
                   String redTeam="";
                   int i=0;
                   for (Summoner sum:g.getSummoners())
                   {
                       if(sum.getTeadId()==100)
                       {
                           blueTeam+="<tr>"+tdChampion(sum)+tdName(sum)+tdSpell(sum)+tdRunes(sum,i)+tdMast(sum,i)+"</tr>";
                       }else
                       if(sum.getTeadId()==200)
                       {
                           redTeam+="<tr>"+tdChampion(sum)+tdName(sum)+tdSpell(sum)+tdRunes(sum,i)+tdMast(sum,i)+"</tr>";
                       }
                       i++;
                   }
                   retValue+="<div class=\"col-md-12\"><div class=\"row\">" +
                           "  <div class=\"col-md-8 col-md-offset-2 text-center\">";

                   retValue+="<table class=\"table table-bordered\"> " +
                           "    <thead> <tr class=\"info\"> <th></th> <th>Nick name</th> <th>Spells</th> <th>Rune</th> <th>Masterys</th> </tr> </thead>" +
                           "     <tbody>";

                   retValue+=blueTeam+"</tbody></table></div></div></div>";

                   retValue+="<div class=\"col-md-12\"><div class=\"row\">" +
                           "  <div class=\"col-md-8 col-md-offset-2 text-center\">";

                   retValue+="<table class=\"table table-bordered\"> " +
                           "    <thead> <tr class=\"danger\"> <th></th> <th>Nick name</th> <th>Spells</th> <th>Rune</th> <th>Masterys</th> </tr> </thead>" +
                           "     <tbody>";

                   retValue+=redTeam+"</tbody></table></div></div></div>";

                   f.setBody(retValue);
               }
           }

        return f;
    }

    private String tdName(Summoner sum)
    {
        return "<td class=\"col-md-2\" style=\"color:white\">"+sum.getName()+"</td> ";
    }

    private String tdChampion(Summoner sum)
    {
        String sTeam="<th scope=\"row\" class=\"col-md-1\"><div id=\"img_see_champ\" style=\"background-image: url(http://ddragon.leagueoflegends.com/cdn/6.3.1/img/champion/";
        sTeam+=Server._champions.get(sum.getChampionId()).getImg();
        sTeam+="\"></div></th>";

        return sTeam;
    }

    private String tdSpell(Summoner sum)
    {
        String sTeam="<td class=\"col-md-1\">";
        sTeam+="<div id=\"img_see_champ\" style=\"background-image: url(";
        sTeam+=sum.getSpell1().getImg();
        sTeam+=")\"></div>";

        sTeam+="<div id=\"img_see_champ\" style=\"background-image: url(";
        sTeam+=sum.getSpell2().getImg();
        sTeam+=")\"></div></td>";

        return sTeam;
    }

    private String tdRunes(Summoner sum,int i)
    {
        if(sum.get_rune().size()==0)
        {
            return "<td class=\"col-md-2\">No Runes</td>";
        }

        String rune="<td class=\"col-md-2\">" +
                "            <div class=\"accordion-group\">" +
                "                    <div class=\"accordion-heading\">" +
                "                      <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#collapseRune"+i+"\">" +
                "                        Runes" +
                "                      </a>" +
                "                    </div>" +
                "                    <div id=\"collapseRune"+i+"\" class=\"accordion-body collapse\">" +
                "                      <div class=\"accordion-inner\"><div class=\"row\">";

        for (Map.Entry<Rune,Integer> entry : sum.get_rune().entrySet())
        {
            Rune key = entry.getKey();
            Integer count = entry.getValue();

            rune+="<div class=\"mast_table\" style=\"color:white;\"><div id=\"img_runes\" data-placement=\"top\" data-original-title=\"Hello\" style=\"background-image: url(" +
                    key.getImg() +
                    ")\"  data-toggle=\"tooltip\" data-placement=\"top\" title=\""+key.getDesc()+"\"" +
                    " ></div>  x"+count+"</div>";

        }

        rune+="</div></div></div></td>";
        return rune;
    }

    private String tdMast(Summoner sum,int i)
    {

        if(sum.get_masterys().size()==0)
        {
            return "<td class=\"col-md-2\">No Mastery</td>";
        }

        String rune="<td class=\"col-md-2\">" +
                "            <div class=\"accordion-group\">" +
                "                    <div class=\"accordion-heading\">" +
                "                      <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#collapseMaster"+i+"\">" +
                "                        Masterys" +
                "                      </a>" +
                "                    </div>" +
                "                    <div id=\"collapseMaster"+i+"\" class=\"accordion-body collapse\">" +
                "                      <div class=\"accordion-inner\"><div class=\"row\">";

        for (MasterySet mast : sum.get_masterys())
        {
            rune+="<div class=\"mast_table\" ";
            if(mast.get_mast().getTree().equals("Ferocity"))
                rune+="style=\"background : #DE8888;\"";
            else if(mast.get_mast().getTree().equals("Cunning"))
                rune+="style=\"background : #D29CDE;\"";
            else if(mast.get_mast().getTree().equals("Resolve"))
                rune+="style=\"background : #9CC1DE;\"";
            rune+="><div id=\"img_runes\" data-placement=\"top\" data-original-title=\"Hello\" style=\"background-image: url(" +
                    mast.get_mast().getImg() +")"+
                    "\"  data-toggle=\"tooltip\" data-placement=\"top\" title=\""+mast.get_mast().getDesc()+"\"" +
                    " ></div>                    x"+mast.getCount()+"</div>";

        }

        rune+="</div></div></div></td>";
        return rune;
    }

    @RequestMapping(value="/see/{gameKey}", method = RequestMethod.GET)
    public String getSeeGame (HttpServletRequest request, HttpServletResponse response, @PathVariable("gameKey") String platform) {
        response.setContentType("text/html");
        request.setAttribute("textBody",getSeeGameJS(request,response,platform).getBody());
        return "/page/index.jsp";
    }
}

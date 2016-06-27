package com.Stone.Pages;

import com.Stone.DAO.DAOUtils;
import com.Stone.connectToServer.Server;
import com.Stone.model.GamesModel.Game;
import com.Stone.model.GamesModel.Summoner;
import com.Stone.model.JSModel.MainRequestForm;
import com.Stone.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wed on 23.02.16.
 */
@Controller
public class myGame extends MainHttpModule{

    @ResponseBody
    @RequestMapping(value="/myGames/1", method = RequestMethod.GET)
    public MainRequestForm downloadFileSpeackJS(HttpServletRequest request, HttpServletResponse response) throws IOException {

        MainRequestForm f=new MainRequestForm();
        reLoadLogin(f);
        String games="";
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (o instanceof User){
            User u = (User)o;

            request.setAttribute("user",u.getUsername());
            for(Game g:u._games.values())
            {
                games+= getGameImg(g);
            }
        }

        f.setBody(games);
        return f;
    }

    @RequestMapping(value="/myGames", method = RequestMethod.GET)
    public String downloadFileSpeack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setAttribute("textBody",downloadFileSpeackJS(request,response).getBody());
        return "/page/index.jsp";
    }
}

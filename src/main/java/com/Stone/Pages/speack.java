package com.Stone.Pages;

import com.Stone.connectToServer.Server;
import com.Stone.model.GamesModel.Game;
import com.Stone.model.GamesModel.Summoner;
import com.Stone.model.JSModel.MainRequestForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Wed on 02.02.16.
 */
@Controller
public class speack extends MainHttpModule {


    @ResponseBody
    @RequestMapping(value="/speak/1", method = RequestMethod.GET)
    public MainRequestForm downloadFileSpeackJS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MainRequestForm f=new MainRequestForm();
        String games="";
        for(Game g : Server._games.values())
            games+= getGameImg(g);

        f.setBody(games);
        reLoadLogin(f);
        return f;
    }

    @RequestMapping(value="/speak", method = RequestMethod.GET)
    public String downloadFileSpeack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setAttribute("textBody",downloadFileSpeackJS(request,response).getBody());
        return "/page/index.jsp";
    }

}
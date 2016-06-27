package com.Stone.Pages;

import com.Stone.Util.StringModule;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wed on 03.02.16.
 */
@WebServlet("/langPage")
public class LangPage extends WebHttpModule {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getParameter("lng")!=null)
            try {
                setLng(response, StringModule.Lng.valueOf(request.getParameter("lng")));
            }catch (Exception e)
            {

            }
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }
}
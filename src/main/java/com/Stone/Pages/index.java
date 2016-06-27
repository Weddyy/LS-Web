package com.Stone.Pages;

import com.Stone.Util.StringModule;
import com.Stone.model.JSModel.MainRequestForm;
import com.Stone.model.JSModel.testModel;
import com.Stone.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Wed on 02.02.16.
 */
@Controller
public class index extends MainHttpModule {

    final String page="/page/index.jsp";


    @ResponseBody
    @RequestMapping(value="/index/1", method = RequestMethod.GET)
    public MainRequestForm downloadFileIndexJS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MainRequestForm t=new MainRequestForm();
        t.setBody("hello");
        reLoadLogin(t);
        return t;
    }

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String downloadFileIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringModule.Lng l=checkLangGet(response,request);
        if(l == StringModule.Lng.None)
            l=getLng(response,request);

        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (o instanceof User)
            request.setAttribute("user",((User)o).getUsername());

        response.setContentType("text/html");
        request.setAttribute("textBody","No JS");
        request.setAttribute("pathc","");

        return page;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String downloadFileIndexx(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return downloadFileIndex(request,response);
    }
}

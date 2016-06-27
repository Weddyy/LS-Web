package com.Stone.Pages;

import com.Stone.Util.StringModule;
import com.Stone.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Wed on 03.02.16.
 */
public class WebHttpModule extends HttpServlet {

    protected String getNickName() {

        //Authentication a =SecurityContextHolder.getContext().getAuthentication();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal.equals("anonymousUser"))
            return null;
        if (principal instanceof User)
            return ((User) principal).getUsername();

        return principal.toString();
    }

    private String  getIP()
    {

        if(SecurityContextHolder.getContext().getAuthentication().getDetails() instanceof WebAuthenticationDetails)
            return ((WebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();
        return "unknown";
    }

    public void setLng(HttpServletResponse response, StringModule.Lng lng)
    {
        Cookie k=new Cookie("lng",lng.toString());
        k.setMaxAge(34560000);//400 days
        response.addCookie(k);
    }

    public StringModule.Lng getLng(HttpServletResponse response,HttpServletRequest request)
    {
        if(request.getCookies()!=null)
        for(Cookie kooie:request.getCookies())
        {
            if(kooie.getName().equals("lng"))
                try {
                    return StringModule.Lng.valueOf(kooie.getValue());
                }catch (Exception e)
                {
                    break;
                }
        }
        setLng(response, StringModule.Lng.En);
        return StringModule.Lng.En;
    }

    public StringModule.Lng checkLangGet(HttpServletResponse response,HttpServletRequest request)
    {
        if(request.getParameter("lng")!=null)
        try {
            StringModule.Lng g=StringModule.Lng.valueOf(request.getParameter("lng"));
            setLng(response, g);
            return g;
        }catch (Exception e)
        {
            return StringModule.Lng.None;
        }
        return StringModule.Lng.None;
    }

}

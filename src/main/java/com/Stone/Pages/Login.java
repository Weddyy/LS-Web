package com.Stone.Pages;

import com.Stone.model.FormModel.LoginModel;
import com.Stone.model.User;
import com.Stone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Wed on 03.02.16.
 */
@Controller
public class Login {

    @Autowired
    AuthenticationManager authenticationManager;

    public static final String LOGIN="<div class=\"nickName\">${user}</div>" +
            "<a class=\"btn_Games\"  href=\"/myGames\" onclick=\"return openPage('/myGames','/myGames/1');\"><span class=\"glyphicon glyphicon-play-circle\" style=\"margin-right:4px\"></span>Your games</a>" +
            "<a class=\"btn_Config\" href=\"/config\" onclick=\"return openPage('/config','/config/1');\"><span class=\"glyphicon glyphicon-cog\" style=\"margin-right:4px\"></span>Config</a>" +
            "<a class=\"btn_Logout\" href=\"/logout\"><span class=\"glyphicon glyphicon-log-out\" style=\"margin-right:4px\"></span>Logout</a>";

    public static final String NO_LOGIN="<a class=\"btn_Registr\" data-toggle=\"modal\" data-target=\"#regModal\"><span class=\"glyphicon glyphicon-new-window\" style=\"margin-right:4px\"></span>Registration</a>" +
            "<a class=\"btn_Login\" data-toggle=\"modal\" data-target=\"#loginModal\"><span class=\"glyphicon glyphicon-log-in\" style=\"margin-right:4px\"></span>Login</a>";


    @RequestMapping(value="/login", method=RequestMethod.GET)
    public @ResponseBody
    String loginGet(LoginModel model)throws Exception {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(model.getEmail(), model.getPassword());
        User details;
        try {
            details = new UserService().loadUserByUsername(model.getEmail());
        }catch (Exception e)
        {
            return "0";
        }
        if(details==null || !details.getPassword().equals(model.getPassword()))
        return "0";
        token.setDetails(details);

        try {
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "1";
        } catch (BadCredentialsException e) {
            return "0";
        }
    }

}
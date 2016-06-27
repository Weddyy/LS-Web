package com.Stone.Pages;

import com.Stone.API.MainClass;
import com.Stone.DAO.DAOUtils;
import com.Stone.connectToServer.addUsersThread;
import com.Stone.model.FormModel.LoginModel;
import com.Stone.model.FormModel.RegModel;
import com.Stone.model.User;
import com.Stone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by Wed on 18.02.16.
 */
@Controller
public class Reg {

    @Autowired
    AuthenticationManager authenticationManager;




    @RequestMapping(value="/reg", method= RequestMethod.GET)
    public @ResponseBody
    String loginGet(RegModel model)throws Exception {

        if(!model.getPassword().equals(model.getRepassword()))
            return "-2";
        if(model.getPassword().length()<6)
            return "-1";

        if(DAOUtils.getInizialise().isEmailReg(model.getEmail()))
            return "-4";

        long userId= MainClass.getUserID(model.getNick().replace(" ",""),model.getServerId());
        if(userId==0)
            return "-3";

        DAOUtils.getInizialise().RegUser(model.getEmail(),model.getPassword(),model.getNick(),model.getServerId(),userId);

        return "1";
    }
}

package com.Stone.service;

import com.Stone.DAO.DAOUtils;
import com.Stone.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    //@Autowired
    //private UserDao userDao;

    @Override
    public User loadUserByUsername(final String username){
        return DAOUtils.getInizialise().findAddressByEmail(username);
    }
}
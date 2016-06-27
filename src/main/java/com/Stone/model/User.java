package com.Stone.model;

import com.Stone.DAO.LoginDB;
import com.Stone.model.GamesModel.Game;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Wed on 31.01.16.
 */
public class User  implements UserDetails {
    private static final long serialVersionUID = 1L;

    LoginDB _login;
    /* Spring Security fields*/
    private List<Role> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    private long timeLastRequest=0;
    public Map<String,Game> _games=new ConcurrentHashMap<>();


    public User(LoginDB log)
    {
        _login=log;
    }

    public void Refresh()
    {
        if((System.currentTimeMillis() - timeLastRequest)>180000)// 3 min
        {

        }
    }

    @Override
    public String getUsername() {
        return _login.getNick();
    }


    @Override
    public String getPassword() {
        return _login.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return _login.toString();
    }
}
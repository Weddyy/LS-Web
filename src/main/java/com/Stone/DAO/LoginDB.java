package com.Stone.DAO;

import javax.persistence.*;

/**
 * Created by Wed on 29.01.16.
 */
@Entity
@Table(name = "login", schema = "Lol", catalog = "")
public class LoginDB {
    private long id;
    private String nick;
    private String password;
    private String mail;
    private int accessLevel;
    private String lastIp;
    private int premium;
    private String lolNick;
    private Long lolId;
    private String lolServer;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false )
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nick", nullable = true, length = 32)
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mail", nullable = true, length = 255)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "access_level", nullable = false)
    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Basic
    @Column(name = "last_ip", nullable = true, length = 15)
    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Basic
    @Column(name = "premium", nullable = false)
    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    @Basic
    @Column(name = "lol_nick", nullable = true, length = 50)
    public String getLolNick() {
        return lolNick;
    }

    public void setLolNick(String lolNick) {
        this.lolNick = lolNick;
    }

    @Basic
    @Column(name = "lol_id", nullable = true)
    public Long getLolId() {
        return lolId;
    }

    public void setLolId(Long lolId) {
        this.lolId = lolId;
    }

    @Basic
    @Column(name = "lol_server", nullable = true, length = 255)
    public String getLolServer() {
        return lolServer;
    }

    public void setLolServer(String lolServer) {
        this.lolServer = lolServer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginDB loginDB = (LoginDB) o;

        if (id != loginDB.id) return false;
        if (accessLevel != loginDB.accessLevel) return false;
        if (premium != loginDB.premium) return false;
        if (nick != null ? !nick.equals(loginDB.nick) : loginDB.nick != null) return false;
        if (password != null ? !password.equals(loginDB.password) : loginDB.password != null) return false;
        if (mail != null ? !mail.equals(loginDB.mail) : loginDB.mail != null) return false;
        if (lastIp != null ? !lastIp.equals(loginDB.lastIp) : loginDB.lastIp != null) return false;
        if (lolNick != null ? !lolNick.equals(loginDB.lolNick) : loginDB.lolNick != null) return false;
        if (lolId != null ? !lolId.equals(loginDB.lolId) : loginDB.lolId != null) return false;
        if (lolServer != null ? !lolServer.equals(loginDB.lolServer) : loginDB.lolServer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + accessLevel;
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + premium;
        result = 31 * result + (lolNick != null ? lolNick.hashCode() : 0);
        result = 31 * result + (lolId != null ? lolId.hashCode() : 0);
        result = 31 * result + (lolServer != null ? lolServer.hashCode() : 0);
        return result;
    }
}

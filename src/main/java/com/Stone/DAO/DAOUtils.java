package com.Stone.DAO;

import com.Stone.connectToServer.addUsersThread;
import com.Stone.model.Role;
import com.Stone.model.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Wed on 19.02.16.
 */
public class DAOUtils {

    private static Map<String ,User> _mapKeyID=new ConcurrentHashMap();
    private static Map<String ,User> _mapKeyEmail=new ConcurrentHashMap();
    private static DAOUtils dao=new DAOUtils();

    public boolean isEmailReg(String email)
    {
        return findAddressByEmail(email)!=null;
    }


    public static DAOUtils getInizialise()
    {
        return dao;
    }

    private static void loadRole(User s)
    {
        Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        s.setAuthorities(roles);
    }

    public User findAddressByEmail(String email) {
        if(_mapKeyEmail.containsKey(email))
            return _mapKeyEmail.get(email);

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from LoginDB a where a.mail = :id");
        query.setParameter("id", email);
        LoginDB l= (LoginDB) query.uniqueResult() ;
        session.close();
        if(l==null)
            return null;

        User s=new User(l);
        loadRole(s);
        _mapKeyID.put(String.valueOf(l.getLolId())+"_"+l.getLolServer(),s);
        _mapKeyEmail.put(l.getMail(),s);

        return s;
    }

    public User findAddressByIDListOnly(long summonerId,String serverId)
    {
        if(_mapKeyID.containsKey(String.valueOf(summonerId)+"_"+serverId))
            return _mapKeyID.get(String.valueOf(summonerId)+"_"+serverId);
        return null;
    }

    public User findAddressByID(long summonerId,String serverId) {
        if(_mapKeyID.containsKey(String.valueOf(summonerId)+"_"+serverId))
            return _mapKeyID.get(String.valueOf(summonerId)+"_"+serverId);

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from LoginDB a where a.lolId = :id AND a.lolServer = :serverId");
        query.setParameter("id", summonerId);
        query.setParameter("serverId", serverId);
        LoginDB l= (LoginDB) query.uniqueResult() ;
        session.close();
        if(l==null)
            return null;

        User s=new User(l);
        loadRole(s);

        _mapKeyID.put(String.valueOf(l.getLolId())+"_"+l.getLolServer(),s);
        _mapKeyEmail.put(l.getMail(),s);

        return s;
    }

    public void RegUser(String email,String password,String lolNickName,String lolServer,long userId)
    {
        LoginDB newLogin=new LoginDB();
        newLogin.setLolId(userId);
        newLogin.setPassword(password);
        newLogin.setMail(email);
        newLogin.setLolNick(lolNickName);
        newLogin.setLolServer(lolServer);

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(newLogin);
            session.getTransaction().commit();
            User s=new User(newLogin);
            loadRole(s);

            _mapKeyID.put(String.valueOf(newLogin.getLolId())+"_"+newLogin.getLolServer(),s);
            _mapKeyEmail.put(newLogin.getMail(),s);
            addUsersThread._logins.add(newLogin);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<LoginDB> getAllPlayers()
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createCriteria(LoginDB.class);
            Query q = session.createQuery("From LoginDB");
            List<LoginDB> list=q.list();
            for(LoginDB p:list)
            {
                User s=new User(p);
                loadRole(s);

                _mapKeyID.put(String.valueOf(p.getLolId())+"_"+p.getLolServer(),s);
                _mapKeyEmail.put(p.getMail(),s);
            }
            return q.list();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

}

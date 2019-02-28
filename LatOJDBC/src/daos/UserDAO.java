/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.BCrypt;

/**
 *
 * @author Panji Sadewo
 */
public class UserDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public UserDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public UserDAO() {
        
    }    
    
    public boolean saveOrDelete(User user, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(user);
            } else {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }        
        return true;
    }
    
    public List<User> getData(Object keyword, boolean isGetData) {
        List<User> users = new ArrayList<User>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isGetData) {
                users = session.createQuery("FROM Users where USERNAMEUSERNAME = "+keyword).list();
            }else{
                users = session.createQuery("SELECT * FROM USERS WHERE USERNAME like '%" + keyword +
                    "%' or PASSWORD like '%" + keyword + "%'").list();
            }
            
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return users;
    }
    
    public List<User> login(Object keyword) {
        List<User> users = new ArrayList<User>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            users = session.createQuery("SELECT * FROM USERS WHERE USERNAME = "+keyword).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return users;
    }
}

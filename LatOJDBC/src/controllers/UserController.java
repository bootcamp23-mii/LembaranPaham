/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import java.sql.Connection;
import java.util.List;
import models.User;
import org.hibernate.SessionFactory;
import tools.BCrypt;

/**
 *
 * @author Panji Sadewo
 */
public class UserController {
    
    private UserDAO udao;

    public UserController(SessionFactory sessionFactory) {
        udao = new UserDAO(sessionFactory);
    }
    
    public boolean login(String username, String password){
        List<User> list = udao.login(username);
        if (!list.isEmpty()) 
            for (User user : list) 
                if (BCrypt.checkpw(password, user.getPassword())) 
                    return true;
        return false;
    }
    
    public List<User> getById(String key) {
        List result;
        result = udao.getData(key, true);
        return result;
    }
    
    public List<User> getData(String key) {
        List result;
        result = udao.getData("", false);
        return result;
    }
    
    public String register(String username, String password){
        String result = "";
        String passhash = BCrypt.hashpw(password, BCrypt.gensalt());
        if (udao.saveOrDelete(new User(username, passhash), true)){
            result = "Registrasi Berhasil";            
        }else{
            result = "Maaf registrasi gagal";
        }
        return result;
    }
    
}

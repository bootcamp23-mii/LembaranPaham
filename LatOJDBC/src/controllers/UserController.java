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
import tools.BCrypt;

/**
 *
 * @author FES
 */
public class UserController {
    private Connection connection;
    private UserDAO udao;

    public UserController(Connection connection) {
        udao = new UserDAO(connection);
    }
    
    public boolean login(String username, String password){
        List<User> list = udao.login(new User(username, password));
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
    
    
//    public String insert(String id, String nama) {
//        String result = "";
//        if (rdao.save(new Region(Integer.parseInt(id), nama), true)){
//            result = "Data berhasil disimpan";            
//        }else{
//            result = "Maaf data gagal disimpan";
//        }
//        return result;
//    }
    
    public String register(String username, String password){
        String result = "";
        if (udao.save(new User(username, password), true)){
            result = "Registrasi Berhasil";            
        }else{
            result = "Maaf registrasi gagal";
        }
        return result;
    }
    
}

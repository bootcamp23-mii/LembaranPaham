/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Country;
import org.hibernate.SessionFactory;

/**
 *
 * @author gerydanu
 */
public class CountryController {
    
    private CountryDAO cdao;

    public CountryController(SessionFactory sessionFactory) {
        cdao=new CountryDAO(sessionFactory);
    }
    
    
     public String insert(String id, String name){
        if (cdao.saveOrDelete(new Country(id), true)) {
             return "Selamat Data Berhasil di Input";
        }
         return "Maaf Anda Gagal memasukkan data";
    }
    
    public String delete(String id){
        if (cdao.saveOrDelete(new Country(id), false)) {
             return "Selamat Berhasil menghapus data";
        }
         return "Maaf Anda Gagal menghapus data";
  
        
    }
    
    public String update(String id, String name){
        if (cdao.saveOrDelete(new Country(new String(id),name), true)) {
             return "Selamat Data Berhasil di Update";
        }
         return "Maaf Anda Gagal melakukan update";

        
    }
    
    public List<Country> select(){
        return cdao.getAll();
        
    }
    public List<Country> searchBy(String key){
        return cdao.searchBy(key);
        
    }
    
    public Country getById(String key){
        return cdao.getById(new BigDecimal(key));
        
    }
}

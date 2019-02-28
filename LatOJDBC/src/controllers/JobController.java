/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lusiana
 */
public class JobController {

     private JobDAO jdao;

    public JobController(SessionFactory sessionFactory) {
        jdao = new JobDAO(sessionFactory);
    }
    
    public String insert(String id, String title, String minSalary, String maxSalary){
        if (jdao.saveOrDelete (new Job(id,title, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)),true)) {
             return " Selamat data berhasil disimpan";
        }
         return "Maaf coba lagi";
    }
    
    public String delete(String id){
         if (jdao.saveOrDelete(new Job(id), false)) {
            return "Selamat berhasil dihapus";
        }
        return "Maaf coba lagi";        
    }
    
    public String update(String id, String title, String minSalary, String maxSalary){
        if (jdao.saveOrDelete(new Job(id, title, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)),true)) {
            return "Selamat data berhasil disimpan";
        }
        return "Maaf coba lagi";
    }
    
    public List<Job> selectAll(){
        return jdao.getData("");
    }
    
    public List<Job> search(String id){
        return jdao.getData(id);
    }
    
    public Job getById(String id){
        return jdao.getById(id);
    }
    
}

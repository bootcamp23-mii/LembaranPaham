/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import java.util.List;
import models.Department;
import models.Employee;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class DepartmentController {

    private DepartmentDAO ddao;

    public DepartmentController(SessionFactory sessionFactory) {
        ddao = new DepartmentDAO(sessionFactory);
    }


    public String insert(String id, String name, String manager, String location){
        if (ddao.saveordelete(new Department(new Short(id), name, new Employee(new Integer(manager)), new Location(Short.valueOf(location))), true)) return "Insert berhasil.";
        else return "FAIL TO INSERT RECORD";
    }
    
    public String update(String id, String name, String manager, String location){
        if (ddao.saveordelete(new Department(new Short(id), name, new Employee(new Integer(manager)), new Location(Short.valueOf(location))), true)) return "Insert berhasil.";
        else return "UPDATE FAILED";
    }
    
    public String delete(String id){
        if (ddao.saveordelete(new Department(new Short(id)), false)) return "RECORD SUCCESSFULLY DELETED";
        else return "DELETE FAILED";
    }
    
    public Department getById(String key) {
        return ddao.getId(new Integer(key));
    }

    public List<Department> seachBy(String key) {
        return ddao.getAll(key);
    }
    
     public List<Department> getAll() {
        return ddao.getAll("");
    }
}

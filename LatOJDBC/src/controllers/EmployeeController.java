/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Panji Sadewo
 */
public class EmployeeController {
    
    private EmployeeDAO edao;

    public EmployeeController() {
    }
    
    public EmployeeController(SessionFactory factory) {
        edao = new EmployeeDAO(factory);
    }
    
    public String insert(String id, String firstName, String lastName, String email, String phoneNumber, String hireDate, String job, String salary, String commissionPct, String manager, String department){
        if (edao.saveOrDelete(new Employee(new Integer(id), firstName, lastName, email, phoneNumber, new Date(hireDate), new Job(job), new BigDecimal(salary), new BigDecimal(commissionPct), new Employee(new Integer(manager)), new Department(new Short(department))), true)) return "Insert berhasil.";
        else return "Insert gagal";
    }
    
    public String update(String id, String firstName, String lastName, String email, String phoneNumber, String hireDate, String job, String salary, String commissionPct, String manager, String department){
        if (edao.saveOrDelete(new Employee(new Integer(id), firstName, lastName, email, phoneNumber, new Date(hireDate), new Job(job), new BigDecimal(salary), new BigDecimal(commissionPct), new Employee(new Integer(manager)), new Department(new Short(department))), true)) return "Update berhasil.";
        else return "Update gagal";
    }
    public String delete(String id){
        if (edao.saveOrDelete(new Employee(new Integer(id)), false)) return "Insert berhasil.";
        else return "Insert gagal";
    }
    
    public List<Employee> getAll(){
        return edao.Search("");
    }
    
    public List<Employee> getData(Object key){
        return edao.Search(key);
    }
    
    public Employee getById(Object key){
        return edao.SearchById(key);
    }
    
}

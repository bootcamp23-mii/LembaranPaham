/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import daos.EmployeeDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author FES
 */
public class EmpBattlefield {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        EmployeeDAO edao = new EmployeeDAO(sessionFactory);
        EmployeeController ec = new EmployeeController(sessionFactory);
//        List<Employee> list = ec.getAll();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getManager());
//        }
//        for (Object object : list.get(0).getDepartmentList()) {
//            System.out.println(object);
//        }
//        for (Employee employee : list) {
//            for (Department department : employee.getDepartmentList()) {
//                System.out.println(department.getId()+department.getName());
//            }
//        }
//        List<Job> jobList = new ArrayList<Job>();
//        for (Employee employee : list) {
//            if (!jobList.contains(employee.getJob()))jobList.add(new Job(employee.getJob().getId(), employee.getJob().getTitle()));
//        }
//        for (Job job : jobList) {
//            System.out.println(job.getId()+job.getTitle());
//            System.out.println(job);
//        }
//        System.out.println("=========================");
//        for (Employee employee : list) {
////            System.out.println(employee.getJob().getId()+employee.getJob().getTitle());
//            System.out.println(employee.getJob());
//        }
        
//        for (Employee employee : ec.getAll()) {
//            for (Employee employee1 : employee.getEmployeeList()) {
//                System.out.println(employee1.getJob().getTitle());
//            }
//        }
//        for (Employee employee : ec.getAll()) {
//            System.out.println(employee.getHireDate().toString());
//        }
//        System.out.println(ec.delete("210"));
        System.out.println(ec.insert("210", "felix", "kaka", "sasa1sa", "321654", "2018-12-13", "SA_MAN", "5000", "0.2", "100", "10"));
//        System.out.println(ec.delete("210", "felix", "kaka", "sasa1sa", "321654", "2018-12-13", "SA_MAN", "5000", "0.2", "100", "10"));
    }
}

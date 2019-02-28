/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DepartmentController;
import daos.DepartmentDAO;
import daos.GeneralDAO;
import daos.GeneralDAO2;
import java.math.BigDecimal;
import models.Country;
import models.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pandu
 */
public class TestGeneral {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
        GeneralDAO gd = new GeneralDAO(sessionFactory);
        
//        gd.search(new Employee(), "a");

//        for (Object object : gd.getData(new Job(), "")) {
//            Job jobs = (Job) object;
//            System.out.println(jobs.getTitle());
//            
//        }
//          Country country = (Country) gd.getById(new Country(), "AR");
//          System.out.println(country.getName());
//          Region region = (Region) gd.getById(new Region(), "1");
//          System.out.println(region.getName());
          GeneralDAO2<Region> gregion= new GeneralDAO2<Region>(sessionFactory);
          for (Region region1 : gregion.getData("")) {
              System.out.println(region1.getName());
        }
    }
}

package tools;

import controllers.DepartmentController;
import controllers.EmployeeController;
import controllers.UserController;
import daos.CountryDAO;
import daos.DepartmentDAO;
import daos.RegionDAO;
import models.Country;
import models.Department;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author milhamafemi
 */
public class LatOJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        DBConnection connection = new DBConnection();
        //System.out.println(connection.getConnection());
//        DepartmentDAO ddao= new DepartmentDAO(connection.getConnection());
//        RegionDAO rdao = new RegionDAO(connection.getConnection());
//        UserController uc = new UserController(connection.getConnection());
        //dengan constructor
//        Region r= new Region();
        //tanpa constructor
//        Region r= new Region();
//        r.setId(5);
//        r.setName("Jauh seklai");
//        rdao.insert(r);
//        System.out.println(rdao.update(r));
//        for (Region region : rdao.getAll()) {
//            System.out.println("ID      : " + region.getId());
//            System.out.println("Name    : " + region.getName());
//        }
//   for (Region region : rdao.getData(20, true)) {
//            System.out.println("ID      : " + region.getId());
//            System.out.println("Name    : " + region.getName());
//        }
//        EmployeeController ec = new EmployeeController(connection.getConnection());
//        System.out.println(ec.delete("210"));
//        System.out.println(uc.login("admin", "admin"));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        DepartmentDAO ddao = new DepartmentDAO(sessionFactory);
        DepartmentController dc = new DepartmentController(sessionFactory);
        
        
        
//        System.out.println(dc.getAll());
        for (Department department : ddao.getAll("")) {
            System.out.println(department.getName());
            
        }
//        System.out.println(sessionFactory);
//        CountryDAO cdao= new CountryDAO(sessionFactory);
//        for (Country country : cdao.getAll()) {
//            System.out.println(country.getName());
//        }

    }
}

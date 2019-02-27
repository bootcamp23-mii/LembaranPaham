/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Controllers.RegionController;
import Models.Country;
import Models.Location;
import Models.Region;
import daos.RegionDAO;
import java.math.BigDecimal;
import org.hibernate.SessionFactory;

/**
 *
 * @author ACER
 */
public class LatORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println(sessionFactory);
        RegionDAO rdao = new RegionDAO(sessionFactory);
        RegionController rc = new RegionController(sessionFactory);

//        for (Region region : rdao.getAll()) {
//            System.out.println(region.getName());
//            for (Country country : region.getCountryList()) {
//                System.out.println("->"+country.getName()+"("+country.getRegion().getName()+")");
//                for (Location location : country.getLocationList()) {
//                    System.out.println("-->"+location.getStreetAddress());
//                }
//            }
//        }
//         System.out.println(rdao.save(new Region(new BigDecimal(5), "Kota muda")));
//        for (Region region : rdao.getData("a")) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
//        System.out.println(rdao.getById(2).getName());
//          untuk manggil getById
//         for (Region region : rdao.getById(2)) {
//             System.out.println(region.getId());
//            System.out.println(region.getName());
//        }

//        System.out.println(rc.insert("7", "galang region"));
//        System.out.println(rc.update("7", "sekte"));
//        System.out.println(rc.delete("7"));
        for (Region region : rc.search("1")) {
            System.out.println(region.getId());
            System.out.println(region.getName());
        }
        for (Region region : rc.selectAll()) {
            System.out.println(region.getId());
            System.out.println(region.getName());
        }
        System.out.println(rc.getById("2").getName());
        

    }

}

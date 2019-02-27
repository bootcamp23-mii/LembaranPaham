/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import java.util.List;
import models.Country;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author AdhityaWP
 */
public class LocationController {
    private LocationDAO ldao;

    public LocationController(SessionFactory sessionFactory) {
        ldao = new LocationDAO(sessionFactory);
    }
    
    public String insert(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId){
        if(ldao.saveOrDelete(new Location(new Short(locationId),streetAddress,postalCode,city,stateProvince, new Country(countryId)), true)){
            return "Selamat insert berhasil";
        }else{
            return "Maaf coba lagi";
        }
    }
    
    public String update(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId){
        if(ldao.saveOrDelete(new Location(new Short(locationId),streetAddress,postalCode,city,stateProvince, new Country(countryId)), true)){
            return "Selamat update berhasil";
        }else{
            return "Maaf coba lagi";
        }
    }
    
   public String delete(String locationId, String city){
        if(ldao.saveOrDelete(new Location(new Short(locationId),city),false)){
            return "Terhapus";
        }else{
            return "Maaf coba lagi";
        }
    }
        
    public List<Location> getAll(){   
        return ldao.getData("");
    }
    
    public List<Location> searchBy(String key){   
        return ldao.getData(key);
    }
    public Location getById(String key){   
        return ldao.getById(key);
    }
}

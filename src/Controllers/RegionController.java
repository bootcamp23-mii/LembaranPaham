/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Region;
import daos.RegionDAO;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Panji Sadewo
 */
public class RegionController {
    
    private RegionDAO rdao;

    public RegionController(SessionFactory sessionFactory) {
        rdao = new RegionDAO(sessionFactory);
    }
    
    
    public String insert(String id, String name){
        if (rdao.saveOrDelete(new Region(new BigDecimal(id), name), true)) {
            return "Selamat insert berhasil";
        }
        return "Maaf coba lagi";
    }
    
    public String delete(String id){
         if (rdao.saveOrDelete(new Region(new BigDecimal(id)), false)) {
            return "Selamat update berhasil";
        }
        return "Maaf coba lagi";        
    }
    
    public String update(String id, String name){
        if (rdao.saveOrDelete(new Region(new BigDecimal(id), name), true)) {
            return "Selamat update berhasil";
        }
        return "Maaf coba lagi";
    }
    
    public List<Region> selectAll(){
        return rdao.getData("");
    }
    
    public List<Region> search(String id){
        return rdao.getData(id);
    }
    
    public Region getById(String id){
        return rdao.getById(new Integer(id));
    }
    
}

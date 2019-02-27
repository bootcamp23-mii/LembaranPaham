/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Location;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AdhityaWP
 */
public class LocationDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public LocationDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public LocationDAO() {
    }

    public List<Location> getAll() {
        List<Location> locations = new ArrayList<Location>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            locations = session.createQuery("FROM Location").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return locations;
    }
    
    public Location getById(Object key) {
        Location locations = new Location();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            locations = (Location) session.createQuery("FROM Location WHERE id = " +key).list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return locations;
    }

    public List<Location> searchBy(String key) {
        List<Location> locations = new ArrayList<Location>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            locations = session.createQuery("FROM Location WHERE id LIKE '%" + key 
                    + "%' OR STREET_ADDRESS LIKE '%" + key + "%' OR POSTAL_CODE LIKE '%"+key+"%' OR CITY LIKE '%"+key
                    + "%' OR STATE_PROVINCE LIKE '%" + key + "%' ORDER BY 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return locations;
    }
    
    public List<Location> getData(String key) {
        List<Location> locations = new ArrayList<Location>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            locations = session.createQuery("FROM Location WHERE id LIKE '%" + key 
                    + "%' OR STREET_ADDRESS LIKE '%" + key + "%' OR POSTAL_CODE LIKE '%"+key+"%' OR CITY LIKE '%"+key
                    + "%' OR STATE_PROVINCE LIKE '%" + key + "%' ORDER BY 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return locations;
    }
    
    public boolean insert(Location location){
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(location);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
    
    public boolean update(Location location){
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(location);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
    
    public boolean delete(Location location){
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(location);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }    
    
    public boolean save(Location location){
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(location);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
    
    public boolean saveOrDelete(Location location, boolean params){
        boolean result = false;
        boolean isSave = params;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if(isSave==true){
                session.saveOrUpdate(location);
            }else{
                session.delete(location);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }

}

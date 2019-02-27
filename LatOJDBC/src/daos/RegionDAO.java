/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Pandu
 */
public class RegionDAO {
    
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public RegionDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    public RegionDAO() {
        
    }
    
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            regions = session.createQuery("FROM Region").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        
        return regions;
    }
//    
//    public Region getByID(){
//        
//    }
    
    public List<Region> search(String keyword) {
        List<Region> regions = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            regions = session.createQuery("from Region where name like '%" + keyword + "%'").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        
        return regions;
        
    }
    
    public boolean saveordelete(Region reg, Boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(reg);
            } else {
                session.delete(reg);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
    
    public boolean delete(Region reg) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(reg);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
    
}

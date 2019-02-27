/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Models.Region;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ACER
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
    
    public List<Region> getData(Object keyword) {
        List<Region> regions = new ArrayList<Region>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            regions = session.createQuery("FROM Region where name like '%"+keyword+"%' or id like '%"+keyword+"%' order by 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return regions;
    }
    
    
    public boolean saveOrDelete(Region region, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(region);
            } else {
                session.delete(region);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }        
        return true;
    }
    
//    public boolean delete(Region region) {
//        boolean result = false;
//        session = this.factory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            session.delete(region);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }        
//        return true;
//    }
    
    public Region getById(int id) {
        Region region = new Region();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            region = (Region) session.createQuery("FROM Region where id = "+id).list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return region;
    }
}

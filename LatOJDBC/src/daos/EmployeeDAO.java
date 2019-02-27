/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FES
 */
public class EmployeeDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public EmployeeDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    public List<Region> getAll(){
        List<Region> regions = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            regions = session.createQuery("FROM Region order by id").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return regions;
    }
    
    public List<Region> Search(Object word){
        List<Region> regions = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            regions = session.createQuery("from Region where id like '%"+word+"%' or name like '%"+word+"%' order by id").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return regions;
    }
    
    public Region SearchById(Object word){
        Region regions = new Region();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            regions = (Region) session.createQuery("from Region where id = "+word+" order by id").list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return regions;
    }
    
    public boolean saveOrDelete(Region region, boolean isSave){
        boolean result = false;
        List<Region> regions = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) session.saveOrUpdate(region);
            else session.delete(region);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return result;
    }
    
}

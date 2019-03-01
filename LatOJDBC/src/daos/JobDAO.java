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
import models.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author Lusiana
 */
public class JobDAO {

   private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public JobDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public JobDAO() {
        
    }
    
    public List<Job> getData(Object keyword) {
        List<Job> jobs = new ArrayList<Job>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            jobs = session.createQuery("FROM Job where title like '%"+keyword+"%' or id like '%"+keyword+"%' order by 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return jobs;
    }
    
    
    public boolean saveOrDelete(Job job, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(job);
            } else {
                session.delete(job);
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
        return true;
    }
    
    public Job getById(String id) {
        Job r = new Job();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            r = (Job) session.createQuery("FROM Job where id = '"+id+"'").list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return r;
    }
}
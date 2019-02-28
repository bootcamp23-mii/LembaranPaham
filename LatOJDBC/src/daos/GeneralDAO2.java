/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
public class GeneralDAO2<T> {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private T t;

    public GeneralDAO2(SessionFactory factory) {
        this.factory = factory;
    }

    public GeneralDAO2() {

    }

    private String getQuery( String keyword) {
        String query = "From " + this.t;
        System.out.println(query);
        if (!keyword.equals("")) {
            query += " where ";
            for (Field field : t.getClass().getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
                    query += field.getName() + " like '%" + keyword + "%' OR ";
                }
            }
            query = query.substring(0, query.lastIndexOf("OR"));
        }
        return query + " order by 1";
    }

    public List<T> getData(String keyword) {
        List<T> obj = new ArrayList<>();
        System.out.println(obj.getClass().getTypeName());
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            obj = session.createQuery(getQuery(keyword)).list();
                getQuery(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

    public Object getById(Object ent, Object id) {
        Object obj = new Object();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            obj = session.createQuery("FROM " + ent.getClass().getSimpleName() + " WHERE id = '" + id + "'").uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return obj;
    }

    public boolean saveordelete(Object ent, Boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(ent);
            } else {
                session.delete(ent);
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

}

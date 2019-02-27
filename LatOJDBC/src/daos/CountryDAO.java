/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Country;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author gerydanu
 */
public class CountryDAO {

    private Session session;
    private SessionFactory factory;
    private Transaction transaction;

    public CountryDAO(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     *
     * @param keyword
     * @param isGetById
     * @return
     */
    public List<Country> getAll() {
        List<Country> country = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();

        try {
            country = session.createQuery("FROM Country").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return country;
    }

    public boolean saveOrUpdate(Country country) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(country);
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

    public boolean saveOrDelete(Country country, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.save(country);
            } else {
                session.delete(country);
            }

            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    public Country getById(Object id) {

        Country country = new Country();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            country = (Country) session.createQuery("FROM Country WHERE id = " + id + "order by 1").list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return country;
    }

    public List<Country> searchBy(Object key) {
        List<Country> listcountry = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            listcountry = session.createQuery("FROM Country WHERE id like '%"
                    + key + "%' or name like '%" + key + "%' or region like '%" + key + "%' order by 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return listcountry;

    }

}

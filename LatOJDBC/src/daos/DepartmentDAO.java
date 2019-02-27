/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Department;

import java.util.ArrayList;
import java.util.List;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author milhamafemi
 */
public class DepartmentDAO {

    private Connection connection;
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Department> getAll() {
        List<Department> department = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            department = session.createQuery("FROM Region").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return department;
    }

    public boolean saveordelete(Department dept, Boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(dept);
            } else {
                session.delete(dept);
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

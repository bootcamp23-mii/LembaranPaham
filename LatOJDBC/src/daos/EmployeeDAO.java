/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

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
    
    public List<Employee> Search(Object keyword){
        List<Employee> employees = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            employees = session.createQuery("FROM Employee WHERE id like '%" + keyword +
                    "%' or firstName like '%" + keyword + "%' or lastName like '%" + keyword + 
                    "%' or email like '%" + keyword + "%' or phoneNumber like '%" + keyword + 
                    "%' or hireDate like '%" + keyword + "%' or job like '%" + keyword + 
                    "%' or salary like '%" + keyword + "%' or commissionPct like '%" + keyword + 
                    "%' or manager like '%" + keyword + "%' or department like '%" + keyword+"%' ORDER BY 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return employees;
    }
    
    public Employee SearchById(Object word){
        Employee employee = new Employee();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            employee = (Employee) session.createQuery("from Employee where id = "+word+" order by 1").list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return employee;
    }
    
    public boolean saveOrDelete(Employee employee, boolean isSave){
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) session.saveOrUpdate(employee);
            else session.delete(employee);
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

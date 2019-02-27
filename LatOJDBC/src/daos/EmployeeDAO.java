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
    
    /**
     * Fungsi untuk mencari data yang terdapat di tabel Employees. Data yang dicari dapat berupa ID, First_name, Last_name, Email, Phone_number, Hire_date, Job, Salary, Commision_pct, Manager, atau Department.
     * @param keyword berupa angka atau huruf.
     * @return Menampilkan data pada tabel sesuai keyword yang dicari.
     */
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
    
    /**
     * Fungsi untuk mencari data pada tabel Employees berdasarkan ID Employee.
     * @param word id Employee yang dicari, dapat berupa angka atau huruf.
     * @return Menampilkan data pada tabel Employees sesuai ID yang dicari
     */
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
    
    /**
     * Fungsi untuk menyimpan data baru ke dalam tabel Employees, atau menghapus data yang terdapat di tabel Employees.
     * @param employee untuk fungsi save, masukkan ID, First_name, Last_name, Email, Phone_number, Hire_date, Job, Salary, Commision_pct, Manager, dan Department pada kotak yang disediakan. Untuk delete, hanya masukkan ID di kotak yang disediakan.
     * @param isSave jika TRUE maka menjalankan fungsi SAVE, jika FALSE maka menjalankan fungsi DELETE.
     * @return untuk SAVE, data baru akan tersimpan di tabel Employees, untuk DELETE, data pada tabel Employees akan dihapus sesuai dengan ID yang ditentukan.
     */
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

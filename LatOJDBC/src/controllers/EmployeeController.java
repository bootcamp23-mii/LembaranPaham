/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Panji Sadewo
 */
public class EmployeeController {
    
    private EmployeeDAO edao;

    public EmployeeController() {
    }
    
    public EmployeeController(SessionFactory factory) {
        edao = new EmployeeDAO(factory);
    }
    
    /**
     * Fungsi untuk memasukkan data baru ke dalam tabel Employees.
     * @param id ID
     * @param firstName Nama depan
     * @param lastName Nama belakang
     * @param email Email
     * @param phoneNumber Telepon
     * @param hireDate Tanggal diterima
     * @param job Pekerjaan
     * @param salary Gaji
     * @param commissionPct Komisi
     * @param manager Manager
     * @param department Departemen
     * @return Data baru akan masuk ke dalam tabel Employees.
     */
    public String insert(String id, String firstName, String lastName, String email, String phoneNumber, String hireDate, String job, String salary, String commissionPct, String manager, String department){
        if (edao.saveOrDelete(new Employee(new Integer(id), firstName, lastName, email, phoneNumber, new Date(hireDate), new Job(job), new BigDecimal(salary), new BigDecimal(commissionPct), new Employee(new Integer(manager)), new Department(new Short(department))), true)) return "Insert berhasil.";
        else return "Insert gagal";
    }
    
    /**
     * Fungsi untuk mengubah data yang sudah ada di dalam tabel Employees.
     * @param id ID
     * @param firstName Nama depan
     * @param lastName Nama belakang
     * @param email Email
     * @param phoneNumber Telepon
     * @param hireDate Tanggal diterima
     * @param job Pekerjaan
     * @param salary Gaji
     * @param commissionPct Komisi
     * @param manager Manager
     * @param department Departemen
     * @return  Data yang dipilih pada tabel Employees berubah sesuai input yang telah dimasukkan.
     */
    public String update(String id, String firstName, String lastName, String email, String phoneNumber, String hireDate, String job, String salary, String commissionPct, String manager, String department){
        if (edao.saveOrDelete(new Employee(new Integer(id), firstName, lastName, email, phoneNumber, new Date(hireDate), new Job(job), new BigDecimal(salary), new BigDecimal(commissionPct), new Employee(new Integer(manager)), new Department(new Short(department))), true)) return "Update berhasil.";
        else return "Update gagal";
    }
    
    /**
     * Menghapus data yang terdapat di tabel Employees berdasarkan ID yang ditentukan.
     * @param id ID yang terdapat di tabel Employees
     * @return Data pada tabel Employees dihapus sesuai ID yang ditentukan.
     */
    public String delete(String id){
        if (edao.saveOrDelete(new Employee(new Integer(id)), false)) return "Insert berhasil.";
        else return "Insert gagal";
    }
    
    /**
     * Fungsi untuk menampilkan seluruh data yang terdapat pada tabel Employees.
     * @return Menampilkan seluruh data di tabel Employees.
     */
    public List<Employee> getAll(){
        return edao.Search("");
    }
    
    /**
     * Fungsi untuk menampilkan data pada tabel Employees sesuai dengan keyword yang dicari.
     * @param key Keyword yang dicari, dapat berupa angka atau huruf.
     * @return Menampilkan data pada tabel Employees sesuai dengan keyword yang dicari.
     */
    public List<Employee> getData(Object key){
        return edao.Search(key);
    }
    
    /**
     * Fungsi untuk menampilkan data pada tabel Employees berdasarkan ID.
     * @param key ID yang dicari, dapat berupa angka atau huruf.
     * @return Menampilkan data pada tabel Employees sesuai ID yang dicari.
     */
    public Employee getById(Object key){
        return edao.SearchById(key);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.AdminDao;
import Ui.Admin;
import Ui.Koneksi;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class AdminController {
    Admin view;
    public AdminController(Admin view){
        this.view = view;
        
    }
    
    public int pesanHari(){
        AdminDao dao = new AdminDao();
        Koneksi k = new Koneksi();
        int hasil = 0;
        try {
            hasil = dao.pesanHari(k.getKoneksi());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public int bayarHari(){
        AdminDao dao = new AdminDao();
        Koneksi k = new Koneksi();
        int hasil = 0;
        try {
            hasil = dao.bayarHari(k.getKoneksi());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public double pendHari(){
        AdminDao dao = new AdminDao();
        Koneksi k = new Koneksi();
        double hasil = 0;
        try {
            hasil = dao.pendHari(k.getKoneksi());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public int pesanBulan(){
        AdminDao dao = new AdminDao();
        Koneksi k = new Koneksi();
        int hasil = 0;
        try {
            hasil = dao.pesanBulan(k.getKoneksi());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public int bayarBulan(){
        AdminDao dao = new AdminDao();
        Koneksi k = new Koneksi();
        int hasil = 0;
        try {
            hasil = dao.bayarBulan(k.getKoneksi());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public double pendBulan(){
        AdminDao dao = new AdminDao();
        Koneksi k = new Koneksi();
        double hasil = 0;
        try {
            hasil = dao.pendBulan(k.getKoneksi());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public double pendTahun(){
        AdminDao dao = new AdminDao();
        Koneksi k = new Koneksi();
        double hasil = 0;
        try {
            hasil = dao.pendTahun(k.getKoneksi());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

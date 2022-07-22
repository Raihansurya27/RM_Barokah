/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author LENOVO
 */
import Ui.Kary;
import Dao.KaryDao;
import Model.KaryModel;
import Ui.Koneksi;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class KaryController {
    Kary view;
    KaryModel model;
    
    public KaryController(Kary view){
        this.view = view;
        isiCboJabatan();
    }
    
    public void isiCboJabatan(){
        view.getCboJabatan().removeAllItems();
        view.getCboJabatan().addItem("Semua");
        view.getCboJabatan().addItem("Admin");
        view.getCboJabatan().addItem("Juru Masak");
        view.getCboJabatan().addItem("Kasir");
        view.getCboJabatan().addItem("Pelayan");
    }
    
    public void cboTipeAction(){
        String temp = view.getCboJabatan().getSelectedItem().toString();
        String tipe = temp.split("-")[0];
        try {
            if(tipe == "Semua"){
                view.populateJTable();
            }else{
                view.selectionTable(tipe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String kode){
        KaryDao dao = new KaryDao();
        Koneksi k = new Koneksi();
        try{
            dao.delete(k.getKoneksi(),kode);
            JOptionPane.showMessageDialog(view, "Proses hapus menu berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(view,"Proses hapus menu gagal karena "+e);
        }
        
    }
}

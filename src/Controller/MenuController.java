/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author LENOVO
 */
import Ui.Koneksi;
import Ui.Menu;
import Dao.MenuDao;
import Model.MenuModel;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class MenuController {
    Menu view;
    MenuModel model;
    
    public MenuController(Menu view){
        this.view = view;
        isiCbotipe();
    }
    
    public void isiCbotipe(){
        view.getCboTipemenu().removeAllItems();
        view.getCboTipemenu().addItem("Semua");
        view.getCboTipemenu().addItem("Makanan");
        view.getCboTipemenu().addItem("Minuman");
        view.getCboTipemenu().addItem("Lainnya");
    }
    
    public void cboTipeAction(){
        String temp = view.getCboTipemenu().getSelectedItem().toString();
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
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        try{
            dao.delete(k.getKoneksi(),kode);
            JOptionPane.showMessageDialog(view, "Proses hapus menu berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(view,"Proses hapus menu gagal karena "+e);
        }
        
    }
    
    public int jumlah(){
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        int jumlah = 0;
        try{
            jumlah = dao.countAll(k.getKoneksi());
        }catch(Exception e){
            
        }
        return jumlah;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author LENOVO
 */
import Dao.MenuDao;
import Dao.HomeDao;
import Ui.Koneksi;
import Ui.MenuForm;
import Model.MenuModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

public class MenuFormController {
    MenuForm view;
    MenuModel model;
    
    public MenuFormController(MenuForm view){
        this.view = view;
        isiCbotipe();
    }
    
    public MenuFormController(MenuForm view, String kode){
        this.view = view;
        pilih(kode);
        isiCbotipe();
    }
    
    public void pilih(String kode){
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        try{
            model = dao.getMenu(k.getKoneksi(), kode);
            view.getKodeTxt().setText(model.getId());
            view.getNamaTxt().setText(model.getNama());
            view.getHargaTxt().setText(String.valueOf(model.getHarga()));
            view.getDeskArea().setText(model.getDesk());
        }catch(Exception e){
            
        }
    }
    
    public void cancel(){
        view.getKodeTxt().setText("");
        view.getNamaTxt().setText("");
        view.getHargaTxt().setText("");
        view.getDeskArea().setText("");
        view.getGambarLbl().setText("");
    }
    
    public void insert() throws FileNotFoundException, IOException{
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        byte[] bytes = null;
        if (view.getGambar().isEmpty()){
            model = new MenuModel(
                view.getKodeTxt().getText(),
                view.getNamaTxt().getText(),
                view.getCboTipeMenu().getSelectedItem().toString().split("-")[0],
                Double.parseDouble(view.getHargaTxt().getText()),
                view.getDeskArea().getText(),
                bytes
            );
        }else{
            InputStream is = new FileInputStream(new File(view.getGambar()));
            bytes = is.readAllBytes();
            model = new MenuModel(
                view.getKodeTxt().getText(),
                view.getNamaTxt().getText(),
                view.getCboTipeMenu().getSelectedItem().toString().split("-")[0],
                Double.parseDouble(view.getHargaTxt().getText()),
                view.getDeskArea().getText(),
                bytes
            );
        }
        try{
            dao.insert(k.getKoneksi(), model);
            JOptionPane.showMessageDialog(view, "Tambah menu baru berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Tambah menu baru gagal karena "+e);
        }
    }
    
    public void update() throws FileNotFoundException, IOException{
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        byte[] bytes = null;
        if (view.getGambar().isEmpty()){
            model = new MenuModel(
                view.getKodeTxt().getText(),
                view.getNamaTxt().getText(),
                view.getCboTipeMenu().getSelectedItem().toString().split("-")[0],
                Double.parseDouble(view.getHargaTxt().getText()),
                view.getDeskArea().getText(),
                bytes
            );
        }else{
            InputStream is = new FileInputStream(new File(view.getGambar()));
            bytes = is.readAllBytes();
            model = new MenuModel(
                view.getKodeTxt().getText(),
                view.getNamaTxt().getText(),
                view.getCboTipeMenu().getSelectedItem().toString().split("-")[0],
                Double.parseDouble(view.getHargaTxt().getText()),
                view.getDeskArea().getText(),
                bytes
            );
        }
        try{
            dao.update(k.getKoneksi(), model);
            JOptionPane.showMessageDialog(view, "Update menu berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Update menu gagal karena "+e);
        }
    }
    
    public void isiCbotipe(){
        view.getCboTipeMenu().removeAllItems();
        view.getCboTipeMenu().addItem("Makanan");
        view.getCboTipeMenu().addItem("Minuman");
        view.getCboTipeMenu().addItem("Lainnya");
    }
    
    public MenuModel tampil(String kode){
        HomeDao dao = new HomeDao();
        Koneksi k = new Koneksi();
        model = null;
        try{
            model = dao.getTampil(k.getKoneksi(), kode); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, e);
        }
        return model;
    }
    
    public void cek(){
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        if(!view.getKodeTxt().getText().trim().isEmpty()){
            String kode1 = view.getKodeTxt().getText();
            if(kode1.length()<=10){
                try{
                    String kode2 = dao.getId(k.getKoneksi(), kode1);
                    if(kode1.equals(kode2)){
                        JOptionPane.showMessageDialog(view, "Kode sudah ada, silahkan ganti");
                    }else{
                        JOptionPane.showMessageDialog(view, "Kode bisa digunakan");
                    }
                }catch(Exception e){

                }
            }else{
                JOptionPane.showMessageDialog(view, "Kode tidak boleh lebih dari 10 karakter");
            }
        }else{
            JOptionPane.showMessageDialog(view, "Kode wajib diisi");
        }
    }
}

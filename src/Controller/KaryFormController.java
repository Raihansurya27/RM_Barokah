/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.KaryDao;
import Ui.KaryForm;
import Model.KaryModel;
import Ui.Koneksi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class KaryFormController {
    KaryForm view;
    KaryModel model;
    
    public KaryFormController(KaryForm view){
        this.view = view;
        isiCboJabatan();
    }
    
    public KaryFormController(KaryForm view, String kode){
        this.view = view;
        pilih(kode);
        isiCboJabatan();
    }
    
    public void pilih(String kode){
        KaryDao dao = new KaryDao();
        Koneksi k = new Koneksi();
        try{
            model = dao.getKary(k.getKoneksi(), kode);
            view.getIdTxt().setText(model.getId());
            view.getNamaTxt().setText(model.getNama());
            view.getAlamatTxtArea().setText(model.getAlamat());
        }catch(Exception e){
            
        }
    }
    
    public KaryModel tampil(String kode){
        KaryDao dao = new KaryDao();
        Koneksi k = new Koneksi();
        model = null;
        try{
            model = dao.getKary(k.getKoneksi(), kode); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, e);
        }
        return model;
    }
    
    public void cancel(){
        view.getNamaTxt().setText("");
        view.getAlamatTxtArea().setText("");
        view.getIdTxt().setText("");
    }
    
    public void insert() throws FileNotFoundException, IOException{
        KaryDao dao = new KaryDao();
        Koneksi k = new Koneksi();
        byte[] bytes = null;
        if (view.getGambar().isEmpty()){
            model = new KaryModel(
                view.getIdTxt().getText(),
                view.getNamaTxt().getText(),
                view.getCboJabatan().getSelectedItem().toString().split("-")[0],
                view.getAlamatTxtArea().getText(),
                bytes
            );
        }else{
            InputStream is = new FileInputStream(new File(view.getGambar()));
            bytes = is.readAllBytes();
            model = new KaryModel(
                view.getIdTxt().getText(),
                view.getNamaTxt().getText(),
                view.getCboJabatan().getSelectedItem().toString().split("-")[0],
                view.getAlamatTxtArea().getText(),
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
        KaryDao dao = new KaryDao();
        Koneksi k = new Koneksi();
        byte[] bytes = null;
        if(view.getGambar().isEmpty()){
            model = new KaryModel(
                view.getIdTxt().getText(),
                view.getNamaTxt().getText(),
                view.getCboJabatan().getSelectedItem().toString().split("-")[0],
                view.getAlamatTxtArea().getText(),
                bytes
            );
        }else{
            InputStream is = new FileInputStream(new File(view.getGambar()));
            bytes = is.readAllBytes();
            model = new KaryModel(
                view.getIdTxt().getText(),
                view.getNamaTxt().getText(),
                view.getCboJabatan().getSelectedItem().toString().split("-")[0],
                view.getAlamatTxtArea().getText(),
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
    
    public void isiCboJabatan(){
        view.getCboJabatan().removeAllItems();
        view.getCboJabatan().addItem("Admin");
        view.getCboJabatan().addItem("Juru Masak");
        view.getCboJabatan().addItem("Kasir");
        view.getCboJabatan().addItem("Pelayan");
    }
    
    public void cek(){
        KaryDao dao = new KaryDao();
        Koneksi k = new Koneksi();
        if(!view.getIdTxt().getText().trim().isEmpty()){
            String kode1 = view.getIdTxt().getText();
            if(kode1.length()<=10){
                try{
                    String kode2 = dao.getId(k.getKoneksi(), kode1);
                    if(kode1.equals(kode2)){
                        JOptionPane.showMessageDialog(view, "Id sudah ada, silahkan ganti");
                    }else{
                        JOptionPane.showMessageDialog(view, "Id bisa digunakan");
                    }
                }catch(Exception e){

                }
            }else{
                JOptionPane.showMessageDialog(view, "Id tidak boleh lebih dari 10 karakter");
            }
        }else{
            JOptionPane.showMessageDialog(view, "Id wajib diisi");
        }
    }
}

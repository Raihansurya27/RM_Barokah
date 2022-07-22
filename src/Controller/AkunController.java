/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Ui.Akun;
import Dao.AkunDao;
import Ui.AkunForm;
import Model.AkunModel;
import Ui.Koneksi;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LENOVO
 */
public class AkunController {
    Akun view;
    AkunModel model;
    AkunForm form;
    public AkunController(Akun view){
        this.view = view;
        viewAllTabel();
        isiCbotipe1();
    }
    
    public AkunController(AkunForm form){
        this.form = form;
        isiCbotipe2();
        cancel();
    }
    
    public AkunController(AkunForm form, String kode){
        this.form = form;
        isiCbotipe2();
        tampil(kode);
    }
    
    public AkunModel tampil(String kode){
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        model = null;
        try{
            model = dao.getAkun(k.getKoneksi(), kode);
            form.getIdText().setText(model.getId());
            form.getNamatxt().setText(model.getNama());
            form.getPasswordtxt().setText(model.getPassword());
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, e);
        }
        return model;
    }
    
    public void viewAllTabel(){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getAkunTbl().getModel();
        tabelmodel.setRowCount(0);
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        try{
            List<AkunModel> list = dao.getAllAkun(k.getKoneksi(),view.getAwal(),view.getBatas());
            view.setJumlah(dao.countGetAllAkun(k.getKoneksi()));
            int no = 1;
            for(AkunModel model:list){
                Object data[] ={
                    no,
                    model.getId(),
                    model.getNama(),
                    model.getPassword(),
                    model.getPeran()
                };
                no++;
                tabelmodel.addRow(data);
                view.setTeks((view.getAwal()+1)+" - "+(view.getAwal()+view.getBatas()));
            }
        }catch(Exception e){
            
        }
    }
    
    public void viewAllTipe(String tipe){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getAkunTbl().getModel();
        tabelmodel.setRowCount(0);
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        try{
            List<AkunModel> list = dao.getAllTipe(k.getKoneksi(),tipe,view.getAwal(),view.getBatas());
            view.setJumlah(dao.countGetAllTipe(k.getKoneksi(),tipe));
            int no = 1;
            for(AkunModel model:list){
                Object data[] ={
                    no,
                    model.getId(),
                    model.getNama(),
                    model.getPassword(),
                    model.getPeran()
                };
                no++;
                tabelmodel.addRow(data);
                view.setTeks((view.getAwal()+1)+" - "+(view.getAwal()+view.getBatas()));
            }
        }catch(Exception e){
            
        }
    }
    
    public void searchAllTable(String kata){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getAkunTbl().getModel();
        tabelmodel.setRowCount(0);
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        String cari = "%"+view.getCariTxt().getText()+"%";
        try{
            List<AkunModel> list = dao.searchAllTable(k.getKoneksi(),cari,view.getAwal(),view.getBatas());
            view.setJumlah(dao.countSearchAllTable(k.getKoneksi(),cari));
            int no = 1;
            for(AkunModel model:list){
                Object data[] ={
                    no,
                    model.getId(),
                    model.getNama(),
                    model.getPassword(),
                    model.getPeran()
                };
                no++;
                tabelmodel.addRow(data);
                view.setTeks((view.getAwal()+1)+" - "+(view.getAwal()+view.getBatas()));
            }
        }catch(Exception e){
            
        }
    }
    
    public void searchTableAllTipe(String kata, String tipe){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getAkunTbl().getModel();
        tabelmodel.setRowCount(0);
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        String cari = "%"+view.getCariTxt().getText()+"%";
        try{
            List<AkunModel> list = dao.searchTableAllTipe(k.getKoneksi(),tipe,cari,view.getAwal(),view.getBatas());
            view.setJumlah(dao.countSearchTableAllTipe(k.getKoneksi(),tipe,cari));
            int no = 1;
            for(AkunModel model:list){
                Object data[] ={
                    no,
                    model.getId(),
                    model.getNama(),
                    model.getPassword(),
                    model.getPeran()
                };
                no++;
                tabelmodel.addRow(data);
                view.setTeks((view.getAwal()+1)+" - "+(view.getAwal()+view.getBatas()));
            }
        }catch(Exception e){
            
        }
    }
    
    public void delete(String kode){
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        try{
            dao.delete(k.getKoneksi(),kode);
            JOptionPane.showMessageDialog(view, "Proses hapus akun berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(view,"Proses hapus akun gagal karena "+e);
        }           
    }
    
    public void insert(){
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        model = new AkunModel(
                form.getIdText().getText(),
                form.getNamatxt().getText(),
                form.getPasswordtxt().getText(),
                form.getCboPeran().getSelectedItem().toString().split("-")[0]
        );
        try{
            dao.insert(k.getKoneksi(), model);
            JOptionPane.showMessageDialog(view, "Tambah menu baru berhasil");
            cancel();
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Tambah menu baru gagal karena "+e);
        }
    }
    
    public void update(){
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        model = new AkunModel(
                form.getIdText().getText(),
                form.getNamatxt().getText(),
                form.getPasswordtxt().getText(),
                form.getCboPeran().getSelectedItem().toString().split("-")[0]
        );
        try{
            dao.update(k.getKoneksi(), model);
            JOptionPane.showMessageDialog(view, "Update menu berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Update menu gagal karena "+e);
        }
    }
    
    public void isiCbotipe1(){
        view.getCboJenisAkun().removeAllItems();
        view.getCboJenisAkun().addItem("Semua");
        view.getCboJenisAkun().addItem("Admin");
        view.getCboJenisAkun().addItem("Kasir");
    }
    
    public void isiCbotipe2(){
        form.getCboPeran().removeAllItems();
        form.getCboPeran().addItem("Admin");
        form.getCboPeran().addItem("Kasir");
    }
    
    public void cancel(){
        form.getNamatxt().setText("");
        form.getIdText().setText("");
        form.getPasswordtxt().setText("");
    }
    
    public void cboTipeAction(){
        String temp = view.getCboJenisAkun().getSelectedItem().toString();
        String tipe = temp.split("-")[0];
        try {
            if(tipe == "Semua"){
                viewAllTabel();
            }else{
                viewAllTipe(tipe);
            }
        } catch (Exception ex) {
           
        }
    }
    
    public void cek(){
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        if(!form.getIdText().getText().trim().isEmpty()){
            String kode1 = form.getIdText().getText();
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
    
    public void cekNama(){
        AkunDao dao = new AkunDao();
        Koneksi k = new Koneksi();
        if(!form.getNamatxt().getText().trim().isEmpty()){
            String kode1 = form.getNamatxt().getText();
            if(kode1.length()<=10){
                try{
                    String kode2 = dao.getNama(k.getKoneksi(), kode1);
                    if(kode1.equals(kode2)){
                        JOptionPane.showMessageDialog(view, "Username sudah ada, silahkan ganti");
                    }else{
                        JOptionPane.showMessageDialog(view, "Username bisa digunakan");
                    }
                }catch(Exception e){

                }
            }else{
                JOptionPane.showMessageDialog(view, "Username tidak boleh lebih dari 10 karakter");
            }
        }else{
            JOptionPane.showMessageDialog(view, "Username wajib diisi");
        }
    }
}

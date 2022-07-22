/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Ui.Koneksi;
import Ui.Pesanan;
import Dao.PesananDao;
import Ui.PesananMn;
import Model.PesananModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class PesananController {
    Pesanan view;
    PesananModel model;
    PesananMn view2;
    
    public PesananController(Pesanan view){
        this.view = view;
        viewTabel();
    }
    
    public PesananController(PesananMn view2){
        this.view2 = view2;
        viewAllTabel();
        isiCbotipe();
    }
    
    public void viewTabel(){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getPesantbl().getModel();
        tabelmodel.setRowCount(0);
        PesananDao dao = new PesananDao();
        Koneksi k = new Koneksi();
        try{
            List<PesananModel> list = dao.getPesanan(k.getKoneksi(), view.getAwal(), view.getBatas());
            view.setJumlah(dao.countGetPesanan(k.getKoneksi()));
            for(PesananModel pesanan :list){
                Object data[] ={
                    pesanan.getKode(),
                    pesanan.getNama(),
                    pesanan.getTanggalpesan()
                };
                tabelmodel.addRow(data);
        
            }
            view.setTeks((view.getAwal()+1)+" - "+(view.getAwal()+view.getBatas()));
        }catch(Exception ex){
        
        }
    }
    
    public void searchTabel(){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getPesantbl().getModel();
        tabelmodel.setRowCount(0);
        PesananDao dao = new PesananDao();
        String cari = "%"+view.getCariTxt().getText()+"%";
        Koneksi k = new Koneksi();
        try{
            List<PesananModel> list = dao.getCariPesanan(k.getKoneksi(), cari, view.getAwal(), view.getBatas());
            view.setJumlah(dao.countGetCariPesanan(k.getKoneksi(),cari));
            for(PesananModel pesanan :list){
                Object data[] ={
                    pesanan.getKode(),
                    pesanan.getNama(),
                    pesanan.getTanggalpesan()
                };
                tabelmodel.addRow(data);
        
            }
            view.setTeks((view.getAwal()+1)+" - "+(view.getAwal()+view.getBatas()));
        }catch(Exception ex){
        
        }
    }
    
    public void viewAllTabel(){
        DefaultTableModel tabelmodel = (DefaultTableModel) view2.getPesananTbl().getModel();
        tabelmodel.setRowCount(0);
        PesananDao dao = new PesananDao();
        Koneksi k = new Koneksi();
        int no = 1;
        try{
            List<PesananModel> list = dao.getAllPesanan(k.getKoneksi(), view2.getAwal(), view2.getBatas());
            view2.setJumlah(dao.countGetViewAllTable(k.getKoneksi()));
            for(PesananModel model:list){
                Object data[] ={
                    no,
                    model.getKode(),
                    model.getNama(),
                    model.getTanggalpesan(),
                    model.getTanggalbayar(),
                    model.getStatus(),
                    model.getTotal()
                };
                tabelmodel.addRow(data);
                no++;
            }
            view2.setTeks((view2.getAwal()+1)+" - "+(view2.getAwal()+view2.getBatas()));
        }catch(Exception e){
            
        }
    }
    
    public void searchAllTable(String kata){
        DefaultTableModel tabelmodel = (DefaultTableModel) view2.getPesananTbl().getModel();
        tabelmodel.setRowCount(0);
        PesananDao dao = new PesananDao();
        String cari = "%"+kata+"%";
        Koneksi k = new Koneksi();
        int no = 1;
        try{
            List<PesananModel> list = dao.getSearchAllTable(k.getKoneksi(), cari, view2.getAwal(), view2.getBatas());
            view2.setJumlah(dao.countGetSearchAllTable(k.getKoneksi(),cari));
            for(PesananModel model :list){
                Object data[] ={
                    no,
                    model.getKode(),
                    model.getNama(),
                    model.getTanggalpesan(),
                    model.getTanggalbayar(),
                    model.getStatus(),
                    model.getTotal()
                };
                tabelmodel.addRow(data);
                no++;
            }
            view2.setTeks((view2.getAwal()+1)+" - "+(view2.getAwal()+view2.getBatas()));
        }catch(Exception ex){
        
        }
    }
    
    
    public void searchTableAllTipe(String kata, String tipe){
        DefaultTableModel tabelmodel = (DefaultTableModel) view2.getPesananTbl().getModel();
        tabelmodel.setRowCount(0);
        PesananDao dao = new PesananDao();
        String cari = "%"+kata+"%";
        Koneksi k = new Koneksi();
        int no = 1;
        try{
            List<PesananModel> list = dao.getSearchAllTableTipe(k.getKoneksi(), tipe, cari, view2.getAwal(), view2.getBatas());
            view2.setJumlah(dao.countGetSearchAllTableTipe(k.getKoneksi(), tipe, cari));
            for(PesananModel model:list){
                Object data[] ={
                    no,
                    model.getKode(),
                    model.getNama(),
                    model.getTanggalpesan(),
                    model.getTanggalbayar(),
                    model.getStatus(),
                    model.getTotal()
                };
                tabelmodel.addRow(data);
                no++;
            }
            view2.setTeks((view2.getAwal()+1)+" - "+(view2.getAwal()+view2.getBatas()));
        }catch(Exception e){
            
        }
    }
    
    public void isiCbotipe(){
        view2.getCboTipe().removeAllItems();
        view2.getCboTipe().addItem("Semua");
        view2.getCboTipe().addItem("Dipesan");
        view2.getCboTipe().addItem("Dibayar");
    }
    
    public void cboTipeAction(){
        String temp = view2.getCboTipe().getSelectedItem().toString();
        String tipe = temp.split("-")[0];
        DefaultTableModel tabelmodel = (DefaultTableModel) view2.getPesananTbl().getModel();
        tabelmodel.setRowCount(0);
        int no = 1;
        PesananDao dao = new PesananDao();
        Koneksi k = new Koneksi();
        if(tipe.equals("Semua")){
            viewAllTabel();
        }else{
            try{
                List<PesananModel> list = dao.getTipePesanan(k.getKoneksi(),tipe, view2.getAwal(), view2.getBatas());
                view2.setJumlah(dao.countGetTipePesanan(k.getKoneksi(), tipe));
            for(PesananModel model:list){
                Object data[] ={
                    no,
                    model.getKode(),
                    model.getNama(),
                    model.getTanggalpesan(),
                    model.getTanggalbayar(),
                    model.getStatus(),
                    model.getTotal()
                };
                tabelmodel.addRow(data);
                no++;
            }
            view2.setTeks((view2.getAwal()+1)+" - "+(view2.getAwal()+view2.getBatas()));
            }catch(Exception e){
                
            }
        }
        
    }
    
    public void delete(String kode){
        PesananDao dao = new PesananDao();
        Koneksi k = new Koneksi();
        try{
            dao.delete(k.getKoneksi(),kode);
            JOptionPane.showMessageDialog(view, "Proses hapus menu berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(view,"Proses hapus menu gagal karena "+e);
        }
    }
}

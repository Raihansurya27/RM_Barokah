/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Ui.Home;
import Dao.HomeDao;
import Model.HomeModel;
import Ui.Koneksi;
import Dao.MenuDao;
import Model.MenuModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class HomeController {
    Home view;
    HomeModel model;
    MenuModel modelmenu;
    List<HomeModel> pesan;
    
    public HomeController(Home view){
        this.view = view;
        isiCbotipe();
        viewTabel();
        pesan = new ArrayList<>();
    }
    
    public void isiCbotipe(){
        view.getCboTipeMenu().removeAllItems();
        view.getCboTipeMenu().addItem("Semua");
        view.getCboTipeMenu().addItem("Makanan");
        view.getCboTipeMenu().addItem("Minuman");
        view.getCboTipeMenu().addItem("Lainnya");
    }
    
     public void cboTipeAction(){
        String temp = view.getCboTipeMenu().getSelectedItem().toString();
        String tipe = temp.split("-")[0];
        if(tipe == "Semua"){
            viewTabel();
        }else{
            viewTipe(tipe);
        }
        view.getCariTxt().setText("");
    }
    
    public void viewTabel(){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getMenuTbl().getModel();
        tabelmodel.setRowCount(0);
        HomeDao dao = new HomeDao();
        Koneksi k = new Koneksi();
        try{
            List<MenuModel> list = dao.getAllMenu(k.getKoneksi(),view.getAwal(),view.getBatas());
            for(MenuModel menu :list){
                Object data[] ={
                    menu.getId(),
                    "<HTML>"+menu.getNama()+"</HTML>",
                    menu.getHarga(),
                    
                };
                tabelmodel.addRow(data);
            }
            view.setJumlah(dao.getCountAllMenu(k.getKoneksi()));
            view.setTeks((view.getAwal()+1)+" - "+(view.getBatas()+view.getAwal()));
        }catch(Exception ex){
        
        }
    }
    
    public void viewTipe(String tipe){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getMenuTbl().getModel();
        tabelmodel.setRowCount(0);
        HomeDao dao = new HomeDao();
        Koneksi k = new Koneksi();
        try{
            List<MenuModel> list = dao.getTipeMenu(k.getKoneksi(),tipe, view.getAwal(), view.getBatas());
            for(MenuModel menu :list){
                Object data[] ={
                    menu.getId(),
                    "<HTML>"+menu.getNama()+"</HTML>",
                    menu.getHarga(),
                    
                };
                tabelmodel.addRow(data);
            }
            view.setJumlah(dao.getCountTipeMenu(k.getKoneksi(),tipe));
            view.setTeks((view.getAwal()+1)+" - "+(view.getBatas()+view.getAwal()));
        }catch(Exception ex){
        
        }
    }
    
    public void searchTable(String cari){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getMenuTbl().getModel();
        tabelmodel.setRowCount(0);
        HomeDao dao = new HomeDao();
        Koneksi k = new Koneksi();
        try{
            List<MenuModel> list = dao.getSearchTable(k.getKoneksi(), cari, view.getAwal(), view.getBatas());
            for(MenuModel menu :list){
                Object data[] ={
                    menu.getId(),
                    "<HTML>"+menu.getNama()+"</HTML>",
                    menu.getHarga(),
                    
                };
                tabelmodel.addRow(data);
            }
            view.setJumlah(dao.getCountSearchTable(k.getKoneksi(), cari));
            view.setTeks((view.getAwal()+1)+" - "+(view.getBatas()+view.getAwal()));
        }catch(Exception ex){
        
        }
    }
    
    public void searchTableTipe(String cari, String tipe){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getMenuTbl().getModel();
        tabelmodel.setRowCount(0);
        HomeDao dao = new HomeDao();
        Koneksi k = new Koneksi();
        try{
            List<MenuModel> list = dao.getSearchTableTipe(k.getKoneksi(), cari, tipe, view.getAwal(), view.getBatas());
            for(MenuModel menu :list){
                Object data[] ={
                    menu.getId(),
                    "<HTML>"+menu.getNama()+"</HTML>",
                    menu.getHarga(),
                    
                };
                tabelmodel.addRow(data);
            }
            view.setJumlah(dao.getCountSearchTableTipe(k.getKoneksi(), cari, tipe));
            view.setTeks((view.getAwal()+1)+" - "+(view.getBatas()+view.getAwal()));
        }catch(Exception ex){
        
        }
    }
    
    public MenuModel tampil(String kode){
        HomeDao dao = new HomeDao();
        Koneksi k = new Koneksi();
        modelmenu = null;
        try{
            modelmenu = dao.getTampil(k.getKoneksi(), kode); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, e);
        }
        return modelmenu;
    }
    
    public void isiPesan(String kode) {
        HomeModel model = new HomeModel();
        model.setKodePesan(view.getNoPesanTxt().getText());
        model.setKodeMakan(kode);
        int jumlah = Integer.parseInt(view.getJumlahTxt().getText());
        model.setQty(jumlah);
        pesan.add(model);
    }
    
    public void viewPesanan(){
        DefaultTableModel tabelModel = (DefaultTableModel) view.getPesanTbl().getModel();
        tabelModel.setRowCount(0);
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        int no = 1;
        try {
            for (HomeModel rp : pesan) {
                MenuModel menu = dao.getMenu(k.getKoneksi(), rp.getKodeMakan());
                Object data[] = {
                    no,
                    menu.getNama(),
                    rp.getQty()
                };
                no++;
                tabelModel.addRow(data);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
    
    public void btnHapusAction(){
        pesan.remove(view.getPesanTbl().getSelectedRow());
    }
    
    public void insert(){
        model = new HomeModel();
        model.setNamapesan(view.getNamaPemesanTxt().getText());
        model.setKodePesan(view.getNoPesanTxt().getText());
        HomeDao dao = new HomeDao();
        Koneksi k = new Koneksi();
        try{
            dao.insertOrder(k.getKoneksi(),model);
            for(HomeModel rp : pesan){
                dao.insertTrans(k.getKoneksi(), rp);
            }
            JOptionPane.showMessageDialog(view, "Pesanan telah dibuat");
            pesan.clear();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(view, "Pesanan error karena "+ex.getMessage());
        }
    }
    
    public void btnBatalAction(){
        pesan.clear();
        viewPesanan();
        view.getNamaPemesanTxt().setText("");
        view.getNoPesanTxt().setText("");
    }
    
    public void cek(){
        HomeDao dao = new HomeDao();
        Koneksi k = new Koneksi();
        if(!view.getNoPesanTxt().getText().trim().isEmpty()){
            String kode1 = view.getNoPesanTxt().getText();
            if(kode1.length()<=10){
                try{
                    String kode2 = dao.getNoPesanan(k.getKoneksi(), kode1);
                    if(kode1.equals(kode2)){
                        JOptionPane.showMessageDialog(view, "No. Pesanan sudah ada, silahkan ganti");
                    }else{
                        JOptionPane.showMessageDialog(view, "No. Pesanan bisa digunakan");
                    }
                }catch(Exception e){

                }
            }else{
                JOptionPane.showMessageDialog(view, "No. Pesanan tidak boleh lebih dari 10 karakter");
            }
        }else{
            JOptionPane.showMessageDialog(view, "No. Pesanan wajib diisi");
        }
    }
}

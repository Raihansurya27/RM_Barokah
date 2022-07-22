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
import Ui.Pembayaran;
import Dao.PembayaranDao;
import Model.PembayaranModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PembayaranController {
    Pembayaran view;

    public PembayaranController(Pembayaran view) {
        this.view = view;
    }
    
    public void viewAll(String kode){
        DefaultTableModel tabelmodel = (DefaultTableModel) view.getPembayaranTabel().getModel();
        tabelmodel.setRowCount(0);
        PembayaranDao dao = new PembayaranDao();
        Koneksi k = new Koneksi();
        try{
            List<PembayaranModel> list = dao.getAllPembayaran(k.getKoneksi(),kode);
            int no = 1;
            for (PembayaranModel model:list){
                Object data[] = {
                    no,
                    model.getNama(),
                    model.getJumlah(),
                    model.getHarga(),
                    model.getTotal(),
                };
                no++;
                tabelmodel.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Pembayaran gagal karena "+e);
        }
    }
    
    public String totalharga(){
        int row = view.getPembayaranTabel().getRowCount();
        double total = 0;
        for(int i = 0; i<row; i++){
            total = total + Double.parseDouble(view.getPembayaranTabel().getValueAt(i, 4).toString());
        }
        return String.valueOf(total);
    }
    
    public void bayar(String kode, double harga){
        PembayaranDao dao = new PembayaranDao();
        Koneksi k = new Koneksi();
        try{
            dao.bayar(k.getKoneksi(), kode, harga);
            JOptionPane.showMessageDialog(view, "Pembayaran sukses");
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Pemabayara gagal karena " + e);
        }
    }
    
}

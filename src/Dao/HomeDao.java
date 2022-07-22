/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.HomeModel;
import Model.MenuModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class HomeDao {
    public ArrayList<MenuModel> getAllMenu(Connection con, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `menu` limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,awal);
        ps.setInt(2,batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<MenuModel> list = new ArrayList<>();
        while(rs.next()){
            MenuModel pesanan = new MenuModel(
                        rs.getString("id_menu"), rs.getString("namamenu"), rs.getString("tipemenu"), rs.getDouble("harga"), rs.getString("deskripsi"), rs.getBytes("gambar"));
            list.add(pesanan);
        }
        return list;
    }
    
    public int getCountAllMenu(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `menu`";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public ArrayList<MenuModel> getTipeMenu(Connection con, String tipe, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `menu` WHERE `tipemenu` = ? limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setInt(2, awal);
        ps.setInt(3, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<MenuModel> list = new ArrayList<>();
        while(rs.next()){
            MenuModel pesanan = new MenuModel(
                        rs.getString("id_menu"), rs.getString("namamenu"), rs.getString("tipemenu"), rs.getDouble("harga"), rs.getString("deskripsi"), rs.getBytes("gambar"));
            list.add(pesanan);
        }
        return list;
    }
    
    public int getCountTipeMenu(Connection con, String tipe) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `menu` WHERE `tipemenu` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ResultSet rs  = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public ArrayList<MenuModel> getSearchTable(Connection con, String cari, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `menu` WHERE `namamenu` like ? limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+cari+"%";
        ps.setString(1, search);
        ps.setInt(2, awal);
        ps.setInt(3, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<MenuModel> list = new ArrayList<>();
        while(rs.next()){
            MenuModel pesanan = new MenuModel(
                        rs.getString("id_menu"), rs.getString("namamenu"), rs.getString("tipemenu"), rs.getDouble("harga"), rs.getString("deskripsi"), rs.getBytes("gambar"));
            list.add(pesanan);
        }
        return list;
    }
    
    public int getCountSearchTable(Connection con, String cari) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `menu` WHERE `namamenu` like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+cari+"%";
        ps.setString(1,search);
        ResultSet rs  = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public ArrayList<MenuModel> getSearchTableTipe(Connection con, String cari, String tipe, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `menu` WHERE `tipemenu` = ? AND `namamenu` like ? limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        String search = "%"+cari+"%";
        ps.setString(2, search);
        ps.setInt(3, awal);
        ps.setInt(4, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<MenuModel> list = new ArrayList<>();
        while(rs.next()){
            MenuModel pesanan = new MenuModel(
                        rs.getString("id_menu"), rs.getString("namamenu"), rs.getString("tipemenu"), rs.getDouble("harga"), rs.getString("deskripsi"), rs.getBytes("gambar"));
            list.add(pesanan);
        }
        return list;
    }
    
    public int getCountSearchTableTipe(Connection con, String cari, String tipe) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `menu` WHERE `tipemenu` = ? AND `namamenu` like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+cari+"%";
        ps.setString(1,tipe);
        ps.setString(2, search);
        ResultSet rs  = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public MenuModel getTampil(Connection con, String kode) throws SQLException{
        String sql = "SELECT * FROM `menu` WHERE `id_menu` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        MenuModel model = null;
        while(rs.next()){
            model = new MenuModel(
                        rs.getString("namamenu"), rs.getDouble("harga"), rs.getString("deskripsi"), rs.getBytes("gambar"));
        }
        return model;
    }
    
    public void insertOrder(Connection con, HomeModel model) throws SQLException{
        String sql = "INSERT INTO `order`(`id_order`, `namapemesan`) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getKodePesan());
        ps.setString(2, model.getNamapesan());
        ps.executeUpdate();
    }
    
    public void insertTrans(Connection con, HomeModel rp) throws SQLException{
        String sql = "INSERT INTO `transaksi`(`id_order`, `id_menu`, `qty`) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, rp.getKodePesan());
        ps.setString(2, rp.getKodeMakan());
        ps.setInt(3, rp.getQty());
        ps.executeUpdate();
    }
    
    public String getNoPesanan(Connection con, String kode) throws SQLException{
        String sql = "SELECT `id_order` FROM `order` WHERE `id_order` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        String hasil = "";
        while(rs.next()){
            hasil = rs.getString(1);
        }
        return hasil;
    }
}

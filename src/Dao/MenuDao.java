/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.MenuModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class MenuDao {
    public void insert(Connection con, MenuModel model) throws  SQLException{
        String sql = "INSERT INTO `menu` VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getId());
        ps.setString(2, model.getNama());
        ps.setString(3, model.getTipe());
        ps.setDouble(4, model.getHarga());
        ps.setString(5, model.getDesk());
        ps.setBytes(6, model.getGambar());
        ps.executeUpdate();
    }
    
    public void delete(Connection con, String kode) throws SQLException{
        String sql = "DELETE FROM `menu` WHERE `id_menu` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
    
    public void update(Connection con, MenuModel model) throws SQLException{
        String sql = "UPDATE `menu` SET `namamenu`=?,`tipemenu`=?,`harga`=?,`deskripsi`=?,`gambar`=? WHERE `id_menu`= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getNama());
        ps.setString(2, model.getTipe());
        ps.setDouble(3, model.getHarga());
        ps.setString(4, model.getDesk());
        ps.setBytes(5, model.getGambar());
        ps.setString(6, model.getId());
        ps.executeUpdate();
    }
    
    public int countAll(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `menu`";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public ArrayList<MenuModel> getAllMenu(Connection con, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `menu` limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, awal);
        ps.setInt(2, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<MenuModel> list = new ArrayList<>();
        while(rs.next()){
            MenuModel pesanan = new MenuModel(
                        rs.getString("id_menu"), rs.getString("namamenu"), rs.getString("tipemenu"), rs.getDouble("harga"), rs.getString("deskripsi"), rs.getBytes("gambar"));
            list.add(pesanan);
        }
        return list;
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
    
    public ArrayList<MenuModel> getCariTipe(Connection con, String tipe, String kata, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `menu` WHERE `tipemenu` = ? AND (`namamenu` LIKE ? OR `id_menu` LIKE ?) limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+kata+"%";
        ps.setString(1, tipe);
        ps.setString(2, search);
        ps.setString(3, search);
        ps.setInt(4, awal);
        ps.setInt(5, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<MenuModel> list = new ArrayList<>();
        while(rs.next()){
            MenuModel pesanan = new MenuModel(
                        rs.getString("id_menu"), rs.getString("namamenu"), rs.getString("tipemenu"), rs.getDouble("harga"), rs.getString("deskripsi"), rs.getBytes("gambar"));
            list.add(pesanan);
        }
        return list;
    }
    
    public ArrayList<MenuModel> getCariMenu(Connection con, String kata, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `menu` WHERE `namamenu` like ? OR `id_menu` LIKE ? limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+kata+"%";
        ps.setString(1,search);
        ps.setString(2,search);
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
    
    public MenuModel getMenu(Connection con, String kode) throws SQLException{
        String sql = "SELECT * FROM `menu` WHERE `id_menu` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        MenuModel model = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            model = new MenuModel(
                    rs.getString("id_menu"), rs.getString("namamenu"), rs.getDouble("harga"), rs.getString("deskripsi")
            );
        }
        return model;
    }
    
    public int countGetCariMenu(Connection con,String kata) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `menu` WHERE `namamenu` like ? OR `id_menu` like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+kata+"%";
        ps.setString(1, search);
        ps.setString(2, search);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public int countGetCariTipe(Connection con, String tipe,String kata) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `menu` WHERE `tipemenu` = ? AND (`namamenu` LIKE ? OR `id_menu` LIKE ?) ";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+kata+"%";
        ps.setString(1, tipe);
        ps.setString(2, search);
        ps.setString(3, search);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public int countGetTipeMenu(Connection con,String tipe) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `menu` WHERE `tipemenu` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public String getId(Connection con, String kode) throws SQLException{
        String sql = "SELECT `id_menu` FROM `menu` WHERE `id_menu` = ?";
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

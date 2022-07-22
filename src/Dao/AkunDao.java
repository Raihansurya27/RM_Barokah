/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.AkunModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class AkunDao {
    public ArrayList<AkunModel> getAllAkun(Connection con, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `users` limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, awal);
        ps.setInt(2, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<AkunModel> list = new ArrayList<>();
        while(rs.next()){
            AkunModel akun = new AkunModel(
                        rs.getString("id_user"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
            list.add(akun);
        }
        return list;
    }
    
    public int countGetAllAkun(Connection con) throws SQLException{
        int jumlah = 0;
        String sql = "SELECT COUNT(*) FROM `users`";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public ArrayList<AkunModel> getAllTipe(Connection con, String tipe, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `users` WHERE `role` = ? limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setInt(2, awal);
        ps.setInt(3, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<AkunModel> list = new ArrayList<>();
        while(rs.next()){
            AkunModel akun = new AkunModel(
                        rs.getString("id_user"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
            list.add(akun);
        }
        return list;
    }
    
    public int countGetAllTipe(Connection con, String tipe) throws SQLException{
        int jumlah = 0;
        String sql = "SELECT COUNT(*) FROM `users` WHERE `role` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public ArrayList<AkunModel> searchAllTable(Connection con, String cari, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `users` WHERE (`username` LIKE ? OR `id_user` LIKE ?) limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cari);
        ps.setString(2, cari);
        ps.setInt(3, awal);
        ps.setInt(4, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<AkunModel> list = new ArrayList<>();
        while(rs.next()){
            AkunModel akun = new AkunModel(
                        rs.getString("id_user"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
            list.add(akun);
        }
        return list;
    }
    
    public int countSearchAllTable(Connection con, String cari) throws SQLException{
        int jumlah = 0;
        String sql = "SELECT COUNT(*) FROM `users` WHERE (`username` LIKE ? OR `id_user` LIKE ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cari);
        ps.setString(2, cari);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public ArrayList<AkunModel> searchTableAllTipe(Connection con, String tipe, String cari, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `users` WHERE `role` = ? AND (`username` LIKE ? OR `id_user` LIKE ?) limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setString(2, cari);
        ps.setString(3, cari);
        ps.setInt(4, awal);
        ps.setInt(5, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<AkunModel> list = new ArrayList<>();
        while(rs.next()){
            AkunModel akun = new AkunModel(
                        rs.getString("id_user"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
            list.add(akun);
        }
        return list;
    }
    
    public int countSearchTableAllTipe(Connection con, String tipe, String cari) throws SQLException{
        int jumlah = 0;
        String sql = "SELECT COUNT(*) FROM `users` WHERE `role` = ? AND (`username` LIKE ? OR `id_user` LIKE ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setString(2, cari);
        ps.setString(3, cari);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public void delete(Connection con, String kode) throws SQLException{
        String sql = "DELETE FROM `users` WHERE `id_user` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
    
    public void insert(Connection con, AkunModel am) throws SQLException{
        String sql = "INSERT INTO `users` VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, am.getId());
        ps.setString(2, am.getNama());
        ps.setString(3, am.getPassword());
        ps.setString(4, am.getPeran());
        ps.executeUpdate();
    }
    
    public void update(Connection con, AkunModel am) throws SQLException{
        String sql = "UPDATE `users` SET `username`=?,`password`=?,`role`=? WHERE `id_user`= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, am.getNama());
        ps.setString(2, am.getPassword());
        ps.setString(3, am.getPeran());
        ps.setString(4, am.getId());
        ps.executeUpdate();
    }
    
    public AkunModel getAkun(Connection con, String kode) throws SQLException{
        String sql = "SELECT * FROM `users` WHERE `id_user` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        AkunModel model = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            model = new AkunModel(
                    rs.getString("id_user"), rs.getString("username"), rs.getString("password"), rs.getString("role")
            );
        }
        return model;
    }
    
    public String getId(Connection con, String kode) throws SQLException{
        String sql = "SELECT `id_user` FROM `users` WHERE `id_user` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        String hasil = "";
        while(rs.next()){
            hasil = rs.getString(1);
        }
        return hasil;
    }
    
    public String getNama(Connection con, String kode) throws SQLException{
        String sql = "SELECT `username` FROM `users` WHERE `username` = ?";
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

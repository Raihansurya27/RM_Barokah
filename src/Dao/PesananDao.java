/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.PesananModel;
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
public class PesananDao {
    public List<PesananModel> getPesanan(Connection con, int awal, int batas) throws SQLException{
        String sql = "SELECT `id_order`, `namapemesan`, `tgl_order` FROM `order` WHERE `status` = \"dipesan\" limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, awal);
        ps.setInt(2, batas);
        ResultSet rs = ps.executeQuery();
        List<PesananModel> list = new ArrayList<>();
        while(rs.next()){
            PesananModel pesanan = new PesananModel(
                        rs.getString(1), rs.getString(2), rs.getDate(3));
            list.add(pesanan);
        }
        return list;
    }
    
    public List<PesananModel> getCariPesanan(Connection con, String cari, int awal, int batas) throws SQLException{
        String sql = "SELECT `id_order`, `namapemesan`, `tgl_order` FROM `order` WHERE `status` = \"dipesan\" AND (`namapemesan` LIKE ? OR `id_order` LIKE ?) limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cari);
        ps.setString(2, cari);
        ps.setInt(3, awal);
        ps.setInt(4, batas);
        ResultSet rs = ps.executeQuery();
        List<PesananModel> list = new ArrayList<>();
        while(rs.next()){
            PesananModel pesanan = new PesananModel(
                        rs.getString(1), rs.getString(2), rs.getDate(3));
            list.add(pesanan);
        }
        return list;
    }
    
    public int countGetPesanan(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE `status` = \"dipesan\"";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public int countGetCariPesanan(Connection con, String cari) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE `status` = \"dipesan\" AND (`namapemesan` LIKE ? OR `id_order` LIKE ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cari);
        ps.setString(2, cari);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public List<PesananModel> getAllPesanan(Connection con, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `order` limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, awal);
        ps.setInt(2, batas);
        ResultSet rs = ps.executeQuery();
        List<PesananModel> list = new ArrayList<>();
        while(rs.next()){
            PesananModel pesanan = new PesananModel(
                        rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getDouble(6));
            list.add(pesanan);
        }
        return list;
    }
    
    public int countGetViewAllTable(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order`";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public List<PesananModel> getSearchAllTable(Connection con, String cari, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `order` WHERE `namapemesan` LIKE ? OR `id_order` LIKE ? limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cari);
        ps.setString(2, cari);
        ps.setInt(3, awal);
        ps.setInt(4, batas);
        ResultSet rs = ps.executeQuery();
        List<PesananModel> list = new ArrayList<>();
        while(rs.next()){
            PesananModel pesanan = new PesananModel(
                        rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getDouble(6));
            list.add(pesanan);
        }
        return list;
    }
    
    public int countGetSearchAllTable(Connection con, String cari) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE `namapemesan` LIKE ? OR `id_order` LIKE ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cari);
        ps.setString(2, cari);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public List<PesananModel> getSearchAllTableTipe(Connection con, String tipe, String cari, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `order` WHERE `status` = ? AND (`namapemesan` LIKE ? OR `id_order` LIKE ?) limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setString(2, cari);
        ps.setString(3, cari);
        ps.setInt(4, awal);
        ps.setInt(5, batas);
        ResultSet rs = ps.executeQuery();
        List<PesananModel> list = new ArrayList<>();
        while(rs.next()){
            PesananModel pesanan = new PesananModel(
                        rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getDouble(6));
            list.add(pesanan);
        }
        return list;
    }
    
    public int countGetSearchAllTableTipe(Connection con, String tipe, String cari) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE `status` = ? AND (`namapemesan` LIKE ? OR `id_order` LIKE ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setString(2, cari);
        ps.setString(3, cari);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public List<PesananModel> getTipePesanan(Connection con, String tipe, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `order` WHERE `status` = ? limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setInt(2, awal);
        ps.setInt(3, batas);
        ResultSet rs = ps.executeQuery();
        List<PesananModel> list = new ArrayList<>();
        while(rs.next()){
            PesananModel pesanan = new PesananModel(
                        rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getDouble(6));
            list.add(pesanan);
        }
        return list;
    }
    
    public int countGetTipePesanan(Connection con, String tipe) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE `status` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public void delete(Connection con, String kode) throws SQLException{
        String sql = "DELETE FROM `order` WHERE `id_order` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author LENOVO
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AdminDao {
    public int pesanHari(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE DATE(tgl_order) = DATE(NOW())";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int hasil = 0;
        if(rs.next()){
            hasil = rs.getInt(1);
        }
        return hasil;
    }
    
    public int bayarHari(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE DATE(tgl_order) = DATE(NOW()) AND `status` = 'dibayar'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int hasil = 0;
        if(rs.next()){
            hasil = rs.getInt(1);
        }
        return hasil;
    }
    
    public double pendHari(Connection con) throws SQLException{
        String sql = "SELECT SUM(`total`) FROM `order` WHERE DATE(tgl_order) = DATE(NOW()) AND `status` = 'dibayar'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        double hasil = 0;
        if(rs.next()){
            hasil = rs.getDouble(1);
        }
        return hasil;
    }
    
    public int pesanBulan(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE MONTH(tgl_order) = MONTH(NOW())";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int hasil = 0;
        if(rs.next()){
            hasil = rs.getInt(1);
        }
        return hasil;
    }
    
    public int bayarBulan(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `order` WHERE MONTH(tgl_order) = MONTH(NOW()) AND `status` = 'dibayar'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int hasil = 0;
        if(rs.next()){
            hasil = rs.getInt(1);
        }
        return hasil;
    }
    
    public double pendBulan(Connection con) throws SQLException{
        String sql = "SELECT SUM(`total`) FROM `order` WHERE MONTH(tgl_order) = MONTH(NOW()) AND `status` = 'dibayar'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        double hasil = 0;
        if(rs.next()){
            hasil = rs.getDouble(1);
        }
        return hasil;
    }
    
    public double pendTahun(Connection con) throws SQLException{
        String sql = "SELECT SUM(`total`) FROM `order` WHERE YEAR(tgl_order) = YEAR(NOW()) AND `status` = 'dibayar'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        double hasil = 0;
        if(rs.next()){
            hasil = rs.getDouble(1);
        }
        return hasil;
    }
}

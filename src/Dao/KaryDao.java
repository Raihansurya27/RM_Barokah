/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.KaryModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class KaryDao {
    public void insert(Connection con, KaryModel model) throws  SQLException{
        String sql = "INSERT INTO `karyawan` VALUES (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getId());
        ps.setString(2, model.getNama());
        ps.setString(3, model.getJabatan());
        ps.setString(4, model.getAlamat());
        ps.setBytes(5, model.getFoto());
        ps.executeUpdate();
    }
    
    public void delete(Connection con, String kode) throws SQLException{
        String sql = "DELETE FROM `karyawan` WHERE `id_kary` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
    
    public void update(Connection con, KaryModel model) throws SQLException{
        String sql = "UPDATE `karyawan` SET `Nama_kary`=?,`Jabatan`=?,`Alamat`=?,`Foto`=? WHERE `id_kary`= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getNama());
        ps.setString(2, model.getJabatan());
        ps.setString(3, model.getAlamat());
        ps.setBytes(4, model.getFoto());
        ps.setString(5, model.getId());
        ps.executeUpdate();
    }
    
    public int countAll(Connection con) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `karyawan`";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int jumlah = 0;
        while(rs.next()){
            jumlah = rs.getInt(1);
        }
        return jumlah;
    }
    
    public ArrayList<KaryModel> getAllKary(Connection con, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `karyawan` limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, awal);
        ps.setInt(2, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<KaryModel> list = new ArrayList<>();
        while(rs.next()){
            KaryModel karyawan = new KaryModel(
                        rs.getString("id_kary"), rs.getString("Nama_kary"), rs.getString("Jabatan"), rs.getString("Alamat"), rs.getBytes("Foto"));
            list.add(karyawan);
        }
        return list;
    }
    
    public ArrayList<KaryModel> getTipeKary(Connection con, String tipe, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `karyawan` WHERE `Jabatan` = ? limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setInt(2, awal);
        ps.setInt(3, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<KaryModel> list = new ArrayList<>();
        while(rs.next()){
            KaryModel karyawan = new KaryModel(
                        rs.getString("id_kary"), rs.getString("Nama_kary"), rs.getString("Jabatan"), rs.getString("Alamat"), rs.getBytes("Foto"));
            list.add(karyawan);
        }
        return list;
    }
    
    public ArrayList<KaryModel> getCariTipe(Connection con, String tipe, String kata, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `karyawan` WHERE `jabatan` = ? AND (`Nama_kary` LIKE ? OR `id_kary` LIKE ?) limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+kata+"%";
        ps.setString(1, tipe);
        ps.setString(2, search);
        ps.setString(3, search);
        ps.setInt(4, awal);
        ps.setInt(5, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<KaryModel> list = new ArrayList<>();
        while(rs.next()){
            KaryModel karyawan = new KaryModel(
                        rs.getString("id_kary"), rs.getString("Nama_kary"), rs.getString("Jabatan"), rs.getString("Alamat"), rs.getBytes("Foto"));
            list.add(karyawan);
        }
        return list;
    }
    
    public ArrayList<KaryModel> getCariKary(Connection con, String kata, int awal, int batas) throws SQLException{
        String sql = "SELECT * FROM `karyawan` WHERE `Nama_kary` like ? OR `id_kary` LIKE ? limit ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        String search = "%"+kata+"%";
        ps.setString(1,search);
        ps.setString(2,search);
        ps.setInt(3, awal);
        ps.setInt(4, batas);
        ResultSet rs = ps.executeQuery();
        ArrayList<KaryModel> list = new ArrayList<>();
        while(rs.next()){
            KaryModel karyawan = new KaryModel(
                        rs.getString("id_kary"), rs.getString("Nama_kary"), rs.getString("Jabatan"), rs.getString("Alamat"), rs.getBytes("Foto"));
            list.add(karyawan);
        }
        return list;
    }
    
    public KaryModel getKary(Connection con, String kode) throws SQLException{
        String sql = "SELECT * FROM `karyawan` WHERE `id_kary` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        KaryModel model = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            model = new KaryModel(
                    rs.getString("id_kary"), rs.getString("Nama_kary"), rs.getString("Jabatan"), rs.getString("Alamat"), rs.getBytes("Foto")
            );
        }
        return model;
    }
    
    public int countGetCariKary(Connection con,String kata) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `karyawan` WHERE `Nama_kary` like ? OR `id_kary` like ?";
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
        String sql = "SELECT COUNT(*) FROM `karyawan` WHERE `Jabatan` = ? AND (`Nama_kary` LIKE ? OR `id_kary` LIKE ?) ";
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
    
    public int countGetTipeKary(Connection con,String tipe) throws SQLException{
        String sql = "SELECT COUNT(*) FROM `karyawan` WHERE `Jabatan` = ?";
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
        String sql = "SELECT `id_kary` FROM `karyawan` WHERE `id_kary` = ?";
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

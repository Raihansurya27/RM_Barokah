/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.PembayaranModel;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
/**
 *
 * @author LENOVO
 */
public class PembayaranDao {
    public List<PembayaranModel> getAllPembayaran(Connection con, String kode) throws SQLException{
        String sql = "SELECT `namamenu`, `qty`, `harga`, `harga`*`qty` AS `total` FROM `order` JOIN `transaksi` USING(`id_order`) JOIN `menu` USING(`id_menu`) WHERE `id_order` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        List<PembayaranModel> list = new ArrayList<>();
        while (rs.next()){
            PembayaranModel model = new PembayaranModel(
                rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4));
            list.add(model);
        }
        return list;
    }
    
    public void bayar(Connection con, String kode, double harga) throws SQLException{
        String sql = "UPDATE `order` SET `tgl_pembayaran` = now(),`status` = 'dibayar',`total` = ? WHERE `id_order` = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(2, kode);
        ps.setDouble(1, harga);
        ps.executeUpdate();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ui;

/**
 *
 * @author LENOVO
 */

import java.sql.*;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;
public class Koneksi {
    private String url = "jdbc:mysql://localhost/sistem";
    private String username = "root";
    private String password = "";
    
    public Connection getKoneksi() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        return con;   
    }
    
    public static void main(String[] args) {
        Koneksi k = new Koneksi();
        try {
            k.getKoneksi();
            javax.swing.JOptionPane.showMessageDialog(null, "Koneksi ok");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        } 
    }
//    private static Connection koneksi;
//    
//    public static Connection GetConnection() throws SQLException{
//        if(koneksi==null){
//            new Driver();
//            
//            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistem","root","");
//        }
//        return koneksi;
//    }
}
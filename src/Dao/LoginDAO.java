/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author LENOVO
 */
import Model.LoginModel;
import java.util.*;
import java.sql.*;
public class LoginDAO {
    public LoginModel Login(Connection con, String username)throws SQLException{
        String sql="select password, role from users where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        LoginModel model = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            model = new LoginModel(
                    rs.getString(1), rs.getString(2)
            );
        }
        return model;
    }
    
}

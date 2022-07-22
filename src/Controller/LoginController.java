/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author LENOVO
 */
import Ui.Admin;
import Ui.Home;
import Ui.Koneksi;
import Ui.Login;
import Dao.LoginDAO;
import Model.LoginModel;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LoginController {
    LoginModel model;
    Login login;

    public LoginController(Login login) {
        this.login = login;
        cancel();
    }
    
    public void cancel(){
        login.getTusername().setText("");
        login.getTpassword().setText("");
    }
    
    public void Login (){
        String username = login.getTusername().getText();
        String password1 = login.getTpassword().getText();
        Koneksi k = new Koneksi();
        LoginDAO dao =  new LoginDAO();
        String password2 = "";
        try{
            model = dao.Login(k.getKoneksi(), username);
            password2 = model.getPassword();
            if(password2 != ""){
                if(password1.equals(password2)){
                    JOptionPane.showMessageDialog(login, "Berhasil login");
                    String role = model.getRole();
                    if(role.equals("Admin")){
                        new Admin().show();
                    }else{
                        new Home().show();
                    }
                    login.dispose();
                }else{
                    JOptionPane.showMessageDialog(login, "Password salah");
                    login.getTpassword().setText("");
                    login.getTpassword().requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(login, "User tidak ditemukan");
                cancel();
                login.getTusername().requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(login, "Login gagal karena User tidak ditemukan");
            cancel();
            login.getTusername().requestFocus();
        }
    }
}

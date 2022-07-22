/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class AkunModel {
    private String id;
    private String nama;
    private String password;
    private String peran;

    public AkunModel(String id, String nama, String password, String peran) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.peran = peran;
    }
    
    public AkunModel(String string, String string0, String string1) {
        this.nama = string;
        this.password = string0;
        this.peran = string1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author LENOVO
 */
public class MenuModel {
    private String id;
    private String nama;
    private String tipe;
    private double harga;
    private String desk;
    private byte[] gambar;
    
    public MenuModel(String id, String nama, String tipe, double harga, String desk, byte[] gambar){
        this.id = id;
        this.nama = nama;
        this.tipe = tipe;
        this.harga = harga;
        this.desk = desk;
        this.gambar = gambar;
    }
    
    public MenuModel(String id, String nama, double harga, String desk){
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.desk = desk;
    }
    
    public MenuModel(String nama, double harga, String desk, byte[] gambar){
        this.nama = nama;
        this.harga = harga;
        this.desk = desk;
        this.gambar = gambar;
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

    public double getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public byte[] getGambar() {
        return gambar;
    }

    public void setGambar(byte[] gambar) {
        this.gambar = gambar;
    }
}

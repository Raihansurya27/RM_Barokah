/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class KaryModel {
    private String id;
    private String nama;
    private String jabatan;
    private String alamat;
    private byte[] foto;

    public KaryModel(String id, String nama, String jabatan, String alamat, byte[] gambar){
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.alamat = alamat;
        this.foto = gambar;
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

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] gambar) {
        this.foto = gambar;
    }
    
    
}

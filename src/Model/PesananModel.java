/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;

/**
 *
 * @author LENOVO
 */
public class PesananModel {
    private String kode;
    private String nama;
    private Date tanggalpesan;
    private Date tanggalbayar;
    private String status;
    private double total;

    public PesananModel(String kode, String namapemesan, Date tanggalpesan) { //untuk pembayaran
        this.kode = kode;
        this.nama = namapemesan;
        this.tanggalpesan = tanggalpesan;
    }
    public PesananModel(String kode, String nama, Date tanggalpesan, Date tanggalbayar, String status, double harga) { //untuk menampilkan data pesanan
        this.kode = kode;
        this.nama = nama;
        this.tanggalpesan = tanggalpesan;
        this.tanggalbayar = tanggalbayar;
        this.status = status;
        this.total = harga;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public Date getTanggalpesan() {
        return tanggalpesan;
    }

    public void setTanggalpesan(Date tanggal) {
        this.tanggalpesan = tanggal;
    }

    public Date getTanggalbayar() {
        return tanggalbayar;
    }

    public void setTanggalbayar(Date tanggalbayar) {
        this.tanggalbayar = tanggalbayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
}

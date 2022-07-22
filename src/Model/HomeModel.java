/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class HomeModel {
    private String kodepesan;
    private String kodemakan;
    private int qty;
    private String namapesan;
    

    public String getKodePesan() {
        return kodepesan;
    }

    public void setKodePesan(String kode) {
        this.kodepesan = kode;
    }

    public String getKodeMakan() {
        return kodemakan;
    }

    public void setKodeMakan(String nama) {
        this.kodemakan = nama;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getNamapesan() {
        return namapesan;
    }

    public void setNamapesan(String namapesan) {
        this.namapesan = namapesan;
    }
    
    
}

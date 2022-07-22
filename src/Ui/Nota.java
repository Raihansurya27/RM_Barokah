/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ui;

import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class Nota extends javax.swing.JFrame {

    /**
     * Creates new form Nota
     */
    public Nota() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/gambar/Logo.png")).getImage());
        this.setTitle("Nota Pembayaran");
        tampil();
    }
    public Nota(String kode, Double uang) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/gambar/Logo.png")).getImage());
        this.setTitle("Nota Pembayaran");
        tampil(kode, uang);
    }
    
    public void tampil(String kode,Double uang){
        Koneksi k = new Koneksi();
        try{
            StringBuilder nota = new StringBuilder("\t\tRumah Makan Barokah"
                    + "\n\tJl. Dr. M. Hatta Pasar baru (kampus Unand) Kota Padang"
                    + "\n\t\tNo. Hp. 0823 8669 9283"
                    + "\n______________________________________________________________________"
                    + "\n");
            String sql1 = "SELECT * FROM `order` WHERE `id_order` = ?";
            PreparedStatement ps1 = k.getKoneksi().prepareStatement(sql1);
            ps1.setString(1, kode);
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()){
                String header = "Nota Pembayaran"
                        + "\nNo. Pesanan\t\t: %s"
                        + "\nNama Pemesan\t: %s"
                        + "\nTanggal Pemesanan\t: %s"
                        + "\n______________________________________________________________________"
                        + "\n";
                header = String.format(header,
                        rs1.getString("id_order"),
                        rs1.getString("namapemesan"),
                        rs1.getDate("tgl_order"));
                nota.append(header);
            }
            String sql2 = "SELECT * FROM `order` JOIN `transaksi` USING(`id_order`) JOIN `menu` USING(`id_menu`) WHERE `id_order` = ?";
            PreparedStatement ps2 = k.getKoneksi().prepareStatement(sql2);
            ps2.setString(1, kode);
            ResultSet rs2 = ps2.executeQuery();
//            String body = "Rendang Sapi\t2 * 1\tRp.120000";
            
            while(rs2.next()){
                String body = "%s\t\t%s * %s\t\tRp.%s\n";
                body = String.format(
                        body,
                        rs2.getString("namamenu"),
                        rs2.getInt("qty"),
                        rs2.getDouble("harga"),
                        rs2.getInt("qty")*rs2.getDouble("harga"));
                nota.append(body);
            }
            String sql3 = "SELECT * FROM `order` WHERE `id_order` = ?";
            PreparedStatement ps3 = k.getKoneksi().prepareStatement(sql3);
            ps3.setString(1, kode);
            ResultSet rs3 = ps3.executeQuery();
            while(rs3.next()){
                String footer = "______________________________________________________________________"
                    + "\n\t\tTotal Tagihan\t\tRp."+rs3.getDouble("total")
                    + "\n\t\tBayar\t\tRp."+uang
                    + "\n\t\tKembalian\t\tRp."+(uang-rs3.getDouble("total"))
                    + "\n______________________________________________________________________";
            nota.append(footer);
            JOptionPane.showMessageDialog(rootPane, "Kembalian : Rp."+(uang-rs3.getDouble("total")));
            }
            jTextArea1.setText(nota.toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    public void tampil(){
        Koneksi k = new Koneksi();
        try{
//            String sql = "SELECT * FROM `order` WHERE `id_order` = ?";
//            PreparedStatement ps = k.getKoneksi().prepareStatement(sql);
            StringBuilder nota = new StringBuilder("\t\tRumah Makan Barokah"
                    + "\n\tJl. Dr. M. Hatta Pasar baru (kampus Unand) Kota Padang"
                    + "\n\t\tNo. Hp. 0823 8669 9283"
                    + "\n______________________________________________________________________\n");
            String body = "Rendang Sapi\t\t2 * 60000\t\tRp.120000"
                        + "\n";
//            ps.setString(1, kode);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//            jumlah = rs.getInt(1);
//            }
            nota.append(body);
            String footer = "______________________________________________________________________"
                    + "\n\t\tTotal Tagihan\t\tRp.120000";
            nota.append(footer);
            jTextArea1.setText(nota.toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jTextArea1.print();
            dispose();
        } catch (PrinterException ex) {
            Logger.getLogger(Nota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

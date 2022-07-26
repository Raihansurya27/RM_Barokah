/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ui;

import Controller.AkunController;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class AkunForm extends javax.swing.JFrame {

    /**
     * Creates new form AkunForm
     */
    AkunController controller;
    public AkunForm() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/gambar/Logo.png")).getImage());
        controller = new AkunController(this);
        this.setTitle("Rumah Makan barokah - Buat Akun baru");
        judul.setText("Buat Menu Baru");
        ubahBtn.setEnabled(false);
    }
    
    public AkunForm(String kode) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/gambar/Logo.png")).getImage());
        controller = new AkunController(this, kode);
        this.setTitle("Rumah Makan Barokah - Ubah akun");
        judul.setText("Ubah akun");
        buatBtn.setEnabled(false);
        idText.setEditable(false);
        batalBtn.setEnabled(false);
    }

    public JTextField getNamatxt() {
        return namatxt;
    }

    public void setNamatxt(JTextField namatxt) {
        this.namatxt = namatxt;
    }

    public JTextField getPasswordtxt() {
        return passwordtxt;
    }

    public void setPasswordtxt(JTextField passwordtxt) {
        this.passwordtxt = passwordtxt;
    }

    public JComboBox<String> getCboPeran() {
        return cboPeran;
    }

    public JTextField getIdText() {
        return idText;
    }

    public void setIdText(JTextField idText) {
        this.idText = idText;
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judul = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namatxt = new javax.swing.JTextField();
        passwordtxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboPeran = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        buatBtn = new javax.swing.JButton();
        ubahBtn = new javax.swing.JButton();
        batalBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        kembaliBtn = new javax.swing.JButton();
        cekBtn = new javax.swing.JButton();
        cekBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        judul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("Judul");
        getContentPane().add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, 420, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Username : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 88, -1, 24));
        getContentPane().add(namatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 85, 240, 30));
        getContentPane().add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 310, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 124, 86, 24));

        cboPeran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cboPeran, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 155, 310, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Peran :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 162, 86, -1));

        buatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/plus.png"))); // NOI18N
        buatBtn.setText("Buat");
        buatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buatBtnActionPerformed(evt);
            }
        });
        getContentPane().add(buatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 191, 92, 40));

        ubahBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pencil_edit.png"))); // NOI18N
        ubahBtn.setText("Ubah");
        ubahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ubahBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 191, 98, 40));

        batalBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/close_delete.png"))); // NOI18N
        batalBtn.setText("Batal");
        batalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBtnActionPerformed(evt);
            }
        });
        getContentPane().add(batalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 191, 95, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Id akun : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 54, 86, -1));
        getContentPane().add(idText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 240, 30));

        kembaliBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/small back.png"))); // NOI18N
        kembaliBtn.setText("Kembali");
        kembaliBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliBtnActionPerformed(evt);
            }
        });
        getContentPane().add(kembaliBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 191, -1, 40));

        cekBtn.setText("Cek");
        cekBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cekBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, 30));

        cekBtn1.setText("Cek");
        cekBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(cekBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 85, -1, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void batalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBtnActionPerformed
        // TODO add your handling code here:
        controller.cancel();
    }//GEN-LAST:event_batalBtnActionPerformed

    private void ubahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBtnActionPerformed
        // TODO add your handling code here:
        if(!this.getIdText().getText().trim().isEmpty() & 
                !this.getNamatxt().getText().trim().isEmpty() & 
                !this.getPasswordtxt().getText().trim().isEmpty()){
            int p = JOptionPane.showConfirmDialog(null, "Apakah yakin mengubah akun ini?", "Update Akun", JOptionPane.YES_NO_OPTION);
                if (p==0){
                    controller.update();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Proses pengubahan akun gagal", "Update Akun", HEIGHT);
                }
        }else{
            JOptionPane.showMessageDialog(this, "Nama akun dan password tidak boleh kosong");
        }
        
    }//GEN-LAST:event_ubahBtnActionPerformed

    private void buatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buatBtnActionPerformed
        // TODO add your handling code here:
        if(!this.getIdText().getText().trim().isEmpty() & 
                !this.getNamatxt().getText().trim().isEmpty() & 
                !this.getPasswordtxt().getText().trim().isEmpty()){
                controller.insert();
            }else{
                JOptionPane.showMessageDialog(this, "Nama akun dan password tidak boleh kosong");
            }
    }//GEN-LAST:event_buatBtnActionPerformed

    private void kembaliBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_kembaliBtnActionPerformed

    private void cekBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBtnActionPerformed
    if(!this.getIdText().getText().trim().isEmpty()){
        controller.cek();
    }else{
        JOptionPane.showMessageDialog(rootPane, "Mohon diisi terlebih dahulu sebelum dicek");
    }
    }//GEN-LAST:event_cekBtnActionPerformed

    private void cekBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBtn1ActionPerformed
    if(!this.getNamatxt().getText().trim().isEmpty()){
        controller.cekNama();
    }else{
        JOptionPane.showMessageDialog(rootPane, "Mohon diisi terlebih dahulu sebelum dicek");
    }
    }//GEN-LAST:event_cekBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(AkunForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AkunForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AkunForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AkunForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AkunForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalBtn;
    private javax.swing.JButton buatBtn;
    private javax.swing.JComboBox<String> cboPeran;
    private javax.swing.JButton cekBtn;
    private javax.swing.JButton cekBtn1;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel judul;
    private javax.swing.JButton kembaliBtn;
    private javax.swing.JTextField namatxt;
    private javax.swing.JTextField passwordtxt;
    private javax.swing.JButton ubahBtn;
    // End of variables declaration//GEN-END:variables
}

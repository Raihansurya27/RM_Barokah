/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ui;

import Model.MenuModel;
import Controller.HomeController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    HomeController controller;
    int batas = 4, awal = 0, jumlah;
    String teks;
    
    public Home() {
        initComponents();
        this.setTitle("Rumah Makan barokah - Halaman Utama");
        setIconImage(new ImageIcon(getClass().getResource("/gambar/Logo.png")).getImage());
        gambar.setText("Pilih Menu");
        String tglsekarang;
        SimpleDateFormat format = new SimpleDateFormat("E, YYYY-MM-dd");
        tglsekarang = format.format(new Date());
        tanggal.setText(tglsekarang);
        setJam();
        namaLbl.setText("");
        deskLbl.setText("");
        hargaLbl.setText("");
        controller = new HomeController(this);
        menuTbl.getColumnModel().getColumn(0).setPreferredWidth(50);
        menuTbl.setRowHeight(50);
        pesanTbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        controller.viewPesanan();
        tombolmati();
        pageTxt.setEditable(false);
        kondisiAwal();
        pageTxt.setText(getTeks());
        if (jumlah > batas){
            selBtn.setEnabled(true);
        }else{
            selBtn.setEnabled(false);
        }
        menuBtn.setEnabled(false);
    }
    
    public final void setJam() {
        ActionListener taskPerformer;
        taskPerformer = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "", nol_menit = "", nol_detik = "";

                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();

                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <= 9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }

                String jam1 = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);

                jam.setText(jam1 + ":" + menit + ":" + detik + "");
            }
        };
        new Timer(1000, taskPerformer).start();
    }
    
    public void tombolmati(){
        buatPesananBtn.setEnabled(false);
        hapusBtn.setEnabled(false);
    }
    
    public void tombolhidup(){
        buatPesananBtn.setEnabled(true);
        hapusBtn.setEnabled(true);
    }

    public JComboBox<String> getCboTipeMenu() {
        return cboTipeMenu;
    }

    public JTable getMenuTbl() {
        return menuTbl;
    }

    public JLabel getDeskLbl() {
        return deskLbl;
    }

    public void setDeskLbl(JLabel deskLbl) {
        this.deskLbl = deskLbl;
    }

    public JLabel getGambar() {
        return gambar;
    }

    public void setGambar(JLabel gambar) {
        this.gambar = gambar;
    }

    public JLabel getHargaLbl() {
        return hargaLbl;
    }

    public void setHargaLbl(JLabel hargaLbl) {
        this.hargaLbl = hargaLbl;
    }

    public JLabel getNamaLbl() {
        return namaLbl;
    }

    public void setNamaLbl(JLabel namaLbl) {
        this.namaLbl = namaLbl;
    }

    public JTable getPesanTbl() {
        return pesanTbl;
    }

    public JTextField getNamaPemesanTxt() {
        return namaPemesanTxt;
    }

    public void setNamaPemesanTxt(JTextField namaPemesanTxt) {
        this.namaPemesanTxt = namaPemesanTxt;
    }

    public JTextField getNoPesanTxt() {
        return noPesanTxt;
    }

    public void setNoPesanTxt(JTextField noPesanTxt) {
        this.noPesanTxt = noPesanTxt;
    }

    public JTextField getJumlahTxt() {
        return jumlahTxt;
    }

    public void setJumlahTxt(JTextField jumlahTxt) {
        this.jumlahTxt = jumlahTxt;
    }

    public int getBatas() {
        return batas;
    }

    public void setBatas(int batas) {
        this.batas = batas;
    }

    public int getAwal() {
        return awal;
    }

    public void setAwal(int awal) {
        this.awal = awal;
    }

    public JTextField getCariTxt() {
        return cariTxt;
    }

    public void setCariTxt(JTextField cariTxt) {
        this.cariTxt = cariTxt;
    }

    public JTextField getPageTxt() {
        return pageTxt;
    }

    public void setPageTxt(JTextField pageTxt) {
        this.pageTxt = pageTxt;
    }

    public void kondisiAwal(){
        setAwal(0);
        sblBtn.setEnabled(false);
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getTeks() {
        return teks;
    }

    public void setTeks(String pesan) {
        this.teks = pesan;
    }
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        keluarbtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        pesananBtn = new javax.swing.JButton();
        tentangBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        gambar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namaLbl = new javax.swing.JLabel();
        hargaLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deskLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTbl = new javax.swing.JTable();
        cboTipeMenu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        pesanBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jumlahTxt = new javax.swing.JTextField();
        batalBtn = new javax.swing.JButton();
        selBtn = new javax.swing.JButton();
        sblBtn = new javax.swing.JButton();
        pageTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cariTxt = new javax.swing.JTextField();
        cariBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        hapusBtn = new javax.swing.JButton();
        buatPesananBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pesanTbl = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        noPesanTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        namaPemesanTxt = new javax.swing.JTextField();
        cekBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU");

        jam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jam.setText("Jam");
        jam.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jam.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jamComponentShown(evt);
            }
        });

        tanggal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tanggal.setText("Tanggal");
        tanggal.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tanggalComponentShown(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jam, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tanggal)
                        .addComponent(jam)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 50));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(111, 414));

        keluarbtn.setText("Keluar");
        keluarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarbtnActionPerformed(evt);
            }
        });

        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        pesananBtn.setText("Pesanan");
        pesananBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesananBtnActionPerformed(evt);
            }
        });

        tentangBtn.setText("Tentang");
        tentangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tentangBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(keluarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addComponent(menuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pesananBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tentangBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pesananBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tentangBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(keluarbtn)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 110, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambar.setText("jLabel3");
        jPanel2.add(gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 218, 170));

        jLabel6.setText("Nama Menu : ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, 20));

        namaLbl.setText("nama");
        jPanel2.add(namaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 160, 20));

        hargaLbl.setText("nama");
        jPanel2.add(hargaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 160, 20));

        jLabel3.setText("Harga : ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, 20));

        jLabel5.setText("Deskripsi : ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 60, 20));

        deskLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deskLbl.setText("nama");
        deskLbl.setToolTipText("");
        deskLbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(deskLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 160, 90));

        menuTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode", "Menu", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        menuTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menuTbl);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, 227));

        cboTipeMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTipeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipeMenuActionPerformed(evt);
            }
        });
        jPanel2.add(cboTipeMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pilih Menu");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        pesanBtn.setText("Pesan");
        pesanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesanBtnActionPerformed(evt);
            }
        });
        jPanel2.add(pesanBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 82, 32));

        jLabel9.setText("Jumlah Pesanan");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, 20));
        jPanel2.add(jumlahTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 95, 30));

        batalBtn.setText("Batal");
        batalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBtnActionPerformed(evt);
            }
        });
        jPanel2.add(batalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 82, 32));

        selBtn.setText(">>");
        selBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selBtnActionPerformed(evt);
            }
        });
        jPanel2.add(selBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 50, -1));

        sblBtn.setText("<<");
        sblBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sblBtnActionPerformed(evt);
            }
        });
        jPanel2.add(sblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 50, -1));

        pageTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(pageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 70, -1));

        jLabel10.setText("Jenis :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel11.setText("Cari Menu :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel2.add(cariTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 30));

        cariBtn.setText("Cari");
        cariBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBtnActionPerformed(evt);
            }
        });
        jPanel2.add(cariBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 60, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 460, 430));

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hapusBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/close_delete.png"))); // NOI18N
        hapusBtn.setText("Hapus");
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });
        jPanel4.add(hapusBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 383, 116, 40));

        buatPesananBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/plus.png"))); // NOI18N
        buatPesananBtn.setText("Buat Pesanan");
        buatPesananBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buatPesananBtnActionPerformed(evt);
            }
        });
        jPanel4.add(buatPesananBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 383, 140, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pesanan");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        pesanTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "Nama Menu", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(pesanTbl);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 122, 260, 255));

        jLabel7.setText("No. Pesanan");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, 82, 25));
        jPanel4.add(noPesanTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 120, 25));

        jLabel8.setText("Nama Pemesan");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 25));
        jPanel4.add(namaPemesanTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 170, 25));

        cekBtn.setText("Cek");
        cekBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBtnActionPerformed(evt);
            }
        });
        jPanel4.add(cekBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 50, 25));

        jLabel12.setText("No. Pesanan maks. 10 karakter");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 65, 280, 430));

        setSize(new java.awt.Dimension(893, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void keluarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarbtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login().show();
    }//GEN-LAST:event_keluarbtnActionPerformed

    private void pesananBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesananBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Pesanan().show();
    }//GEN-LAST:event_pesananBtnActionPerformed

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Kamu sudah berada di Menu");
    }//GEN-LAST:event_menuBtnActionPerformed

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
        // TODO add your handling code here:
        controller.btnHapusAction();
        controller.viewPesanan();
        int row = this.getMenuTbl().getColumnCount();
        if(row == 0){
            tombolmati();
        }else{
            
        }
    }//GEN-LAST:event_hapusBtnActionPerformed

    private void cboTipeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipeMenuActionPerformed
        // TODO add your handling code here:
        if(controller!=null){
            kondisiAwal();
            controller.cboTipeAction();
            pageTxt.setText(getTeks());
            if(jumlah > batas){
                selBtn.setEnabled(true);
            }else{
                selBtn.setEnabled(false);
            }
        }
    }//GEN-LAST:event_cboTipeMenuActionPerformed

    private void menuTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTblMouseClicked
        // TODO add your handling code here:
        int row = this.getMenuTbl().getSelectedRow();
        String kode = this.getMenuTbl().getValueAt(row, 0).toString();
        MenuModel model = controller.tampil(kode);
        
        if(model != null){
            ImageIcon image = new ImageIcon(new ImageIcon(model.getGambar()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)); 
            gambar.setIcon(image);
            gambar.setText("");
            namaLbl.setText(model.getNama());
            hargaLbl.setText("Rp."+String.valueOf(model.getHarga()));
            deskLbl.setText("<HTML>"+model.getDesk()+"</HTML>");
        }
    }//GEN-LAST:event_menuTblMouseClicked

    private void buatPesananBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buatPesananBtnActionPerformed
        // TODO add your handling code here:
        controller.insert();
        controller.viewPesanan();
        namaPemesanTxt.setEnabled(true);
        namaPemesanTxt.setText("");
        noPesanTxt.setEnabled(true);
        noPesanTxt.setText("");
        tombolmati();
    }//GEN-LAST:event_buatPesananBtnActionPerformed

    private void pesanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesanBtnActionPerformed
        // TODO add your handling code here:
        try{
        int row = this.getMenuTbl().getSelectedRow();
        String kode = this.getMenuTbl().getValueAt(row, 0).toString();
            if(!this.getNoPesanTxt().getText().trim().isEmpty()){
                controller.isiPesan(kode);
                controller.viewPesanan();
                namaPemesanTxt.setEnabled(false);
                noPesanTxt.setEnabled(false);
                tombolhidup();
            }else{
                JOptionPane.showMessageDialog(this, "No. Pesanan tidak boleh kosong");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Pilih Dahulu menu dan masukkan no pesanan");
        }
    }//GEN-LAST:event_pesanBtnActionPerformed

    private void batalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBtnActionPerformed
        // TODO add your handling code here:
        controller.btnBatalAction();
        namaPemesanTxt.setEnabled(true);
        noPesanTxt.setEnabled(true);
        tombolmati();
    }//GEN-LAST:event_batalBtnActionPerformed

    private void cariBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBtnActionPerformed
        // TODO add your handling code here:
        if(!this.getCariTxt().getText().trim().isEmpty()){
            String temp = getCboTipeMenu().getSelectedItem().toString();
            String tipe = temp.split("-")[0];
            String kata = getCariTxt().getText();
            kondisiAwal();
            if(tipe == "Semua"){
                controller.searchTable(kata);
                pageTxt.setText(getTeks());
                if(jumlah>batas){
                    selBtn.setEnabled(true);
                }else{
                    selBtn.setEnabled(false);
                }
            }else{
                controller.searchTableTipe(kata, tipe);
                pageTxt.setText(getTeks());
                if(jumlah>batas){
                    selBtn.setEnabled(true);
                }else{
                    selBtn.setEnabled(false);
                }        
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Masukkan input/kata pencarian dahulu");
        }
    }//GEN-LAST:event_cariBtnActionPerformed

    private void selBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selBtnActionPerformed
        // TODO add your handling code here:
        String temp = getCboTipeMenu().getSelectedItem().toString();
        String tipe = temp.split("-")[0];
        String kata = getCariTxt().getText();
        if(awal+batas<getJumlah()){
            setAwal(awal+batas);
                if(tipe=="Semua"){
                    if(kata == ""){
                        controller.viewTabel();
                        pageTxt.setText(getTeks());
                    }else{
                        controller.searchTable(kata);
                        pageTxt.setText(getTeks());
                    }
                }else{
                    if(kata == ""){
                        controller.viewTipe(tipe);
                        pageTxt.setText(getTeks());
                    }else{
                        controller.searchTableTipe(kata, tipe);
                        pageTxt.setText(getTeks());
                    }
                }
                if(awal+batas<getJumlah()){
                    selBtn.setEnabled(true);
                }else{
                    selBtn.setEnabled(false);
                }
        }else{
            selBtn.setEnabled(false);
        }
        sblBtn.setEnabled(true);
    }//GEN-LAST:event_selBtnActionPerformed

    private void sblBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sblBtnActionPerformed
        // TODO add your handling code here:
        String temp = getCboTipeMenu().getSelectedItem().toString();
        String tipe = temp.split("-")[0];
        String kata = getCariTxt().getText();
        if(awal>0){
            setAwal(awal-batas);
                if(tipe=="Semua"){
                    if(kata == ""){
                        controller.viewTabel();
                        pageTxt.setText(getTeks());
                    }else{
                        controller.searchTable(kata);
                        pageTxt.setText(getTeks());
                    }
                }else{
                    if(kata == ""){
                        controller.viewTipe(tipe);
                        pageTxt.setText(getTeks());
                    }else{
                        controller.searchTableTipe(kata, tipe);
                        pageTxt.setText(getTeks());
                    }
                }
            if(awal-batas<0){
                sblBtn.setEnabled(false);
            }
            selBtn.setEnabled(true);
        }else{
            sblBtn.setEnabled(false);
        }
    }//GEN-LAST:event_sblBtnActionPerformed

    private void cekBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBtnActionPerformed
        // TODO add your handling code here:
        controller.cek();
    }//GEN-LAST:event_cekBtnActionPerformed

    private void tentangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tentangBtnActionPerformed
        // TODO add your handling code here:
        new Tentang().show();
    }//GEN-LAST:event_tentangBtnActionPerformed

    private void tanggalComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tanggalComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalComponentShown

    private void jamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jamComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jamComponentShown

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalBtn;
    private javax.swing.JButton buatPesananBtn;
    private javax.swing.JButton cariBtn;
    private javax.swing.JTextField cariTxt;
    private javax.swing.JComboBox<String> cboTipeMenu;
    private javax.swing.JButton cekBtn;
    private javax.swing.JLabel deskLbl;
    private javax.swing.JLabel gambar;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JLabel hargaLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jam;
    private javax.swing.JTextField jumlahTxt;
    private javax.swing.JButton keluarbtn;
    private javax.swing.JButton menuBtn;
    private javax.swing.JTable menuTbl;
    private javax.swing.JLabel namaLbl;
    private javax.swing.JTextField namaPemesanTxt;
    private javax.swing.JTextField noPesanTxt;
    private javax.swing.JTextField pageTxt;
    private javax.swing.JButton pesanBtn;
    private javax.swing.JTable pesanTbl;
    private javax.swing.JButton pesananBtn;
    private javax.swing.JButton sblBtn;
    private javax.swing.JButton selBtn;
    private javax.swing.JLabel tanggal;
    private javax.swing.JButton tentangBtn;
    // End of variables declaration//GEN-END:variables
}

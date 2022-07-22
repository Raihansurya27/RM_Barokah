/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ui;

import Model.TheModel;
import Model.MenuModel;
import Dao.MenuDao;
import Controller.MenuController;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author LENOVO
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    MenuController controller;
    int batas = 3, jumlah, awal = 0;

    public Menu() throws SQLException, ClassNotFoundException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/gambar/Logo.png")).getImage());
        String tglsekarang;
        this.setTitle("Rumah Makan barokah - Halaman Menu");
        SimpleDateFormat format = new SimpleDateFormat("E, YYYY-MM-dd");
        tglsekarang = format.format(new Date());
        tanggalSekarang.setText(tglsekarang);
        setJam();
        controller = new MenuController(this);
        pageTxt.setEditable(false);
        kondisiAwal();
        populateJTable();
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

    public JTable getMenuTbl() {
        return menuTbl;
    }

    public void populateJTable() throws SQLException, ClassNotFoundException {
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        setJumlah(controller.jumlah());
        jumlahLbl.setText(String.valueOf(getJumlah()));
        ArrayList<MenuModel> list = dao.getAllMenu(k.getKoneksi(), getAwal(), getBatas());
        String[] columnName = {"Kode", "Nama Menu", "Tipe", "Harga", "Deskripsi", "Gambar"};
        Object[][] rows = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = "<HTML>" + list.get(i).getNama() + "</HTML>";
            rows[i][2] = list.get(i).getTipe();
            rows[i][3] = "Rp." + list.get(i).getHarga();
            rows[i][4] = "<HTML>" + list.get(i).getDesk() + "</HTML>";

            if (list.get(i).getGambar() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getGambar()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

                rows[i][5] = image;
            } else {
                rows[i][5] = null;
            }
        }
        if (jumlah <= batas) {
            selTbn.setEnabled(false);
        } else {
            selTbn.setEnabled(true);
        }
        pageTxt.setText((awal + 1) + " - " + (batas + awal));
        TheModel model = new TheModel(rows, columnName);
        menuTbl.setModel(model);
        ukuranTbl();
    }

    public void ukuranTbl() {
        menuTbl.setRowHeight(120);
        menuTbl.getColumnModel().getColumn(0).setPreferredWidth(10);
        menuTbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        menuTbl.getColumnModel().getColumn(2).setPreferredWidth(30);
        menuTbl.getColumnModel().getColumn(4).setPreferredWidth(30);
        menuTbl.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    public void selectionTable(String tipe) throws SQLException, ClassNotFoundException {
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        ArrayList<MenuModel> list = dao.getTipeMenu(k.getKoneksi(), tipe, getAwal(), getBatas());
        setJumlah(dao.countGetTipeMenu(k.getKoneksi(), tipe));
        jumlahLbl.setText(String.valueOf(getJumlah()));
        String[] columnName = {"Kode", "Nama Menu", "Tipe", "Harga", "Deskripsi", "Gambar"};
        Object[][] rows = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = "<HTML>" + list.get(i).getNama() + "</HTML>";
            rows[i][2] = list.get(i).getTipe();
            rows[i][3] = "Rp." + list.get(i).getHarga();
            rows[i][4] = "<HTML>" + list.get(i).getDesk() + "</HTML>";

            if (list.get(i).getGambar() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getGambar()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

                rows[i][5] = image;
            } else {
                rows[i][5] = null;
            }
        }
        if (jumlah <= batas) {
            selTbn.setEnabled(false);
        } else {
            selTbn.setEnabled(true);
        }
        pageTxt.setText((awal + 1) + " - " + (batas + awal));
        TheModel model = new TheModel(rows, columnName);
        menuTbl.setModel(model);
        ukuranTbl();
    }

    public void SearchTableTipe(String tipe, String kata) throws SQLException, ClassNotFoundException {
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        ArrayList<MenuModel> list = dao.getCariTipe(k.getKoneksi(), tipe, kata, getAwal(), getBatas());
        setJumlah(dao.countGetCariTipe(k.getKoneksi(), tipe, kata));
        jumlahLbl.setText(String.valueOf(getJumlah()));
        String[] columnName = {"Kode", "Nama Menu", "Tipe", "Harga", "Deskripsi", "Gambar"};
        Object[][] rows = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = "<HTML>" + list.get(i).getNama() + "</HTML>";
            rows[i][2] = list.get(i).getTipe();
            rows[i][3] = "Rp." + list.get(i).getHarga();
            rows[i][4] = "<HTML>" + list.get(i).getDesk() + "</HTML>";

            if (list.get(i).getGambar() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getGambar()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

                rows[i][5] = image;
            } else {
                rows[i][5] = null;
            }
        }
        if (jumlah <= batas) {
            selTbn.setEnabled(false);
        } else {
            selTbn.setEnabled(true);
        }
        pageTxt.setText((awal + 1) + " - " + (batas + awal));
        TheModel model = new TheModel(rows, columnName);
        menuTbl.setModel(model);
        ukuranTbl();
    }

    public void SearchTable(String kata) throws SQLException, ClassNotFoundException {
        MenuDao dao = new MenuDao();
        Koneksi k = new Koneksi();
        ArrayList<MenuModel> list = dao.getCariMenu(k.getKoneksi(), kata, getAwal(), getBatas());
        setJumlah(dao.countGetCariMenu(k.getKoneksi(), kata));
        jumlahLbl.setText(String.valueOf(getJumlah()));
        String[] columnName = {"Kode", "Nama Menu", "Tipe", "Harga", "Deskripsi", "Gambar"};
        Object[][] rows = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = "<HTML>" + list.get(i).getNama() + "</HTML>";
            rows[i][2] = list.get(i).getTipe();
            rows[i][3] = "Rp." + list.get(i).getHarga();
            rows[i][4] = "<HTML>" + list.get(i).getDesk() + "</HTML>";

            if (list.get(i).getGambar() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getGambar()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

                rows[i][5] = image;
            } else {
                rows[i][5] = null;
            }
        }
        if (jumlah <= batas) {
            selTbn.setEnabled(false);
        } else {
            selTbn.setEnabled(true);
        }
        pageTxt.setText((awal + 1) + " - " + (batas + awal));
        TheModel model = new TheModel(rows, columnName);
        menuTbl.setModel(model);
        ukuranTbl();
    }

    public void kondisiAwal() {
        setAwal(0);
        sebBtn.setEnabled(false);
    }

    public JComboBox<String> getCboTipemenu() {
        return cboTipemenu;
    }

    public int getBatas() {
        return batas;
    }

    public void setBatas(int batas) {
        this.batas = batas;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public JTextField getCariTxt() {
        return cariTxt;
    }

    public void setCariTxt(JTextField cariTxt) {
        this.cariTxt = cariTxt;
    }

    public int getAwal() {
        return awal;
    }

    public void setAwal(int awal) {
        this.awal = awal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tanggalSekarang = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        keluarBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        pesananMnBtn = new javax.swing.JButton();
        karyBtn = new javax.swing.JButton();
        dashboardBtn = new javax.swing.JButton();
        akunBtn = new javax.swing.JButton();
        tentangBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTbl = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        hapusBtn = new javax.swing.JButton();
        tambahBtn = new javax.swing.JButton();
        ubahBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboTipemenu = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jumlahLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cariTxt = new javax.swing.JTextField();
        cariBtn = new javax.swing.JButton();
        sebBtn = new javax.swing.JButton();
        pageTxt = new javax.swing.JTextField();
        selTbn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu");

        tanggalSekarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tanggalSekarang.setForeground(new java.awt.Color(255, 255, 255));
        tanggalSekarang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tanggalSekarang.setText("Tanggal");
        tanggalSekarang.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tanggalSekarangComponentShown(evt);
            }
        });

        jam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jam.setText("Jam");
        jam.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jamComponentShown(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 632, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggalSekarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jam))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tanggalSekarang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 80));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        keluarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        keluarBtn.setText("Keluar");
        keluarBtn.setMaximumSize(new java.awt.Dimension(91, 25));
        keluarBtn.setMinimumSize(new java.awt.Dimension(91, 25));
        keluarBtn.setPreferredSize(new java.awt.Dimension(91, 25));
        keluarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarBtnActionPerformed(evt);
            }
        });

        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        pesananMnBtn.setText("Pesanan");
        pesananMnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesananMnBtnActionPerformed(evt);
            }
        });

        karyBtn.setText("Karyawan");
        karyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karyBtnActionPerformed(evt);
            }
        });

        dashboardBtn.setText("Dashboard");
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        akunBtn.setText("Akun");
        akunBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akunBtnActionPerformed(evt);
            }
        });

        tentangBtn.setText("Tentang");
        tentangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tentangBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pesananMnBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(karyBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dashboardBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
            .addComponent(akunBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tentangBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(keluarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pesananMnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(karyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(akunBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tentangBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(keluarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 120, 440));

        menuTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama Menu", "Jenis", "Harga", "Deskripsi", "Gambar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(menuTbl);
        if (menuTbl.getColumnModel().getColumnCount() > 0) {
            menuTbl.getColumnModel().getColumn(0).setPreferredWidth(50);
            menuTbl.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 620, 330));

        refreshBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.setMaximumSize(new java.awt.Dimension(91, 25));
        refreshBtn.setMinimumSize(new java.awt.Dimension(91, 25));
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        getContentPane().add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 130, 40));

        hapusBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hapusBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/close_delete.png"))); // NOI18N
        hapusBtn.setText("Hapus");
        hapusBtn.setMaximumSize(new java.awt.Dimension(91, 25));
        hapusBtn.setMinimumSize(new java.awt.Dimension(91, 25));
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });
        getContentPane().add(hapusBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 130, 40));

        tambahBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tambahBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/plus.png"))); // NOI18N
        tambahBtn.setText("Tambah");
        tambahBtn.setMaximumSize(new java.awt.Dimension(91, 25));
        tambahBtn.setMinimumSize(new java.awt.Dimension(91, 25));
        tambahBtn.setPreferredSize(new java.awt.Dimension(91, 25));
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });
        getContentPane().add(tambahBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 130, 40));

        ubahBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ubahBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pencil_edit.png"))); // NOI18N
        ubahBtn.setText("Ubah");
        ubahBtn.setMaximumSize(new java.awt.Dimension(91, 25));
        ubahBtn.setMinimumSize(new java.awt.Dimension(91, 25));
        ubahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ubahBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 130, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Data Menu");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 40));
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        cboTipemenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTipemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipemenuActionPerformed(evt);
            }
        });
        getContentPane().add(cboTipemenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 180, 30));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jumlahLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jumlahLbl.setForeground(new java.awt.Color(255, 255, 255));
        jumlahLbl.setText("00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Menu");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jumlahLbl))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jumlahLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 120, 100));
        getContentPane().add(cariTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 170, 30));

        cariBtn.setText("Cari");
        cariBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cariBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, 30));

        sebBtn.setText("<<");
        sebBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sebBtnActionPerformed(evt);
            }
        });
        getContentPane().add(sebBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 80, -1));
        sebBtn.getAccessibleContext().setAccessibleDescription("");

        pageTxt.setEditable(false);
        pageTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(pageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 80, -1));

        selTbn.setText(">>");
        selTbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selTbnActionPerformed(evt);
            }
        });
        getContentPane().add(selTbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 80, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pesananMnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesananMnBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new PesananMn().show();
    }//GEN-LAST:event_pesananMnBtnActionPerformed

    private void karyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karyBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Kary().show();
    }//GEN-LAST:event_karyBtnActionPerformed

    private void tanggalSekarangComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tanggalSekarangComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_tanggalSekarangComponentShown

    private void keluarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login().show();
    }//GEN-LAST:event_keluarBtnActionPerformed

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
        // TODO add your handling code here:
        try {
            int row = this.getMenuTbl().getSelectedRow();
            String kode = this.getMenuTbl().getValueAt(row, 0).toString();
            int p = JOptionPane.showConfirmDialog(null, "Apakah yakin menghapus menu ini?", "Hapus Menu", JOptionPane.YES_NO_OPTION);
            if (p == 0) {
                controller.delete(kode);
                try {
                    populateJTable();
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Proses penghapusan menu gagal", "Hapus Menu", HEIGHT);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Pilih dahulu menu yang mau dihapus");
        }

    }//GEN-LAST:event_hapusBtnActionPerformed

    private void ubahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBtnActionPerformed
        // TODO add your handling code here:

        try {
            int row = this.getMenuTbl().getSelectedRow();
            String kode = this.getMenuTbl().getValueAt(row, 0).toString();
            MenuForm form = new MenuForm(kode);
            form.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Pilih dahulu menu sebelum diubah");
        }

    }//GEN-LAST:event_ubahBtnActionPerformed

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        // TODO add your handling code here:
        this.show();
        JOptionPane.showMessageDialog(rootPane, "Kamu sudah berada di Halaman Menu");
    }//GEN-LAST:event_menuBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Admin().show();
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        MenuForm form = new MenuForm();
        form.show();
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            // TODO add your handling code here:
            kondisiAwal();
            cariTxt.setText("");
            populateJTable();
            if (jumlah > batas) {
                selTbn.setEnabled(true);
            } else {
                selTbn.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void cboTipemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipemenuActionPerformed
        // TODO add your handling code here:
        if (controller != null) {
            kondisiAwal();
            cariTxt.setText("");
            controller.cboTipeAction();
            jumlahLbl.setText(String.valueOf(jumlah));
            pageTxt.setText((awal + 1) + " - " + (batas + awal));
            if (jumlah > batas) {
                selTbn.setEnabled(true);
            } else {
                selTbn.setEnabled(false);
            }
        }
    }//GEN-LAST:event_cboTipemenuActionPerformed

    private void akunBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akunBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Akun().show();
    }//GEN-LAST:event_akunBtnActionPerformed

    private void selTbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selTbnActionPerformed
        // TODO add your handling code here:
        String temp = getCboTipemenu().getSelectedItem().toString();
        String tipe = temp.split("-")[0];
        String kata = getCariTxt().getText();
        if (awal + batas < getJumlah()) {
            setAwal(awal + batas);
            try {
                if (tipe == "Semua") {
                    if (kata != "") {
                        SearchTable(kata);
                    } else {
                        populateJTable();
                    }
                } else {
                    if (kata != "") {
                        SearchTableTipe(tipe, kata);
                    } else {
                        selectionTable(tipe);
                    }
                }
                if (awal + batas < getJumlah()) {
                    selTbn.setEnabled(true);
                } else {
                    selTbn.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            selTbn.setEnabled(false);
        }
        sebBtn.setEnabled(true);
    }//GEN-LAST:event_selTbnActionPerformed

    private void sebBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sebBtnActionPerformed
        // TODO add your handling code here:
        String temp = getCboTipemenu().getSelectedItem().toString();
        String tipe = temp.split("-")[0];
        String kata = getCariTxt().getText();
        if (awal > 0) {
            setAwal(awal - batas);
            try {
                if (tipe == "Semua") {
                    if (kata != "") {
                        SearchTable(kata);
                    } else {
                        populateJTable();
                    }
                } else {
                    if (kata != "") {
                        SearchTableTipe(tipe, kata);
                    } else {
                        selectionTable(tipe);
                    }
                }
            } catch (Exception e) {

            }
            if (awal - batas < 0) {
                sebBtn.setEnabled(false);
            }
            selTbn.setEnabled(true);
        } else {
            sebBtn.setEnabled(false);
        }
    }//GEN-LAST:event_sebBtnActionPerformed

    private void cariBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBtnActionPerformed
        // TODO add your handling code here:
        kondisiAwal();
        if (!this.getCariTxt().getText().trim().isEmpty()) {
            String temp = getCboTipemenu().getSelectedItem().toString();
            String tipe = temp.split("-")[0];
            String kata = getCariTxt().getText();
            try {
                if (tipe == "Semua") {
                    SearchTable(kata);
                    if (jumlah > batas) {
                        selTbn.setEnabled(true);
                    } else {
                        selTbn.setEnabled(false);
                    }
                } else {
                    SearchTableTipe(tipe, kata);
                    if (jumlah > batas) {
                        selTbn.setEnabled(true);
                    } else {
                        selTbn.setEnabled(false);
                    }
                }
            } catch (Exception e) {

            }
        } else {
            JOptionPane.showMessageDialog(this, "Masukkan inputan/kata sebelum mencari");
        }
    }//GEN-LAST:event_cariBtnActionPerformed

    private void tentangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tentangBtnActionPerformed
        // TODO add your handling code here:
        new Tentang().show();
    }//GEN-LAST:event_tentangBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new Menu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton akunBtn;
    private javax.swing.JButton cariBtn;
    private javax.swing.JTextField cariTxt;
    private javax.swing.JComboBox<String> cboTipemenu;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jam;
    private javax.swing.JLabel jumlahLbl;
    private javax.swing.JButton karyBtn;
    private javax.swing.JButton keluarBtn;
    private javax.swing.JButton menuBtn;
    private javax.swing.JTable menuTbl;
    private javax.swing.JTextField pageTxt;
    private javax.swing.JButton pesananMnBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton sebBtn;
    private javax.swing.JButton selTbn;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JLabel tanggalSekarang;
    private javax.swing.JButton tentangBtn;
    private javax.swing.JButton ubahBtn;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tr_pbog;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.Timer;

/**
 *
 * @author Windows
 */
public class AdminDosenPage extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminDosenPage.class.getName());

    /**
     * Creates new form AdminDosenPage
     */
    private void setButtonIcon(javax.swing.JButton button, String path, int width, int height) {
        try {

            javax.swing.ImageIcon originalIcon = new javax.swing.ImageIcon(getClass().getResource(path));

            // Ubah ukuran ikon
            java.awt.Image originalImage = originalIcon.getImage();
            java.awt.Image resizedImage = originalImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);

            // menampilkan ikon baru yang sudah di-resize
            button.setIcon(new javax.swing.ImageIcon(resizedImage));

        } catch (Exception e) {
            System.err.println("Error loading icon: " + path);
            // Biarkan tombolnya tanpa ikon jika gambar tidak ditemukan
        }
    }
    public AdminDosenPage() {
        initComponents();
        setButtonIcon(dashboardBtn, "/image/dashboard.png", 24, 24);
        setButtonIcon(dosenBtn, "/image/teacher.png", 24, 24);
        setButtonIcon(mahasiswaBtn, "/image/graduated.png", 24, 24);
        setButtonIcon(matkulBtn, "/image/higher-education.png", 24, 24);
        setDarkMode(DarkMode.isDarkMode);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jScrollPane1.getViewport().setOpaque(false);
        // Set initial toggle state
        darkModeToggle.setSelected(DarkMode.isDarkMode);
        darkModeToggle.setText(DarkMode.isDarkMode ? "Light Mode" : "Dark Mode");
        cariButton.setForeground(Color.WHITE);
        tambahButton.setForeground(Color.WHITE);
        editButton.setForeground(Color.WHITE);
        hapusButton.setForeground(Color.WHITE);
        // Initialize date and time display
        initDateTime();
        initTableSize();
    }
    
    private void initTableSize(){
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        javax.swing.table.TableColumnModel cm = jTable2.getColumnModel();
        cm.getColumn(0).setPreferredWidth(30);  // No
        cm.getColumn(1).setPreferredWidth(100);  // NIDN
        cm.getColumn(2).setPreferredWidth(331); // Nama Dosen
        cm.getColumn(3).setPreferredWidth(250);  // Email
        cm.getColumn(4).setPreferredWidth(100);  // Progdi
        cm.getColumn(5).setPreferredWidth(140); // Status
        cm.getColumn(6).setPreferredWidth(120); //Aksi
    }
    
    private void initDateTime() {
        // lokalisasi Indonesia
        Locale localeIndonesia = Locale.of("id", "ID");

        //Format terpisah untuk setiap JLabel
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", localeIndonesia);
        DateTimeFormatter formatJam = DateTimeFormatter.ofPattern("HH:mm:ss");

        //Timer untuk memperbarui semuanya
        Timer timer = new Timer(1000, e -> {
            // Kode berjalan setiap 1 detik
            LocalDateTime now = LocalDateTime.now();

            // Terapkan teks ke label masing-masing
            dateLabel.setText(now.format(formatTanggal));
            clockLabel.setText(now.format(formatJam));
        });

        timer.start();
    }

    private void setDarkMode(boolean isDark) {
        if (isDark) {
            // Dark mode colors
            jPanel1.setBackground(new Color(38, 38, 40));
            jPanel2.setBackground(new Color(38, 38, 40));
            jPanel3.setForeground(Color.WHITE);
            sidebarMenuPanel.setBackground(new Color(50, 50, 52));
            headerPanel.setBackground(new Color(50, 50, 52));
            cariDosenLabel.setForeground(Color.WHITE);
            jTable2.setBackground(new Color(38, 38, 40));
            jTable2.setGridColor(Color.WHITE);
            jTable2.setForeground(Color.WHITE);
            navTitlePanel.setBackground(new Color(50, 50, 52));
            navTitle.setForeground(Color.WHITE);
            navTitlePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));


            manajemenAkunLabel.setForeground(Color.WHITE);
            manajemenAkademikLabel.setForeground(Color.WHITE);
            dateLabel.setForeground(Color.WHITE);
            clockLabel.setForeground(Color.WHITE);
            informationTitle.setForeground(Color.WHITE);
        } else {
            // Light mode colors
            jPanel1.setBackground(new Color(249, 248, 246));
            jPanel2.setBackground(new Color(249, 248, 246));
            sidebarMenuPanel.setBackground(new Color(239, 233, 227));
            headerPanel.setBackground(new Color(217, 207, 199));
            cariDosenLabel.setForeground(Color.BLACK);
            jTable2.setBackground(new Color(249, 248, 246));
            jTable2.setGridColor(Color.BLACK);
            jTable2.setForeground(Color.BLACK);
            navTitlePanel.setBackground(new Color(239, 233, 227));
            navTitle.setForeground(Color.BLACK);
            navTitlePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));


            manajemenAkunLabel.setForeground(Color.BLACK);
            manajemenAkademikLabel.setForeground(Color.BLACK);
            dateLabel.setForeground(Color.BLACK);
            clockLabel.setForeground(Color.BLACK);
            informationTitle.setForeground(Color.BLACK);
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

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        sidebarMenuPanel = new javax.swing.JPanel();
        navTitlePanel = new javax.swing.JPanel();
        navTitle = new javax.swing.JLabel();
        dashboardBtn = new javax.swing.JButton();
        manajemenAkunLabel = new javax.swing.JLabel();
        dosenBtn = new javax.swing.JButton();
        mahasiswaBtn = new javax.swing.JButton();
        manajemenAkademikLabel = new javax.swing.JLabel();
        matkulBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        darkModeToggle = new javax.swing.JToggleButton();
        headerPanel = new javax.swing.JPanel();
        siasatLogo = new com.mycompany.tr_pbog.ScalableIconLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        clockLabel = new javax.swing.JLabel();
        informationTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tambahButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        cariDosenLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        cariButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new java.awt.BorderLayout());

        sidebarMenuPanel.setPreferredSize(new java.awt.Dimension(200, 100));

        navTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        navTitlePanel.setOpaque(false);
        navTitlePanel.setPreferredSize(new java.awt.Dimension(200, 50));

        navTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle.setText("Navigation");

        javax.swing.GroupLayout navTitlePanelLayout = new javax.swing.GroupLayout(navTitlePanel);
        navTitlePanel.setLayout(navTitlePanelLayout);
        navTitlePanelLayout.setHorizontalGroup(
            navTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        navTitlePanelLayout.setVerticalGroup(
            navTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navTitle)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        dashboardBtn.setText("Dashboard");
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        manajemenAkunLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manajemenAkunLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manajemenAkunLabel.setText("Manajemen Akun");
        manajemenAkunLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        dosenBtn.setText("Dosen");
        dosenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosenBtnActionPerformed(evt);
            }
        });

        mahasiswaBtn.setText("Mahasiswa");
        mahasiswaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mahasiswaBtnActionPerformed(evt);
            }
        });

        manajemenAkademikLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manajemenAkademikLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manajemenAkademikLabel.setText("Manajemen Akademik");

        matkulBtn.setText("Kelola Matkul");
        matkulBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matkulBtnActionPerformed(evt);
            }
        });

        logoutBtn.setText("Log Out");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        darkModeToggle.setText("Dark Mode");
        darkModeToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkModeToggleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarMenuPanelLayout = new javax.swing.GroupLayout(sidebarMenuPanel);
        sidebarMenuPanel.setLayout(sidebarMenuPanelLayout);
        sidebarMenuPanelLayout.setHorizontalGroup(
            sidebarMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboardBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(manajemenAkunLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dosenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mahasiswaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(manajemenAkademikLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(matkulBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(sidebarMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(darkModeToggle))
            .addComponent(navTitlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidebarMenuPanelLayout.setVerticalGroup(
            sidebarMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarMenuPanelLayout.createSequentialGroup()
                .addComponent(navTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(manajemenAkunLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(dosenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(mahasiswaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(manajemenAkademikLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(matkulBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(darkModeToggle)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jPanel1.add(sidebarMenuPanel, java.awt.BorderLayout.WEST);

        headerPanel.setBackground(new java.awt.Color(204, 255, 204));

        siasatLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/siasat.png"))); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(siasatLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(siasatLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setToolTipText("");
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setOpaque(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "67096", "PRATYAKSA OCSA N. SAIAN", "pratyaksa.ocsa@uksw.edu", "S1 TI", "Aktif", null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "NIDN", "Dosen", "Email", "Program Studi", "Status", "Aksi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setShowGrid(true);
        jScrollPane1.setViewportView(jTable2);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel6.setOpaque(false);

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setText("dateLabel");
        dateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        clockLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clockLabel.setText("clockLabel");

        informationTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        informationTitle.setText("Data Dosen");

        jPanel3.setOpaque(false);

        tambahButton.setBackground(new java.awt.Color(0, 204, 0));
        tambahButton.setText("Tambah Dosen");
        tambahButton.setActionCommand("tambahDosen");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(0, 0, 255));
        editButton.setText("Edit Dosen");
        editButton.setActionCommand("editDosen");

        hapusButton.setBackground(new java.awt.Color(255, 0, 0));
        hapusButton.setText("Hapus Dosen");
        hapusButton.setActionCommand("hapusDosen");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahButton)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cariDosenLabel.setText("Cari Dosen :");

        jTextField1.setText("Cari Nama");
        jTextField1.setActionCommand("Search");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S1 TI", "DKV", "SI", "BD" }));
        jComboBox1.setActionCommand("List");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        cariButton.setBackground(new java.awt.Color(0, 0, 255));
        cariButton.setText("Cari");
        cariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(informationTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cariDosenLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cariButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(833, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(informationTitle)
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariDosenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dateLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(clockLabel)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void darkModeToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkModeToggleActionPerformed
        // TODO add your handling code here:
        boolean isDark = darkModeToggle.isSelected();

        // Update global state
        DarkMode.isDarkMode = isDark;

        // Update button text
        darkModeToggle.setText(isDark ? "Light Mode" : "Dark Mode");

        // Apply dark mode to UI
        setDarkMode(isDark);
    }//GEN-LAST:event_darkModeToggleActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        loginPage login = new loginPage();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void matkulBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matkulBtnActionPerformed
        // TODO add your handling code here:
        AdminKelasPage MahasiswaPage = new AdminKelasPage();
        MahasiswaPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_matkulBtnActionPerformed

    private void mahasiswaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mahasiswaBtnActionPerformed
        // TODO add your handling code here:
        AdminMahasiswaPage MahasiswaPage = new AdminMahasiswaPage();
        MahasiswaPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mahasiswaBtnActionPerformed

    private void dosenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosenBtnActionPerformed
        AdminDosenPage dosenPage = new AdminDosenPage();
        dosenPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dosenBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        AdminHomePage adminPage = new AdminHomePage();
        adminPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AdminDosenPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariButton;
    private javax.swing.JLabel cariDosenLabel;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JToggleButton darkModeToggle;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton dosenBtn;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel informationTitle;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton mahasiswaBtn;
    private javax.swing.JLabel manajemenAkademikLabel;
    private javax.swing.JLabel manajemenAkunLabel;
    private javax.swing.JButton matkulBtn;
    private javax.swing.JLabel navTitle;
    private javax.swing.JPanel navTitlePanel;
    private javax.swing.JLabel siasatLogo;
    private javax.swing.JPanel sidebarMenuPanel;
    private javax.swing.JButton tambahButton;
    // End of variables declaration//GEN-END:variables
}

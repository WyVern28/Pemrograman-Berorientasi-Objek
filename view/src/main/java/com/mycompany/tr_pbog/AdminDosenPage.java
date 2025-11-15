/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tr_pbog;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
    public AdminDosenPage() {
        initComponents();
        setDarkMode(DarkMode.isDarkMode);

        // Set initial toggle state
        darkModeToggle.setSelected(DarkMode.isDarkMode);
        darkModeToggle.setText(DarkMode.isDarkMode ? "Light Mode" : "Dark Mode");

        // Initialize date and time display
        initDateTime();
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
            sidebarMenuPanel.setBackground(new Color(50, 50, 52));
            headerPanel.setBackground(new Color(50, 50, 52));
            navTitlePanel.setBackground(new Color(50, 50, 52));

            // Set all navTitle labels to white
            navTitle1.setForeground(Color.WHITE);
            navTitle2.setForeground(Color.WHITE);
            navTitle3.setForeground(Color.WHITE);
            navTitle4.setForeground(Color.WHITE);
            navTitle5.setForeground(Color.WHITE);
            navTitle6.setForeground(Color.WHITE);
            navTitle7.setForeground(Color.WHITE);
            navTitle8.setForeground(Color.WHITE);
            navTitle9.setForeground(Color.WHITE);
            navTitle10.setForeground(Color.WHITE);
            navTitle11.setForeground(Color.WHITE);
            navTitle12.setForeground(Color.WHITE);
            navTitle13.setForeground(Color.WHITE);
            navTitle14.setForeground(Color.WHITE);
            navTitle15.setForeground(Color.WHITE);
            navTitle16.setForeground(Color.WHITE);
            navTitle17.setForeground(Color.WHITE);
            navTitle18.setForeground(Color.WHITE);
            navTitle19.setForeground(Color.WHITE);
            navTitle20.setForeground(Color.WHITE);
            navTitle21.setForeground(Color.WHITE);
            navTitle22.setForeground(Color.WHITE);
            navTitle23.setForeground(Color.WHITE);
            navTitle24.setForeground(Color.WHITE);
            navTitle25.setForeground(Color.WHITE);
            navTitle26.setForeground(Color.WHITE);
            navTitle27.setForeground(Color.WHITE);
            navTitle28.setForeground(Color.WHITE);
            navTitle29.setForeground(Color.WHITE);
            navTitle30.setForeground(Color.WHITE);

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
            navTitlePanel.setBackground(new Color(239, 233, 227));

            // Set all navTitle labels to black
            navTitle1.setForeground(Color.BLACK);
            navTitle2.setForeground(Color.BLACK);
            navTitle3.setForeground(Color.BLACK);
            navTitle4.setForeground(Color.BLACK);
            navTitle5.setForeground(Color.BLACK);
            navTitle6.setForeground(Color.BLACK);
            navTitle7.setForeground(Color.BLACK);
            navTitle8.setForeground(Color.BLACK);
            navTitle9.setForeground(Color.BLACK);
            navTitle10.setForeground(Color.BLACK);
            navTitle11.setForeground(Color.BLACK);
            navTitle12.setForeground(Color.BLACK);
            navTitle13.setForeground(Color.BLACK);
            navTitle14.setForeground(Color.BLACK);
            navTitle15.setForeground(Color.BLACK);
            navTitle16.setForeground(Color.BLACK);
            navTitle17.setForeground(Color.BLACK);
            navTitle18.setForeground(Color.BLACK);
            navTitle19.setForeground(Color.BLACK);
            navTitle20.setForeground(Color.BLACK);
            navTitle21.setForeground(Color.BLACK);
            navTitle22.setForeground(Color.BLACK);
            navTitle23.setForeground(Color.BLACK);
            navTitle24.setForeground(Color.BLACK);
            navTitle25.setForeground(Color.BLACK);
            navTitle26.setForeground(Color.BLACK);
            navTitle27.setForeground(Color.BLACK);
            navTitle28.setForeground(Color.BLACK);
            navTitle29.setForeground(Color.BLACK);
            navTitle30.setForeground(Color.BLACK);

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
        jPanel1 = new javax.swing.JPanel();
        sidebarMenuPanel = new javax.swing.JPanel();
        dashboardBtn = new javax.swing.JButton();
        manajemenAkunLabel = new javax.swing.JLabel();
        dosenBtn = new javax.swing.JButton();
        mahasiswaBtn = new javax.swing.JButton();
        manajemenAkademikLabel = new javax.swing.JLabel();
        matkulBtn = new javax.swing.JButton();
        bukaRegisBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        darkModeToggle = new javax.swing.JToggleButton();
        headerPanel = new javax.swing.JPanel();
        siasatLogo = new com.mycompany.tr_pbog.ScalableIconLabel();
        navTitlePanel = new javax.swing.JPanel();
        navTitle1 = new javax.swing.JLabel();
        navTitle2 = new javax.swing.JLabel();
        navTitle3 = new javax.swing.JLabel();
        navTitle4 = new javax.swing.JLabel();
        navTitle5 = new javax.swing.JLabel();
        navTitle6 = new javax.swing.JLabel();
        navTitle7 = new javax.swing.JLabel();
        navTitle8 = new javax.swing.JLabel();
        navTitle9 = new javax.swing.JLabel();
        navTitle10 = new javax.swing.JLabel();
        navTitle11 = new javax.swing.JLabel();
        navTitle12 = new javax.swing.JLabel();
        navTitle13 = new javax.swing.JLabel();
        navTitle14 = new javax.swing.JLabel();
        navTitle15 = new javax.swing.JLabel();
        navTitle16 = new javax.swing.JLabel();
        navTitle17 = new javax.swing.JLabel();
        navTitle18 = new javax.swing.JLabel();
        navTitle19 = new javax.swing.JLabel();
        navTitle20 = new javax.swing.JLabel();
        navTitle21 = new javax.swing.JLabel();
        navTitle22 = new javax.swing.JLabel();
        navTitle23 = new javax.swing.JLabel();
        navTitle24 = new javax.swing.JLabel();
        navTitle25 = new javax.swing.JLabel();
        navTitle26 = new javax.swing.JLabel();
        navTitle27 = new javax.swing.JLabel();
        navTitle28 = new javax.swing.JLabel();
        navTitle29 = new javax.swing.JLabel();
        navTitle30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        clockLabel = new javax.swing.JLabel();
        informationTitle = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebarMenuPanel.setPreferredSize(new java.awt.Dimension(200, 100));

        dashboardBtn.setText("Dashboard");
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        manajemenAkunLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manajemenAkunLabel.setText("Manajemen Akun");

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
        manajemenAkademikLabel.setText("Manajemen Akademik");

        matkulBtn.setText("Kelola Matkul");
        matkulBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matkulBtnActionPerformed(evt);
            }
        });

        bukaRegisBtn.setText("Buka Registrasi");

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
            .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(manajemenAkunLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dosenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mahasiswaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(manajemenAkademikLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(matkulBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bukaRegisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(sidebarMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(darkModeToggle))
        );
        sidebarMenuPanelLayout.setVerticalGroup(
            sidebarMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarMenuPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
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
                .addGap(2, 2, 2)
                .addComponent(bukaRegisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(darkModeToggle)
                .addContainerGap(154, Short.MAX_VALUE))
        );

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

        navTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        navTitlePanel.setOpaque(false);
        navTitlePanel.setPreferredSize(new java.awt.Dimension(200, 50));

        navTitle1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle1.setText("Navigation");

        navTitle2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle2.setText("Navigation");

        navTitle3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle3.setText("Navigation");

        navTitle4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle4.setText("Navigation");

        navTitle5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle5.setText("Navigation");

        navTitle6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle6.setText("Navigation");

        navTitle7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle7.setText("Navigation");

        navTitle8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle8.setText("Navigation");

        navTitle9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle9.setText("Navigation");

        navTitle10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle10.setText("Navigation");

        navTitle11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle11.setText("Navigation");

        navTitle12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle12.setText("Navigation");

        navTitle13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle13.setText("Navigation");

        navTitle14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle14.setText("Navigation");

        navTitle15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle15.setText("Navigation");

        navTitle16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle16.setText("Navigation");

        navTitle17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle17.setText("Navigation");

        navTitle18.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle18.setText("Navigation");

        navTitle19.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle19.setText("Navigation");

        navTitle20.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle20.setText("Navigation");

        navTitle21.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle21.setText("Navigation");

        navTitle22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle22.setText("Navigation");

        navTitle23.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle23.setText("Navigation");

        navTitle24.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle24.setText("Navigation");

        navTitle25.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle25.setText("Navigation");

        navTitle26.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle26.setText("Navigation");

        navTitle27.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle27.setText("Navigation");

        navTitle28.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle28.setText("Navigation");

        navTitle29.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle29.setText("Navigation");

        navTitle30.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        navTitle30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navTitle30.setText("Navigation");

        javax.swing.GroupLayout navTitlePanelLayout = new javax.swing.GroupLayout(navTitlePanel);
        navTitlePanel.setLayout(navTitlePanelLayout);
        navTitlePanelLayout.setHorizontalGroup(
            navTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle5, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle6, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle7, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle8, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle9, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle10, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle11, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle12, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle13, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle14, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle15, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle16, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle17, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle18, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle19, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle20, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle21, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle22, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle23, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle24, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle25, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle26, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle27, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle28, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle29, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(navTitle30, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        navTitlePanelLayout.setVerticalGroup(
            navTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navTitlePanelLayout.createSequentialGroup()
                .addComponent(navTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navTitle30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navTitle11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navTitle10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navTitle7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navTitle6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navTitle5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navTitle4))
        );

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setText("dateLabel");
        dateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        clockLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clockLabel.setText("clockLabel");

        informationTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        informationTitle.setText("Informasi Universitas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(clockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(informationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 517, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clockLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationTitle)
                .addGap(0, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidebarMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(894, Short.MAX_VALUE))
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(navTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sidebarMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    }//GEN-LAST:event_matkulBtnActionPerformed

    private void mahasiswaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mahasiswaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mahasiswaBtnActionPerformed

    private void dosenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosenBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dosenBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardBtnActionPerformed

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
    private javax.swing.JButton bukaRegisBtn;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JToggleButton darkModeToggle;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton dosenBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel informationTitle;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton mahasiswaBtn;
    private javax.swing.JLabel manajemenAkademikLabel;
    private javax.swing.JLabel manajemenAkunLabel;
    private javax.swing.JButton matkulBtn;
    private javax.swing.JLabel navTitle1;
    private javax.swing.JLabel navTitle10;
    private javax.swing.JLabel navTitle11;
    private javax.swing.JLabel navTitle12;
    private javax.swing.JLabel navTitle13;
    private javax.swing.JLabel navTitle14;
    private javax.swing.JLabel navTitle15;
    private javax.swing.JLabel navTitle16;
    private javax.swing.JLabel navTitle17;
    private javax.swing.JLabel navTitle18;
    private javax.swing.JLabel navTitle19;
    private javax.swing.JLabel navTitle2;
    private javax.swing.JLabel navTitle20;
    private javax.swing.JLabel navTitle21;
    private javax.swing.JLabel navTitle22;
    private javax.swing.JLabel navTitle23;
    private javax.swing.JLabel navTitle24;
    private javax.swing.JLabel navTitle25;
    private javax.swing.JLabel navTitle26;
    private javax.swing.JLabel navTitle27;
    private javax.swing.JLabel navTitle28;
    private javax.swing.JLabel navTitle29;
    private javax.swing.JLabel navTitle3;
    private javax.swing.JLabel navTitle30;
    private javax.swing.JLabel navTitle4;
    private javax.swing.JLabel navTitle5;
    private javax.swing.JLabel navTitle6;
    private javax.swing.JLabel navTitle7;
    private javax.swing.JLabel navTitle8;
    private javax.swing.JLabel navTitle9;
    private javax.swing.JPanel navTitlePanel;
    private javax.swing.JLabel siasatLogo;
    private javax.swing.JPanel sidebarMenuPanel;
    // End of variables declaration//GEN-END:variables
}

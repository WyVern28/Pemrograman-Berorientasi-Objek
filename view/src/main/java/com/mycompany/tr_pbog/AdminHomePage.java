package com.mycompany.tr_pbog;

import java.awt.Color;
import javax.swing.JFrame;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.Timer;
import javax.swing.BorderFactory;

public class AdminHomePage extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminHomePage.class.getName());

    /**
     * Creates new form DosenHomePage
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
    public AdminHomePage() {
        initComponents();
        setDarkMode(DarkMode.isDarkMode);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setButtonIcon(dashboardBtn, "/image/dashboard.png", 24, 24);
        setButtonIcon(dosenBtn, "/image/teacher.png", 24, 24);
        setButtonIcon(mahasiswaBtn, "/image/graduated.png", 24, 24);
        setButtonIcon(matkulBtn, "/image/higher-education.png", 24, 24);
        setButtonIcon(bukaRegisBtn, "/image/digital-signature.png", 24, 24);
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
        
        if(isDark){
            navTitlePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
            informationPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
            BackPanel.setBackground(new Color(38, 38, 40));
            headerPanel.setBackground(new Color(50, 50, 52));
            mainPanel.setBackground(new Color(38, 38, 40));
            sidebarPanel.setBackground(new Color(50, 50, 52));
            navTitlePanel.setBackground(new Color(50, 50, 52));
            sidebarMenuPanel.setBackground(new Color(50, 50, 52));
            navTitle.setForeground(Color.WHITE);
            mainPanel.setForeground(Color.WHITE);
            dateLabel.setForeground(Color.WHITE);
            clockLabel.setForeground(Color.WHITE);
            manajemenAkunLabel.setForeground(Color.WHITE);
            manajemenAkademikLabel.setForeground(Color.WHITE);
            informationTitle.setForeground(Color.WHITE);
            jumlahDosenTitle.setForeground(Color.WHITE);
            jumlahMahasiswaTitle.setForeground(Color.WHITE);
            jumlahKelasTitle.setForeground(Color.WHITE);
            jumlahDosen.setForeground(Color.WHITE);
            jumlahMahasiswa.setForeground(Color.WHITE);
            jumlahKelas.setForeground(Color.WHITE);
            jumlahDosenPanel.setBackground(new Color(50, 50, 52));
            jumlahMahasiswaPanel.setBackground(new Color(50, 50, 52));
            jumlahKelasPanel.setBackground(new Color(50, 50, 52));
            jalanPintasTitle.setForeground(Color.WHITE);
        }else{
            navTitlePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            
            informationPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            BackPanel.setBackground(new Color(249, 248, 246));
            headerPanel.setBackground(new Color(217, 207, 199));
            mainPanel.setBackground(new Color(249, 248, 246));
            sidebarPanel.setBackground(new Color(239, 233, 227));
            navTitlePanel.setBackground(new Color(239, 233, 227));
            sidebarMenuPanel.setBackground(new Color(239, 233, 227));
            navTitle.setForeground(Color.BLACK);
            mainPanel.setForeground(Color.BLACK);
            dateLabel.setForeground(Color.BLACK);
            clockLabel.setForeground(Color.BLACK);
            informationTitle.setForeground(Color.BLACK);
            jumlahDosenTitle.setForeground(Color.BLACK);
            jumlahMahasiswaTitle.setForeground(Color.BLACK);
            jumlahKelasTitle.setForeground(Color.BLACK);
            jumlahDosen.setForeground(Color.BLACK);
            jumlahMahasiswa.setForeground(Color.BLACK);
            jumlahKelas.setForeground(Color.BLACK);
            jumlahDosenPanel.setBackground(new Color(239, 233, 227));
            jumlahMahasiswaPanel.setBackground(new Color(239, 233, 227));
            jumlahKelasPanel.setBackground(new Color(239, 233, 227));
            manajemenAkunLabel.setForeground(Color.BLACK);
            manajemenAkademikLabel.setForeground(Color.BLACK);
            jalanPintasTitle.setForeground(Color.BLACK);
            
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

        BackPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        siasatLogo = new com.mycompany.tr_pbog.ScalableIconLabel();
        sidebarPanel = new javax.swing.JPanel();
        navTitlePanel = new javax.swing.JPanel();
        navTitle = new javax.swing.JLabel();
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
        mainPanel = new javax.swing.JPanel();
        informationPanel = new javax.swing.JPanel();
        informationTitle = new javax.swing.JLabel();
        jumlahDosenPanel = new javax.swing.JPanel();
        jumlahDosenTitle = new javax.swing.JLabel();
        jumlahDosen = new javax.swing.JLabel();
        jumlahMahasiswaPanel = new javax.swing.JPanel();
        jumlahMahasiswaTitle = new javax.swing.JLabel();
        jumlahMahasiswa = new javax.swing.JLabel();
        jumlahKelasPanel = new javax.swing.JPanel();
        jumlahKelasTitle = new javax.swing.JLabel();
        jumlahKelas = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        clockLabel = new javax.swing.JLabel();
        jalanPintasTitle = new javax.swing.JLabel();
        shortcut1 = new javax.swing.JButton();
        shortcut2 = new javax.swing.JButton();
        shortcut3 = new javax.swing.JButton();
        shortcut4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        BackPanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(204, 255, 204));

        siasatLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/siasat.png"))); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(siasatLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1064, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(siasatLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BackPanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        sidebarPanel.setBackground(new java.awt.Color(0, 255, 255));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(200, 338));
        sidebarPanel.setLayout(new java.awt.BorderLayout());

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
            .addComponent(navTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        navTitlePanelLayout.setVerticalGroup(
            navTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidebarPanel.add(navTitlePanel, java.awt.BorderLayout.PAGE_START);

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
                .addContainerGap())
        );

        sidebarPanel.add(sidebarMenuPanel, java.awt.BorderLayout.CENTER);

        BackPanel.add(sidebarPanel, java.awt.BorderLayout.WEST);

        mainPanel.setBackground(new java.awt.Color(51, 255, 51));

        informationPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        informationPanel.setOpaque(false);

        informationTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        informationTitle.setText("Informasi Universitas");

        jumlahDosenPanel.setBackground(new java.awt.Color(255, 255, 0));
        jumlahDosenPanel.setPreferredSize(new java.awt.Dimension(155, 95));

        jumlahDosenTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jumlahDosenTitle.setText("Dosen Aktif");

        jumlahDosen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jumlahDosen.setText("[Jumlah Dosen]");

        javax.swing.GroupLayout jumlahDosenPanelLayout = new javax.swing.GroupLayout(jumlahDosenPanel);
        jumlahDosenPanel.setLayout(jumlahDosenPanelLayout);
        jumlahDosenPanelLayout.setHorizontalGroup(
            jumlahDosenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumlahDosenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jumlahDosenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahDosenTitle)
                    .addComponent(jumlahDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jumlahDosenPanelLayout.setVerticalGroup(
            jumlahDosenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumlahDosenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jumlahDosenTitle)
                .addGap(18, 18, 18)
                .addComponent(jumlahDosen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jumlahMahasiswaPanel.setBackground(new java.awt.Color(255, 255, 0));
        jumlahMahasiswaPanel.setPreferredSize(new java.awt.Dimension(155, 95));

        jumlahMahasiswaTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jumlahMahasiswaTitle.setText("Mahasiswa Aktif");

        jumlahMahasiswa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jumlahMahasiswa.setText("[Jumlah Mahasiswa]");

        javax.swing.GroupLayout jumlahMahasiswaPanelLayout = new javax.swing.GroupLayout(jumlahMahasiswaPanel);
        jumlahMahasiswaPanel.setLayout(jumlahMahasiswaPanelLayout);
        jumlahMahasiswaPanelLayout.setHorizontalGroup(
            jumlahMahasiswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumlahMahasiswaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jumlahMahasiswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahMahasiswaTitle)
                    .addComponent(jumlahMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jumlahMahasiswaPanelLayout.setVerticalGroup(
            jumlahMahasiswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumlahMahasiswaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jumlahMahasiswaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jumlahMahasiswa)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jumlahKelasPanel.setBackground(new java.awt.Color(255, 255, 0));
        jumlahKelasPanel.setPreferredSize(new java.awt.Dimension(155, 0));

        jumlahKelasTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jumlahKelasTitle.setText("Matkul Semester Ini");

        jumlahKelas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jumlahKelas.setText("[Jumlah Matkul]");

        javax.swing.GroupLayout jumlahKelasPanelLayout = new javax.swing.GroupLayout(jumlahKelasPanel);
        jumlahKelasPanel.setLayout(jumlahKelasPanelLayout);
        jumlahKelasPanelLayout.setHorizontalGroup(
            jumlahKelasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumlahKelasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jumlahKelasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahKelasTitle)
                    .addComponent(jumlahKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jumlahKelasPanelLayout.setVerticalGroup(
            jumlahKelasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumlahKelasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jumlahKelasTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jumlahKelas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(jumlahDosenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jumlahMahasiswaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jumlahKelasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(573, Short.MAX_VALUE))
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationTitle)
                .addGap(24, 24, 24)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahKelasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, informationPanelLayout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jumlahDosenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setText("dateLabel");
        dateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        clockLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clockLabel.setText("clockLabel");

        jalanPintasTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jalanPintasTitle.setText("Jalan Pintas");

        shortcut1.setText("+ Tambah Dosen");
        shortcut1.setPreferredSize(new java.awt.Dimension(153, 23));
        shortcut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortcut1ActionPerformed(evt);
            }
        });

        shortcut2.setText("+ Tambah Mahasiswa");
        shortcut2.setPreferredSize(new java.awt.Dimension(153, 23));
        shortcut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortcut2ActionPerformed(evt);
            }
        });

        shortcut3.setText("+ Buat Kelas");
        shortcut3.setPreferredSize(new java.awt.Dimension(153, 23));
        shortcut3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortcut3ActionPerformed(evt);
            }
        });

        shortcut4.setText("Buka / Tutup Registrasi");
        shortcut4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortcut4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jalanPintasTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shortcut1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shortcut3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shortcut2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shortcut4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(dateLabel)
                .addGap(4, 4, 4)
                .addComponent(clockLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jalanPintasTitle)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shortcut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shortcut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shortcut3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shortcut4))
                .addContainerGap(288, Short.MAX_VALUE))
        );

        BackPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    
    private void dosenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosenBtnActionPerformed
        AdminDosenPage dosenPage = new AdminDosenPage();
        dosenPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dosenBtnActionPerformed

    private void darkModeToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkModeToggleActionPerformed
        // TODO add your handling code here:
        setDarkMode(darkModeToggle.isSelected());
        DarkMode.isDarkMode = darkModeToggle.isSelected();

        if (darkModeToggle.isSelected()) {
            darkModeToggle.setText("Light Mode");
        } else {
            darkModeToggle.setText("Dark Mode");
        }
    }//GEN-LAST:event_darkModeToggleActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void mahasiswaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mahasiswaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mahasiswaBtnActionPerformed

    private void matkulBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matkulBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matkulBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        loginPage login = new loginPage();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void shortcut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortcut1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shortcut1ActionPerformed

    private void shortcut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortcut2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shortcut2ActionPerformed

    private void shortcut3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortcut3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shortcut3ActionPerformed

    private void shortcut4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortcut4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shortcut4ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new AdminHomePage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackPanel;
    private javax.swing.JButton bukaRegisBtn;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JToggleButton darkModeToggle;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton dosenBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JLabel informationTitle;
    private javax.swing.JLabel jalanPintasTitle;
    private javax.swing.JLabel jumlahDosen;
    private javax.swing.JPanel jumlahDosenPanel;
    private javax.swing.JLabel jumlahDosenTitle;
    private javax.swing.JLabel jumlahKelas;
    private javax.swing.JPanel jumlahKelasPanel;
    private javax.swing.JLabel jumlahKelasTitle;
    private javax.swing.JLabel jumlahMahasiswa;
    private javax.swing.JPanel jumlahMahasiswaPanel;
    private javax.swing.JLabel jumlahMahasiswaTitle;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton mahasiswaBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel manajemenAkademikLabel;
    private javax.swing.JLabel manajemenAkunLabel;
    private javax.swing.JButton matkulBtn;
    private javax.swing.JLabel navTitle;
    private javax.swing.JPanel navTitlePanel;
    private javax.swing.JButton shortcut1;
    private javax.swing.JButton shortcut2;
    private javax.swing.JButton shortcut3;
    private javax.swing.JButton shortcut4;
    private javax.swing.JLabel siasatLogo;
    private javax.swing.JPanel sidebarMenuPanel;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration//GEN-END:variables
}

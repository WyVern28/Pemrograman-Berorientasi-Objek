/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tr_pbog.admin;

import com.mycompany.tr_pbog.DarkMode;
import com.mycompany.tr_pbog.DarkMode.Listener;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import dbCon.Kelas;
import dbCon.Dosen;
import dbCon.Matkul;
import dbCon.db_config;
import repo.KelasRepository;
import repo.DosenRepository;
import repo.MatkulRepository;

/**
 *
 * @author Made
 */
public class AdminKelasPanel extends javax.swing.JPanel implements Listener{

    /**
     * Creates new form AdminKelasPanel
     */
    public AdminKelasPanel() {
        initComponents();
        initTableSize();
        initDateTime();
        jScrollPane1.getViewport().setOpaque(false);
        setDarkMode(DarkMode.isDarkMode);
        loadKelasData();
    }

    private void loadKelasData() {
        String sql = """
            SELECT
                k.id_kelas, k.nama_kelas, d.name as nama_dosen,
                m.id_prodi, j.id_ruangan, j.hari, j.jam_mulai, j.jam_selesai
            FROM kelas k
            INNER JOIN dosen d ON k.nid = d.nid
            INNER JOIN matkul m ON k.id_matkul = m.id_matkul
            LEFT JOIN jadwal_kelas j ON k.id_kelas = j.id_kelas
            """;

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet res = prep.executeQuery()) {

            int no = 1;
            while (res.next()) {
                Object[] row = {
                    no++,
                    res.getString("id_kelas"),
                    res.getString("nama_kelas"),
                    res.getString("nama_dosen"),
                    res.getString("id_prodi"),
                    res.getString("id_ruangan") != null ? res.getString("id_ruangan") : "-",
                    res.getString("hari") != null ? res.getString("hari") : "-",
                    res.getString("jam_mulai") != null ? res.getString("jam_mulai") : "-",
                    res.getString("jam_selesai") != null ? res.getString("jam_selesai") : "-"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal memuat data kelas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshTable() {
        loadKelasData();
    }

    private void initTableSize(){
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        javax.swing.table.TableColumnModel cm = jTable2.getColumnModel();
        cm.getColumn(0).setPreferredWidth(30);  // No
        cm.getColumn(1).setPreferredWidth(100);  // Kode Kelas
        cm.getColumn(2).setPreferredWidth(281); // Nama Kelas
        cm.getColumn(3).setPreferredWidth(220);  // Nama Dosen
        cm.getColumn(4).setPreferredWidth(100);  // Progdi
        cm.getColumn(5).setPreferredWidth(100); // Ruang
        cm.getColumn(6).setPreferredWidth(90); //Hari
        cm.getColumn(7).setPreferredWidth(75); //Jam Mulai
        cm.getColumn(8).setPreferredWidth(75); //Jam Selesai
    }
    
    private void initDateTime() {
        Locale localeIndonesia = Locale.of("id", "ID");

        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", localeIndonesia);
        DateTimeFormatter formatJam = DateTimeFormatter.ofPattern("HH:mm:ss");

        Timer timer = new Timer(1000, e -> {
            LocalDateTime now = LocalDateTime.now();

            dateLabel.setText(now.format(formatTanggal));
            clockLabel.setText(now.format(formatJam));
        });

        timer.start();
    }

    @Override
    public void setDarkMode(boolean isDark) {
        if (isDark) {

            jPanel2.setBackground(new Color(38, 38, 40));
            jPanel3.setForeground(Color.WHITE);
            cariDosenLabel.setForeground(Color.WHITE);
            jTable2.setBackground(new Color(38, 38, 40));
            jTable2.setGridColor(Color.WHITE);
            jTable2.setForeground(Color.WHITE);
            dateLabel.setForeground(Color.WHITE);
            clockLabel.setForeground(Color.WHITE);
            informationTitle.setForeground(Color.WHITE);
        } else {
            jPanel2.setBackground(new Color(249, 248, 246));
            cariDosenLabel.setForeground(Color.BLACK);
            jTable2.setBackground(new Color(249, 248, 246));
            jTable2.setGridColor(Color.BLACK);
            jTable2.setForeground(Color.BLACK);
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

        setOpaque(false);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setToolTipText("");
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setOpaque(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "TC212G", "Pemrograman Berbasis Obyek G", "Pratyaks Ocsa N. Saian", "S1 TI", "FTI455", "Senin", "13.00", "16.00"},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Kelas", "Nama Kelas", "Nama Dosen", "Program Studi", "Ruang", "Hari", "Jam Mulai", "Jam Selesai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel6.setOpaque(false);

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setText("dateLabel");
        dateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        clockLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clockLabel.setText("clockLabel");

        informationTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        informationTitle.setText("Data Kelas");

        jPanel3.setOpaque(false);

        tambahButton.setBackground(new java.awt.Color(0, 204, 0));
        tambahButton.setText("Tambah Kelas");
        tambahButton.setActionCommand("tambahDosen");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        editButton. setBackground(new java.awt. Color(0, 0, 255));
        editButton.setText("Edit Kelas");
        editButton.setActionCommand("editKelas");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        
        hapusButton. setBackground(new java.awt. Color(255, 0, 0));
        hapusButton.setText("Hapus Kelas");
        hapusButton.setActionCommand("hapusKelas");
hapusButton. addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        hapusButtonActionPerformed(evt);
    }
});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambahButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tambahButton)
                .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hapusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cariDosenLabel.setText("Cari Kelas: ");

        jTextField1.setText("Cari Kelas");
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
                        .addGap(12, 12, 12)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cariButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1095, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // Cek apakah ada baris yang dipilih
        int selectedRow = jTable2.getSelectedRow();
        String idMatkul = null;

        if (selectedRow != -1) {
            // Opsi A: Jika ada baris dipilih, ambil ID Prodi dari baris tersebut untuk filter mata kuliah
            String idProdi = jTable2.getValueAt(selectedRow, 4).toString(); // Kolom Program Studi

            // Dapatkan mata kuliah berdasarkan prodi yang sama
            MatkulRepository matkulRepo = new MatkulRepository();
            List<Matkul> listMatkul = matkulRepo.getAllMatkul();

            // Filter hanya matkul dengan prodi yang sama
            List<Matkul> filteredMatkul = new ArrayList<>();
            for (Matkul m : listMatkul) {
                if (m.getId_prodi().equals(idProdi)) {
                    filteredMatkul.add(m);
                }
            }

            if (filteredMatkul.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Tidak ada mata kuliah untuk prodi " + idProdi + "!\nSilakan pilih baris dengan prodi lain atau tambah mata kuliah terlebih dahulu.",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Jika hanya ada 1 matkul, langsung gunakan tanpa dialog
            if (filteredMatkul.size() == 1) {
                idMatkul = filteredMatkul.get(0).getId_matkul();
                JOptionPane.showMessageDialog(this,
                    "Menggunakan mata kuliah: " + filteredMatkul.get(0).getNama_matkul(),
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Tampilkan dropdown hanya untuk matkul dengan prodi yang sama
                String[] matkulOptions = new String[filteredMatkul.size()];
                for (int i = 0; i < filteredMatkul.size(); i++) {
                    Matkul m = filteredMatkul.get(i);
                    matkulOptions[i] = m.getId_matkul() + " - " + m.getNama_matkul();
                }

                String selectedMatkul = (String) JOptionPane.showInputDialog(
                    this,
                    "Pilih Mata Kuliah (Prodi: " + idProdi + "):",
                    "Tambah Kelas",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    matkulOptions,
                    matkulOptions[0]
                );

                if (selectedMatkul == null) return;
                idMatkul = selectedMatkul.split(" - ")[0];
            }
        } else {
            // Opsi B: Tidak ada baris dipilih - tampilkan dropdown semua mata kuliah
            MatkulRepository matkulRepo = new MatkulRepository();
            List<Matkul> listMatkul = matkulRepo.getAllMatkul();

            if (listMatkul.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tidak ada mata kuliah yang terdaftar!\nSilakan tambah mata kuliah terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String[] matkulOptions = new String[listMatkul.size()];
            for (int i = 0; i < listMatkul.size(); i++) {
                Matkul m = listMatkul.get(i);
                matkulOptions[i] = m.getId_matkul() + " - " + m.getNama_matkul() + " (" + m.getId_prodi() + ")";
            }

            String selectedMatkul = (String) JOptionPane.showInputDialog(
                this,
                "Pilih Mata Kuliah:",
                "Tambah Kelas",
                JOptionPane.QUESTION_MESSAGE,
                null,
                matkulOptions,
                matkulOptions[0]
            );

            if (selectedMatkul == null) return;
            idMatkul = selectedMatkul.split(" - ")[0];
        }

        // Input dialog untuk menambah kelas
        String idKelas = JOptionPane.showInputDialog(this, "Masukkan ID Kelas:", "Tambah Kelas", JOptionPane.PLAIN_MESSAGE);
        if (idKelas == null || idKelas.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Kelas tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String namaKelas = JOptionPane.showInputDialog(this, "Masukkan Nama Kelas:", "Tambah Kelas", JOptionPane.PLAIN_MESSAGE);
        if (namaKelas == null || namaKelas.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Kelas tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Dropdown pilihan dosen
        DosenRepository dosenRepo = new DosenRepository();
        List<Dosen> listDosen = dosenRepo.getAllDosen();

        if (listDosen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada dosen yang terdaftar!\nSilakan tambah dosen terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] dosenOptions = new String[listDosen.size()];
        for (int i = 0; i < listDosen.size(); i++) {
            Dosen d = listDosen.get(i);
            dosenOptions[i] = d.getNid() + " - " + d.getNama();
        }

        String selectedDosen = (String) JOptionPane.showInputDialog(
            this,
            "Pilih Dosen Pengampu:",
            "Tambah Kelas",
            JOptionPane.QUESTION_MESSAGE,
            null,
            dosenOptions,
            dosenOptions[0]
        );

        if (selectedDosen == null) return;
        String nid = selectedDosen.split(" - ")[0];

        String kapasitasStr = JOptionPane.showInputDialog(this, "Masukkan Kapasitas:", "Tambah Kelas", JOptionPane.PLAIN_MESSAGE);
        if (kapasitasStr == null || kapasitasStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kapasitas tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int kapasitas = Integer.parseInt(kapasitasStr.trim());

            if (kapasitas < 1) {
                JOptionPane.showMessageDialog(this, "Kapasitas harus lebih dari 0!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            KelasRepository kelasRepo = new KelasRepository();
            Kelas kelas = new Kelas(idKelas.trim(), namaKelas.trim(), nid.trim(), idMatkul.trim(), kapasitas);

            if (kelasRepo.createKelas(kelas)) {
                // Optional: tambah jadwal
                int addJadwal = JOptionPane.showConfirmDialog(this,
                    "Kelas berhasil ditambahkan!\nTambahkan jadwal kelas sekarang?",
                    "Tambah Jadwal",
                    JOptionPane.YES_NO_OPTION);

                if (addJadwal == JOptionPane.YES_OPTION) {
                    addJadwalKelas(idKelas.trim());
                }
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal menambahkan kelas!\n\nKemungkinan penyebab:\n" +
                    "1. ID Kelas sudah terdaftar\n" +
                    "2. Dosen atau Mata Kuliah tidak valid\n" +
                    "3. Koneksi database bermasalah\n\n" +
                    "Silakan cek console untuk detail error.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kapasitas harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Terjadi kesalahan: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void addJadwalKelas(String idKelas) {
        String idJadwal = JOptionPane.showInputDialog(this, "Masukkan ID Jadwal:", "Tambah Jadwal");
        if (idJadwal == null || idJadwal.trim().isEmpty()) return;

        String idRuangan = JOptionPane.showInputDialog(this, "Masukkan ID Ruangan:", "Tambah Jadwal");
        if (idRuangan == null || idRuangan.trim().isEmpty()) return;

        String[] hariOptions = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};
        String hari = (String) JOptionPane.showInputDialog(this, "Pilih Hari:", "Tambah Jadwal",
                JOptionPane.QUESTION_MESSAGE, null, hariOptions, hariOptions[0]);
        if (hari == null) return;

        String jamMulai = JOptionPane.showInputDialog(this, "Masukkan Jam Mulai (HH:MM:SS):", "Tambah Jadwal");
        if (jamMulai == null || jamMulai.trim().isEmpty()) return;

        String jamSelesai = JOptionPane.showInputDialog(this, "Masukkan Jam Selesai (HH:MM:SS):", "Tambah Jadwal");
        if (jamSelesai == null || jamSelesai.trim().isEmpty()) return;

        KelasRepository kelasRepo = new KelasRepository();
        if (kelasRepo.createJadwalKelas(idJadwal.trim(), idKelas, idRuangan.trim(), hari, jamMulai.trim(), jamSelesai.trim())) {
            JOptionPane.showMessageDialog(this, "Jadwal berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan jadwal!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        repo.JadwalKelasRepository jadwalRepo = new repo.JadwalKelasRepository();

        // cek bentrok di kelas atau tidak
        if (jadwalRepo.isJadwalBentrok(idRuangan, hari, jamMulai, jamSelesai)) {
            JOptionPane.showMessageDialog(this,
                    "GAGAL! Ruangan " + idRuangan + " sudah terpakai pada hari " + hari +
                            " pukul " + jamMulai + "-" + jamSelesai + ".",
                    "Jadwal Bentrok",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        //ini kalo ga tabrakan
        if (kelasRepo.createJadwalKelas(idJadwal, idKelas, idRuangan, hari, jamMulai, jamSelesai)) {
            JOptionPane.showMessageDialog(this, "Jadwal berhasil ditambahkan!");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan jadwal (Error Database)!");
        }
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // Search on Enter
        cariButtonActionPerformed(evt);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // Combo box action
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtonActionPerformed
        String keyword = jTextField1.getText().trim().toLowerCase();

        if (keyword.isEmpty() || keyword.equals("cari kelas")) {
            loadKelasData();
            return;
        }

        String sql = """
            SELECT
                k.id_kelas, k.nama_kelas, d.name as nama_dosen,
                m.id_prodi, j.id_ruangan, j.hari, j.jam_mulai, j.jam_selesai
            FROM kelas k
            INNER JOIN dosen d ON k.nid = d.nid
            INNER JOIN matkul m ON k.id_matkul = m.id_matkul
            LEFT JOIN jadwal_kelas j ON k.id_kelas = j.id_kelas
            WHERE LOWER(k.id_kelas) LIKE ? OR LOWER(k.nama_kelas) LIKE ? OR LOWER(d.name) LIKE ?
            """;

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        try (Connection conn = db_config.getConn();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            String searchPattern = "%" + keyword + "%";
            prep.setString(1, searchPattern);
            prep.setString(2, searchPattern);
            prep.setString(3, searchPattern);

            ResultSet res = prep.executeQuery();
            int no = 1;
            while (res.next()) {
                Object[] row = {
                    no++,
                    res.getString("id_kelas"),
                    res.getString("nama_kelas"),
                    res.getString("nama_dosen"),
                    res.getString("id_prodi"),
                    res.getString("id_ruangan") != null ? res.getString("id_ruangan") : "-",
                    res.getString("hari") != null ? res.getString("hari") : "-",
                    res.getString("jam_mulai") != null ? res.getString("jam_mulai") : "-",
                    res.getString("jam_selesai") != null ? res.getString("jam_selesai") : "-"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mencari data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cariButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih kelas yang akan diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idKelas = jTable2.getValueAt(selectedRow, 1).toString();
        String namaLama = jTable2.getValueAt(selectedRow, 2).toString();

        String namaBaru = JOptionPane.showInputDialog(this, "Masukkan Nama Kelas Baru:", namaLama);
        if (namaBaru == null || namaBaru.trim().isEmpty()) return;

        // Dropdown pilihan dosen
        DosenRepository dosenRepo = new DosenRepository();
        List<Dosen> listDosen = dosenRepo.getAllDosen();

        if (listDosen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada dosen yang terdaftar!\nSilakan tambah dosen terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] dosenOptions = new String[listDosen.size()];
        for (int i = 0; i < listDosen.size(); i++) {
            Dosen d = listDosen.get(i);
            dosenOptions[i] = d.getNid() + " - " + d.getNama();
        }

        String selectedDosen = (String) JOptionPane.showInputDialog(
            this,
            "Pilih Dosen Pengampu Baru:",
            "Edit Kelas",
            JOptionPane.QUESTION_MESSAGE,
            null,
            dosenOptions,
            dosenOptions[0]
        );

        if (selectedDosen == null) return;
        String nid = selectedDosen.split(" - ")[0];

        // Dropdown pilihan mata kuliah
        MatkulRepository matkulRepo = new MatkulRepository();
        List<Matkul> listMatkul = matkulRepo.getAllMatkul();

        if (listMatkul.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada mata kuliah yang terdaftar!\nSilakan tambah mata kuliah terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] matkulOptions = new String[listMatkul.size()];
        for (int i = 0; i < listMatkul.size(); i++) {
            Matkul m = listMatkul.get(i);
            matkulOptions[i] = m.getId_matkul() + " - " + m.getNama_matkul();
        }

        String selectedMatkul = (String) JOptionPane.showInputDialog(
            this,
            "Pilih Mata Kuliah Baru:",
            "Edit Kelas",
            JOptionPane.QUESTION_MESSAGE,
            null,
            matkulOptions,
            matkulOptions[0]
        );

        if (selectedMatkul == null) return;
        String idMatkul = selectedMatkul.split(" - ")[0];

        String kapasitasStr = JOptionPane.showInputDialog(this, "Masukkan Kapasitas Baru:");
        if (kapasitasStr == null || kapasitasStr.trim().isEmpty()) return;

        try {
            int kapasitas = Integer.parseInt(kapasitasStr.trim());

            if (kapasitas < 1) {
                JOptionPane.showMessageDialog(this, "Kapasitas harus lebih dari 0!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            KelasRepository kelasRepo = new KelasRepository();
            Kelas kelas = new Kelas(idKelas, namaBaru.trim(), nid.trim(), idMatkul.trim(), kapasitas);

            if (kelasRepo.updateKelas(kelas)) {
                JOptionPane.showMessageDialog(this, "Kelas berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal mengupdate kelas!\n\nKemungkinan penyebab:\n" +
                    "1. Dosen atau Mata Kuliah tidak valid\n" +
                    "2. Koneksi database bermasalah\n\n" +
                    "Silakan cek console untuk detail error.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kapasitas harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Terjadi kesalahan: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih kelas yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idKelas = jTable2.getValueAt(selectedRow, 1).toString();
        String namaKelas = jTable2.getValueAt(selectedRow, 2).toString();

        int confirm = JOptionPane.showConfirmDialog(this,
            "Apakah Anda yakin ingin menghapus kelas:\n" + namaKelas + " (" + idKelas + ")?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            KelasRepository kelasRepo = new KelasRepository();
            if (kelasRepo.deleteKelas(idKelas)) {
                JOptionPane.showMessageDialog(this, "Kelas berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus kelas!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_hapusButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariButton;
    private javax.swing.JLabel cariDosenLabel;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel informationTitle;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton tambahButton;
    // End of variables declaration//GEN-END:variables
}

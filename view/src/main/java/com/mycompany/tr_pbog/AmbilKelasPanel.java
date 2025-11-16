package com.mycompany.tr_pbog;

import com.mycompany.tr_pbog.DarkMode.Listener;
import java.awt.CardLayout; // <-- Import CardLayout
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AmbilKelasPanel extends javax.swing.JPanel implements Listener {

    private CardLayout cardLayout; // Variabel untuk mengontrol CardLayout

    public AmbilKelasPanel() {
        initComponents();
        
        // 1. Dapatkan CardLayout (Anda sudah punya ini)
        cardLayout = (CardLayout) (this.getLayout());
        
        // --- TAMBAHKAN BARIS INI ---
        // 2. Tampilkan kartu 'master' secara default
        // "card2" adalah nama yang Anda berikan untuk 'panelMasterList'
        // di dalam initComponents() Anda
        cardLayout.show(this, "card2"); 
        // ---------------------------
        
        // 3. Setup transparansi
        setupTransparency();
        
        // 4. Muat daftar mata kuliah induk
        loadMatkulMasterList();
        
        // 5. Atur warna awal
        setDarkMode(DarkMode.isDarkMode);
    }

    private void loadMatkulMasterList() {
        matkulListContentPanel.removeAll(); // Bersihkan list
        
        // Dummy data: [ID Matkul, Nama Matkul]
        String[][] dummyMatkul = {
            {"IF-401", "IF-401 | Pemrograman Berorientasi Objek"},
            {"IF-203", "IF-203 | Struktur Data"},
            {"UM-101", "UM-101 | Pancasila"},
            {"IF-505", "IF-505 | Kecerdasan Buatan"},
            {"IF-401", "IF-401 | Pemrograman Berorientasi Objek"},
            {"IF-203", "IF-203 | Struktur Data"},
            {"UM-101", "UM-101 | Pancasila"},
            {"IF-505", "IF-505 | Kecerdasan Buatan"},
            {"IF-505", "IF-505 | Kecerdasan Buatan"},
            {"IF-401", "IF-401 | Pemrograman Berorientasi Objek"},
            {"IF-203", "IF-203 | Struktur Data"},
            {"UM-101", "UM-101 | Pancasila"},
            {"IF-505", "IF-505 | Kecerdasan Buatan"},
            {"IF-401", "IF-401 | Pemrograman Berorientasi Objek"},
            {"IF-203", "IF-203 | Struktur Data"},
            {"UM-101", "UM-101 | Pancasila"},
            {"IF-505", "IF-505 | Kecerdasan Buatan"},
            {"IF-401", "IF-401 | Pemrograman Berorientasi Objek"},
            {"IF-203", "IF-203 | Struktur Data"},
            {"UM-101", "UM-101 | Pancasila"},
            {"IF-505", "IF-505 | Kecerdasan Buatan"},
            {"IF-505", "IF-505 | Kecerdasan Buatan"},
            {"IF-401", "IF-401 | Pemrograman Berorientasi Objek"},
            {"IF-203", "IF-203 | Struktur Data"},
            {"UM-101", "UM-101 | Pancasila"},
            {"IF-505", "IF-505 | Kecerdasan Buatan"}
        };
        
        for (String[] matkul : dummyMatkul) {
            String matkulID = matkul[0];
            String matkulName = matkul[1];
            
            // Buat kartu baru
            matkulIndukCardPanel card = new matkulIndukCardPanel(matkulID, matkulName);
            
            // PENTING: Tambahkan listener ke tombol 'Pilih'
            card.getPilihButton().addActionListener(e -> {
                // Saat 'Pilih' diklik, muat dan tampilkan detail
                showKelasDetailView(matkulID, matkulName);
            });
            
            matkulListContentPanel.add(card);
        }
        
        matkulListContentPanel.revalidate();
        matkulListContentPanel.repaint();
    }
    
    /**
     * Memuat tabel kelas detail (Tampilan 2)
     */
// Ganti seluruh metode ini
    private void showKelasDetailView(String matkulID, String matkulName) {
        // 1. Atur judul
        detailScrollPane.getViewport().setOpaque(false);
        detailJudulLabel.setText("Pilih Kelas untuk: " + matkulName);
        
        // 2. Bersihkan daftar lama
        kelasDetailContentPanel.removeAll();
        
        // 3. Buat Dummy Data (berdasarkan matkulID yang diklik)
        String[][] data;
        if (matkulID.equals("IF-401")) {
            data = new String[][] {
                {"IF-401-A", "Senin, 08:00-10:30, Ruang F-404, Dosen: Prof. Budi"},
                {"IF-401-B", "Selasa, 13:00-15:30, Ruang F-405, Dosen: Prof. Budi"}
            };
        } else if (matkulID.equals("IF-203")) {
            data = new String[][] {
                {"IF-203-A", "Selasa, 08:00-10:30, Ruang G-101, Dosen: Dr. Ani"},
                {"IF-203-B", "Rabu, 13:00-15:30, Ruang G-101, Dosen: Dr. Ani"}
            };
        } else {
            data = new String[][] {
                {matkulID + "-A", "Kamis, 10:00-12:30, Ruang H-101, Dosen: Dosen X"}
            };
        }
        
        // 4. Loop dan Buat Kartu Detail
        for (String[] kelas : data) {
            String kodeKelas = kelas[0];
            String infoText = kelas[1];
            
            // Buat kartu baru
            kelasDetailCardPanel card = new kelasDetailCardPanel(kodeKelas, infoText);
            
            // --- INI KUNCINYA ---
            // Tambahkan listener ke tombol "Ambil" di kartu
            card.getAmbilButton().addActionListener(e -> {
                // Panggil fungsi baru untuk menangani pengambilan
                handleAmbilKelas(kodeKelas);
            });
            
            // Tambahkan kartu ke panel (yang di dalam scroll pane)
            kelasDetailContentPanel.add(card);
        }

        // 5. Terapkan dark mode
        setDarkMode(DarkMode.isDarkMode);

        // 6. Pindahkan tampilan ke 'panelDetailView'
        cardLayout.show(this, "card3"); // (Nama ini sudah benar)
        
        kelasDetailContentPanel.revalidate();
        kelasDetailContentPanel.repaint();
    }
    
    /**
     * Menangani logika saat tombol "Ambil" di kartu detail diklik.
     * @param kodeKelas ID kelas yang dipilih (misal: "IF-401-A")
     */
    private void handleAmbilKelas(String kodeKelas) {
        String konfirmasi = "Anda yakin ingin mengambil kelas:\n" + kodeKelas;
        
        int response = JOptionPane.showConfirmDialog(this, 
                         konfirmasi, "Konfirmasi Pengambilan", JOptionPane.YES_NO_OPTION);
        
        if (response == JOptionPane.YES_OPTION) {
            // TODO: Kirim 'kodeKelas' ke database
            
            JOptionPane.showMessageDialog(this, 
                "Berhasil mengambil " + kodeKelas, 
                "Registrasi Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
            // Kembali ke halaman master
            showMasterListView();
        }
        // Jika "NO", tidak terjadi apa-apa
    }
    private void showMasterListView() {
        cardLayout.show(this, "card2"); // "cardMaster" adalah nama panel
    }
    private void setupTransparency() {
        this.setOpaque(false);
        panelMasterList.setOpaque(false);
        panelDetailView.setOpaque(false);
        matkulListContentPanel.setOpaque(false);
        detailBottomPanel.setOpaque(false);
        
        masterScrollPane.setOpaque(false);
        masterScrollPane.getViewport().setOpaque(false);
        masterScrollPane.setBorder(null);
        
        detailScrollPane.setOpaque(false);
        detailScrollPane.getViewport().setOpaque(false);
        detailScrollPane.setBorder(null);
    }

    /**
     * Metode dari Interface DarkMode.Listener
     */
    @Override
    public void setDarkMode(boolean isDark) {
        // Tentukan warna
        Color bgColor = isDark ? new Color(38, 38, 40) : new Color(249, 248, 246);
        Color cardBgColor = isDark ? new Color(50, 50, 52) : Color.WHITE;
        Color textColor = isDark ? Color.WHITE : Color.BLACK;
        Color headerBgColor = isDark ? new Color(38, 38, 40) : new Color(249, 248, 246);
        Color gridColor = isDark ? new Color(80, 80, 80) : Color.LIGHT_GRAY;

        // Terapkan warna
        this.setBackground(bgColor);
        judulLabel.setForeground(textColor);
        panelMasterList.setBackground(bgColor);
        panelDetailView.setBackground(bgColor);
        matkulListContentPanel.setBackground(bgColor);
        detailBottomPanel.setBackground(bgColor);
        
        masterScrollPane.getViewport().setBackground(bgColor);
        detailScrollPane.getViewport().setBackground(bgColor);
        
        detailJudulLabel.setForeground(textColor);
        
        // Atur warna untuk Kartu (jika ada)
        for (java.awt.Component card : matkulListContentPanel.getComponents()) {
            if (card instanceof Listener) {
                ((Listener) card).setDarkMode(isDark);
            }
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

        panelMasterList = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        matkulListContentPanel = new javax.swing.JPanel();
        panelDetailView = new javax.swing.JPanel();
        detailJudulLabel = new javax.swing.JLabel();
        detailScrollPane = new javax.swing.JScrollPane();
        kelasDetailContentPanel = new javax.swing.JPanel();
        detailBottomPanel = new javax.swing.JPanel();
        kembaliButton = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        panelMasterList.setLayout(new java.awt.BorderLayout());

        judulLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        judulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulLabel.setText("PILIH MATA KULIAH");
        panelMasterList.add(judulLabel, java.awt.BorderLayout.PAGE_START);

        matkulListContentPanel.setLayout(new javax.swing.BoxLayout(matkulListContentPanel, javax.swing.BoxLayout.Y_AXIS));
        masterScrollPane.setViewportView(matkulListContentPanel);

        panelMasterList.add(masterScrollPane, java.awt.BorderLayout.CENTER);

        add(panelMasterList, "card2");

        panelDetailView.setLayout(new java.awt.BorderLayout());

        detailJudulLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        detailJudulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailJudulLabel.setText("jLabel2");
        panelDetailView.add(detailJudulLabel, java.awt.BorderLayout.PAGE_START);

        kelasDetailContentPanel.setOpaque(false);
        kelasDetailContentPanel.setLayout(new javax.swing.BoxLayout(kelasDetailContentPanel, javax.swing.BoxLayout.Y_AXIS));
        detailScrollPane.setViewportView(kelasDetailContentPanel);

        panelDetailView.add(detailScrollPane, java.awt.BorderLayout.CENTER);

        detailBottomPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        kembaliButton.setText("Kembali");
        kembaliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliButtonActionPerformed(evt);
            }
        });
        detailBottomPanel.add(kembaliButton);

        panelDetailView.add(detailBottomPanel, java.awt.BorderLayout.SOUTH);

        add(panelDetailView, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliButtonActionPerformed
        // TODO add your handling code here:
        showMasterListView(); // Panggil metode untuk kembali
    }//GEN-LAST:event_kembaliButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel detailBottomPanel;
    private javax.swing.JLabel detailJudulLabel;
    private javax.swing.JScrollPane detailScrollPane;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JPanel kelasDetailContentPanel;
    private javax.swing.JButton kembaliButton;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JPanel matkulListContentPanel;
    private javax.swing.JPanel panelDetailView;
    private javax.swing.JPanel panelMasterList;
    // End of variables declaration//GEN-END:variables
}

package com.mycompany.tr_pbog;

import javax.swing.JLabel;
import java.awt.Color;
import com.mycompany.tr_pbog.DarkMode.Listener;
import java.util.List;
import dbCon.Dosen;
import dbCon.Kelas;
import dbCon.Mahasiswa;
import logic.FiturDosen;

import javax.swing.JPanel; // <-- IMPORT BARU
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font; // <-- IMPORT BARU

public class DaftarKelasPanel extends javax.swing.JPanel implements Listener {

    // Variabel untuk menyimpan mainPanel dari DosenHomePage
    private JPanel mainPanel; 

    /**
     * Konstruktor Kustom (Diperbaiki)
     * Menerima mainPanel dari DosenHomePage
     */
    public DaftarKelasPanel(JPanel mainPanel) {
        initComponents();
        this.mainPanel = mainPanel; // Simpan mainPanel
        
        // --- KODE TRANSPARANSI ---
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);
        ContentPanel.setOpaque(false);
        
        // Atur transparansi untuk komponen tabel
        if (jScrollPane3 != null) {
            jScrollPane3.getViewport().setOpaque(false);
            jScrollPane3.setBorder(null);
            jScrollPane3.setOpaque(false);
        }
        if (tableContainerPanel != null) {
            tableContainerPanel.setOpaque(false);
        }
        // -------------------------
        
        setDarkMode(DarkMode.isDarkMode); // Atur warna awal
    }

    @Override
    public void setDarkMode(boolean isDark) {
        for (java.awt.Component card : ContentPanel.getComponents()) {
            if (card instanceof Listener) { // Cek apakah kartu juga 'Listener'
                ((Listener) card).setDarkMode(isDark);
            }
        }
        if (tableContainerPanel != null) {
            jScrollPane3.getViewport().setOpaque(false);
            jadwalTable.setShowGrid(true);
            tableContainerPanel.setBackground(new Color(249, 248, 246));
            jadwalTable.setShowHorizontalLines(true);
            jadwalTable.setShowVerticalLines(true);
            judulLabel.setForeground(Color.BLACK);
            jadwalTable.setGridColor(Color.BLACK);
            jadwalTable.getTableHeader().setBackground(Color.WHITE);
            jadwalTable.getTableHeader().setForeground(Color.BLACK);
            jadwalTable.setBackground(Color.WHITE); // Latar sel tabel
            jadwalTable.setForeground(Color.BLACK);   // Teks sel tabel
            if(DarkMode.isDarkMode == true){
                judulLabel.setForeground(Color.WHITE);
                jadwalTable.setGridColor(Color.WHITE);
                tableContainerPanel.setBackground(new Color(38, 38, 40));
                jadwalTable.setBackground(new Color(38, 38, 40)); // Latar sel tabel
                jadwalTable.setForeground(Color.WHITE);   // Teks sel tabel
            }
            // Atur header tabel

        }
    }
 public void loadDataKelas(Object user) {
        FiturDosen fDosen = new FiturDosen();
        if (user instanceof Dosen) {
            judulLabel.setText("KELAS SAYA");
            judulLabel.setVisible(true);
            ContentPanel.removeAll(); 

            List<Kelas> lsKelas = fDosen.lihatKelas((Dosen) user);
            
            System.out.println("DEBUG: Jumlah kelas ditemukan: " + lsKelas.size());
            
            for (Kelas kelas : lsKelas) {
                // ambil id dan nama dari objek Kelas (sesuaikan nama getter jika berbeda)
                String idKelas = kelas.getId_kelas();
                String namaKelas = kelas.getNama_kelas();
                
                System.out.println("DEBUG: Menambahkan kelas - ID: " + idKelas + ", Nama: " + namaKelas);
                
                DosenKelasCardPanel card = new DosenKelasCardPanel(idKelas, namaKelas);
                
                // Set ukuran card agar terlihat di BoxLayout
                card.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 60));
                card.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
                
            // Kita panggil satu-satunya tombol yang ada ("Lihat Mhs dan Input Nilai")
            // menggunakan getter yang baru saja kita buat
            card.getLihatMhsButton().addActionListener(e -> {
                // Panggil metode baru untuk menampilkan detail
                showMahasiswaListView(idKelas, namaKelas, kelas);
            });

                ContentPanel.add(card);
            }
            
            // PINDAHKAN INI KE LUAR LOOP
            jScrollPane1.setViewportView(ContentPanel);
            
        }
        if (user instanceof Mahasiswa) {
            judulLabel.setText("JADWAL KULIAH");
            judulLabel.setVisible(true);
            
            String[] columnNames = {"No", "Kode", "Mata Kuliah", "Dosen", "Ruang", "Hari", "Mulai", "Selesai"};
            Object[][] data = {
                {1, "IF-401", "PBO", "Prof. Budi", "F-404", "Senin", "08:00", "10:30"},
                {2, "IF-203", "Struktur Data", "Dr. Ani", "G-101", "Selasa", "13:00", "15:00"},
                // ... (sisa data)
            };
            
            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
                @Override public boolean isCellEditable(int row, int column) { return false; }
            };
            
            jadwalTable.setRowHeight(30);
            jadwalTable.setModel(model);
            jadwalTable.getTableHeader().setResizingAllowed(false);
            jadwalTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            javax.swing.table.TableColumnModel cm = jadwalTable.getColumnModel();
            cm.getColumn(0).setPreferredWidth(30);  // No
            cm.getColumn(1).setPreferredWidth(100);  // Kode
            cm.getColumn(2).setPreferredWidth(430); // Matakuliah
            cm.getColumn(3).setPreferredWidth(200);  // Dosen
            cm.getColumn(4).setPreferredWidth(100);  // Ruang
            cm.getColumn(5).setPreferredWidth(120); // Hari
            cm.getColumn(6).setPreferredWidth(50); //Mulai
            cm.getColumn(7).setPreferredWidth(50); //Mulai
            javax.swing.table.TableColumnModel columnModel = jadwalTable.getColumnModel();
            // ... (kode atur lebar kolom Anda sudah benar) ...
            
            // Tampilkan pembungkus tabel di scroll pane
            jScrollPane1.setViewportView(tableContainerPanel);
        }
        
        setDarkMode(DarkMode.isDarkMode);

        this.revalidate();
        this.repaint();
    }
    private void showMahasiswaListView(String classID, String className, Kelas kelas ) {
        
        // 1. Buat panel detail baru
        // Kirim 'mainPanel', 'this' (DaftarKelasPanel), dan info kelas
        DaftarMahasiswaPanel detailPanel = new DaftarMahasiswaPanel(mainPanel, this, classID, className, kelas);
        
        // 2. Ganti isi mainPanel
        mainPanel.removeAll();
        mainPanel.add(detailPanel, java.awt.BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableContainerPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jadwalTable = new javax.swing.JTable();
        judulLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ContentPanel = new javax.swing.JPanel();

        tableContainerPanel.setOpaque(false);
        tableContainerPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setBackground(new java.awt.Color(51, 255, 153));
        jScrollPane3.setOpaque(false);
        jScrollPane3.setViewportView(null);

        jadwalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jadwalTable);

        tableContainerPanel.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        judulLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        judulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulLabel.setText("JUDUL");
        judulLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(judulLabel, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setOpaque(false);

        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new javax.swing.BoxLayout(ContentPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(ContentPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jadwalTable;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JPanel tableContainerPanel;
    // End of variables declaration//GEN-END:variables
}

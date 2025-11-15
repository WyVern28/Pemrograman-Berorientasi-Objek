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
    private DefaultTableModel tableModel;

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
    private void showKelasDetailView(String matkulID, String matkulName) {
        // 1. Atur judul
        detailJudulLabel.setText("Pilih Kelas untuk: " + matkulName);
        
        // 2. Definisikan Kolom (DENGAN TAMBAHAN "MATA KULIAH")
        String[] columnNames = {"Ambil", "Kode Kelas", "Mata Kuliah", "Hari", "Jam", "Ruang", "Dosen"};
        
        // 3. Buat Dummy Data (DENGAN TAMBAHAN 'matkulName')
        Object[][] data;
        if (matkulID.equals("IF-401")) {
            data = new Object[][] {
                {false, "IF-401-A", matkulName, "Senin", "08:00-10:30", "F-404", "Prof. Budi"},
                {false, "IF-401-B", matkulName, "Selasa", "13:00-15:30", "F-405", "Prof. Budi"}
            };
        } else if (matkulID.equals("IF-203")) {
            data = new Object[][] {
                {false, "IF-203-A", matkulName, "Selasa", "08:00-10:30", "G-101", "Dr. Ani"},
                {false, "IF-203-B", matkulName, "Rabu", "13:00-15:30", "G-101", "Dr. Ani"}
            };
        } else {
            data = new Object[][] {
                {false, matkulID + "-A", matkulName, "Kamis", "10:00-12:30", "H-101", "Dosen X"}
            };
        }
        
        // 4. Buat Model (Kode ini tidak berubah)
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) return Boolean.class;
                return super.getColumnClass(columnIndex);
            }
            @Override
            public boolean isCellEditable(int row, int column) {
               return column == 0;
            }
        };
        
        availableKelasTable.setModel(tableModel);
        
        // 5. Atur tampilan tabel
        availableKelasTable.setRowHeight(30);
        availableKelasTable.getTableHeader().setReorderingAllowed(false);
        availableKelasTable.getTableHeader().setResizingAllowed(false);
        availableKelasTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        // 6. ATUR LEBAR KOLOM (DENGAN TAMBAHAN 'Mata Kuliah')
        javax.swing.table.TableColumnModel cm = availableKelasTable.getColumnModel();
        cm.getColumn(0).setPreferredWidth(40);  // Ambil
        cm.getColumn(1).setPreferredWidth(100); // Kode Kelas
        cm.getColumn(2).setPreferredWidth(460); // <-- KOLOM BARU "Mata Kuliah"
        cm.getColumn(3).setPreferredWidth(100); // Hari
        cm.getColumn(4).setPreferredWidth(100); // Jam
        cm.getColumn(5).setPreferredWidth(80);  // Ruang
        cm.getColumn(6).setPreferredWidth(200); // Dosen
        
        // 7. Terapkan dark mode ke tabel
        setDarkMode(DarkMode.isDarkMode);

        // 8. Pindahkan tampilan ke 'panelDetailView'
        cardLayout.show(this, "card3"); // (Nama ini sudah benar)
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
        Color headerBgColor = isDark ? new Color(70, 70, 70) : new Color(230, 230, 230);
        Color gridColor = isDark ? new Color(80, 80, 80) : Color.LIGHT_GRAY;

        // Terapkan warna
        this.setBackground(bgColor);
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

        // Atur warna untuk Tabel
        if (availableKelasTable != null) {
            availableKelasTable.setBackground(cardBgColor);
            availableKelasTable.setForeground(textColor);
            availableKelasTable.setGridColor(gridColor);
            availableKelasTable.setShowGrid(true);
            availableKelasTable.getTableHeader().setBackground(headerBgColor);
            availableKelasTable.getTableHeader().setForeground(textColor);
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
        jLabel1 = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        matkulListContentPanel = new javax.swing.JPanel();
        panelDetailView = new javax.swing.JPanel();
        detailJudulLabel = new javax.swing.JLabel();
        detailScrollPane = new javax.swing.JScrollPane();
        availableKelasTable = new javax.swing.JTable();
        detailBottomPanel = new javax.swing.JPanel();
        kembaliButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        panelMasterList.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PILIH MATA KULIAH");
        panelMasterList.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        matkulListContentPanel.setLayout(new javax.swing.BoxLayout(matkulListContentPanel, javax.swing.BoxLayout.Y_AXIS));
        masterScrollPane.setViewportView(matkulListContentPanel);

        panelMasterList.add(masterScrollPane, java.awt.BorderLayout.CENTER);

        add(panelMasterList, "card2");

        panelDetailView.setLayout(new java.awt.BorderLayout());

        detailJudulLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        detailJudulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailJudulLabel.setText("jLabel2");
        panelDetailView.add(detailJudulLabel, java.awt.BorderLayout.PAGE_START);

        availableKelasTable.setModel(new javax.swing.table.DefaultTableModel(
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
        detailScrollPane.setViewportView(availableKelasTable);

        panelDetailView.add(detailScrollPane, java.awt.BorderLayout.CENTER);

        detailBottomPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        kembaliButton.setText("Kembali");
        kembaliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliButtonActionPerformed(evt);
            }
        });
        detailBottomPanel.add(kembaliButton);

        submitButton.setText("Ambil Kelas");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        detailBottomPanel.add(submitButton);

        panelDetailView.add(detailBottomPanel, java.awt.BorderLayout.SOUTH);

        add(panelDetailView, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        ArrayList<String> kelasDiambil = new ArrayList<>();
        
        // 1. Loop (Kode Anda sudah benar)
        // Kumpulkan semua kelas yang dicentang
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Boolean isChecked = (Boolean) tableModel.getValueAt(i, 0);
            if (isChecked) {
                // Ambil kode kelas (misal: "IF-401-A")
                String kodeKelas = (String) tableModel.getValueAt(i, 1);
                kelasDiambil.add(kodeKelas);
            }
        }
        
        // --- 2. INI ADALAH LOGIKA VALIDASI BARU ---
        
        // Kasus 1: Pengguna tidak mencentang apa-apa
        if (kelasDiambil.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Anda belum memilih kelas apapun.", 
                "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        
        // Kasus 2: Pengguna mencentang LEBIH DARI SATU
        } else if (kelasDiambil.size() > 1) { 
            JOptionPane.showMessageDialog(this, 
                "Anda hanya boleh mengambil SATU kelas (misal: A saja atau B saja) per mata kuliah.", 
                "Kesalahan Validasi", 
                JOptionPane.ERROR_MESSAGE);
            
            // PENTING: Jangan tutup halaman. Biarkan pengguna memperbaiki pilihannya.
        
        // Kasus 3: BERHASIL (Pengguna mencentang TEPAT SATU)
        } else {
            // Dapatkan satu-satunya kelas yang dipilih
            String kodeKelas = kelasDiambil.get(0); 
            
            String konfirmasi = "Anda berhasil mengambil kelas:\n" + kodeKelas;
            JOptionPane.showMessageDialog(this, 
                konfirmasi, 
                "Registrasi Berhasil", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // TODO: Di sini Anda akan mengirim 'kodeKelas' (String tunggal) ke database
            
            // Kembali ke halaman master
            showMasterListView();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliButtonActionPerformed
        // TODO add your handling code here:
        showMasterListView(); // Panggil metode untuk kembali
    }//GEN-LAST:event_kembaliButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableKelasTable;
    private javax.swing.JPanel detailBottomPanel;
    private javax.swing.JLabel detailJudulLabel;
    private javax.swing.JScrollPane detailScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton kembaliButton;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JPanel matkulListContentPanel;
    private javax.swing.JPanel panelDetailView;
    private javax.swing.JPanel panelMasterList;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}

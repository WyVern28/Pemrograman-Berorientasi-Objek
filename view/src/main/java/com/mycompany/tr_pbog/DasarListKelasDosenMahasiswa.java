package com.mycompany.tr_pbog;

import com.mycompany.tr_pbog.dosen.DaftarMahasiswaPanel;
import com.mycompany.tr_pbog.dosen.DosenKelasCardPanel;
import java.awt.Color;
import com.mycompany.tr_pbog.DarkMode.Listener;

import DTO.JadwalDTO;

import java.util.List;
import dbCon.Dosen;
import dbCon.Kelas;
import dbCon.Mahasiswa;
import logic.FiturDosen;
import logic.FiturMahasiswa;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DasarListKelasDosenMahasiswa extends javax.swing.JPanel implements Listener {

    private JPanel mainPanel; 

    public DasarListKelasDosenMahasiswa(JPanel mainPanel) {
        initComponents();
        this.mainPanel = mainPanel;
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);
        ContentPanel.setOpaque(false);
        if (jScrollPane3 != null) {
            jScrollPane3.getViewport().setOpaque(false);
            jScrollPane3.setBorder(null);
            jScrollPane3.setOpaque(false);
        }
        if (tableContainerPanel != null) {
            tableContainerPanel.setOpaque(false);
        }
        setDarkMode(DarkMode.isDarkMode);
    }

    @Override
    public void setDarkMode(boolean isDark) {
        for (java.awt.Component card : ContentPanel.getComponents()) {
            if (card instanceof Listener) {
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
                jadwalTable.setBackground(new Color(38, 38, 40));
                jadwalTable.setForeground(Color.WHITE);
            }

        }
    }
 public void loadDataKelas(Object user) {
        FiturDosen fDosen = new FiturDosen();
        FiturMahasiswa fMahasiswa = new FiturMahasiswa();
        if (user instanceof Dosen) {
            judulLabel.setText("KELAS SAYA");
            judulLabel.setVisible(true);
            ContentPanel.removeAll(); 

            List<Kelas> lsKelas = fDosen.lihatKelas((Dosen) user);
            
            System.out.println("DEBUG: Jumlah kelas ditemukan: " + lsKelas.size());
            
            for (Kelas kelas : lsKelas) {
                String idKelas = kelas.getId_kelas();
                String namaKelas = kelas.getNama_kelas();
                
                System.out.println("DEBUG: Menambahkan kelas - ID: " + idKelas + ", Nama: " + namaKelas);
                
                DosenKelasCardPanel card = new DosenKelasCardPanel(idKelas, namaKelas);
                
                card.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 60));
                card.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
                
            card.getLihatMhsButton().addActionListener(e -> {
                showMahasiswaListView(idKelas, namaKelas, kelas);
            });

                ContentPanel.add(card);
            }
            
            jScrollPane1.setViewportView(ContentPanel);
            
        }
        if (user instanceof Mahasiswa) {
            judulLabel.setText("JADWAL KULIAH");
            judulLabel.setVisible(true);
            List<JadwalDTO> lsKelas = fMahasiswa.getJadwalKelasByMahasiswa((Mahasiswa) user);
            String[] columnNames = {"No","Mata Kuliah","Ruang", "Hari", "Mulai", "Selesai"};
            Object[][] data = new Object[lsKelas.size()][6];
            for (int i = 0; i < lsKelas.size(); i++) {
                JadwalDTO jadwal = lsKelas.get(i);
                data[i][0] = i + 1;
                data[i][1] = jadwal.getNamaKelas();
                data[i][2] = jadwal.getId_ruangan();
                data[i][3] = jadwal.getHari();
                data[i][4] = jadwal.getJam_mulai();
                data[i][5] = jadwal.getJam_selesai();            }
            
            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
                @Override public boolean isCellEditable(int row, int column) { return false; }
            };
            
            jadwalTable.setRowHeight(30);
            jadwalTable.setModel(model);
            jadwalTable.getTableHeader().setResizingAllowed(false);
            jadwalTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            javax.swing.table.TableColumnModel cm = jadwalTable.getColumnModel();
            cm.getColumn(0).setPreferredWidth(30);  // No
            cm.getColumn(1).setPreferredWidth(550); // Matakuliah
            cm.getColumn(2).setPreferredWidth(150);  // Ruang
            cm.getColumn(3).setPreferredWidth(150); // Hari
            cm.getColumn(4).setPreferredWidth(100); //Mulai
            cm.getColumn(5).setPreferredWidth(100); //Selesai
            javax.swing.table.TableColumnModel columnModel = jadwalTable.getColumnModel();
            jScrollPane1.setViewportView(tableContainerPanel);
        }
        
        setDarkMode(DarkMode.isDarkMode);

        this.revalidate();
        this.repaint();
    }
    private void showMahasiswaListView(String classID, String className, Kelas kelas ) {
        DaftarMahasiswaPanel detailPanel = new DaftarMahasiswaPanel(mainPanel, this, classID, className, kelas);
        
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

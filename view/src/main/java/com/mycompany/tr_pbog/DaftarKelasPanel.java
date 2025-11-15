/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tr_pbog;

/**
 *
 * @author Made
 */
import java.awt.Color;
import com.mycompany.tr_pbog.DarkMode.Listener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class DaftarKelasPanel extends javax.swing.JPanel implements Listener {

    /**
     * Creates new form DaftarKelasPanel
     */
    public DaftarKelasPanel() {
        initComponents();
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);
        ContentPanel.setOpaque(false);
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
    public void loadDataKelas(String role) {
    

    if (role.equals("dosen")) {
        judulLabel.setText("");
        judulLabel.setVisible(false);
        ContentPanel.removeAll();
        // --- INI ADALAH DUMMY DATA ---
        String[][] dummyKelasDosen = {
            {"IF-401-A", "IF-401: Pemrograman Berorientasi Objek (Kelas A)"},
            {"IF-203-B", "IF-203: Struktur Data (Kelas B)"},
            {"IF-505-A", "IF-505: Kecerdasan Buatan (Kelas A)"},
            {"IF-101-C", "IF-101: Algoritma dan Pemrograman (Kelas C)"},
            {"IF-602-A", "IF-602: Proyek Perangkat Lunak (Kelas A)"},
            {"IF-702-B", "IF-702: Pengenalan Teknologi Informasi"},
            {"IF-401-A", "IF-401: Pemrograman Berorientasi Objek (Kelas A)"},
            {"IF-203-B", "IF-203: Struktur Data (Kelas B)"},
            {"IF-505-A", "IF-505: Kecerdasan Buatan (Kelas A)"},
            {"IF-101-C", "IF-101: Algoritma dan Pemrograman (Kelas C)"},
            {"IF-602-A", "IF-602: Proyek Perangkat Lunak (Kelas A)"},
            {"IF-702-B", "IF-702: Pengenalan Teknologi Informasi"}

        };

        for (String[] kelas : dummyKelasDosen) {
            // Buat Card baru, kirim ID sama Nama
            DosenKelasCardPanel card = new DosenKelasCardPanel(kelas[0], kelas[1]);
            ContentPanel.add(card);

            
            //Tambah Card ke ContentPanel
            ContentPanel.add(card);
            //Tampilkan ContentPanel di dalam scroll pane
            jScrollPane1.setViewportView(ContentPanel);
        }
        
    } else if (role.equals("mahasiswa")) {
        // 1. Definisikan Kolom
            judulLabel.setText("JADWAL KULIAH");
            judulLabel.setVisible(true);
            String[] columnNames = {"No", "Kode", "Mata Kuliah", "Dosen", "Ruang", "Hari", "Mulai", "Selesai"};
            
            // 2. Buat Dummy Data
            Object[][] data = {
                {1, "IF-401", "Pemrograman Berorientasi Objek", "Prof. Budi", "F-404", "Senin", "08:00", "10:30"},
                {2, "IF-203", "Struktur Data", "Dr. Ani", "G-101", "Selasa", "13:00", "15:00"},
                {3, "UM-101", "Pancasila", "Pak Eko", "H-202", "Rabu", "10:00", "12:00"},
                {4, "IF-505", "Kecerdasan Buatan", "Prof. Budi", "F-404", "Kamis", "08:00", "10:30"},
                {5, "IF-101", "Algoritma dan Pemrograman", "Dr. Ani", "G-101", "Jumat", "13:00", "15:00"}
            };
            // 3. Buat Model dan set ke JTable
            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
                //Buat tabel tidak bisa diedit
                @Override
                public boolean isCellEditable(int row, int column) {
                   return false;
                }
            };
            jadwalTable.setRowHeight(30);
            jadwalTable.setModel(model); // Terapkan model ke JTable agar tabel muncul di gui
            jadwalTable.getTableHeader().setResizingAllowed(false);
            jadwalTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            // Dapatkan model kolom 
            javax.swing.table.TableColumnModel columnModel = jadwalTable.getColumnModel();

            // 3. Atur lebar yang Anda inginkan untuk setiap kolom

            // Kolom "No"
            columnModel.getColumn(0).setPreferredWidth(30);

            // Kolom "Kode"
            columnModel.getColumn(1).setPreferredWidth(80); 

            // Kolom "Mata Kuliah"
            columnModel.getColumn(2).setPreferredWidth(350); 

            // Kolom "Dosen" 
            columnModel.getColumn(3).setPreferredWidth(285); 

            // Kolom "Ruang"
            columnModel.getColumn(4).setPreferredWidth(80); 

            // Kolom "Hari"
            columnModel.getColumn(5).setPreferredWidth(90); 

            // Kolom "Mulai"
            columnModel.getColumn(6).setPreferredWidth(80);

            // Kolom "Selesai"
            columnModel.getColumn(7).setPreferredWidth(80);
            
            //Tampilkan jadwalTable di dalam scroll pane
            jScrollPane1.setViewportView(tableContainerPanel);
        }
        
        // Terapkan warna Dark Mode ke komponen yang baru dimuat
        setDarkMode(DarkMode.isDarkMode);

        // Perbarui UI
        this.revalidate();
        this.repaint();
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

package com.mycompany.tr_pbog.dosen;

import com.mycompany.tr_pbog.mahasiswa.MahasiswaNilaiCardPanel;
import com.mycompany.tr_pbog.DarkMode.Listener;

import DTO.LihatMahasiswa;
import com.mycompany.tr_pbog.DarkMode;
import com.mycompany.tr_pbog.DasarListKelasDosenMahasiswa;
import dbCon.Kelas;
import logic.FiturDosen;
import java.util.List;
import java.awt.Color;
import javax.swing.JPanel;
public class DaftarMahasiswaPanel extends javax.swing.JPanel implements Listener {
    
    // Panel utama (mainPanel dari DosenHomePage)
    private JPanel mainPanel;
    private DasarListKelasDosenMahasiswa parentPanel; 
    FiturDosen fDosen = new FiturDosen();
    public DaftarMahasiswaPanel(JPanel mainPanel, DasarListKelasDosenMahasiswa parentPanel, String classID, String className, Kelas kelas) {
        initComponents();
        
        this.mainPanel = mainPanel;
        this.parentPanel = parentPanel;
        this.setOpaque(false);
        this.navPanel.setOpaque(false);
        this.detailScrollPane.setOpaque(false);
        this.detailScrollPane.getViewport().setOpaque(false);
        this.detailScrollPane.setBorder(null);
        this.studentListContentPanel.setOpaque(false);
        loadMahasiswa(classID, className, kelas);
        setDarkMode(DarkMode.isDarkMode);
    }
    public void loadMahasiswa(String classID, String className, Kelas kelas) {
        detailJudulLabel.setText("Daftar Mahasiswa - " + className);
        studentListContentPanel.removeAll();
        List<LihatMahasiswa> mhs = fDosen.lihatMahasiswa(kelas);
        System.out.println("DEBUG: Jumlah siswa ditemukan: " + mhs.size());
        
        for (LihatMahasiswa mahasiswa: mhs) {
            String studentID = mahasiswa.getNim();
            String studentName = mahasiswa.getNama();
            System.out.println("DEBUG: Menambahkan Mahasiswa - ID: " + studentID + ", Nama: " + studentName);
            MahasiswaNilaiCardPanel card = new MahasiswaNilaiCardPanel(studentID, studentName, kelas.getId_kelas());
            studentListContentPanel.add(card);
        }
        
        studentListContentPanel.revalidate();
        studentListContentPanel.repaint();
    }
    
    @Override
    public void setDarkMode(boolean isDark) {
        Color bgColor = isDark ? new Color(38, 38, 40) : new Color(249, 248, 246);
        Color textColor = isDark ? Color.WHITE : Color.BLACK;

        this.setBackground(bgColor);
        this.navPanel.setBackground(bgColor);
        this.studentListContentPanel.setBackground(bgColor);
        this.detailScrollPane.getViewport().setBackground(bgColor);
        this.detailJudulLabel.setForeground(textColor);
        for (java.awt.Component card : studentListContentPanel.getComponents()) {
            if (card instanceof Listener) {
                ((Listener) card).setDarkMode(isDark);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navPanel = new javax.swing.JPanel();
        detailJudulLabel = new javax.swing.JLabel();
        kembaliButton = new javax.swing.JButton();
        detailScrollPane = new javax.swing.JScrollPane();
        studentListContentPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        navPanel.setLayout(new java.awt.BorderLayout());

        detailJudulLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        detailJudulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailJudulLabel.setText("jLabel1");
        navPanel.add(detailJudulLabel, java.awt.BorderLayout.CENTER);

        kembaliButton.setText("Kembali");
        kembaliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliButtonActionPerformed(evt);
            }
        });
        navPanel.add(kembaliButton, java.awt.BorderLayout.LINE_START);

        add(navPanel, java.awt.BorderLayout.NORTH);

        studentListContentPanel.setLayout(new javax.swing.BoxLayout(studentListContentPanel, javax.swing.BoxLayout.Y_AXIS));
        detailScrollPane.setViewportView(studentListContentPanel);

        add(detailScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliButtonActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(parentPanel, java.awt.BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_kembaliButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detailJudulLabel;
    private javax.swing.JScrollPane detailScrollPane;
    private javax.swing.JButton kembaliButton;
    private javax.swing.JPanel navPanel;
    private javax.swing.JPanel studentListContentPanel;
    // End of variables declaration//GEN-END:variables
}

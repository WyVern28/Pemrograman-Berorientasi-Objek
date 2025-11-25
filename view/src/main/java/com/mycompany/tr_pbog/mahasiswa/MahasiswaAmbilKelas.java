package com.mycompany.tr_pbog.mahasiswa;

import com.mycompany.tr_pbog.DarkMode.Listener;
import java.awt.CardLayout;
import java.awt.Color;
import dbCon.Matkul;
import DTO.RegistrasiKelas;
import com.mycompany.tr_pbog.DarkMode;
import logic.FiturMahasiswa;
import java.util.List;
import dbCon.Mahasiswa;
import javax.swing.JOptionPane;

public class MahasiswaAmbilKelas extends javax.swing.JPanel implements Listener {

    private CardLayout cardLayout;

    public MahasiswaAmbilKelas(Mahasiswa mhs) {
        initComponents();
        cardLayout = (CardLayout) (this.getLayout());
        cardLayout.show(this, "masterCard");
        setupTransparency();
        loadMatkulMasterList(mhs);
        setDarkMode(DarkMode.isDarkMode);
    }

    private void loadMatkulMasterList(Mahasiswa mhs) {
        matkulListContentPanel.removeAll();
        FiturMahasiswa fMahasiswa = new FiturMahasiswa();
        List<Matkul> lsMatkul = fMahasiswa.getMatkul(mhs);
        
        for (Matkul matkul : lsMatkul) {
            String matkulID = matkul.getId_matkul();
            String matkulName = matkul.getNama_matkul();
            matkulIndukCardPanel card = new matkulIndukCardPanel(matkulID, matkulName);
            card.getPilihButton().addActionListener(e -> {
                showKelasDetailView(matkul, mhs);
            });
            
            matkulListContentPanel.add(card);
        }
        
        matkulListContentPanel.revalidate();
        matkulListContentPanel.repaint();
    }
    //daftar kelas dalam matkul
    private void showKelasDetailView(Matkul matkul, Mahasiswa mhs) {
        detailScrollPane.getViewport().setOpaque(false);
        FiturMahasiswa fMahasiswa = new FiturMahasiswa();
        boolean bisaAmbil = fMahasiswa.bisaAmbilMatkul(mhs.getNim(), matkul.getId_matkul());
        if (bisaAmbil) {
        List<RegistrasiKelas> lstKelas = fMahasiswa.getKelas(matkul);
        detailJudulLabel.setText("Pilih Kelas untuk: " + matkul.getNama_matkul());
        kelasDetailContentPanel.removeAll();
        String[][] data = null;
        for (RegistrasiKelas kelas : lstKelas){
            data = new String[][] {{kelas.getId_kelas(), kelas.getNama_kelas() +"   |   " + kelas.getNamaDosen() + "      " + "Kapasitas: " + kelas.getKapasitas()}};
        }
        
        for (String[] kelas : data) {
            String kodeKelas = kelas[0];
            String infoText = kelas[1];
            kelasDetailCardPanel card = new kelasDetailCardPanel(kodeKelas, infoText);
            card.getAmbilButton().addActionListener(e -> {
                handleAmbilKelas(kodeKelas, mhs.getNim());
            });
            kelasDetailContentPanel.add(card);
        }

        setDarkMode(DarkMode.isDarkMode);
        cardLayout.show(this, "detailCard");
        
        kelasDetailContentPanel.revalidate();
        kelasDetailContentPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Sudah ambil kelas", matkul.getNama_matkul(), JOptionPane.INFORMATION_MESSAGE, null);
        }
    }
    private void handleAmbilKelas(String kodeKelas, String nim) {
        FiturMahasiswa fMahasiswa = new FiturMahasiswa();
        boolean adaKelas = fMahasiswa.cekAdaKelas(kodeKelas);
        System.out.println("Kode Kelas: " + kodeKelas);
        System.out.println("nilai adaKelas: " + adaKelas);
        if (adaKelas) {        
            int response = JOptionPane.showConfirmDialog(this, 
                         "Anda yakin ingin mengambil kelas:\n" + kodeKelas, "Konfirmasi Pengambilan", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                boolean cekTabrakan = fMahasiswa.cekTabrakanJadwal(nim, kodeKelas);
                System.out.println("Cek tabrakan: " + cekTabrakan);
                if (!cekTabrakan) {
                        fMahasiswa.regisKelas(nim, kodeKelas);
                        JOptionPane.showMessageDialog(this, 
                            "Berhasil mengambil " + kodeKelas, 
                            "Registrasi Berhasil", JOptionPane.INFORMATION_MESSAGE);
                        showMasterListView();   
                } else {
                    JOptionPane.showMessageDialog(this, "Kelas Tabrakan dengan kelas lain", "Registrasi Kelas", JOptionPane.INFORMATION_MESSAGE, null);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Kelas penuh", "Registrasi Kelas", JOptionPane.INFORMATION_MESSAGE, null);
        }
        
    }
    private void showMasterListView() {
        cardLayout.show(this, "masterCard");
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
    @Override
    public void setDarkMode(boolean isDark) {
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

        add(panelMasterList, "masterCard");

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

        add(panelDetailView, "detailCard");
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

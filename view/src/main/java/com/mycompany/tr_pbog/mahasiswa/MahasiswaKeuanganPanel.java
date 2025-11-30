package com.mycompany.tr_pbog.mahasiswa;

import com.mycompany.tr_pbog.DarkMode;
import com.mycompany.tr_pbog.DarkMode.Listener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import logic.FiturKeuangan;
import DTO.TagihanDTO;
import dbCon.Mahasiswa;

public class MahasiswaKeuanganPanel extends javax.swing.JPanel implements Listener {

    private FiturKeuangan fiturKeuangan;
    private Mahasiswa mahasiswa;
    private List<TagihanDTO> currentDataList;

    public MahasiswaKeuanganPanel(Mahasiswa mhs) {
        initComponents();
        this.mahasiswa = mhs;
        this.fiturKeuangan = new FiturKeuangan();

        initDateTime();
        setupCustomTable();
        loadData();
        setDarkMode(DarkMode.isDarkMode);

        this.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel4.setOpaque(false);
        jPanel6.setOpaque(false);
        jPanel3.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setOpaque(false);
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

    private void setupCustomTable() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Pilih", "ID Nilai", "Mata Kuliah", "SKS", "Total Harga", "Status"}
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) return Boolean.class;
                return super.getColumnClass(columnIndex);
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                String status = (String) getValueAt(row, 5);
                return column == 0 && "BELUM".equalsIgnoreCase(status);
            }
        };

        tblTagihan.setModel(model);

        tblTagihan.getColumnModel().getColumn(1).setMinWidth(0);
        tblTagihan.getColumnModel().getColumn(1).setMaxWidth(0);
        tblTagihan.getColumnModel().getColumn(1).setWidth(0);

        tblTagihan.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblTagihan.getColumnModel().getColumn(0).setMaxWidth(50);

        tblTagihan.getTableHeader().setResizingAllowed(false);
        tblTagihan.setRowHeight(30);

        tblTagihan.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String status = (String) table.getValueAt(row, 5); // Kolom 5 = Status

                if ("LUNAS".equalsIgnoreCase(status)) {
                    c.setBackground(new Color(200, 255, 200));
                    c.setForeground(Color.BLACK);
                } else {
                    if (isSelected) {
                        c.setBackground(table.getSelectionBackground());
                        c.setForeground(table.getSelectionForeground());
                    } else {
                        c.setBackground(Color.WHITE);
                        c.setForeground(Color.BLACK);
                    }
                }
                return c;
            }
        });

        tblTagihan.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                String status = (String) table.getValueAt(row, 5);

                if ("LUNAS".equalsIgnoreCase(status)) {
                    super.getTableCellRendererComponent(table, "", isSelected, hasFocus, row, column);
                    this.setBackground(new Color(200, 255, 200));
                    this.setBorder(null);
                    return this;
                } else {
                    return table.getDefaultRenderer(Boolean.class).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });
    }

    private void loadData() {
        lblHargaSks.setText("Harga Per SKS: " + fiturKeuangan.getInfoHargaSKS());
        currentDataList = fiturKeuangan.getDaftarTagihan(mahasiswa.getNim());

        DefaultTableModel model = (DefaultTableModel) tblTagihan.getModel();
        model.setRowCount(0);

        for (TagihanDTO data : currentDataList) {
            Object[] row = {
                    false,
                    data.getIdNilai(),
                    data.getNamaMatkul(),
                    data.getSks(),
                    String.format("Rp %,.0f", data.getTotalHarga()),
                    data.getStatusBayar()
            };
            model.addRow(row);
        }
    }

    private void aksiBayarPilihan() {
        List<TagihanDTO> itemToPay = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tblTagihan.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 0);
            TagihanDTO dto = currentDataList.get(i);

            if (Boolean.TRUE.equals(isChecked) && "BELUM".equals(dto.getStatusBayar())) {
                itemToPay.add(dto);
            }
        }

        if (itemToPay.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih minimal satu matkul yang BELUM lunas!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        openInvoice(itemToPay);
    }

    private void aksiBayarSemua() {
        List<TagihanDTO> itemToPay = new ArrayList<>();

        for (TagihanDTO dto : currentDataList) {
            if ("BELUM".equals(dto.getStatusBayar())) {
                itemToPay.add(dto);
            }
        }

        if (itemToPay.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua tagihan sudah LUNAS!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        openInvoice(itemToPay);
    }

    private void openInvoice(List<TagihanDTO> items) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        InvoiceDialogGUI dialog = new InvoiceDialogGUI(parentFrame, true, items, fiturKeuangan, () -> {
            loadData();
        });

        dialog.setVisible(true);
    }

    @Override
    public void setDarkMode(boolean isDark) {
        if (isDark) {
            jPanel2.setBackground(new Color(38, 38, 40));
            informationTitle.setForeground(Color.WHITE);
            dateLabel.setForeground(Color.WHITE);
            clockLabel.setForeground(Color.WHITE);
            lblHargaSks.setForeground(Color.WHITE);

            tblTagihan.setBackground(new Color(38, 38, 40));
            tblTagihan.setForeground(Color.WHITE);
            tblTagihan.setGridColor(Color.WHITE);
            tblTagihan.getTableHeader().setBackground(new Color(50, 50, 52));
            tblTagihan.getTableHeader().setForeground(Color.WHITE);
        } else {
            jPanel2.setBackground(new Color(249, 248, 246));
            informationTitle.setForeground(Color.BLACK);
            dateLabel.setForeground(Color.BLACK);
            clockLabel.setForeground(Color.BLACK);
            lblHargaSks.setForeground(Color.BLACK);

            tblTagihan.setBackground(new Color(249, 248, 246));
            tblTagihan.setForeground(Color.BLACK);
            tblTagihan.setGridColor(Color.BLACK);
            tblTagihan.getTableHeader().setBackground(new Color(240, 240, 240));
            tblTagihan.getTableHeader().setForeground(Color.BLACK);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        informationTitle = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        clockLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTagihan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        lblHargaSks = new javax.swing.JLabel();
        btnBayarSemua = new javax.swing.JButton();
        btnBayarPilih = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setOpaque(false);

        informationTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        informationTitle.setText("Pembayaran Mata Kuliah");

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setText("dateLabel");

        clockLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clockLabel.setText("clockLabel");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(informationTitle)
                                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(833, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clockLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(informationTitle)
                                .addContainerGap())
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setOpaque(false);

        tblTagihan.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {}
        ));
        tblTagihan.setShowGrid(true);
        jScrollPane1.setViewportView(tblTagihan);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setOpaque(false);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblHargaSks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHargaSks.setText("Harga Per SKS: Rp 0");

        btnBayarSemua.setBackground(new java.awt.Color(51, 255, 102));
        btnBayarSemua.setText("Bayar Semua");
        btnBayarSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarSemuaActionPerformed(evt);
            }
        });

        btnBayarPilih.setBackground(new java.awt.Color(255, 153, 0));
        btnBayarPilih.setForeground(new java.awt.Color(255, 255, 255));
        btnBayarPilih.setText("Bayar Yang Dipilih");
        btnBayarPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarPilihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblHargaSks)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                                .addComponent(btnRefresh)
                                .addGap(18, 18, 18)
                                .addComponent(btnBayarPilih)
                                .addGap(18, 18, 18)
                                .addComponent(btnBayarSemua)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRefresh)
                                        .addComponent(lblHargaSks)
                                        .addComponent(btnBayarSemua)
                                        .addComponent(btnBayarPilih))
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.SOUTH);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>                        

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        loadData();
    }

    private void btnBayarSemuaActionPerformed(java.awt.event.ActionEvent evt) {
        aksiBayarSemua();
    }

    private void btnBayarPilihActionPerformed(java.awt.event.ActionEvent evt) {
        aksiBayarPilihan();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBayarPilih;
    private javax.swing.JButton btnBayarSemua;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel informationTitle;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHargaSks;
    private javax.swing.JTable tblTagihan;
    // End of variables declaration                   
}
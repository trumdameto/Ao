package view;

import entity.GiayChiTiet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import repository.GiayChiTietDAO;

public class HoaDon_panel extends javax.swing.JFrame {

    private DefaultTableModel dtmSP = new DefaultTableModel();
    private ArrayList<GiayChiTiet> listGCT = new ArrayList<>();
    private GiayChiTietDAO gctDao = new GiayChiTietDAO();
    
    public HoaDon_panel() {
        initComponents();
        dtmSP = (DefaultTableModel) tblGiayCT.getModel();
        listGCT = gctDao.getAll();
//        loadTableSanPham();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTaoHD = new javax.swing.JLabel();
        pnlTrai = new javax.swing.JPanel();
        pnTableDSHD = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        pnlGiayCT = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGiayCT = new javax.swing.JTable();
        pnlTableHDCT = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        lblMa = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        pnlPhai = new javax.swing.JPanel();
        pnlThongTinHD = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1140, 640));

        btnTaoHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTaoHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTaoHD.setText("Tạo hóa đơn");
        btnTaoHD.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));
        btnTaoHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHDMouseClicked(evt);
            }
        });

        pnTableDSHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDon);

        javax.swing.GroupLayout pnTableDSHDLayout = new javax.swing.GroupLayout(pnTableDSHD);
        pnTableDSHD.setLayout(pnTableDSHDLayout);
        pnTableDSHDLayout.setHorizontalGroup(
            pnTableDSHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnTableDSHDLayout.setVerticalGroup(
            pnTableDSHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTableDSHDLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlGiayCT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        tblGiayCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane4.setViewportView(tblGiayCT);

        javax.swing.GroupLayout pnlGiayCTLayout = new javax.swing.GroupLayout(pnlGiayCT);
        pnlGiayCT.setLayout(pnlGiayCTLayout);
        pnlGiayCTLayout.setHorizontalGroup(
            pnlGiayCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlGiayCTLayout.setVerticalGroup(
            pnlGiayCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGiayCTLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTableHDCT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane3.setViewportView(tblHDCT);

        javax.swing.GroupLayout pnlTableHDCTLayout = new javax.swing.GroupLayout(pnlTableHDCT);
        pnlTableHDCT.setLayout(pnlTableHDCTLayout);
        pnlTableHDCTLayout.setHorizontalGroup(
            pnlTableHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        pnlTableHDCTLayout.setVerticalGroup(
            pnlTableHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTraiLayout = new javax.swing.GroupLayout(pnlTrai);
        pnlTrai.setLayout(pnlTraiLayout);
        pnlTraiLayout.setHorizontalGroup(
            pnlTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTableDSHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlGiayCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTableHDCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlTraiLayout.setVerticalGroup(
            pnlTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraiLayout.createSequentialGroup()
                .addComponent(pnlTableHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlGiayCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTableDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMa.setText("Mã HĐ:");

        lblMaHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblMaHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.darkGray));

        pnlThongTinHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        javax.swing.GroupLayout pnlThongTinHDLayout = new javax.swing.GroupLayout(pnlThongTinHD);
        pnlThongTinHD.setLayout(pnlThongTinHDLayout);
        pnlThongTinHDLayout.setHorizontalGroup(
            pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        pnlThongTinHDLayout.setVerticalGroup(
            pnlThongTinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPhaiLayout = new javax.swing.GroupLayout(pnlPhai);
        pnlPhai.setLayout(pnlPhaiLayout);
        pnlPhaiLayout.setHorizontalGroup(
            pnlPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhaiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlThongTinHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPhaiLayout.setVerticalGroup(
            pnlPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlThongTinHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(682, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTrai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlPhai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMa, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTrai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPhai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

//    void loadTableSanPham(){
//        dtmSP.setRowCount(0);
//        for (GiayChiTiet gct : listGCT) {
//            dtmSP.addRow(new Object[]{
//                gct.getId_giay(),gct.getId_hang(),
//                gct.getId_kieudang(),gct.getId_danhmuc(),
//                gct.getId_mausac(),gct.getId_kichco(),
//                gct.getHinhanh(),gct.getGia(),
//                gct.getSoluong(),gct.getTrangthai()
//            });
//        }
//    }
    private void btnTaoHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHDMouseClicked
        
    }//GEN-LAST:event_btnTaoHDMouseClicked
  public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HoaDon_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDon_panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnTaoHD;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JPanel pnTableDSHD;
    private javax.swing.JPanel pnlGiayCT;
    private javax.swing.JPanel pnlPhai;
    private javax.swing.JPanel pnlTableHDCT;
    private javax.swing.JPanel pnlThongTinHD;
    private javax.swing.JPanel pnlTrai;
    private javax.swing.JTable tblGiayCT;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables
}

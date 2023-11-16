package view;

import entity.KichCo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repository.KichCoDAO;
import utilities.JOPane;

public class KichCoView extends javax.swing.JFrame {

    private KichCoDAO hangservice = new KichCoDAO();
    private DefaultTableModel dtm;
    private int soTrang = 1; //số Trang hiện tại
    private int soDong = 5;//Số dòng hiển thị mỗi trang của bảng
    private List<KichCo> list;

    public KichCoView() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this);
        setResizable(false);
        list = hangservice.getKichCo();
        dtm = (DefaultTableModel) tblHang.getModel();
        dtm.setRowCount(soDong);
        fillTable();
    }

    void clear() {
        txtHang.setText("");
    }

    void showTable(KichCo hang) {
        txtHang.setText(hang.getSize()+"");
    }

    void fillTable() {
        int maxPage = (int) Math.ceil((double) list.size() / soDong);//Tạo max trang

        int startIdx = (soTrang - 1) * soDong;
        int endIdx = Math.min(startIdx + soDong, list.size());

        dtm.setRowCount(0);

        for (int i = startIdx; i < endIdx; i++) {
            KichCo hang = list.get(i);
            dtm.addRow(new Object[]{
                hang.getSize()
            });
        }

        lblItemPage.setText("Page " + soTrang + " of " + " / " + maxPage);
    }

    KichCo getForm() {
        String tenHang = txtHang.getText().trim();
        if (tenHang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên hãng kìa");
            return null;
        }
        KichCo hang = new KichCo(Integer.parseInt(tenHang));
        return hang;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtHang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHang = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblItemPage = new javax.swing.JLabel();
        btnPrevPage = new javax.swing.JButton();
        btnNextPage = new javax.swing.JButton();
        btnHang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hãng");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, 51, 31));
        getContentPane().add(txtHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 41, 224, -1));

        tblHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Tên Hãng"
            }
        ));
        tblHang.getTableHeader().setResizingAllowed(false);
        tblHang.getTableHeader().setReorderingAllowed(false);
        tblHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 109, 281, 118));

        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 74, -1, -1));

        txtSearch.setText("Tìm theo tên");
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 74, 138, -1));

        lblItemPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblItemPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 80, 25));

        btnPrevPage.setText("<");
        btnPrevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevPageActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrevPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        btnNextPage.setText(">");
        btnNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPageActionPerformed(evt);
            }
        });
        getContentPane().add(btnNextPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnHangLayout = new javax.swing.GroupLayout(btnHang);
        btnHang.setLayout(btnHangLayout);
        btnHangLayout.setHorizontalGroup(
            btnHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHangLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnHangLayout.setVerticalGroup(
            btnHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSua)
                .addComponent(btnThem)
                .addComponent(btnXoa))
        );

        getContentPane().add(btnHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 264, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close Window.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KichCo hang = getForm();
        if (hang == null) {
            return;
        } else {
            boolean confirm = JOPane.showConfirmDialog(this, "Are you sure?");
            if (confirm) {
                hangservice.InsertKichCo(hang);
                list = hangservice.getKichCo();
                fillTable();
                clear();
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblHang.getSelectedRow();
        if (row < 0) {
            JOPane.showMessageDialog(this, "Chọn hãng cần sửa!");
            return;
        }
        if (row >= 0) {
            boolean confirm = JOPane.showConfirmDialog(this, "Are you sure?");
            if (confirm) {
                int rowHienTai = (soTrang - 1) * soDong + row;
                if (rowHienTai < list.size()) {
                    KichCo hang = getForm();
                    hang.setId(hangservice.getKichCo().get(rowHienTai).getId());
                    hangservice.UpdateKichCo(hang);
                    list = hangservice.getKichCo();
                    fillTable();
                    clear();
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangMouseClicked
        int row = tblHang.getSelectedRow();
        if (row >= 0) {
            int rowHienTai = (soTrang - 1) * soDong + row;
            if (rowHienTai < list.size()) {
                KichCo hang = list.get(rowHienTai);
                showTable(hang);
            }
        }
    }//GEN-LAST:event_tblHangMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblHang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn hãng cần xóa!");
            return;
        }
        if (row >= 0) {
            boolean confirm = JOPane.showConfirmDialog(this, "Are you sure?");
            if (confirm) {
                String name = tblHang.getValueAt(row, 0).toString();
                hangservice.DeleteKichCo(Integer.parseInt(name));
                list = hangservice.getKichCo();
                fillTable();
                clear();
                JOptionPane.showMessageDialog(this, "Xóa thành công hãng: " + name);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String search = txtSearch.getText().trim();
        KichCo hang = hangservice.SearchKichCo(Integer.parseInt(search));
        if (search == null) {
            JOPane.showMessageDialog(this, "Nhập kích cỡ cần tìm !");
        } else {
            boolean confirm = JOPane.showConfirmDialog(this, "Are you sure?");
            if (confirm) {
                if (Integer.parseInt(search)==hang.getSize()) {
                    showTable(hang);
                    JOPane.showMessageDialog(this, "Tìm thấy kich cỡ tên: " + hang.getSize());
                } else {
                    JOPane.showMessageDialog(this, "Không tìm thấy kich cỡ tên: " + hang.getSize());
                }
            }

        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevPageActionPerformed
        if (soTrang > 1) {
            soTrang--;
            fillTable();
        }
    }//GEN-LAST:event_btnPrevPageActionPerformed

    private void btnNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPageActionPerformed
        int maxPage = (int) Math.ceil((double) hangservice.getKichCo().size() / soDong);
        if (soTrang < maxPage) {
            soTrang++;
            fillTable();
        }
    }//GEN-LAST:event_btnNextPageActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KichCoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KichCoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KichCoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KichCoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KichCoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnHang;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPrevPage;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItemPage;
    private javax.swing.JTable tblHang;
    private javax.swing.JTextField txtHang;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

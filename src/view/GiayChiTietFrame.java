package view;

import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import entity.DanhMuc;
import entity.Giay;
import entity.GiayChiTiet;
import entity.Hang;
import entity.KichCo;
import entity.KieuDang;
import entity.MauSac;
import java.math.BigDecimal;
import repository.DanhMucDAO;
import repository.GiayChiTietRepository;
import repository.HangDAO;
import repository.KichCoDAO;
import repository.KieuDangDAO;
import repository.MauSacDAO;
import utilities.JOPane;

public class GiayChiTietFrame extends javax.swing.JFrame {

    private DanhMucView danhMucFrame = new DanhMucView();
    private HangView hangFrame = new HangView();
    private KieuDangView kieuDangFrame = new KieuDangView();
    private MauSacView mauSacFrame = new MauSacView();
    private KichCoView kichCoFrame = new KichCoView();

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<DanhMuc> listDanhMuc;
    private List<KichCo> listKichCo;
    private List<KieuDang> listKieuDang;
    private List<MauSac> listMauSac;
    private List<Hang> listHang;

    private DanhMucDAO danhMucService = new DanhMucDAO();
    private KichCoDAO kichCoService = new KichCoDAO();
    private KieuDangDAO kieuDangService = new KieuDangDAO();
    private MauSacDAO mauSacService = new MauSacDAO();
    private GiayChiTietRepository giayChiTietService = new GiayChiTietRepository();
    private HangDAO hangService = new HangDAO();

    private Giay giayData;
    private Integer currentPage = 1;
    private Integer rowCountPage = 5;
    private Integer totalPage;
    private List<GiayChiTiet> list;
    private String urlAnh = "";

    public GiayChiTietFrame(Giay giay) {
        initComponents();
        lblMaTen.setText(giay.getMa_giay() + " - " + giay.getName());
        giayData = giay;
        dtm = (DefaultTableModel) tblDanhSach.getModel();
        setSize(860, 530);
        setResizable(false);
        setLocationRelativeTo(null);
        setList();
        setDataCbo();
        setDefaultCloseOperation(2);
        list = giayChiTietService.getAllByGiay(giayData.getId());
        loadData(list, currentPage);
    }

    private void setTotalPage() {
        int totalItem = giayChiTietService.getAllByGiay(giayData.getId()).size();
        if (totalItem % rowCountPage == 0) {
            totalPage = totalItem / rowCountPage;
        } else {
            totalPage = totalItem / rowCountPage + 1;
        }
    }

    private void loadData(List<GiayChiTiet> list, int page) {
        dtm.setRowCount(0);
        setTotalPage();
        int limit = page * rowCountPage;
        int totalItem = list.size();
        lblPage.setText("Trang " + currentPage + "/" + totalPage);
        for (int start = (page - 1) * rowCountPage; start < totalItem; start++) {
            GiayChiTiet giayChiTiet = list.get(start);
            dtm.addRow(new Object[]{
                giayChiTiet.getHang().getName(),
                giayChiTiet.getKieudang().getName(),
                giayChiTiet.getDanhmuc().getName(),
                giayChiTiet.getMausac().getName(),
                giayChiTiet.getKichco().getSize(),
                giayChiTiet.getGia(),
                giayChiTiet.getSoluong(),
                giayChiTiet.getTrangthai()
            });
            if (start + 1 == limit) {
                return;
            }
        }
        dtm.setColumnIdentifiers(new String[]{
            "Hãng", "Kiểu Dáng", "Danh Mục", "Màu Sắc", "Kích Cỡ", "Giá", "Số Lượng", "Trạng Thái"
        });
    }

    private void setList() {
        listDanhMuc = danhMucService.getDanhMuc();
        listKichCo = kichCoService.getKichCo();
        listKieuDang = kieuDangService.getKieuDang();
        listMauSac = mauSacService.getMauSac();
        listHang = hangService.getHang();
    }

    private void setDataDanhMuc() {
        cboDanhMuc.removeAllItems();
        for (DanhMuc danhMuc : listDanhMuc) {
            cboDanhMuc.addItem(danhMuc.getName());
        }
    }

    private void setDataHang() {
        cboHang.removeAllItems();
        for (Hang hang : listHang) {
            cboHang.addItem(hang.getName());
        }
    }

    private void setDataKichCo() {
        cboKichCo.removeAllItems();
        for (KichCo kichCo : listKichCo) {
            cboKichCo.addItem(kichCo.getSize() + "");
        }
    }

    private void setDataKieuDang() {
        cboKieuDang.removeAllItems();
        for (KieuDang kieuDang : listKieuDang) {
            cboKieuDang.addItem(kieuDang.getName());
        }
    }

    private void setDataMauSac() {
        cboMauSac.removeAllItems();
        for (MauSac mauSac : listMauSac) {
            cboMauSac.addItem(mauSac.getName());
        }
    }

    private void setDataTrangThai() {
        cboTrangThai.removeAllItems();
        String[] trangThai = {"Hàng mới", "Hàng cũ", "Hàng..."};
        for (int i = 0; i < trangThai.length; i++) {
            String string = trangThai[i];
            cboTrangThai.addItem(string);
        }
    }

    private void setDataCbo() {
        setDataDanhMuc();
        setDataKichCo();
        setDataKieuDang();
        setDataMauSac();
        setDataTrangThai();
        setDataHang();
    }

    private GiayChiTiet getDataForm() {
        Hang hang = null;
        KieuDang kieuDang = null;
        DanhMuc danhMuc = null;
        MauSac mauSac = null;
        KichCo kichCo = null;
        String gia = txtGia.getText();
        String soLuong = txtSoLuong.getText();
        String trangThai = cboTrangThai.getSelectedItem().toString();
        String moTa = txtMoTa.getText();
        try {
            BigDecimal.valueOf(Double.parseDouble(gia));
            Integer.parseInt(soLuong);
        } catch (Exception e) {
            return null;
        }

        for (int i = 0; i < listDanhMuc.size(); i++) {
            DanhMuc get = listDanhMuc.get(i);
            if (i == cboDanhMuc.getSelectedIndex()) {
                danhMuc = get;
            }
        }
        for (int i = 0; i < listKieuDang.size(); i++) {
            KieuDang get = listKieuDang.get(i);
            if (i == cboKieuDang.getSelectedIndex()) {
                kieuDang = get;
            }
        }
        for (int i = 0; i < listMauSac.size(); i++) {
            MauSac get = listMauSac.get(i);
            if (i == cboMauSac.getSelectedIndex()) {
                mauSac = get;
            }
        }
        for (int i = 0; i < listKichCo.size(); i++) {
            KichCo get = listKichCo.get(i);
            if (i == cboKichCo.getSelectedIndex()) {
                kichCo = get;
            }
        }
        for (int i = 0; i < listHang.size(); i++) {
            Hang get = listHang.get(i);
            if (i == cboKichCo.getSelectedIndex()) {
                hang = get;
            }
        }
        GiayChiTiet giayChiTiet = new GiayChiTiet();
        giayChiTiet.setGiay(giayData);
        giayChiTiet.setDanhmuc(danhMuc);

        giayChiTiet.setHang(hang);
        giayChiTiet.setHinhanh(urlAnh);
        System.out.println("setHinhAnhUrl: " + urlAnh);
        giayChiTiet.setKichco(kichCo);
        giayChiTiet.setKieudang(kieuDang);
        giayChiTiet.setMausac(mauSac);
        giayChiTiet.setGia(BigDecimal.valueOf(Double.parseDouble(gia)));
        giayChiTiet.setSoluong(Integer.parseInt(soLuong));
        giayChiTiet.setTrangthai(trangThai);
        giayChiTiet.setMota(moTa);
        System.out.println(giayChiTiet.toString());
        return giayChiTiet;
    }

    private GiayChiTiet getDataTable() {
        int selected = tblDanhSach.getSelectedRow();
        int index = (currentPage - 1) * rowCountPage + selected;
        System.out.println(giayChiTietService.getAll().get(index).toString());
        return giayChiTietService.getAllByGiay(giayData.getId()).get(index);
    }

    private void showAnh(String icon) {
        // Chuyển ImageIcon thành Image
        System.out.println(icon);
        ImageIcon imageIcon = new ImageIcon(icon);
        Image newImage = imageIcon.getImage().getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);
        urlAnh = icon;
        lblAnh.setIcon(newIcon);
    }

    private void fillTableToForm(GiayChiTiet giayChiTiet) {
        txtGia.setText(giayChiTiet.getGia().toString());
        txtMoTa.setText(giayChiTiet.getMota());
        txtSoLuong.setText(giayChiTiet.getSoluong() + "");
        cboDanhMuc.setSelectedItem(giayChiTiet.getDanhmuc().getName());
        cboHang.setSelectedItem(giayChiTiet.getHang().getName());
        cboKichCo.setSelectedItem(giayChiTiet.getKichco().getSize() + "");
        cboKieuDang.setSelectedItem(giayChiTiet.getKieudang().getName());
        cboMauSac.setSelectedItem(giayChiTiet.getMausac().getName());
        cboTrangThai.setSelectedItem(giayChiTiet.getTrangthai());
        if (giayChiTiet.getHinhanh() == null || giayChiTiet.getHinhanh() == "") {
            lblAnh.setText("Ảnh lỗi");
        } else {
            showAnh(giayChiTiet.getHinhanh());
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

        jPanel1 = new javax.swing.JPanel();
        lblMaTen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        lblPage = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboHang = new javax.swing.JComboBox<>();
        btnHang = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboKieuDang = new javax.swing.JComboBox<>();
        btnKieuDang = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboDanhMuc = new javax.swing.JComboBox<>();
        btnDanhMuc = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        btnMauSac = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboKichCo = new javax.swing.JComboBox<>();
        btnKichCo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMaTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMaTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaTen.setText("Mã - Tên Giày");

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hang", "KieuDang", "DanhMuc", "Mau", "Size", "Gia", "SoLuong", "TrangThai"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        lblPage.setText("Trang");

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrev)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNext, btnPrev});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPage)
                    .addComponent(btnNext)
                    .addComponent(btnPrev))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel3.setText("Hãng");

        cboHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnHang.setText("+");
        btnHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangActionPerformed(evt);
            }
        });

        jLabel4.setText("Kiểu dáng");

        cboKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKieuDang.setText("+");
        btnKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKieuDangActionPerformed(evt);
            }
        });

        jLabel5.setText("Danh mục");

        cboDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDanhMuc.setText("+");
        btnDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMucActionPerformed(evt);
            }
        });

        jLabel6.setText("Màu sắc");

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnMauSac.setText("+");
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        jLabel7.setText("Kích cỡ");

        cboKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKichCo.setText("+");
        btnKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichCoActionPerformed(evt);
            }
        });

        jLabel9.setText("Số lượng");

        jLabel10.setText("Trạng thái");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jLabel12.setText("Hình ảnh:");

        lblAnh.setBackground(new java.awt.Color(255, 255, 255));
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setText("Chọn ảnh");
        lblAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

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

        jLabel13.setText("Giá");

        btnLoad.setText("LoadData");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoad)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cboKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnKieuDang))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnHang)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDanhMuc))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKichCo))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMauSac))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGia)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoLuong))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(btnHang)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(btnKieuDang)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnDanhMuc)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btnMauSac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btnKichCo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLoad)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangActionPerformed
        hangFrame.setVisible(true);
    }//GEN-LAST:event_btnHangActionPerformed

    private void btnKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKieuDangActionPerformed
        // TODO add your handling code here:
        kieuDangFrame.setVisible(true);
    }//GEN-LAST:event_btnKieuDangActionPerformed

    private void btnDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMucActionPerformed
        // TODO add your handling code here:
        danhMucFrame.setVisible(true);
    }//GEN-LAST:event_btnDanhMucActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        // TODO add your handling code here:
        mauSacFrame.setVisible(true);
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichCoActionPerformed
        // TODO add your handling code here:
        kichCoFrame.setVisible(true);
    }//GEN-LAST:event_btnKichCoActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        GiayChiTiet giayct = getDataForm();
        if (giayct == null) {
            JOPane.showMessageDialog(this, "Lỗi truy vấn");
            return;
        }
        if (giayct != null) {
            boolean confirm = JOPane.showConfirmDialog(this, "Are you sure?");
            if (confirm) {
                giayChiTietService.add(giayct);
                list = giayChiTietService.getAllByGiay(giayData.getId());
                loadData(list, currentPage);
                JOPane.showMessageDialog(this, "Thêm thành công");
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        getDataTable();
        fillTableToForm(getDataTable());
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblDanhSach.getSelectedRow();
        if (row < 0) {
            JOPane.showMessageDialog(this, "Chọn sp cần sửa!");
            return;
        }
        if (row >= 0) {
            boolean confirm = JOPane.showConfirmDialog(this, "Are you sure?");
            if (confirm) {
                int rowHienTai = (currentPage - 1) * rowCountPage + row;
                if (rowHienTai < list.size()) {
                    GiayChiTiet gct = getDataForm();
                    giayChiTietService.update(gct);
                    list = giayChiTietService.getAllByGiay(giayData.getId());
                    loadData(list, currentPage);
                    JOPane.showMessageDialog(this, "Sửa thành công");
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        setTotalPage();
        if (currentPage == 1) {
            currentPage = totalPage;
            loadData(list, currentPage);
        } else {
            currentPage--;
            loadData(list, currentPage);
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        setTotalPage();
        if (currentPage == totalPage) {
            currentPage = 1;
            loadData(list, currentPage);
        } else {
            currentPage++;
            loadData(list, currentPage);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn của file được chọn
            String imagePath = fileChooser.getSelectedFile().getAbsolutePath();

            if (imagePath != null && !imagePath.isEmpty()) {
                File imageFile = new File(imagePath);
                // Kiểm tra kiểu tệp (ví dụ: .jpg, .png)
                String fileExtension = imageFile.getName().substring(imageFile.getName().lastIndexOf("."));
                if (fileExtension.equalsIgnoreCase(".jpg") || fileExtension.equalsIgnoreCase(".png") || fileExtension.equalsIgnoreCase(".gif")) {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    System.out.println("imageIcon: " + imageIcon);
                    showAnh(imageIcon.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn hình ảnh!", "Thông báo", JOptionPane.OK_OPTION);
                    System.out.println("Tệp không phải là hình ảnh.");
                }
            } else {
                lblAnh.setIcon(null);
            }
        }
    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        setList();
        setDataCbo();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblDanhSach.getSelectedRow();
        if (row < 0) {
            JOPane.showMessageDialog(this, "Chọn sp cần xóa!");
            return;
        }
        if (row >= 0) {
            boolean confirm = JOPane.showConfirmDialog(this, "Are you sure?");
            if (confirm) {
                int rowHienTai = (currentPage - 1) * rowCountPage + row;
                if (rowHienTai < list.size()) {
                    
                    giayChiTietService.delete(getDataTable().getId());
                    list = giayChiTietService.getAllByGiay(giayData.getId());
                    loadData(list, currentPage);
                    JOPane.showMessageDialog(this, "Xóa thành công");
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiayChiTietFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiayChiTietFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiayChiTietFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiayChiTietFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Giay giay = new Giay();
                new GiayChiTietFrame(giay).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanhMuc;
    private javax.swing.JButton btnHang;
    private javax.swing.JButton btnKichCo;
    private javax.swing.JButton btnKieuDang;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JComboBox<String> cboKichCo;
    private javax.swing.JComboBox<String> cboKieuDang;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblMaTen;
    private javax.swing.JLabel lblPage;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}

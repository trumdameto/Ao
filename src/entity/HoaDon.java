package entity;

import java.math.BigDecimal;
import java.util.Date;

public class HoaDon {

    private String id, ma, id_voucher;
    private NhanVien id_nhanvien;
    private KhachHang id_khachhang;
    private Date ngaytao;
    private String ten_nguoinhan,sdt,diachi;
    private BigDecimal phiship;
    private BigDecimal tongtien;
    private String trangthai;

    public HoaDon() {
    }

    public HoaDon(String id, String ma, String id_voucher, NhanVien id_nhanvien, KhachHang id_khachhang, Date ngaytao, String ten_nguoinhan, String sdt, String diachi, BigDecimal phiship, BigDecimal tongtien, String trangthai) {
        this.id = id;
        this.ma = ma;
        this.id_voucher = id_voucher;
        this.id_nhanvien = id_nhanvien;
        this.id_khachhang = id_khachhang;
        this.ngaytao = ngaytao;
        this.ten_nguoinhan = ten_nguoinhan;
        this.sdt = sdt;
        this.diachi = diachi;
        this.phiship = phiship;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }

    public HoaDon(String ma, String id_voucher, NhanVien id_nhanvien, KhachHang id_khachhang, Date ngaytao, String ten_nguoinhan, String sdt, String diachi, BigDecimal phiship, BigDecimal tongtien, String trangthai) {
        this.ma = ma;
        this.id_voucher = id_voucher;
        this.id_nhanvien = id_nhanvien;
        this.id_khachhang = id_khachhang;
        this.ngaytao = ngaytao;
        this.ten_nguoinhan = ten_nguoinhan;
        this.sdt = sdt;
        this.diachi = diachi;
        this.phiship = phiship;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getId_voucher() {
        return id_voucher;
    }

    public void setId_voucher(String id_voucher) {
        this.id_voucher = id_voucher;
    }

    public NhanVien getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(NhanVien id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public KhachHang getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(KhachHang id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTen_nguoinhan() {
        return ten_nguoinhan;
    }

    public void setTen_nguoinhan(String ten_nguoinhan) {
        this.ten_nguoinhan = ten_nguoinhan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public BigDecimal getPhiship() {
        return phiship;
    }

    public void setPhiship(BigDecimal phiship) {
        this.phiship = phiship;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", ma=" + ma + ", id_voucher=" + id_voucher + ", id_nhanvien=" + id_nhanvien + ", id_khachhang=" + id_khachhang + ", ngaytao=" + ngaytao + ", ten_nguoinhan=" + ten_nguoinhan + ", sdt=" + sdt + ", diachi=" + diachi + ", phiship=" + phiship + ", tongtien=" + tongtien + ", trangthai=" + trangthai + '}';
    }

    
}

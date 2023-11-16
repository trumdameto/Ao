package entity;

import java.math.BigDecimal;

public class GiayChiTiet {

    private String id;
    private Giay giay;
    private Hang hang;
    private KieuDang kieudang;
    private DanhMuc danhmuc;
    private MauSac mausac;
    private KichCo kichco;
    private String hinhanh;
    private BigDecimal gia;
    private int soluong;
    private String trangthai, mota;

    public GiayChiTiet() {
    }

    public GiayChiTiet(String id, Giay giay, Hang hang, KieuDang kieudang, DanhMuc danhmuc, MauSac mausac, KichCo kichco, String hinhanh, BigDecimal gia, int soluong, String trangthai, String mota) {
        this.id = id;
        this.giay = giay;
        this.hang = hang;
        this.kieudang = kieudang;
        this.danhmuc = danhmuc;
        this.mausac = mausac;
        this.kichco = kichco;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.soluong = soluong;
        this.trangthai = trangthai;
        this.mota = mota;
    }

    public GiayChiTiet(Giay giay, Hang hang, KieuDang kieudang, DanhMuc danhmuc, MauSac mausac, KichCo kichco, String hinhanh, BigDecimal gia, int soluong, String trangthai, String mota) {
        this.giay = giay;
        this.hang = hang;
        this.kieudang = kieudang;
        this.danhmuc = danhmuc;
        this.mausac = mausac;
        this.kichco = kichco;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.soluong = soluong;
        this.trangthai = trangthai;
        this.mota = mota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Giay getGiay() {
        return giay;
    }

    public void setGiay(Giay giay) {
        this.giay = giay;
    }

    public Hang getHang() {
        return hang;
    }

    public void setHang(Hang hang) {
        this.hang = hang;
    }

    public KieuDang getKieudang() {
        return kieudang;
    }

    public void setKieudang(KieuDang kieudang) {
        this.kieudang = kieudang;
    }

    public DanhMuc getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(DanhMuc danhmuc) {
        this.danhmuc = danhmuc;
    }

    public MauSac getMausac() {
        return mausac;
    }

    public void setMausac(MauSac mausac) {
        this.mausac = mausac;
    }

    public KichCo getKichco() {
        return kichco;
    }

    public void setKichco(KichCo kichco) {
        this.kichco = kichco;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    
}

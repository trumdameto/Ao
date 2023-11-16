package entity;

import java.math.BigDecimal;

public class HoaDonChiTiet {
     private String id;
     private GiayChiTiet id_giayct;
     private HoaDon id_hoadon;
     private BigDecimal gia;
     private int soluong;
     private String trangthai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String id, GiayChiTiet id_giayct, HoaDon id_hoadon, BigDecimal gia, int soluong, String trangthai) {
        this.id = id;
        this.id_giayct = id_giayct;
        this.id_hoadon = id_hoadon;
        this.gia = gia;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public HoaDonChiTiet(GiayChiTiet id_giayct, HoaDon id_hoadon, BigDecimal gia, int soluong, String trangthai) {
        this.id_giayct = id_giayct;
        this.id_hoadon = id_hoadon;
        this.gia = gia;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GiayChiTiet getId_giayct() {
        return id_giayct;
    }

    public void setId_giayct(GiayChiTiet id_giayct) {
        this.id_giayct = id_giayct;
    }

    public HoaDon getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(HoaDon id_hoadon) {
        this.id_hoadon = id_hoadon;
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

    
}

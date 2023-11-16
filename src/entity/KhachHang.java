package entity;

public class KhachHang {
    private String id,ma,ten;
    private boolean gioitinh=true;// =0 Nam
    private String sdt,diachi;

    public KhachHang(String id, String ma, String ten, boolean gioitinh, String sdt, String diachi) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public KhachHang(String ma, String ten, boolean gioitinh, String sdt, String diachi) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.diachi = diachi;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
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

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", gioitinh=" + gioitinh + ", sdt=" + sdt + ", diachi=" + diachi + '}';
    }
    
    
}

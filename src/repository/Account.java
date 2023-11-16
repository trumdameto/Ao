package repository;

import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilities.DBConnect;

public class Account {

    public static boolean checkLogin(String ma, String matkhau, String vaitro) {
        String sql = "SELECT * FROM NHANVIEN WHERE ma = ? AND matkhau = ? and vaitro=? ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            ps.setString(2, matkhau);
            ps.setString(3, vaitro);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Integer InsertNV(NhanVien nv) {
        String sql = "Insert into NhanVien (id,ma,ten,gioitinh,sdt,diachi,ngaysinh,matkhau,vaitro,trangthai) values (newid(),dbo.AUTO_MaNV(),?,?,?,?,?,?,?,?)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nv.getTen());
            ps.setBoolean(2, nv.isGioitinh());
            ps.setString(3, nv.getSdt());
            ps.setString(4, nv.getDiachi());
            ps.setDate(5, new java.sql.Date(nv.getNgaysinh().getTime()));
            ps.setString(6, nv.getMatkhau());
            ps.setString(7, nv.getVaitro());
            ps.setString(8, nv.getTrangthai());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public ArrayList<NhanVien> getNV() {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "Select * from NhanVien";

        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(new NhanVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

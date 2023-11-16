package repository;

import entity.DanhMuc;
import entity.Giay;
import entity.GiayChiTiet;
import entity.Hang;
import entity.KichCo;
import entity.KieuDang;
import entity.MauSac;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

public class GiayChiTietDAO extends MeoDAO<GiayChiTiet, Object> {

    @Override
    public ArrayList<GiayChiTiet> getAll() {
        ArrayList<GiayChiTiet> list = new ArrayList<>();
        String sql = """
                 SELECT * FROM GIAYCHITIET
                 INNER JOIN DANHMUC ON GIAYCHITIET.ID_DANHMUC = DANHMUC.ID
                 INNER JOIN HANG ON GIAYCHITIET.ID_HANG = HANG.ID
                 INNER JOIN MAUSAC ON GIAYCHITIET.ID_MAUSAC = MAUSAC.ID
                 INNER JOIN GIAY ON GIAYCHITIET.ID_GIAY = GIAY.ID
                 INNER JOIN KICHCO ON GIAYCHITIET.ID_KICHCO = KICHCO.ID
                 INNER JOIN KIEUDANG ON GIAYCHITIET.ID_KIEUDANG = KIEUDANG.ID
                 """;
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);

            while (rs.next()) {
                Giay giay = new Giay(rs.getString("ID_GIAY"), rs.getString("MA_GIAY"), rs.getString(21));
                Hang hang = new Hang(rs.getString("ID_HANG"), rs.getString(16));
                KieuDang kieuDang = new KieuDang(rs.getString("ID_KIEUDANG"), rs.getString(25));
                DanhMuc danhMuc = new DanhMuc(rs.getString("ID_DANHMUC"), rs.getString(14));
                MauSac mauSac = new MauSac(rs.getString("ID_MAUSAC"), rs.getString(18));
                KichCo kichCo = new KichCo(rs.getString("ID_KICHCO"), rs.getInt("SIZE"));

                list.add(new GiayChiTiet(rs.getString(1), giay, hang, kieuDang, danhMuc, mauSac, kichCo,
                        rs.getString(8),
                        rs.getBigDecimal(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCHelper.closeConnection();
        }
        return null;
    }

    @Override
    public Integer insert(GiayChiTiet entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer update(GiayChiTiet entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

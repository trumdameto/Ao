package repository;

import entity.Hang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.KieuDang;
import java.sql.SQLException;
import utilities.DBConnect;

public class KieuDangDAO {

     public ArrayList<KieuDang> getKieuDang() {
        ArrayList<KieuDang> list = new ArrayList<>();
        String sql = "SELECT * FROM KieuDang";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                list.add(new KieuDang(id, name));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //đóng kết nối sau khi hoàn thành công việc
            JDBCHelper.closeConnection();
        }
        return null;
    }

    public Integer InsertKieuDang(KieuDang hang) {
        String sql = "insert into KieuDang (id,name) values (newid(),?)";
        int row = JDBCHelper.excuteUpdate(sql, hang.getName());
        return row;
    }

    public Integer UpdateKieuDang(KieuDang hang) {
        String sql = "update KieuDang set name=? where id = ?";
        int row = JDBCHelper.excuteUpdate(sql, hang.getName(), hang.getId());
        return row;
    }

    public Integer DeleteKieuDang(String name) {
        String sql = "DELETE FROM KieuDang WHERE name = ?";
        int row = JDBCHelper.excuteUpdate(sql, name);
        return row;
    }

    public KieuDang SearchKieuDang(String name) {
        String sql = "SELECT * FROM KieuDang WHERE name=?";
        ResultSet rs = JDBCHelper.executeQuery(sql, name);

        if (rs != null) {
            try {
                if (rs.next()) {
                    return new KieuDang(rs.getString("id"), rs.getString("name"));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

package repository;

import entity.Hang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.MauSac;
import java.sql.SQLException;
import utilities.DBConnect;


public class MauSacDAO {

    public ArrayList<MauSac> getMauSac() {
        ArrayList<MauSac> list = new ArrayList<>();
        String sql = "SELECT * FROM MauSac";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                list.add(new MauSac(id, name));
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

    public Integer InsertMauSac(MauSac hang) {
        String sql = "insert into MauSac (id,name) values (newid(),?)";
        int row = JDBCHelper.excuteUpdate(sql, hang.getName());
        return row;
    }

    public Integer UpdateMauSac(MauSac hang) {
        String sql = "update MauSac set name=? where id = ?";
        int row = JDBCHelper.excuteUpdate(sql, hang.getName(), hang.getId());
        return row;
    }

    public Integer DeleteMauSac(String name) {
        String sql = "DELETE FROM MauSac WHERE name = ?";
        int row = JDBCHelper.excuteUpdate(sql, name);
        return row;
    }

    public MauSac SearchMauSac(String name) {
        String sql = "SELECT * FROM MauSac WHERE name=?";
        ResultSet rs = JDBCHelper.executeQuery(sql, name);

        if (rs != null) {
            try {
                if (rs.next()) {
                    return new MauSac(rs.getString("id"), rs.getString("name"));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

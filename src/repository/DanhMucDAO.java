package repository;

import entity.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import utilities.DBConnect;

public class DanhMucDAO {

     public ArrayList<DanhMuc> getDanhMuc() {
        ArrayList<DanhMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM DanhMuc";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                list.add(new DanhMuc(id, name));
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

    public Integer InsertDanhMuc(DanhMuc hang) {
        String sql = "insert into DanhMuc (id,name) values (newid(),?)";
        int row = JDBCHelper.excuteUpdate(sql, hang.getName());
        return row;
    }

    public Integer UpdateDanhMuc(DanhMuc hang) {
        String sql = "update DanhMuc set name=? where id = ?";
        int row = JDBCHelper.excuteUpdate(sql, hang.getName(), hang.getId());
        return row;
    }

    public Integer DeleteDanhMuc(String name) {
        String sql = "DELETE FROM DanhMuc WHERE name = ?";
        int row = JDBCHelper.excuteUpdate(sql, name);
        return row;
    }

    public DanhMuc SearchDanhMuc(String name) {
        String sql = "SELECT * FROM DanhMuc WHERE name=?";
        ResultSet rs = JDBCHelper.executeQuery(sql, name);

        if (rs != null) {
            try {
                if (rs.next()) {
                    return new DanhMuc(rs.getString("id"), rs.getString("name"));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

package repository;

import entity.Hang;
import java.sql.*;
import java.util.ArrayList;

public class HangDAO {

    public ArrayList<Hang> getHang() {
        ArrayList<Hang> list = new ArrayList<>();
        String sql = "SELECT * FROM Hang";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                list.add(new Hang(id, name));
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

    public Integer InsertHang(Hang hang) {
        String sql = "insert into HANG (id,name) values (newid(),?)";
        int row = JDBCHelper.excuteUpdate(sql, hang.getName());
        return row;
    }

    public Integer UpdateHang(Hang hang) {
        String sql = "update HANG set name=? where id = ?";
        int row = JDBCHelper.excuteUpdate(sql, hang.getName(), hang.getId());
        return row;
    }

    public Integer DeleteHang(String name) {
        String sql = "DELETE FROM HANG WHERE name = ?";
        int row = JDBCHelper.excuteUpdate(sql, name);
        return row;
    }

    public Hang SearchHang(String name) {
        String sql = "SELECT * FROM Hang WHERE name=?";
        ResultSet rs = JDBCHelper.executeQuery(sql, name);

        if (rs != null) {
            try {
                if (rs.next()) {
                    return new Hang(rs.getString("id"), rs.getString("name"));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
    

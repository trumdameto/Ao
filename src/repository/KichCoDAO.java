package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.KichCo;
import entity.MauSac;
import java.sql.SQLException;
import utilities.DBConnect;

public class KichCoDAO {

    public ArrayList<KichCo> getKichCo() {
        ArrayList<KichCo> list = new ArrayList<>();
        String sql = "SELECT * FROM KichCo";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                Integer size = rs.getInt("size");
                list.add(new KichCo(id, size));
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

    public Integer InsertKichCo(KichCo hang) {
        String sql = "insert into KichCo (id,size) values (newid(),?)";
        int row = JDBCHelper.excuteUpdate(sql, hang.getSize());
        return row;
    }

    public Integer UpdateKichCo(KichCo hang) {
        String sql = "update KichCo set size=? where id = ?";
        int row = JDBCHelper.excuteUpdate(sql, hang.getSize(), hang.getId());
        return row;
    }

    public Integer DeleteKichCo(int size) {
        String sql = "DELETE FROM KichCo WHERE size = ?";
        int row = JDBCHelper.excuteUpdate(sql, size);
        return row;
    }

    public KichCo SearchKichCo(int size) {
        String sql = "SELECT * FROM KichCo WHERE size=?";
        ResultSet rs = JDBCHelper.executeQuery(sql, size);

        if (rs != null) {
            try {
                if (rs.next()) {
                    return new KichCo(rs.getString("id"), rs.getInt("size"));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}


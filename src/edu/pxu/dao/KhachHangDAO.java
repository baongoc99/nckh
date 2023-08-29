package edu.pxu.dao;

import edu.pxu.connect.ConnectJDBC;
import edu.pxu.model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDAO {

    public static ArrayList<KhachHang> getAll() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<KhachHang> lst = new ArrayList<>();
        Connection conn = ConnectJDBC.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select * from khachhang";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                KhachHang bnv = new KhachHang();
                bnv.setMakh(rs.getString(1));
                bnv.setTenkh(rs.getString(2));
                bnv.setDiachi(rs.getString(3));
                bnv.setSdt(rs.getString(4));
                bnv.setDiemtl(rs.getInt(5));
                lst.add(bnv);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lst;
    }

    public List<KhachHang> timkiem(String name) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement sttm = null;
        List<KhachHang> ls = new ArrayList<>();
        try {
            String sql = "select * from khachhang where tenkhachhang like '%" + name + "%%%%'";
            Connection conn = ConnectJDBC.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            while (rs.next()) {
                KhachHang bk = new KhachHang();
                bk.setMakh(rs.getString("makhachhang"));
                bk.setTenkh(rs.getString("tenkhachhang"));
                bk.setDiachi(rs.getString("diachi"));
                bk.setSdt(rs.getString("sdt"));
                bk.setDiemtl(rs.getInt("diemtl"));
                ls.add(bk);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return ls;

    }

    public boolean insert(KhachHang bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "insert into khachhang (makhachhang, tenkhachhang, diachi,sdt,diemtl) values(?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);

        {
            prst.setString(1, bnv.getMakh());
            prst.setString(2, bnv.getTenkh());
            prst.setString(3, bnv.getDiachi());
            prst.setString(4, bnv.getSdt());
            prst.setInt(5, bnv.getDiemtl());

            return prst.executeUpdate() > 0;
        }
    }

    public boolean update(KhachHang bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "update khachhang set diemtl=?" + " where makhachhang=?";

        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        {
//            prst.setString(1, bnv.getTenkh());
//            prst.setString(2,bnv.getSdt());
            prst.setInt(1, bnv.getDiemtl());
            prst.setString(2, bnv.getMakh());

            return prst.executeUpdate() > 0;

        }
    }

    public boolean delete(KhachHang bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "delete from khachhang where makhachhang=?";

        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        {
            prst.setString(1, bnv.getMakh());
        }
        return prst.executeUpdate() > 0;
    }

    public KhachHang FindMakh(String makh) throws SQLException, ClassNotFoundException, Exception {
        String sql = "select * from khachhang where makhachhang=?";
        try (Connection conn = ConnectJDBC.getConnection(); PreparedStatement prst = conn.prepareStatement(sql);) {
            prst.setString(1, makh);
            try (ResultSet rs = prst.executeQuery();) {
                if (rs.next()) {
                    KhachHang bk = new KhachHang();
                    bk.setMakh(rs.getString("makhachhang"));
                    bk.setTenkh(rs.getString("tenkhachhang"));
                    bk.setDiachi(rs.getString("diachi"));
                    bk.setSdt(rs.getString("sdt"));
                    bk.setDiemtl(rs.getInt("diemtl"));
                    return bk;
                }
            }
            return null;
        }
    }
}

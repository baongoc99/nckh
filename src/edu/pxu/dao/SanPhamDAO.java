package edu.pxu.dao;

import edu.pxu.connect.ConnectJDBC;
import edu.pxu.model.SanPham;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

public class SanPhamDAO {

    public static ArrayList<SanPham> getAll() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<SanPham> lst = new ArrayList<>();
        Connection conn = ConnectJDBC.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select * from sanpham where soluong > 0";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SanPham bnv = new SanPham();
                bnv.setMasp(rs.getInt(1));
                bnv.setTensp(rs.getString(2));
                bnv.setGiasp(Float.valueOf(rs.getString(3)));
                bnv.setSoluong(rs.getInt(4));
//                Blob blob = rs.getBlob("anhsp");
//                if (blob != null) {
//                    bnv.setAnhsp(blob.getBytes(1, (int) blob.length()));
//                }
//                bnv.setMaloai(rs.getInt(5));
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

    public boolean insert1(SanPham bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "insert into sanpham (tensanpham, giasp, soluong, anhsp, maloai) values(?,?,?,?,?)";
        try (
                Connection conn = ConnectJDBC.getConnection(); PreparedStatement prstt = conn.prepareStatement(sql);) {
           

            prstt.setString(1, bnv.getTensp());
            prstt.setString(2, Float.valueOf(bnv.getGiasp()).toString());
            prstt.setInt(3, bnv.getSoluong());
            if (bnv.getAnhsp() != null) {
                Blob hinh = new SerialBlob(bnv.getAnhsp());
                prstt.setBlob(4, hinh);
            } else {
                Blob hinh = null;
                prstt.setBlob(4, hinh);
            }
            prstt.setInt(5, bnv.getMaloai());
            
            return prstt.executeUpdate() > 0;
        }
    }

    public SanPham FindMasp(int masp) throws SQLException, ClassNotFoundException, Exception {
        String sql = "select * from sanpham where masanpham=? ";
        try (Connection conn = ConnectJDBC.getConnection(); PreparedStatement prst = conn.prepareStatement(sql);) {
            prst.setInt(1, masp);
            try (ResultSet rs = prst.executeQuery();) {
                if (rs.next()) {
                    SanPham bk = new SanPham();
                    bk.setMasp(rs.getInt("masanpham"));
                    bk.setTensp(rs.getString("tensanpham"));
                    bk.setGiasp(rs.getFloat("giasp"));
                    bk.setSoluong(rs.getInt("soluong"));
               
                    bk.setMaloai(rs.getInt("maloai"));
                    Blob blob = rs.getBlob("anhsp");
                    if (blob != null) {
                        bk.setAnhsp(blob.getBytes(1, (int) blob.length()));
                    }
                    return bk;
                }
            }
            return null;
        }
    }
    

    public boolean update1(SanPham bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "update sanpham set tensanpham=?, giasp=?, soluong=? ,anhsp=? ,maloai=? where masanpham=?";

        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        {

            prst.setString(1, bnv.getTensp());
            prst.setString(2, Float.valueOf(bnv.getGiasp()).toString());
            prst.setInt(3, bnv.getSoluong());
            if (bnv.getAnhsp() != null) {
                Blob hinh = new SerialBlob(bnv.getAnhsp());
                prst.setBlob(4, hinh);
            } else {
                Blob hinh = null;
                prst.setBlob(4, hinh);
            }
            prst.setString(5, Float.valueOf(bnv.getMaloai()).toString());
            prst.setInt(6, bnv.getMasp());

            return prst.executeUpdate() > 0;

        }
    }
    
    public boolean update2(SanPham bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "update SANPHAM set soluong=? where masanpham=?";

        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        {

            prst.setInt(1, bnv.getSoluong());
            prst.setInt(2, bnv.getMasp());

            return prst.executeUpdate() > 0;

        }
    }

    public boolean delete1(SanPham bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "delete from sanpham where masanpham=?";

        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        {
            prst.setInt(1, bnv.getMasp());
        }
        return prst.executeUpdate() > 0;
    }

    public List<SanPham> timkiem(String name) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement sttm = null;
        List<SanPham> ls = new ArrayList<>();
        try {
            String sql = "select * from sanpham where tensanpham like '" + name + "%'";
            Connection conn = ConnectJDBC.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            while (rs.next()) {
                SanPham bk = new SanPham();
                bk.setMasp(rs.getInt("masanpham"));
                bk.setTensp(rs.getString("tensanpham"));
                bk.setGiasp(rs.getFloat("giasp"));
                bk.setSoluong(rs.getInt("soluong"));
                bk.setMaloai(rs.getInt("maloai"));
                Blob blob = rs.getBlob("anhsp");
                if (blob != null) {
                    bk.setAnhsp(blob.getBytes(1, (int) blob.length()));
                }

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
   
}

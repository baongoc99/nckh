
package edu.pxu.dao;


import edu.pxu.connect.ConnectJDBC;
import edu.pxu.model.DatHang;
import edu.pxu.model.SanPham;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DatHangDAO {
    public static ArrayList<DatHang>getAll() throws SQLException, ClassNotFoundException, Exception{
        ArrayList<DatHang> lst = new ArrayList<>();
        Connection conn = ConnectJDBC.getConnection();
        try {
          Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM hoadon ";
          ResultSet rs = stmt.executeQuery(sql);   
            while(rs.next()){
                DatHang bnv = new DatHang();
                bnv.setMadh(rs.getInt(1));
                bnv.setManv(rs.getString(3));
                bnv.setMakh(rs.getInt(2));
                bnv.setTongtien(rs.getFloat(4));
                bnv.setTrangthai(rs.getString(5));
                bnv.setNgaydat(rs.getDate(6));
                lst.add(bnv);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
// 
    
    public boolean insertOrder(DatHang order) throws SQLException, ClassNotFoundException, Exception {
        String sql = "INSERT INTO hoadon (NgayBan, MaKhachHang, MANhanVien, TongGiaTri, TrangThai) VALUES ( ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectJDBC.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, (java.sql.Date) order.getNgaydat());
            pstmt.setInt(2, order.getMakh());
            pstmt.setString(3, order.getManv());
            pstmt.setFloat(4, order.getTongtien());
            pstmt.setString(5, order.getTrangthai());

            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(DatHang bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "update hoadon set Tonggiatri=?, TrangThai=? where MaHoaDon=?";
        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prstt = conn.prepareStatement(sql);
        {
            prstt.setFloat(1, bnv.getTongtien());
            prstt.setString(2, bnv.getTrangthai());
            prstt.setInt(3, bnv.getMadh());
            return prstt.executeUpdate() > 0;
        }
    }
    
    public boolean update1(DatHang dh) throws SQLException, ClassNotFoundException, Exception {
        String sql = "update hoadon set Tonggiatri=? where MaHoaDon=?";
        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prstt = conn.prepareStatement(sql);
        {
            prstt.setFloat(1, dh.getTongtien());
            prstt.setInt(2, dh.getMadh());
            return prstt.executeUpdate() > 0;
        }
    }

    
    
    
//    public boolean insert(DatHang bnv) throws SQLException, ClassNotFoundException, Exception{
//         String sql="insert into HOA_DON (manv,makh,tongtien,thanhtoan,ngaydat,trangthai) values(?,?,?,?,?,?,?)";
//        try (Connection conn = ConnectJDBC.getConnection();
//        PreparedStatement  prstt = conn.prepareStatement(sql);){
////            prstt.setInt(1, bnv.getMadonhang());
//            prstt.setString(1, bnv.getManv());
//            prstt.setString(2, bnv.getMakh());
//            prstt.setString(3,bnv.getTongtien());
//            prstt.setString(5, bnv.getTrangthai());
//            prstt.setDate(4, bnv.getNgaydat());
//            return prstt.executeUpdate()>0;
//        } 
//    }
//    public boolean update(DatHang bnv) throws SQLException, ClassNotFoundException, Exception{
//        String sql="update HOA_DON set manv=?, makh=?,trangthai=?,tongtien=?,ngaydat=?,thanhtoan=? where madh=?";
//          Connection conn = ConnectJDBC.getConnection();
//        PreparedStatement  prstt = conn.prepareStatement(sql);
//        {
//            prstt.setString(1, bnv.getManv());
//            prstt.setString(2, bnv.getMakh());
//            prstt.setString(3,bnv.getTongtien());
//            prstt.setString(5, bnv.getTrangthai());
//            prstt.setDate(4, bnv.getNgaydat());
//            prstt.setInt(6, bnv.getMadh());
//            return prstt.executeUpdate()>0;
//        }
//    }
    public List<DatHang> timkiem(String name) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement sttm = null;
        List<DatHang> ls = new ArrayList<>();
        try {
            String sql = "select * from hoadon where ngayban like '%" + name + "%%%%'";
            Connection conn = ConnectJDBC.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            while (rs.next()) {
                DatHang bk = new DatHang();
                bk.setMadh(rs.getInt("mahoadon"));
                bk.setMakh(rs.getInt("makhachhang"));
                bk.setManv(rs.getString("manhanvien"));
                bk.setTongtien(rs.getFloat("tonggiatri"));
                bk.setTrangthai(rs.getString("trangthai"));
                bk.setNgaydat(rs.getDate("ngayban"));
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
    public DatHang Find(int madonhang) throws SQLException, ClassNotFoundException, Exception{
        String sql="select * from hoadon where mahoadon=?";
        try (
              Connection conn = ConnectJDBC.getConnection();
              PreparedStatement prst = conn.prepareStatement(sql);  ){
              prst.setInt(1, madonhang);
              try (ResultSet rs = prst.executeQuery();){
                  if(rs.next()){
                      DatHang bk = new DatHang();
                      bk.setMadh(rs.getInt("mahoadon"));
                      bk.setManv(rs.getString("manhanvien"));
                      bk.setMakh(rs.getInt("makhachhang"));
                      bk.setTrangthai(rs.getString("trangthai"));
                      bk.setTongtien(rs.getFloat("tonggiatri"));
                      bk.setNgaydat(rs.getDate("ngayban"));
                      
                      return bk;
                  }
            } 
            return null;
        }
    }
    public SanPham FindMasp(String masp) throws SQLException, ClassNotFoundException, Exception{
          String sql = "select * from sanpham where masanpham=?";
          try(Connection conn = ConnectJDBC.getConnection();
                 PreparedStatement prst = conn.prepareStatement(sql);
                 ){prst.setString(1, masp);
             try(ResultSet rs = prst.executeQuery();){
                  if(rs.next()){
                     SanPham bk = new SanPham();
                     bk.setMasp(rs.getInt("masanpham"));
                     bk.setTensp(rs.getString("tensanpham"));
                     bk.setGiasp(rs.getFloat("giasp"));
                     bk.setSoluong(rs.getInt("soluong"));
                      
                     return bk;
                    }
                  }
                  return null;
             }
     }   
}


package edu.pxu.dao;


import edu.pxu.connect.ConnectJDBC;
import edu.pxu.model.ChiTietDatHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ChiTietDatHangDAO {
    public static ArrayList<ChiTietDatHang> getAll() throws SQLException, ClassNotFoundException, Exception{
        ArrayList<ChiTietDatHang> lst = new ArrayList<>();
        Connection conn = ConnectJDBC.getConnection();
        try {
          Statement stmt = conn.createStatement();
          String sql = "select * from chitiethoadon ";
          ResultSet rs = stmt.executeQuery(sql);   
          while(rs.next()){
              ChiTietDatHang bnv = new ChiTietDatHang();
              bnv.setMahd(rs.getInt(1));
              bnv.setMasp(rs.getInt(2));
              bnv.setSoluong(rs.getInt(3));
              bnv.setGiasp(rs.getFloat(4));
              bnv.setThanhtien(rs.getFloat(5));
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
    
    public boolean  insert (ChiTietDatHang bnv) throws SQLException, ClassNotFoundException, Exception{
        String sql="insert into chitiethoadon (mahoadon,masanpham,soluongban,giaban,thanhtien) values(?,?,?,?,?)";
         try (Connection conn = ConnectJDBC.getConnection();
        PreparedStatement  prstt = conn.prepareStatement(sql);){
             
            prstt.setInt(1, bnv.getMahd());
            prstt.setInt(2, bnv.getMasp());
            prstt.setInt(3, bnv.getSoluong());
            prstt.setFloat(4, bnv.getGiasp());
            prstt.setFloat(5, bnv.getThanhtien());
           return prstt.executeUpdate()>0;
        } 
    }
    
//    public ChiTietDatHang Fin(int maCTdonhang) throws SQLException, ClassNotFoundException, Exception{
//        String sql ="select * from CT_HOADON where mahd=?";
//        try(
//              Connection conn = ConnectJDBC.getConnection();
//              PreparedStatement prst = conn.prepareStatement(sql);  ) {
//              prst.setInt(1, maCTdonhang);
//              try(ResultSet rs = prst.executeQuery();){
//                  while(rs.next()){
//                      ChiTietDatHang bk = new ChiTietDatHang();
//                      bk.setMadh(rs.getInt("madh"));
//                      bk.setMasp(rs.getString("masp"));
//                      bk.setTensp(rs.getString("tensp"));
//                      bk.setSoluong(rs.getInt("soluong"));
//                      bk.setGiasp(rs.getString("giasp"));
//                      bk.setThanhtien(rs.getString("thanhtien"));
//                      
//                      return bk;
//                  }
//              }
//              return null;
//        }
//      
//    }
//    public List<ChiTietDatHang> getd(int madonhang){
//        String sql="select * from CT_HOADON "
//                + " where madh=?";
//        List<ChiTietDatHang> list = new ArrayList<>();
//        try {
//           Connection conn = ConnectJDBC.getConnection();
//           PreparedStatement prst = conn.prepareStatement(sql);
//           prst.setInt(1, madonhang);
//           ResultSet rs = prst.executeQuery();
//           while(rs.next()){
//               list.add(new ChiTietDatHang(
//                       rs.getInt(1),
//                       rs.getString(2),
//                       rs.getString(3),
//                       rs.getInt(4), 
//                       rs.getString(5), 
//                       rs.getString(6)));
//           }
//           return  list;
//        } catch (Exception e) {
//        }
//        return null;
//    }
//    public boolean update(ChiTietDatHang bnv ) throws SQLException, ClassNotFoundException, Exception{
//            String sql = "update CT_HOADON set masp=?, tensp=?, soluong=?,giasp=?, thanhtien=?"
//                    + " where madh=?";
//             Connection conn = ConnectJDBC.getConnection();
//        PreparedStatement  prstt = conn.prepareStatement(sql);
//        {
//            prstt.setString(1, bnv.getMasp());
//            prstt.setString(2, bnv.getTensp());
//            prstt.setInt(3, bnv.getSoluong());
//            prstt.setString(4, bnv.getGiasp());
//            prstt.setString(5, bnv.getThanhtien());
//
//            prstt.setInt(6, bnv.getMadh());
//           return prstt.executeUpdate()>0;
//        }
//     }
    public boolean delete(ChiTietDatHang bnv ) throws SQLException, ClassNotFoundException, Exception{
        String sql ="delete from chitiethoadon "
                + " where mahoadon =?";
         Connection conn = ConnectJDBC.getConnection();
        PreparedStatement  prst = conn.prepareStatement(sql);
        {
            prst.setInt(1, bnv.getMahd());
        }
        return prst.executeUpdate()>0;
        }
     public boolean deletect(ChiTietDatHang bnv ) throws SQLException, ClassNotFoundException, Exception{
        String sql ="delete from chitiethoadon "
                + " where machitiethoadon =?";
         Connection conn = ConnectJDBC.getConnection();
        PreparedStatement  prst = conn.prepareStatement(sql);
        {
            prst.setInt(1, bnv.getMactdh());
        }
        return prst.executeUpdate()>0;
        }
}

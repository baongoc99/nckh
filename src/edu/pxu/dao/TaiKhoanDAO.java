
package edu.pxu.dao;


import edu.pxu.connect.ConnectJDBC;
import edu.pxu.model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TaiKhoanDAO {
    public TaiKhoan checkLogin(String tendn, String mk) throws SQLException, ClassNotFoundException, Exception{
        String sql="select tendn, matkhau, vaitro from TAI_KHOAN"
                + " where tendn=? and matkhau=?";
        try(
                Connection conn = ConnectJDBC.getConnection();
                PreparedStatement  prstt = conn.prepareStatement(sql);

                ){
             prstt.setString(1,tendn);
             prstt.setString(2, mk);
            try (ResultSet rs = prstt.executeQuery();){
                if(rs.next()){
                    TaiKhoan nd = new TaiKhoan();
                    nd.setTendn(tendn);
                    nd.setVaitro(rs.getString("vaitro"));
                    return nd;
                 }
            }
        }
        return null;
    }
    
    public static ArrayList<TaiKhoan> getAll() throws SQLException, ClassNotFoundException, Exception{
        ArrayList<TaiKhoan> lst = new ArrayList<>();
        Connection conn = ConnectJDBC.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select * from TAI_KHOAN";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                TaiKhoan bnv = new TaiKhoan();
                bnv.setTendn(rs.getString(1));
                bnv.setMk(rs.getString(2));
                bnv.setManv(rs.getString(3));
                bnv.setTennv(rs.getString(4));
                bnv.setVaitro(rs.getString(5));
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
    public  boolean  insert(TaiKhoan bnv) throws SQLException, ClassNotFoundException, Exception{
        String sql="insert into TAI_KHOAN (tendn,matkhau,manv,hotennv,vaitro) values (?,?,?,?,?)";
        try (
               Connection conn = ConnectJDBC.getConnection();
        PreparedStatement  prstt = conn.prepareStatement(sql);
                  ){
                prstt.setString(1, bnv.getTendn());
                prstt.setString(2, bnv.getMk());
                prstt.setString(3, bnv.getManv());
                prstt.setString(4, bnv.getTennv());
                prstt.setString(5, bnv.getVaitro());
                return prstt.executeUpdate()>0;

    }
        }
    
   public TaiKhoan fin(String tendn) throws SQLException, ClassNotFoundException, Exception{
                   String sql = "select * from TAI_KHOAN where tendn=?";
       try(Connection conn = ConnectJDBC.getConnection();
                 PreparedStatement prst = conn.prepareStatement(sql);
                 ){prst.setString(1, tendn);
             try(ResultSet rs = prst.executeQuery();){
                  if(rs.next()){
                     TaiKhoan bk = new TaiKhoan();
                     bk.setTendn(rs.getString("tendn"));
                     bk.setMk(rs.getString("matkhau"));
                     bk.setManv(rs.getString("manv"));
                     bk.setTennv(rs.getString("hotennv"));
                     bk.setVaitro(rs.getString("vaitro"));
                     return bk;
                    }
                  }
                  return null;
             }
   }
    public  boolean  update(TaiKhoan bnv) throws SQLException, ClassNotFoundException, Exception{
        String sql="update TAI_KHOAN set matkhau=?,manv=?,hotennv=?,vaitro=? "
                + " where tendn=?";
        try (
               Connection conn = ConnectJDBC.getConnection();
        PreparedStatement  prstt = conn.prepareStatement(sql);
                  ){
                prstt.setString(1, bnv.getMk());
                prstt.setString(2, bnv.getManv());
                prstt.setString(3, bnv.getTennv());
                prstt.setString(4, bnv.getVaitro());
                prstt.setString(5, bnv.getTendn());
                return prstt.executeUpdate()>0;

    }
        }
    public  boolean  delete(TaiKhoan bnv) throws SQLException, ClassNotFoundException, Exception{
        String sql="delete from TAI_KHOAN where tendn=?";
                
        try (
               Connection conn = ConnectJDBC.getConnection();
        PreparedStatement  prstt = conn.prepareStatement(sql);
                  ){
                prstt.setString(1, bnv.getTendn());
                return prstt.executeUpdate()>0;
    }
        }
}

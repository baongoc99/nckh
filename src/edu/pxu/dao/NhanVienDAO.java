package edu.pxu.dao;

import edu.pxu.connect.ConnectJDBC;
import edu.pxu.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    public NhanVien checkLogin(String tendangnhap, String matkhau) throws SQLException, ClassNotFoundException {
        String sql = "select tennhanvien,tendangnhap,matkhau,chucvu from nhanvien"
                + " where tendangnhap=? and matkhau=?";
        try (
                Connection conn = ConnectJDBC.getConnection();
                PreparedStatement prstt = conn.prepareStatement(sql);) {
            prstt.setString(1, tendangnhap);
            prstt.setString(2, matkhau);
            try (ResultSet rs = prstt.executeQuery();) {
                if (rs.next()) {
                    NhanVien nd = new NhanVien();
                    nd.setTendangnhap(tendangnhap);
                    nd.setChucvu(rs.getString("chucvu"));
                    nd.setHotennv(rs.getString("tennhanvien"));
                    return nd;
                }
            }
        }
        return null;
    }

    public static ArrayList<NhanVien> getAll() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<NhanVien> lst = new ArrayList<>();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Connection conn = ConnectJDBC.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select * from nhanvien";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhanVien bnv = new NhanVien();
                bnv.setManv(rs.getString(1));
                bnv.setHotennv(rs.getString(2));
                bnv.setNgaysinh(rs.getDate(3));
                bnv.setGioitinh(rs.getString(4));
                bnv.setLuong(rs.getFloat(5));
                bnv.setChucvu(rs.getString(6));
                bnv.setSdt(rs.getString(7));
                bnv.setDiachi(rs.getString(8));
                bnv.setTrangthai(rs.getString(9));
                bnv.setTendangnhap(rs.getString(10));
                bnv.setMatkhau(rs.getString(11));
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

    public List<NhanVien> timkiem(String name) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement sttm = null;
        List<NhanVien> ls = new ArrayList<>();
        try {
            String sql = "select * from nhanvien where tennhanvien like '%" + name + "%%%%'";
            Connection conn = ConnectJDBC.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sql);
            while (rs.next()) {
                NhanVien bk = new NhanVien();
                bk.setManv(rs.getString("manhanvien"));
                bk.setHotennv(rs.getString("tennhanvien"));
                bk.setNgaysinh(rs.getDate("ngaysinh"));
                bk.setDiachi(rs.getString("diachi"));
                bk.setSdt(rs.getString("sdt"));
                bk.setEmail(rs.getString("email"));
                bk.setGioitinh(rs.getString("gioitinh"));
                bk.setChucvu(rs.getString("chucvu"));
                bk.setLuong(rs.getFloat("luong"));
                bk.setTendangnhap(rs.getString("tendangnhap"));
                bk.setMatkhau(rs.getString("matkhau"));
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

    public List<NhanVien> timkiemgt(String gioitinh) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement sttm = null;
        List<NhanVien> ls = new ArrayList<>();
        try {
//         String sql = "select * from NHAN_VIEN where hotennv like '"+name+"%'";
            String sqll = "select * from nhanvien where gioitinh ='" + gioitinh + "'";
            Connection conn = ConnectJDBC.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sqll);
            while (rs.next()) {
                NhanVien bk = new NhanVien();
                bk.setManv(rs.getString("manhanvien"));
                bk.setHotennv(rs.getString("tennhanvien"));
                bk.setNgaysinh(rs.getDate("ngaysinh"));
                bk.setDiachi(rs.getString("diachi"));
                bk.setSdt(rs.getString("sdt"));
                bk.setEmail(rs.getString("email"));
                bk.setGioitinh(rs.getString("gioitinh"));
                bk.setChucvu(rs.getString("chucvu"));
                bk.setLuong(rs.getFloat("luong"));

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

    public NhanVien FindManv(String manv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "select * from nhanvien where manhanvien=?";
        try (Connection conn = ConnectJDBC.getConnection(); PreparedStatement prst = conn.prepareStatement(sql);) {
            prst.setString(1, manv);
            try (ResultSet rs = prst.executeQuery();) {
                if (rs.next()) {
                    NhanVien bk = createNhanVien(rs);
                    return bk;
                }
            }
            return null;
        }
    }

    private NhanVien createNhanVien(final ResultSet rs) throws SQLException {
        NhanVien bk = new NhanVien();
        bk.setManv(rs.getString("manhanvien"));
        bk.setHotennv(rs.getString("tennhanvien"));
        bk.setNgaysinh(rs.getDate("ngaysinh"));
        bk.setDiachi(rs.getString("diachi"));
        bk.setSdt(rs.getString("sdt"));
        bk.setEmail(rs.getString("email"));
        bk.setGioitinh(rs.getString("gioitinh"));
        bk.setChucvu(rs.getString("chucvu"));
        bk.setLuong(rs.getFloat("luong"));
        bk.setTendangnhap(rs.getString("tendangnhap"));
        bk.setMatkhau(rs.getString("matkhau"));


        return bk;
    }

    public List<NhanVien> FindAll() throws SQLException, ClassNotFoundException, Exception {
        String sql = "select * from nhanvien ";
        try (Connection conn = ConnectJDBC.getConnection(); PreparedStatement prst = conn.prepareStatement(sql);) {
//             prst.setString(1, manv);
            try (ResultSet rs = prst.executeQuery();) {
                List<NhanVien> list = new ArrayList<>();
                while (rs.next()) {
                    NhanVien bk = createNhanVien(rs);
                    list.add(bk);
                }
                return list;
            }

        }
    }

    public boolean insert(NhanVien bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "insert into nhanvien (manhanvien, tennhanvien, ngaysinh,diachi,sdt,email, gioitinh, chucvu,luong, tendangnhap,matkhau ) values(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);

        {
            prst.setString(1, bnv.getManv());
            prst.setString(2, bnv.getHotennv());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            prst.setDate(3, bnv.getNgaysinh());
            prst.setString(4, bnv.getDiachi());
            prst.setString(5, bnv.getSdt());
            prst.setString(6, bnv.getEmail());
            prst.setString(7, bnv.getGioitinh());
            prst.setString(8, bnv.getChucvu());
            prst.setFloat(9, bnv.getLuong());
            prst.setString(10, bnv.getTendangnhap());
            prst.setString(11, bnv.getMatkhau());
            return prst.executeUpdate() > 0;
        }
    }

    public boolean update(NhanVien bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "update nhanvien set tennhanvien=?, ngaysinh=?,diachi=?, sdt=?,email=?, gioitinh=?, chucvu=?, luong=?, tendangnhap=?,matkhau=?"
                + " where manhanvien=?";
        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        {
            prst.setString(1, bnv.getHotennv());
            prst.setDate(2, bnv.getNgaysinh());
            prst.setString(3,bnv.getDiachi());
            prst.setString(4, bnv.getSdt());
            prst.setString(5, bnv.getEmail());
            prst.setString(6, bnv.getGioitinh());
            prst.setString(7, bnv.getChucvu());
            prst.setFloat(8, bnv.getLuong());
            
            prst.setString(9, bnv.getTendangnhap());
            prst.setString(10, bnv.getMatkhau());
            prst.setString(11, bnv.getManv());

            return prst.executeUpdate() > 0;

        }
    }

    public boolean delete(NhanVien bnv) throws SQLException, ClassNotFoundException, Exception {
        String sql = "delete from nhanvien where manhanvien=?";

        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement prst = conn.prepareStatement(sql);
        {
            prst.setString(1, bnv.getManv());
        }
        return prst.executeUpdate() > 0;
    }

}

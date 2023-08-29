
package edu.pxu.model;

import java.sql.Date;

public class NhanVien {
    private String manv;
    private String hotennv;
    private Date ngaysinh;
    private String gioitinh;
    private float luong;
    private String chucvu;
    private String sdt;
    private String email;
    private String diachi;
    private String trangthai;
    private String tendangnhap;
    private String matkhau;

    public NhanVien() {
    }

    public NhanVien(String manv, String hotennv, Date ngaysinh, String gioitinh, float luong, String chucvu, String sdt, String email, String diachi, String trangthai, String tendangnhap, String matkhau) {
        this.manv = manv;
        this.hotennv = hotennv;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.luong = luong;
        this.chucvu = chucvu;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.trangthai = trangthai;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHotennv() {
        return hotennv;
    }

    public void setHotennv(String hotennv) {
        this.hotennv = hotennv;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "manv=" + manv + ", hotennv=" + hotennv + ", ngaysinh=" + ngaysinh + ", gioitinh=" + gioitinh + ", luong=" + luong + ", chucvu=" + chucvu + ", sdt=" + sdt + ", email=" + email + ", diachi=" + diachi + ", trangthai=" + trangthai + ", tendangnhap=" + tendangnhap + ", matkhau=" + matkhau + '}';
    }

    
    
}

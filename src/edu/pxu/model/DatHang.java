
package edu.pxu.model;

import java.sql.Date;


public class DatHang {
    private int madh;
    private String manv;
    private int makh;
    private String trangthai;
    private float tongtien;
    private Date ngaydat;
    private String ghichu;

    public DatHang() {
    }

    public DatHang(int madh, String manv, int makh, String trangthai, float tongtien, Date ngaydat, String ghichu) {
        this.madh = madh;
        this.manv = manv;
        this.makh = makh;
        this.trangthai = trangthai;
        this.tongtien = tongtien;
        this.ngaydat = ngaydat;
        this.ghichu = ghichu;
    }

    public int getMadh() {
        return madh;
    }

    public void setMadh(int madh) {
        this.madh = madh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public Date getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(Date ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "DatHang{" + "madh=" + madh + ", manv=" + manv + ", makh=" + makh + ", trangthai=" + trangthai + ", tongtien=" + tongtien + ", ngaydat=" + ngaydat + ", ghichu=" + ghichu + '}';
    }

    

}

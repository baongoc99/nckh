
package edu.pxu.model;

public class KhachHang {
    private String makh;
    private String tenkh;
    private String diachi;
    private String sdt;
    private int diemtl;

    public KhachHang() {
    }

    public KhachHang(String makh, String tenkh, String diachi, String sdt, int diemtl) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.diemtl = diemtl;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getDiemtl() {
        return diemtl;
    }

    public void setDiemtl(int diemtl) {
        this.diemtl = diemtl;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "makh=" + makh + ", tenkh=" + tenkh + ", diachi=" + diachi + ", sdt=" + sdt + ", diemtl=" + diemtl + '}';
    }

    
    
    
}

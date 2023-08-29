
package edu.pxu.model;


public class TaiKhoan {
    private String tendn, mk,manv, tennv,vaitro;

    public TaiKhoan() {
    }

    public TaiKhoan(String tendn, String mk, String manv, String tennv, String vaitro) {
        this.tendn = tendn;
        this.mk = mk;
        this.manv = manv;
        this.tennv = tennv;
        this.vaitro = vaitro;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }
    
    
}

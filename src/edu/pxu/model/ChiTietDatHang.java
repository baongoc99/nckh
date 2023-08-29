/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.pxu.model;

/**
 *
 * @author Admin
 */
public class ChiTietDatHang {
    private int mactdh;
    private int mahd;
    private int masp;
    private int soluong;
    private float giasp;
    private float thanhtien;


    public ChiTietDatHang() {
    }

    public ChiTietDatHang(int mactdh, int mahd, int masp, int soluong, float giasp, float thanhtien) {
        this.mactdh = mactdh;
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.giasp = giasp;
        this.thanhtien = thanhtien;
    }

    public int getMactdh() {
        return mactdh;
    }

    public void setMactdh(int mactdh) {
        this.mactdh = mactdh;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGiasp() {
        return giasp;
    }

    public void setGiasp(float giasp) {
        this.giasp = giasp;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "ChiTietDatHang{" + "mactdh=" + mactdh + ", mahd=" + mahd + ", masp=" + masp + ", soluong=" + soluong + ", giasp=" + giasp + ", thanhtien=" + thanhtien + '}';
    }

    
}

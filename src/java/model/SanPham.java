/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private int id;
    private float giathue;
    private String tenSP,maSP,mota;
    
    
    public SanPham(){};

    public SanPham(int id, String tenSP, String maSP, float giathue, String mota) {
        this.id = id;
        this.tenSP = tenSP;
        this.maSP = maSP;
        this.giathue = giathue;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public float getGiathue() {
        return giathue;
    }

    public void setGiathue(float giathue) {
        this.giathue = giathue;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", tenSP=" + tenSP + ", maSP=" + maSP + ", giathue=" + giathue + ", mota=" + mota + '}';
    }
    
}

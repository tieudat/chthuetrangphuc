/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class SanPhamThue {
    private int idThue;
    private HoaDon hd;
    private SanPham sp;
    private String status;
    
    public SanPhamThue(){};

    public SanPhamThue(int idThue, HoaDon hd, SanPham sp, String status) {
        this.idThue = idThue;
        this.hd = hd;
        this.sp = sp;
        this.status = status;
    }

    public int getIdThue() {
        return idThue;
    }

    public void setIdThue(int idThue) {
        this.idThue = idThue;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SanPhamThue{" + "idThue=" + idThue + ", hd=" + hd + ", sp=" + sp + ", status=" + status + '}';
    }

    
}

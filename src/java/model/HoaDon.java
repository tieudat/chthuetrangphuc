/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private int idHD;
    private KhachHang kh;
    private ArrayList<SanPham> listSP;
    private Date ngaythue;
    private String status;
    private int tongtien;
   
    
    public HoaDon(){};

    public HoaDon(int idHD, KhachHang kh, ArrayList<SanPham> listSP, Date ngaythue, int tongtien,String status) {
        this.idHD = idHD;
        this.kh = kh;
        this.listSP = listSP;
        this.ngaythue = ngaythue;
        this.tongtien = tongtien;
        this.status = status;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public ArrayList<SanPham> getListSP() {
        return listSP;
    }

    public void setListSP(ArrayList<SanPham> listSP) {
        this.listSP = listSP;
    }

    public Date getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(Date ngaythue) {
        this.ngaythue = ngaythue;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHD=" + idHD + ", kh=" + kh + ", listSP=" + listSP + ", ngaythue=" + ngaythue + ", status=" + status + ", tongtien=" + tongtien + '}';
    }
    
   
}

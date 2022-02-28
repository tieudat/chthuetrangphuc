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
public class KhachHang {
    private int id;
    private String maKH;
    private String ten,diachi,email,dienthoai,ghichu;
    private Date ngaysinh;
    private ArrayList<HoaDon> dshd = new ArrayList<>();
    
    public KhachHang(){};

    public KhachHang(int id,String maKH, String ten, String diachi, String email, String dienthoai, String ghichu, Date ngaysinh,ArrayList<HoaDon> dshd) {
        this.id = id;
        this.maKH = maKH;
        this.ten = ten;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.ghichu = ghichu;
        this.ngaysinh = ngaysinh;
        this.dshd = dshd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public ArrayList<HoaDon> getDshd() {
        return dshd;
    }

    public void setDshd(ArrayList<HoaDon> dshd) {
        this.dshd = dshd;
    }
    

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", maKH=" + maKH + ", ten=" + ten + ", diachi=" + diachi + ", email=" + email + ", dienthoai=" + dienthoai + ", ghichu=" + ghichu + ", ngaysinh=" + ngaysinh + '}';
    }
    
}

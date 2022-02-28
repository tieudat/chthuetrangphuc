/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import static dao.dao.con;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import model.HoaDon;
import model.KhachHang;
import model.SanPham;
import model.SanPhamThue;
/**
 *
 * @author admin
 */
public class clothDAO extends dao {
    public clothDAO(){
        super();
    }
    //lấy thông tin khách hàng
    public ArrayList<KhachHang> getListKH(int id){
        ArrayList<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT * from customer where idKH = ?";
        try{
             PreparedStatement ps =con.prepareStatement(sql);     
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 KhachHang a = new KhachHang();
                 a.setId(rs.getInt("idKH"));
                 a.setMaKH(rs.getString("maKH"));
                 a.setTen(rs.getString("tenKH"));
                 a.setDiachi(rs.getString("diachi"));
                 a.setEmail(rs.getString("email"));
                 a.setDienthoai(rs.getString("dienthoai"));
                 a.setGhichu(rs.getString("ghichu"));
                 a.setNgaysinh(rs.getDate("ngaysinh"));
                 listKH.add(a);
             }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listKH;
    }
    //lấy danh sách hoá đơn đang thuê của khách hàng
    public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT DISTINCT hd.idKH\n" +
                    "FROM hoadon hd\n" +
                    "LEFT JOIN customer c\n" +
                    "ON hd.idKH = c.idKH where hd.status='chua'";
        try{
             PreparedStatement ps =con.prepareStatement(sql);        

             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 KhachHang a = new KhachHang();
                 a.setId(rs.getInt("idKH"));
                 listKH.add(a);
             }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listKH;
    }
    //lấy ngày thuê sản phẩm
    public ArrayList<HoaDon> getListHD(int id){
            ArrayList<HoaDon> dshd = new ArrayList<>();
            String sql = "select * from hoadon where idHD= ?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    HoaDon a = new HoaDon();
                    a.setIdHD(rs.getInt("idHD"));
                    int idKH = rs.getInt("idKH");
                    a.setNgaythue(rs.getDate("ngaythue"));
                    KhachHang kh = new KhachHang();
                    kh.setId(idKH);
                    a.setKh(kh);
                    dshd.add(a);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return dshd;
        }
    //getDS sản phẩm thuê của khách hàng
    public ArrayList<SanPhamThue> getListSPT(int id){
            ArrayList<SanPhamThue> dssp = new ArrayList<>();
            String sql = "select * from sanphamthue spt\n" +
                         "left join hoadon hd\n" +
                         "on hd.idHD = spt.idHD\n" +
                         "where hd.status ='chua' and hd.idKH= ?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    SanPhamThue s = new SanPhamThue();
                    s.setIdThue(rs.getInt("idThue"));
                    SanPham a = new SanPham();
                    int idsp = rs.getInt("idSP");
                    a.setId(idsp);
                    s.setSp(a);
                    int idHD = rs.getInt("idHD");
                    HoaDon b = new HoaDon();
                    b.setIdHD(idHD);
                    s.setHd(b);
                    dssp.add(s);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return dssp;
        }
    //get thông tin sản phẩm
    public ArrayList<SanPham> getSP( int id){
            ArrayList<SanPham> dssp1 = new ArrayList<>();
            String sql = "select * from sanpham where idSP=? ";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    SanPham s = new SanPham();
                    s.setId(rs.getInt("idSP"));
                    s.setMaSP(rs.getString("maSP"));
                    s.setTenSP(rs.getString("tenSP"));
                    s.setGiathue(rs.getInt("giathue"));
                    dssp1.add(s);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return dssp1;
        }
    // đếm số sản phẩm 
    public int numberItem(){
        int count=0;
        String sql ="SELECT COUNT(idSP) AS SL FROM sanpham";
        try{
                PreparedStatement ps =con.prepareStatement(sql);               
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                count = rs.getInt("SL");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return count;
    }
    // đếm số hoá đơn của khách hàng
    public int numberHD(int id){
        int count=0;
        String sql ="SELECT COUNT(idHD) AS SL FROM hoadon where idKH =? and status='chua'";
        try{
                PreparedStatement ps =con.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs= ps.executeQuery();
                
                while(rs.next()){
                count = rs.getInt("SL");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return count;
    }
    // đếm số sản phẩm của khách hàng
     public int numberSP(int id){
        int count=0;
        String sql ="SELECT  count(spt.idThue) as SL\n" +
                    "FROM customer c\n" +
                    "JOIN hoadon hd ON hd.idKH = c.idKH\n" +
                    "inner JOIN sanphamthue spt ON spt.idHD = hd.idHD\n" +
                    "where spt.status = 'chua' and c.idKH =? and hd.status='chua' \n" +
                    "group by c.idKH;";
        try{
                PreparedStatement ps =con.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs= ps.executeQuery();
                
                while(rs.next()){
                count = rs.getInt("SL");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return count;
    }
}

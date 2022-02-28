/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.user;
/**
 *
 * @author admin
 */
public class userDAO extends dao{
    public userDAO(){
        super();
    }
    public boolean checkLogin(user user){
        boolean result = false;
        String sql = "SELECT* FROM user WHERE username = ? and password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                result = true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
        }
    public int numberCustomer(){
        int count=0;
        String sql ="SELECT COUNT(idKH) AS SoKhachHang FROM customer ";
        try{
                PreparedStatement ps =con.prepareStatement(sql);               
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                count = rs.getInt("SoKhachHang");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return count;
    }
}

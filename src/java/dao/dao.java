/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author admin
 */
public class dao {
    
	
    public static Connection con;
    public dao(){
        if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/qlch?autoReconnect=true&useSSL=false";
			String dbClass = "com.mysql.jdbc.Driver";

			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "Dat18111999@");
                                System.out.println("success");
			}catch(Exception e) {
				e.printStackTrace();
                                 System.out.println("false");
			}
		}
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2017102078_khaerulanwar_uas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

/**
 *
 * @author khoer
 */
public class koneksi {
    private static Connection con;
    public static Connection koneksi() throws SQLException {
        if(con==null){
        try{
            String url="jdbc:mysql://localhost/travel_2017102078";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (Connection) DriverManager.getConnection(url,user,pass);
            System.out.println("Koneksi Ke Databse Berhasil");
        }
        catch(Exception e){
            System.err.println("Koneksi Gagal" +e.getMessage());
        }
    }   
        return con;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fees_management;


import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author chauh
 */
public class DBconnection {
    
    public static Connection getConnection(){
        Connection con = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = (Connection)DriverManager.getConnection("jdbc:derby://localhost:1527/fees_managment","admin1","admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}

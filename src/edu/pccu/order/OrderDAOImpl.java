/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.pccu.order;

/**
 *
 * @author Administrator
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAOImpl 
    implements OrderDAO
{
    final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    final String CONN_STRING = "jdbc:mysql://localhost:3306/mydb?" +
                    "user=root&password=123456";
    @Override
    public void add(Order o) {
        try {        
            Class.forName(DRIVER_NAME);
            
            Connection conn = DriverManager.getConnection(CONN_STRING);
            conn.setAutoCommit(false);
            
            PreparedStatement pstmt = conn.prepareStatement("Insert into `Order` (CustomerName, CustomerTel) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, o.CustomerName);
            pstmt.setString(2, o.CustomerTel);
            pstmt.executeUpdate();                        
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int auto_id = rs.getInt(1);
            rs.close();
            for (OrderDetail od : o.Detail)
            {
                PreparedStatement pstmt2 = conn.prepareStatement("Insert into order_detail (order_id, ItemName, num) values (?, ?,?)");
                pstmt2.setInt(1, auto_id);
                pstmt2.setString(2, od.ItemName);
                pstmt2.setInt(3, od.num);
                pstmt2.executeUpdate();
             }
            
            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


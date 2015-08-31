/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.pccu.ordertest;

import edu.pccu.order.*;

/**
 *
 * @author Administrator
 */
public class T01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Order o = new Order(1, "Bob", "123123");
        OrderDetail od = new OrderDetail(1, "Cake", 3);
        o.Detail.add(od);
        OrderDetail od2 = new OrderDetail(2, "果汁", 1);
        o.Detail.add(od2);
        OrderDetail od3 = new OrderDetail(3, "餅乾", 10);
        o.Detail.add(od3);
        
        OrderDAO dao = new OrderDAOImpl();
        dao.add(o);
        
    }
    
}

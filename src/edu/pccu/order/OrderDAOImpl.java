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
public class OrderDAOImpl 
    implements OrderDAO
{

    @Override
    public void add(Order o) {
        System.out.println(o.id + "," + o.CustomerName + "," + o.CustomerTel);
        for (OrderDetail od : o.Detail)
        {
            System.out.println(od.id + "," + od.ItemName + "," + od.num);
        }
    }
    
}

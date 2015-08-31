/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.pccu.order;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Order {
    int id;
    String CustomerName;
    String CustomerTel;
    ArrayList<OrderDetail> Detail;
    
    public Order(int id, String CN, String CT)
    {
        this.id = id;
        this.CustomerName = CN;
        this.CustomerTel = CT;        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;
import com.gina.model.UsStockItem;
/**
 *
 * @author hanwang
 */
public interface usStockItemDao {
    
    UsStockItem selectStockItemDetail(String symbol);
    
}

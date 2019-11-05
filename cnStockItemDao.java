/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;
import com.gina.model.CnStockItem;
/**
 *
 * @author hanwang
 */
public interface cnStockItemDao {
    
    CnStockItem selectStockItemDetail(String ts_code);
    
}

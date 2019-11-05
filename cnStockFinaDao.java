/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;
import com.gina.model.CnStockFina;
import java.util.List;
/**
 *
 * @author hanwang
 */
public interface cnStockFinaDao {
    
    public List<CnStockFina> selectLatest4BySymbol(String symbol);
    public List<CnStockFina> selectLatest2BySymbol(String symbol);
}

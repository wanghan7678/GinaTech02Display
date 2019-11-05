/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;
import com.gina.model.UsStockFina;
import java.util.List;
/**
 *
 * @author hanwang
 */
public interface usStockFinaDao {
    
    public List<UsStockFina> selectLatest4BySymbol(String symbol);
    public List<UsStockFina> selectLatest2BySymbol(String symbol);
}

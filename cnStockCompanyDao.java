/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;

/**
 *
 * @author hanwang
 */
public interface cnStockCompanyDao {
    
    public String selectIntroductionBySymbol(String symbol);
    public String selectWebsiteBySymbol(String symbol);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.model;

/**
 *
 * @author hanwang
 */
public class UsStockItem {
    private int id;
    private String symbol;
    private String name;
    private String last_sale;
    private String market_cap;
    private String ipo_year;
    private String sector;
    private String industry;
    private String sum_quote;
    
    public void setId(int id){this.id = id;}
    public void setSymbol(String symbol){this.symbol = symbol;}
    public void setName(String name){this.name = name;}
    public void setLast_sale(String last_sale){this.last_sale = last_sale;}
    public void setMarket_cap(String market_cap){this.market_cap = market_cap;}
    public void setIpo_year(String ipo_year){this.ipo_year = ipo_year;}
    public void setSector(String sector){this.sector = sector;}
    public void setIndustry(String industry){this.industry = industry;}
    public void setSum_quote(String sum_quote){this.sum_quote = sum_quote;}
    
    
    public int getId(){return this.id;}
    public String getSymbol(){return this.symbol;}
    public String getName(){return this.name;}
    public String getLast_sale(){return this.last_sale;}
    public String getMarket_cap(){return this.market_cap;}
    public String getIpo_year(){return this.ipo_year;}
    public String getSector(){return this.sector;}
    public String getIndustry(){return this.industry;}
    public String getSum_quote(){return this.sum_quote;}
}

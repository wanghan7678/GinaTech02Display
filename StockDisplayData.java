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
public class StockDisplayData {
    private String symbol;
    private String name;
    private String area;
    private String sector;
    private String market;
    private String industry;
    private String trade_date;
    private String category;
    private String data;
    private String result;
    private String exchange;
    
    public void setSymbol(String symbol){this.symbol=symbol;}
    public void setName(String name){this.name = name;}
    public void setArea(String area){this.area = area;}
    public void setSector(String sector){
        if(sector.isEmpty()||sector.equals("nan")){
            sector = "-";
        }
        this.sector = sector;
    }
    public void setMarket(String market){
        this.market = market;
    } 
    public void setIndustry(String industry){
        if(industry.isEmpty()||industry.equals("nan")){
            industry = "-";
        }
        this.industry = industry;
    }
    public void setTrade_date(String trade_date){
        this.trade_date = trade_date;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setData(String data){
        this.data = data;
    }
    public void setResult(String result){this.result = result;}
    public void setExchange(String exchange){this.exchange = exchange;}
    public String getSymbol(){return this.symbol;}
    public String getName(){return this.name;}
    public String getArea(){return this.area;}
    public String getCategory(){return this.category;}
    public String getData(){return this.data;}
    public String getIndustry(){return this.industry;}
    public String getMarket(){return this.market;}
    public String getSector(){return this.sector;}
    public String getTrade_date(){return this.trade_date;}
    public String getResult(){return this.result;}
    public String getExchange(){return this.exchange;}
}

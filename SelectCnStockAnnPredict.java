/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.model;
import java.sql.Date;
/**
 *
 * @author hanwang
 */
public class SelectCnStockAnnPredict {

    private String symbol;
    private Date trade_date;
    private Date cal_date;
    private float result;
    private String name;
    private String area;
    private String industry;
    private String market;
    
    public void setSymbol(String symbol){this.symbol = symbol;}
    public void setTrade_date(Date trade_date){this.trade_date = trade_date;}
    public void setCal_date(Date cal_date){this.cal_date = cal_date;}
    public void setResult(float result){this.result = result;}
    public void setName(String name){this.name = name;}
    public void setArea(String area){this.area = area;}
    public void setIndustry(String industry){this.industry = industry;}
    public void setMarket(String market){this.market = market;}
    
    public String getSymbol(){return this.symbol;}
    public Date getTrade_date(){return this.trade_date;}
    public Date getCal_date(){return this.cal_date;}
    public float getResult(){return this.result;}
    public String getName(){return this.name;}
    public String getArea(){return this.area;}
    public String getIndustry(){return this.industry;}
    public String getMarket(){return this.market;}
    
}

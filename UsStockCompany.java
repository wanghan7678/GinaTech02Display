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
public class UsStockCompany {
    private int id;
    private String symbol;
    private String name;
    private String exchange_code;
    private String desrciption;
    private Date end_date;
    private Date start_date;
    
    public void setId(int id){this.id = id;}
    public void setSymbol(String symbol){this.symbol = symbol;}
    public void setName(String name){this.name = name;}
    public void setExchange_code(String exchange_code){this.exchange_code = exchange_code;}
    public void setDescription(String description){this.desrciption = description;}
    public void setEnd_date(Date end_date){this.end_date = end_date;}
    public void setStart_date(Date start_date){this.start_date = start_date;}
    
    public int getId(){return this.id;}
    public String getSymbol(){return this.symbol;}
    public String getName(){return this.name;}
    public String getExchange_code(){return this.exchange_code;}
    public String getDescription(){return this.desrciption;}
    public Date getEnd_date(){return this.end_date;}
    public Date getStart_date(){return this.start_date;}
    
    
}

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
public class CnStockItem {
    private int id;
    private String ts_code;
    private String name;
    private String area;
    private String industry;
    private String enname;
    private String market;
    private String exchange;
    private String list_status;
    private Date list_date;
    private String is_hs;
    
    public void setId(int id){this.id = id;}
    public void setTs_code(String ts_code){this.ts_code = ts_code;}
    public void setName(String name){this.name = name;}
    public void setArea(String area){this.area = area;}
    public void setIndustry(String industry){this.industry = industry;}
    public void setEnname(String enname){this.enname = enname;}
    public void setMarket(String market){this.market = market;}
    public void setExchange(String exchange){this.exchange = exchange;}
    public void setList_status(String list_status){this.list_status = list_status;}
    public void setList_date(Date list_date){this.list_date = list_date;}
    public void setIs_hs(String is_hs){this.is_hs = is_hs;}
    
    public int getId(){return this.id;}
    public String getTs_code(){return this.ts_code;}
    public String getName(){return this.name;}
    public String getArea(){return this.area;}
    public String getIndustry(){return this.industry;}
    public String getEnname(){return this.enname;}
    public String getMarket(){return this.market;}
    public String getExchange(){return this.exchange;}
    public String getList_status(){return this.list_status;}
    public Date getList_date(){return this.list_date;}
    public String getIs_hs(){return this.is_hs;}
    
}

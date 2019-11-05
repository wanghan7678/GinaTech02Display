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
public class CnStockCompany {
    private int id;
    private String ts_code;
    private String exchange;
    private String chairman;
    private String manager;
    private String secretary;
    private float re_capital;
    private Date setup_date;
    private String province;
    private String city;
    private String introduction;
    private String website;
    private int employees;
    private String main_business;
    private String business_scope;
    
    public void setId(int id){this.id = id;}
    public void setTs_code(String ts_code){this.ts_code = ts_code;}
    public void setExchange(String exchange){this.exchange = exchange;}
    public void setChairman(String chairman){this.chairman = chairman;}
    public void setManager(String manager){this.manager = manager;}
    public void setSecretary(String secretary){this.secretary = secretary;}
    public void setRe_capital(float re_capital){this.re_capital = re_capital;}
    public void setSetup_date(Date setup_date){this.setup_date = setup_date;}
    public void setProvince(String province){this.province = province;}
    public void setCity(String city){this.city = city;}
    public void setIntroduction(String introduction){this.introduction = introduction;}
    public void setWebsite(String website){this.website = website;}
    public void setEmployees(int employees){this.employees = employees;}
    public void setMain_business(String main_business){this.main_business = main_business;}
    public void setBusiness_scope(String business_scope){this.business_scope = business_scope;}
    
    public int getId(){return this.id;}
    public String getTs_code(){return this.ts_code;}
    public String getExchange(){return this.exchange;}
    public String getChairman(){return this.chairman;}
    public String getManager(){return this.manager;}
    public String getSecretary(){return this.secretary;}
    public float getRe_capital(){return this.re_capital;}
    public Date getSetup_date(){return this.setup_date;}
    public String getProvince(){return this.province;}
    public String getCity(){return this.city;}
    public String getIntroduction(){return this.introduction;}
    public String getWebsite(){return this.website;}
    public int getEmployees(){return this.employees;}
    public String getMain_business(){return this.main_business;}
    public String getBusiness_scope(){return this.business_scope;}

    
    
}

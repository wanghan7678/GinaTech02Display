/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.model;
import java.sql.Date;
import com.gina.util.util;
/**
 *
 * @author hanwang
 */
public class UsStockOneMainTopData {
    private float score;
    private String symbol;
    private String name;
    private Date trig_date;
    private Date last_date;
    private float high;
    private float low;
    private float open;
    private float close;
    private float vol;
    private float pct_chg;
    private String introduction;
    private String category;
    private String data;
    private String industry;
    private String website;
    private String sector;
    
    public void setScore(float score){this.score = util.getKeepDigitals(score*100, 2);}
    public void setSymbol(String symbol){this.symbol = symbol;}
    public void setName(String name){this.name = name;}
    public void setTrig_date(Date trig_date){this.trig_date = trig_date;}
    public void setLast_date(Date last_date){this.last_date = last_date;}
    public void setHigh(float high){this.high = util.getKeepDigitals(high, 2);}
    public void setLow(float low){this.low = util.getKeepDigitals(low, 2);}
    public void setOpen(float open){this.open = util.getKeepDigitals(open, 2);}
    public void setClose(float close){this.close = util.getKeepDigitals(close, 2);}
    public void setVol(float vol){this.vol = vol;}
    public void setPct_chg(float pct_chg){this.pct_chg = util.getKeepDigitals(pct_chg, 2);}
    public void setIntroduction(String introduction){this.introduction = introduction;}
    public void setCategory(String category){this.category = category;}
    public void setData(String data){this.data = data;}
    public void setIndustry(String industry){this.industry = industry;}
    public void setWebsite(String website){this.website = website;}
    public void setSector(String sector){this.sector = sector;}
    
    public float getScore(){return this.score;}
    public String getSymbol(){return this.symbol;}
    public String getName(){return this.name;}
    public Date getTrig_date(){return this.trig_date;}
    public Date getLast_date(){return this.last_date;}
    public float getHigh(){return this.high;}
    public float getLow(){return this.low;}
    public float getOpen(){return this.open;}
    public float getClose(){return this.close;}
    public float getVol(){return this.vol;}
    public float getPct_chg(){return this.pct_chg;}
    public String getIntroduction(){return this.introduction;}
    public String getCategory(){return this.category;}
    public String getData(){return this.data;}
    public String getIndustry(){return this.industry;}
    public String getWebsite(){return this.website;}
    public String getSector(){return this.sector;}
}

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
public class CnStockDaily implements Comparable{
    private int id;
    private String ts_code;
    private Date trade_date;
    private float open;
    private float high;
    private float low;
    private float close;
    private float pct_chg;
    private float vol;
    private float turnover_rate;
    private float volume_ratio;
    private float pe;
    
    public void setId(int id){this.id = id;}
    public void setTs_code(String ts_code){this.ts_code=ts_code;}
    public void setTrade_date(Date trade_date){this.trade_date=trade_date;}
    public void setOpen(float open){this.open = open;}
    public void setHigh(float high){this.high = high;}
    public void setLow(float low){this.low = low;}
    public void setClose(float close){this.close = close;}
    public void setPct_chg(float pct_chg){this.pct_chg = pct_chg;}
    public void setVol(float vol){this.vol = vol;}
    public void setTurnover_rate(float turnover_rate){this.turnover_rate = turnover_rate;}
    public void setVolume_ratio(float volume_ratio){this.volume_ratio = volume_ratio;}
    public void setPe(float pe){this.pe = pe;}
    
    public int getId(){return this.id;}
    public String getTs_code(){return this.ts_code;}
    public Date getTrade_date(){return this.trade_date;}
    public float getOpen(){return this.open;}
    public float getHigh(){return this.high;}
    public float getLow(){return this.low;}
    public float getClose(){return this.close;}
    public float getPct_chg(){return this.pct_chg;}
    public float getVol(){return this.vol;}
    public float getTurnover_rate(){return this.turnover_rate;}
    public float getVolume_ratio(){return this.volume_ratio;}
    public float getPe(){return this.pe;}
    
    @Override
    public int compareTo(Object o){
        int rs = 0;
        if(this.getTrade_date().before(((CnStockDaily)o).getTrade_date())){
            rs = -1;
        }else
            rs = 1;
        return rs;
    }
    
}

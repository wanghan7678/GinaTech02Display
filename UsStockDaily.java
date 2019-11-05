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
public class UsStockDaily implements Comparable {
    private int id;
    private String symbol;
    private Date trade_date;
    private float open;
    private float high;
    private float low;
    private float close;
    private float adj_close;
    private float volume;
    private float pct_chg;
    
    public void setId(int id){this.id = id;}
    public void setSymbol(String symbol){this.symbol = symbol;}
    public void setTrade_date(Date trade_date){this.trade_date = trade_date;}
    public void setOpen(float open){this.open = open;}
    public void setHigh(float high){this.high = high;}
    public void setLow(float low){this.low = low;}
    public void setClose(float close){this.close = close;}
    public void setAdj_close(float adj_close){this.adj_close = adj_close;}
    public void setVolume(float volume){this.volume = volume;}
    public void setPct_chg(float pct_chg){this.pct_chg = pct_chg;}
    
    public int getId(){return this.id;}
    public String getSymbol(){return this.symbol;}
    public Date getTrade_date(){return this.trade_date;}
    public float getOpen(){return this.open;}
    public float getHigh(){return this.high;}
    public float getLow(){return this.low;}
    public float getClose(){return this.close;}
    public float getAdj_close(){return this.adj_close;}
    public float getVolume(){return this.volume;}
    public float getPct_chg(){return this.pct_chg;}
    
    @Override
    public int compareTo(Object o){
        int rs = 0;
        if(this.getTrade_date().before(((UsStockDaily)o).getTrade_date())){
            rs = -1;
        }else
            rs = 1;
        return rs;
    }
}

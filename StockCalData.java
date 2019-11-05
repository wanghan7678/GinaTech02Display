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
public class StockCalData {
    private int periods;
    private float[] close;
    private float[] high;
    private float[] low;
    private float[] open;
    private float[] vol;
    private Date[] date;
    
    public void setPeriods(int periods){this.periods = periods;}
    public void setClose(float[] close){this.close = close;}
    public void setHigh(float[] high){this.high = high;}
    public void setLow(float[] low){this.low = low;}
    public void setOpen(float[] open){this.open = open;}
    public void setVol(float[] vol){this.vol = vol;}
    public void setDate(Date[] date){this.date = date;}
    
    
    public int getPeriods(){return this.periods;}
    public float[] getClose(){return this.close;}
    public float[] getHigh(){return this.high;}
    public float[] getLow(){return this.low;}
    public float[] getOpen(){return this.open;}
    public float[] getVol(){return this.vol;}
    public Date[] getDate(){return this.date;}
}

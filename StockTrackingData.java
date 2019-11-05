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
public class StockTrackingData {
    private String symbol;
    private String name;
    private float result;
    private int pastdays;
    private boolean ifup;
    private float chgpct;
    private float chgpct6;
    private Date trig_date;
    
    public void setSymbol(String symbol){this.symbol = symbol;}
    public void setName(String name){this.name = name;}
    public void setResult(float result){this.result = result;}
    public void setPastdays(int pastdays){this.pastdays = pastdays;}
    public void setIfup(boolean ifup){this.ifup = ifup;}
    public void setChgpct(float chgpct){this.chgpct = chgpct;}
    public void setChgpct6(float chgpct6){this.chgpct6 = chgpct6;}
    public void setTrig_date(Date trig_date){this.trig_date = trig_date;}
    
    public String getSymbol(){return this.symbol;}
    public String getName(){return this.name;}
    public float getResult(){return this.result;}
    public int getPastdays(){return this.pastdays;}
    public boolean getIfup(){return this.ifup;}
    public float getChgpct(){return this.chgpct;}
    public float getChgpct6(){return this.chgpct6;}
    public Date getTrig_date(){return this.trig_date;}
    
    @Override
    public String toString(){
        String str = "";
        str = this.symbol+" "+this.name+" "+this.result+" "+this.pastdays+"d";
        if (this.ifup){
            str += " "+"+";
        }else
            str +=" "+"-";
        str +=" "+this.chgpct;
        return str;
    }

    
}

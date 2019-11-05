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
public class AnnPredictResult {
    private int id;
    private String symbol;
    private Date trade_date;
    private Date cal_date;
    private float result;
    private String comment;
    
    public void setId(int id){this.id = id;}
    public void setSymbol(String symbol){this.symbol = symbol;}
    public void setTrade_date(Date date){this.trade_date = date;}
    public void setCal_date(Date date){this.cal_date = date;}
    public void setResult(float result){this.result = result;}
    public void setComment(String comment){this.comment = comment;}
    public int getId(){return this.id;}
    public String getSymbol(){return this.symbol;}
    public Date getTrade_date(){return this.trade_date;}
    public Date getCal_date(){return this.cal_date;}
    public float getResult(){return this.result;}
    public String getComment(){return this.comment;}
    
    @Override
    public String toString(){
        String str = this.id+", "+this.symbol+", "+this.trade_date+", "+this.result+", "+this.comment;
        return str;
    }
}

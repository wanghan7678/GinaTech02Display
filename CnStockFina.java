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
public class CnStockFina {
    private int id;
    private String ts_code;
    private Date ann_date;
    private Date end_date;
    private float eps;
    private float dt_eps;
    private float total_revenue_ps;
    private float revenue_ps;
    private float extra_item;
    private float profit_dedt;
    private float gross_margin;
    private float current_ratio;
    private float quick_ratio;
    private float cash_ratio;
    private float assets_turn;
    private float interst_income;
    private float daa;
    private float ebit;
    private float ebitda;
    private float netdebt;
    private float bps;
    private float roe;
    private float roa;
    private float npta;
    private float debt_to_assets;
    
    public void setId(int id){this.id = id;}
    public void setTs_code(String ts_code){this.ts_code = ts_code;}
    public void setAnn_date(Date ann_date){this.ann_date = ann_date;}
    public void setEnd_date(Date end_date){this.end_date = end_date;}
    public void setEps(float eps){this.eps = eps;}
    public void setDt_eps(float dt_eps){this.dt_eps = dt_eps;}
    public void setTotal_revenue_ps(float total_revenue_ps){this.total_revenue_ps = total_revenue_ps;}
    public void setRevenue_ps(float revenue_ps){this.revenue_ps = revenue_ps;}
    public void setExtra_item(float extra_item){this.extra_item = extra_item;}
    public void setProfit_dedt(float profit_dedt){this.profit_dedt = profit_dedt;}
    public void setGross_margin(float gross_margin){this.gross_margin = gross_margin;}
    public void setCurrent_ratio(float current_ratio){this.current_ratio = current_ratio;}
    public void setQuick_ratio(float quick_ratio){this.quick_ratio = quick_ratio;}
    public void setCash_ratio(float cash_ratio){this.cash_ratio = cash_ratio;}
    public void setAssets_turn(float assets_turn){this.assets_turn = assets_turn;}
    public void setInterst_income(float interst_income){this.interst_income = interst_income;}
    public void setDaa(float daa){this.daa = daa;}
    public void setEbit(float ebit){this.ebit = ebit;}
    public void setEbitda(float ebitda){this.ebitda = ebitda;}
    public void setNetdebt(float netdebt){this.netdebt = netdebt;}
    public void setBps(float bps){this.bps = bps;}
    public void setRoe(float roe){this.roe = roe;}
    public void setRoa(float roa){this.roa = roa;}
    public void setNpta(float npta){this.npta = npta;}
    public void setDebt_to_assets(float debt_to_assets){this.debt_to_assets = debt_to_assets;}
    
    public int getId(){return this.id;}
    public String getTs_code(){return this.ts_code;}
    public Date getAnn_date(){return this.ann_date;}
    public Date getEnd_date(){return this.end_date;}
    public float getEps(){return this.eps;}
    public float getDt_eps(){return this.dt_eps;}
    public float getTotal_revenue_ps(){return this.total_revenue_ps;}
    public float getRevenue_ps(){return this.revenue_ps;}
    public float getExtra_item(){return this.extra_item;}
    public float getProfit_dedt(){return this.profit_dedt;}
    public float getGross_margin(){return this.gross_margin;}
    public float getCurrent_ratio(){return this.current_ratio;}
    public float getQuick_ratio(){return this.quick_ratio;}
    public float getCash_ratio(){return this.cash_ratio;}
    public float getAssets_turn(){return this.assets_turn;}
    public float getInterst_income(){return this.interst_income;}
    public float getDaa(){return this.daa;}
    public float getEbit(){return this.ebit;}
    public float getEbitda(){return this.ebitda;}
    public float getNetdebt(){return this.netdebt;}
    public float getBps(){return this.bps;}
    public float getRoe(){return this.roe;}
    public float getRoa(){return this.roa;}
    public float getNpta(){return this.npta;}
    public float getDebt_to_assets(){return this.debt_to_assets;}
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.model;

/**
 *
 * @author hanwang
 */
public class CandleData {
    private String[] category;
    private float[][] data;
    
    public void setCategory(String[] category){this.category = category;}
    public void setData(float[][] data){this.data = data;}
    public String[] getCategory(){return this.category;}
    public float[][] getData(){return this.data;}
    
}

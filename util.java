/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.util;
import com.gina.model.UsStockDaily;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;
/**
 *
 * @author hanwang
 */
public class util {
    
    public static Date getZonedDate(String inputdate){
        Date dt = Date.valueOf(inputdate);
        ZoneId zoneId = ZoneId.of("UTC");
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        fm.setTimeZone(TimeZone.getTimeZone(zoneId));
        try{
            java.util.Date dat = fm.parse(inputdate);
            dt = Date.valueOf(dat.toString());
        }catch(Exception e){
            System.out.println("parse error");
        }
        return dt;
        
    }

    public static String getPercentStr(float input){
        float a = Math.round(input*10000)/100;
        String rs = a+ "%";
        return rs;
        
    }
    
    public static String arrayStrTojsonStr(String[] input){
        String rs = "[";
        for (int i=0; i<input.length; i++){
            rs = rs+"\""+input[i]+"\"";
            //rs = rs + input[i];
            if (i!=input.length-1){
                rs += ",";
            }
        }
        rs += "]";
        return rs;
    }
    public static String arrayDateTojsonStr(Date[] input){
        String rs = "[";
        for (int i=0; i<input.length; i++){
            rs = rs+"\""+input[i].toString()+"\"";
            //rs = rs + input[i];
            if (i!=input.length-1){
                rs += ",";
            }
        }
        rs += "]";
        return rs;
    }
   public static String array1doubleTojsonStr(double[] input){
        String rs = "[";
        for (int i=0; i<input.length; i++){
            //rs = rs+"\""+input[i]+"\"";
            rs = rs + input[i];
            if (i!=input.length-1){
                rs += ",";
            }
        }
        rs += "]";
        return rs;
    }
    public static String array2floatTojsonStr(float[][] input){
        String rs = "[";
        for (int i=0; i<input.length; i++){
            rs +="[";
            for (int j=0; j<input[i].length; j++){
                rs += input[i][j]+"";
                if (j!=input[j].length-1){
                    rs+=",";
                }
            }
            rs +="]";
            if(i!=input.length-1){
                rs +=",";
            }
            
        }
        
        
        rs+="]";
        return rs;
        
    }
    
    public static float getKeepDigitals(float input, int num){
        int r = 1;
        if (num <=0)
            r = 1;
        else
            r = (int)Math.pow(10, num);
        float rs = ((float)Math.round(input*r))/r;
        return rs;
                   
    }
    
    public static float calPercentofChange(float original, float target){
        float rs = target - original;
        if (original == 0){
            return 0;
        }else{
            float ratio = (rs/original)*100;
            int a = Math.round(ratio*100);
            float r = ((float)a)/100;
            return r;
        }
    }
    public static UsStockDaily[] setPctChgsAndCleans(List<UsStockDaily> inputlist){
        int ln = inputlist.size();
        UsStockDaily[] output = new UsStockDaily[ln-1];
        for(int i=0; i<ln-1; i++){
            UsStockDaily item = new UsStockDaily();
            UsStockDaily one = inputlist.get(i);
            UsStockDaily one_1 = inputlist.get(i+1);
            float pct = util.calPercentofChange(one_1.getClose(), one.getClose());
            one.setPct_chg(pct);
            item.setAdj_close(util.getKeepDigitals(one.getAdj_close(), 2));
            item.setClose(util.getKeepDigitals(one.getClose(), 2));
            item.setHigh(util.getKeepDigitals(one.getHigh(), 2));
            item.setLow(util.getKeepDigitals(one.getLow(), 2));
            item.setOpen(util.getKeepDigitals(one.getOpen(), 2));
            item.setPct_chg(pct);
            item.setSymbol(one.getSymbol());
            item.setTrade_date(one.getTrade_date());
            item.setVolume(one.getVolume());
            output[i] = item;
        }
        return output;
    }
}

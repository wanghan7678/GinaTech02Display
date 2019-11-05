/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;
import com.gina.dao.cnStockDailyDao;
import com.gina.dao.usStockDailyDao;
import com.gina.model.StockCalData;
import com.gina.model.CnStockDaily;
import com.gina.model.UsStockDaily;
import com.tictactec.ta.lib.MAType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
/**
 *
 * @author hanwang
 */
@Service
public class StockTechCalService {

    @Autowired
    private cnStockDailyDao cnStkDailyDao;
    
    @Autowired
    private usStockDailyDao usStkDailyDao;

    public StockCalData getUsStockCalData(String symbol, int periods){
        StockCalData dt = new StockCalData();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("symbol", symbol);
        map.put("periods", periods);
        List<UsStockDaily> dailys = usStkDailyDao.selectDataOrderDesc(map);
        Collections.sort(dailys);
        if (periods > dailys.size()){
            periods = dailys.size();
        }
        float[] close = new float[periods];
        float[] open = new float[periods];
        float[] vol = new float[periods];
        float[] high = new float[periods];
        float[] low = new float[periods];
        Date[] date = new Date[periods];
        for(int i=0; i< periods; i++){
            close[i] = dailys.get(i).getClose();
            open[i] = dailys.get(i).getOpen();
            high[i] = dailys.get(i).getHigh();
            low[i] = dailys.get(i).getLow();
            vol[i] = dailys.get(i).getVolume();
            date[i] = dailys.get(i).getTrade_date();
        }
        dt.setClose(close);
        dt.setHigh(high);
        dt.setLow(low);
        dt.setOpen(open);
        dt.setPeriods(periods);
        dt.setVol(vol);
        dt.setDate(date);
        return dt;
    }
    
    public StockCalData getStockCalData(String symbol, int periods){
        StockCalData dt = new StockCalData();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("symbol", symbol);
        map.put("periods", periods);
        List<CnStockDaily> dailys = cnStkDailyDao.selectDataOrderDesc(map);
        Collections.sort(dailys);
        if (periods > dailys.size()){
            periods = dailys.size();
        }
        float[] close = new float[periods];
        float[] open = new float[periods];
        float[] vol = new float[periods];
        float[] high = new float[periods];
        float[] low = new float[periods];
        Date[] date = new Date[periods];
        for(int i=0; i< periods; i++){
            close[i] = dailys.get(i).getClose();
            open[i] = dailys.get(i).getOpen();
            high[i] = dailys.get(i).getHigh();
            low[i] = dailys.get(i).getLow();
            vol[i] = dailys.get(i).getVol();
            date[i] = dailys.get(i).getTrade_date();
        }
        dt.setClose(close);
        dt.setHigh(high);
        dt.setLow(low);
        dt.setOpen(open);
        dt.setPeriods(periods);
        dt.setVol(vol);
        dt.setDate(date);
        return dt;
    }
    
    
    public double[] calculateObv(StockCalData inputdata){
        int periods = inputdata.getPeriods();
        double[] output = new double[periods];
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();
        c.obv(0, periods-1, inputdata.getClose(), inputdata.getVol(), outBegIdx, outNBElement, output);
        return output;
    }

    public HashMap<String, double[]> calculateFaststc(StockCalData inputdata){
        int periods = inputdata.getPeriods();
        double[] outputK = new double[periods];
        double[] outputD = new double[periods];
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();
        c.stochF(0, periods-1, inputdata.getHigh(), inputdata.getLow(), inputdata.getClose(), 10, 3, MAType.Sma, outBegIdx, outNBElement, outputK, outputD);
        HashMap<String, double[]> map = new HashMap<String, double[]>();
        outputD = this.fixtheEnd(outputD);
        outputK = this.fixtheEnd(outputK);
        map.put("fastd", outputD);
        map.put("fastk", outputK);
        return map;
                
        }
    
    public HashMap<String, double[]> calculateMA10(StockCalData inputdata){
        int periods = inputdata.getPeriods();
        double[] output = new double[periods];
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();;
        c.sma(0, periods-1, inputdata.getClose(), 10, outBegIdx, outNBElement, output);
        HashMap<String, double[]> map = new HashMap<String, double[]>();
        output = this.fixtheEnd(output);
        map.put("ma10", output);
        return map;
    }
    
    public HashMap<String, double[]> calculateBoll(StockCalData inputdata){
        int periods = inputdata.getPeriods();
        double[] outputUpper = new double[periods];
        double[] outputMiddle = new double[periods];
        double[] outputLower = new double[periods];
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();;
        c.bbands(0, periods-1, inputdata.getClose(), 5, 2, 2, MAType.Sma, outBegIdx, outNBElement, outputUpper, outputMiddle, outputLower);
        HashMap<String, double[]> map = new HashMap<String, double[]>();
        outputUpper = this.fixtheEnd(outputUpper);
        outputMiddle = this.fixtheEnd(outputMiddle);
        outputLower = this.fixtheEnd(outputLower);
        map.put("boll_upper", outputUpper);
        map.put("boll_middle", outputMiddle);
        map.put("boll_lower", outputLower);
        return map;
    }
    
    public HashMap<String, double[]> calculateDmi(StockCalData inputdata){
        int periods = inputdata.getPeriods();
        HashMap<String, double[]> map = new HashMap<String, double[]>();
        double[] outputAdx = new double[periods];
        double[] outputPdi = new double[periods];
        double[] outputMdi = new double[periods];
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();
        c.adx(0, periods-1, inputdata.getHigh(), inputdata.getLow(), inputdata.getClose(), 14, outBegIdx, outNBElement, outputAdx);
        c.plusDI(0, periods-1, inputdata.getHigh(), inputdata.getLow(), inputdata.getClose(), 14, outBegIdx, outNBElement, outputPdi);
        c.minusDI(0, periods-1, inputdata.getHigh(), inputdata.getLow(), inputdata.getClose(), 14, outBegIdx, outNBElement, outputMdi);
        outputAdx = this.fixtheEnd(outputAdx);
        outputPdi = this.fixtheEnd(outputPdi);
        outputMdi = this.fixtheEnd(outputMdi);        
        map.put("dmi_adx", outputAdx);
        map.put("dmi_pdi", outputPdi);
        map.put("dmi_mdi", outputMdi);
        return map;
        
    }
    public HashMap<String, double[]> calculateWMSR(StockCalData inputdata){
        int periods = inputdata.getPeriods();
        HashMap<String, double[]> map = new HashMap<String, double[]>();
        double[] outputWr1 = new double[periods];
        double[] outputWr2 = new double[periods];
        float[] inHigh = inputdata.getHigh();
        float[] inLow = inputdata.getLow();
        float[] inClose = inputdata.getClose();
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();
        
        c.willR(0, periods-1, inHigh, inLow, inClose, 6, outBegIdx, outNBElement, outputWr1);
        c.willR(0, periods-1, inHigh, inLow, inClose, 13, outBegIdx, outNBElement, outputWr2);

        outputWr1 = this.fixtheEnd(outputWr1);
        outputWr2 = this.fixtheEnd(outputWr2);
     
        map.put("wmsr_wr1", outputWr1);
        map.put("wmsr_wr2", outputWr2);
        return map;
        
    }
    public double[] calculateMOM(StockCalData inputdata){
        int periods = inputdata.getPeriods();

        double[] output = new double[periods];
        //float[] inHigh = inputdata.getHigh();
        //float[] inLow = inputdata.getLow();
        float[] inClose = inputdata.getClose();
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();
        
        c.mom(0, periods-1, inClose, 12, outBegIdx, outNBElement, output);

        output = this.fixtheEnd(output);
   
        return output;
        
    }
   public double[] calculateSAR(StockCalData inputdata){
        int periods = inputdata.getPeriods();

        double[] output = new double[periods];
        float[] inHigh = inputdata.getHigh();
        float[] inLow = inputdata.getLow();
        //float[] inClose = inputdata.getClose();
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();
        
        c.sar(0, periods-1, inHigh, inLow, 0.02, 0.2, outBegIdx, outNBElement, output);

        output = this.fixtheEnd(output);
   
        return output;
        
    }
    public double[] calculateAD(StockCalData inputdata){
        int periods = inputdata.getPeriods();

        double[] output = new double[periods];
        float[] inHigh = inputdata.getHigh();
        float[] inLow = inputdata.getLow();
        float[] inClose = inputdata.getClose();
        float[] inVolume = inputdata.getVol();
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();
        
        c.ad(0, periods-1, inHigh, inLow, inClose, inVolume, outBegIdx, outNBElement, output);

        output = this.fixtheEnd(output);
   
        return output;
        
    }
    public double[] calculateTrange(StockCalData inputdata){
        int periods = inputdata.getPeriods();

        double[] output = new double[periods];
        //float[] inHigh = inputdata.getHigh();
        //float[] inLow = inputdata.getLow();
        float[] inClose = inputdata.getClose();
        //float[] inVolume = inputdata.getVol();
        Core c = new Core();
        MInteger outBegIdx = new MInteger();
        MInteger outNBElement = new MInteger();
        
        c.t3(0, periods-1, inClose, 5, 0.7, outBegIdx, outNBElement, output);

        output = this.fixtheEnd(output);
   
        return output;
        
    }
    
    private double[] fixtheEnd(double[] input){
        int len = input.length;
        double[] temp = new double[len];
        int i = len-1;
        int c = 0;
        while(input[i]==0){
            i--;
            c++;
        }
        for(int j=0; j<c; j++){
            temp[j] = 0;
        }
        for(int j=c; j<len; j++){
            temp[j] = input[j-c];
        }
        return temp;
    }
}

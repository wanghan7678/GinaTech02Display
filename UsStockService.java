/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gina.model.AnnPredictResult;
import com.gina.model.UsStockItem;
import com.gina.model.UsStockDaily;
import com.gina.model.CandleData;
import com.gina.model.StockTrackingData;
import com.gina.model.StockDisplayData;
import com.gina.model.UsStockOneMainTopData;
import com.gina.model.UsStockFina;
import com.gina.dao.usStockItemDao;
import com.gina.dao.usStockDailyDao;
import com.gina.dao.usStockCompanyDao;
import com.gina.dao.usStockFinaDao;

import java.util.List;
import java.util.HashMap;
import java.sql.Date;
import java.util.Collections;
import com.gina.dao.usPredictResultDao;
import com.gina.util.util;
/**
 *
 * @author hanwang
 */
@Service
public class UsStockService {
    @Autowired
    private usPredictResultDao annPreDao;
    
    @Autowired
    private usStockItemDao usStkDao;
    
    @Autowired
    private usStockDailyDao usStkDailyDao;
    
    @Autowired
    private usStockCompanyDao usStkCompanyDao;
    
    @Autowired
    private usStockFinaDao usStkFinaDao;
    
    public AnnPredictResult getMostOneStock(Date trade_date){
        return annPreDao.selectTheMostByDate(trade_date);
    }

    
    
    
    public UsStockItem getOneStockItem(String symbol){
        return usStkDao.selectStockItemDetail(symbol);
    }
    
    public AnnPredictResult getMostOneStockLatest(){
        return annPreDao.selectTheMostOneLatest();
    }
    public List<AnnPredictResult> getTop6StockResult(){
        return annPreDao.selectTop6Latest();
    }
            
            
            
            
    public List<UsStockDaily> getLast60StockDaily(String symbol){
        List<UsStockDaily> list = usStkDailyDao.selectLast60BySymbol(symbol);
        Collections.sort(list);
        return list;
    }
    public List<UsStockDaily> getLast30StockDaily(String symbol){
        List<UsStockDaily> list = usStkDailyDao.selectLast30BySymbol(symbol);
        Collections.sort(list);
        return list;
    }
    
    public CandleData getLast60CandleData(String symbol){
        List<UsStockDaily> list = this.getLast60StockDaily(symbol);
        String[] a = new String[60];
        float[][] b = new float[60][4];
        int l = list.size();
        if (l>60)
                l=60;
        for(int i=0; i<l; i++){
            UsStockDaily usStk = list.get(i);
            a[i] = usStk.getTrade_date().toString();
            b[i][0] = usStk.getOpen();
            b[i][1] = usStk.getClose();
            b[i][2] = usStk.getLow();
            b[i][3] = usStk.getHigh();
        }
        CandleData cd = new CandleData();
        cd.setCategory(a);
        cd.setData(b);
        return cd;
    }
    public CandleData getLast30CandleData(String ts_code){
        List<UsStockDaily> list = this.getLast30StockDaily(ts_code);
        String[] a = new String[30];
        float[][] b = new float[30][4];
        int l = list.size();
        if (l>30)
                l=30;
        for(int i=0; i<l; i++){
            UsStockDaily usStk = list.get(i);
            a[i] = usStk.getTrade_date().toString();
            b[i][0] = usStk.getOpen();
            b[i][1] = usStk.getClose();
            b[i][2] = usStk.getLow();
            b[i][3] = usStk.getHigh();
        }
        CandleData cd = new CandleData();
        cd.setCategory(a);
        cd.setData(b);
        return cd;
    }
    
    //yesterday: lastnum=1
    //5-last: lastnum=5
    public StockTrackingData[] getLastTracking(int lastnum){
        //List<Date> tradedates = annPreDao.selectTradeDateLast6();
        //StockTrackingData[] data = new StockTrackingData[6];
        List<Date> tradedates = annPreDao.selectTradeDateLast10();
        StockTrackingData[] data = new StockTrackingData[10];
         
        
        if (lastnum > tradedates.size()-1)
            lastnum = tradedates.size()-1;
        Date trade_date = tradedates.get(lastnum);
        List<AnnPredictResult> rslist = annPreDao.selectTop10ByDate(trade_date);
        for (int i=0; i<rslist.size(); i++){
            StockTrackingData oneItem = new StockTrackingData();
            AnnPredictResult itemRes = rslist.get(i);
            UsStockItem itemDetail = usStkDao.selectStockItemDetail(itemRes.getSymbol());
            oneItem.setSymbol(itemRes.getSymbol());
            oneItem.setName((itemDetail.getName()));
            oneItem.setResult(util.getKeepDigitals(itemRes.getResult()*100, 2));
            int days = usStkDailyDao.selectDayCountsToToday(itemRes);
            float close = usStkDailyDao.selectTradeDateClose(itemRes);
            float today_close = usStkDailyDao.selectTodayClose(itemRes.getSymbol());
            boolean ifUp = (today_close>=close);
            oneItem.setPastdays(days-1);
            oneItem.setIfup(ifUp);
            float pct = util.calPercentofChange(close, today_close);
            oneItem.setChgpct(pct);
            data[i] = oneItem;
        }
        return data;
    }
    public StockTrackingData[] getHighest25Scores(){
        StockTrackingData[] data = new StockTrackingData[25];
        List<AnnPredictResult> rslist = annPreDao.selectTop25highscoures();
        for (int i=0; i<rslist.size(); i++){
            StockTrackingData oneItem = new StockTrackingData();
            AnnPredictResult itemRes = rslist.get(i);
            UsStockItem itemDetail = usStkDao.selectStockItemDetail(itemRes.getSymbol());
            oneItem.setSymbol(itemRes.getSymbol());
            oneItem.setName((itemDetail.getName()));
            oneItem.setResult(util.getKeepDigitals(itemRes.getResult()*100, 2));
            int days = usStkDailyDao.selectDayCountsToToday(itemRes);
            float close = usStkDailyDao.selectTradeDateClose(itemRes);
            float today_close = usStkDailyDao.selectTodayClose(itemRes.getSymbol());
            boolean ifUp = (today_close>=close);
            oneItem.setPastdays(days);
            oneItem.setIfup(ifUp);
            float pct = util.calPercentofChange(close, today_close);
            oneItem.setChgpct(pct);
            data[i] = oneItem;            
        }
        return data;
        
    }
    public StockTrackingData[] getHighest15Scores(){
        StockTrackingData[] data = new StockTrackingData[15];
        List<AnnPredictResult> rslist = annPreDao.selectTop15highscoures();
        for (int i=0; i<rslist.size(); i++){
            StockTrackingData oneItem = new StockTrackingData();
            AnnPredictResult itemRes = rslist.get(i);
            UsStockItem itemDetail = usStkDao.selectStockItemDetail(itemRes.getSymbol());
            oneItem.setSymbol(itemRes.getSymbol());
            oneItem.setName((itemDetail.getName()));
            oneItem.setResult(util.getKeepDigitals(itemRes.getResult()*100, 2));
            int days = usStkDailyDao.selectDayCountsToToday(itemRes);
            float close = usStkDailyDao.selectTradeDateClose(itemRes);
            float today_close = usStkDailyDao.selectTodayClose(itemRes.getSymbol());
            boolean ifUp = (today_close>=close);
            oneItem.setPastdays(days);
            oneItem.setIfup(ifUp);
            float pct = util.calPercentofChange(close, today_close);
            oneItem.setChgpct(pct);
            data[i] = oneItem;            
        }
        return data;
        
    }
    public StockDisplayData[] getTopNStockDisplayData(int num){
        List<AnnPredictResult> rl = annPreDao.selectTopNLatest(num);
        int queryed_size = rl.size();
        int size = num;
        StockDisplayData[] rs = new StockDisplayData[size];
        if(queryed_size<size)
            size = queryed_size;
        for (int i=0; i<rl.size(); i++){
            AnnPredictResult r1 = rl.get(i);
            if (r1!=null){
                String symbol = r1.getSymbol();
                UsStockItem usStk = usStkDao.selectStockItemDetail(symbol);
                CandleData cd;
                if (i==0)
                    cd = this.getLast60CandleData(symbol);
                else
                    cd = this.getLast30CandleData(symbol);
                StockDisplayData dd = new StockDisplayData();
                dd.setArea("-");
                dd.setCategory(util.arrayStrTojsonStr(cd.getCategory()));
                dd.setData(util.array2floatTojsonStr(cd.getData()));
                dd.setIndustry(usStk.getIndustry());
                dd.setMarket("-");
                dd.setName(usStk.getName());
                dd.setSector(usStk.getSector());
                dd.setSymbol(usStk.getSymbol());
                dd.setTrade_date(r1.getTrade_date().toString());
                dd.setResult(util.getKeepDigitals(r1.getResult()*100, 2)+" %");
                dd.setExchange("-");
                rs[i] = dd;
            }
            
        }
        return rs;
        
    }
    public StockDisplayData[] getTop6StockDisplayData(){
        List<AnnPredictResult> rl = annPreDao.selectTop6Latest();
        StockDisplayData[] rs = new StockDisplayData[6];
        
        for (int i=0; i<rl.size(); i++){
            AnnPredictResult r1 = rl.get(i);
            if (r1!=null){
                String symbol = r1.getSymbol();
                UsStockItem usStk = usStkDao.selectStockItemDetail(symbol);
                CandleData cd;
                if (i==0)
                    cd = this.getLast60CandleData(symbol);
                else
                    cd = this.getLast30CandleData(symbol);
                StockDisplayData dd = new StockDisplayData();
                dd.setArea("-");
                dd.setCategory(util.arrayStrTojsonStr(cd.getCategory()));
                dd.setData(util.array2floatTojsonStr(cd.getData()));
                dd.setIndustry(usStk.getIndustry());
                dd.setMarket("-");
                dd.setName(usStk.getName());
                dd.setSector(usStk.getSector());
                dd.setSymbol(usStk.getSymbol());
                dd.setTrade_date(r1.getTrade_date().toString());
                dd.setResult(util.getKeepDigitals(r1.getResult()*100, 2)+" %");
                dd.setExchange("-");
                rs[i] = dd;
            }
            
        }
        return rs;
        
    }
    public float getPctChg(String symbol, Date trade_date){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("symbol", symbol);
        map.put("trade_date", trade_date);
        float[] close = usStkDailyDao.selectTradeDateLast2Close(map);
        if(close.length == 2){
            float today_close = close[0];
            float yesterday_close = close[1];
            return util.calPercentofChange(yesterday_close, today_close);
        }else
            return 0;

    }
    
    public UsStockOneMainTopData getOneMainTopData(String symbol){
        UsStockOneMainTopData data = new UsStockOneMainTopData();
        AnnPredictResult rs = annPreDao.selectResultBySymbol(symbol);
        UsStockItem item = usStkDao.selectStockItemDetail(symbol);
        String description = usStkCompanyDao.selectIntroductionBySymbol(symbol);
        UsStockDaily daily = usStkDailyDao.selectLast1BySymbol(symbol);
        CandleData cd = this.getLast60CandleData(symbol);
        data.setCategory(util.arrayStrTojsonStr(cd.getCategory()));
        data.setClose(daily.getClose());
        data.setData(util.array2floatTojsonStr(cd.getData()));
        data.setIntroduction(description);
        data.setHigh(daily.getHigh());
        data.setLast_date(daily.getTrade_date());
        data.setLow(daily.getLow());
        data.setName(item.getName());
        data.setOpen(daily.getOpen());
        data.setPct_chg(this.getPctChg(symbol, rs.getTrade_date()));
        data.setScore(rs.getResult());
        data.setSymbol(symbol);
        data.setTrig_date(rs.getTrade_date());
        data.setVol(daily.getVolume());
        data.setIndustry(item.getIndustry());
        data.setWebsite(item.getSum_quote());
        data.setSector(item.getSector());
        return data;
    }
    
    public List<UsStockFina> getLast2FinaReport(String symbol){
        List<UsStockFina> dl = usStkFinaDao.selectLatest2BySymbol(symbol);
        return dl;
    }
    
    public List<UsStockDaily> getLastNumUsStockDailyDesc(String ts_code, int num){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("symbol", ts_code);
        map.put("periods", num);
        List<UsStockDaily> list = usStkDailyDao.selectDataOrderDesc(map);
        return list;
    }
    public StockTrackingData[] getHistoryResult(String symbol){
        List<AnnPredictResult> rslist = annPreDao.selectResultBySymbolAll(symbol);
        StockTrackingData[] data = new StockTrackingData[rslist.size()];
        for(int i=0; i<rslist.size(); i++){
            StockTrackingData oneItem = new StockTrackingData();
            AnnPredictResult itemRes = rslist.get(i);
            UsStockItem itemDetail = usStkDao.selectStockItemDetail(itemRes.getSymbol());
            oneItem.setSymbol(itemRes.getSymbol());
            oneItem.setName((itemDetail.getName()));
            oneItem.setResult(util.getKeepDigitals(itemRes.getResult()*100, 2));
            int days = usStkDailyDao.selectDayCountsToToday(itemRes);
            float close = usStkDailyDao.selectTradeDateClose(itemRes);
            float today_close = usStkDailyDao.selectTodayClose(itemRes.getSymbol());
            float d6_close = this.get6DaysAfterClose(symbol, itemRes.getTrade_date());
            boolean ifUp = (today_close>=close);
            oneItem.setPastdays(days-1);
            oneItem.setIfup(ifUp);
            float pct = util.calPercentofChange(close, today_close);
            float pct6 = util.calPercentofChange(close, d6_close);
            oneItem.setChgpct(pct);
            if (d6_close==-100)
                oneItem.setChgpct6(-100);
            else
                oneItem.setChgpct6(pct6);
            oneItem.setTrig_date(itemRes.getTrade_date());
            data[i] = oneItem;
        }
        return data;
    }
    public float get6DaysAfterClose(String symbol, Date date){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("symbol", symbol);
        map.put("trade_date", date);
        float[] c = usStkDailyDao.select6DaysAfterClose(map);
        float r = -100;
        int l = c.length;
        if (l>=7){
            r = c[6];
        }
        return r;
        
    }

}

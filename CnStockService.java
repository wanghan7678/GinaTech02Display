/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gina.model.AnnPredictResult;
import com.gina.model.CnStockItem;
import com.gina.model.CnStockDaily;
import com.gina.model.CandleData;
import com.gina.model.StockTrackingData;
import com.gina.model.CnStockOneMainTopData;
import com.gina.model.CnStockFina;
import com.gina.dao.cnStockItemDao;
import com.gina.dao.cnStockDailyDao;
import com.gina.dao.cnStockCompanyDao;
import com.gina.dao.cnStockFinaDao;
import java.util.List;
import java.sql.Date;
import java.util.Collections;
import com.gina.dao.cnPredictResultDao;
import com.gina.model.StockDisplayData;
import com.gina.util.util;
import java.util.HashMap;
/**
 *
 * @author hanwang
 */
@Service
public class CnStockService {
    @Autowired
    private cnPredictResultDao annPreDao;
    
    @Autowired
    private cnStockItemDao cnStkDao;
    
    @Autowired
    private cnStockDailyDao cnStkDailyDao;
    
    @Autowired
    private cnStockCompanyDao cnStkCompanyDao;
    
    @Autowired
    private cnStockFinaDao cnStkFinaDao;
    
    public AnnPredictResult getMostOneCnStock(Date trade_date){
        return annPreDao.selectTheMostByDateCn(trade_date);
    }

    
    
    
    public CnStockItem getOneStockItem(String ts_code){
        return cnStkDao.selectStockItemDetail(ts_code);
    }
    
    public AnnPredictResult getMostOneCnStockLatest(){
        return annPreDao.selectTheMostOneLatest();
    }
    public List<AnnPredictResult> getTop6CnStockResult(){
        return annPreDao.selectTop6Latest();
    }
            
            
            
            
    public List<CnStockDaily> getLast60CnStockDaily(String ts_code){
        List<CnStockDaily> list = cnStkDailyDao.selectLast60BySymbol(ts_code);
        Collections.sort(list);
        return list;
    }
    public List<CnStockDaily> getLast30CnStockDaily(String ts_code){
        List<CnStockDaily> list = cnStkDailyDao.selectLast30BySymbol(ts_code);
        Collections.sort(list);
        return list;
    }
    //this is in desc order
    public List<CnStockDaily> getLastNumCnStockDailyDesc(String ts_code, int num){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("symbol", ts_code);
        map.put("periods", num);
        List<CnStockDaily> list = cnStkDailyDao.selectDataOrderDesc(map);
        return list;
    }
    
    public CandleData getLast60CandleData(String ts_code){
        List<CnStockDaily> list = this.getLast60CnStockDaily(ts_code);
        String[] a = new String[60];
        float[][] b = new float[60][4];
        int l = list.size();
        if (l>60)
                l=60;
        for(int i=0; i<l; i++){
            CnStockDaily cnStk = list.get(i);
            a[i] = cnStk.getTrade_date().toString();
            b[i][0] = cnStk.getOpen();
            b[i][1] = cnStk.getClose();
            b[i][2] = cnStk.getLow();
            b[i][3] = cnStk.getHigh();
        }
        CandleData cd = new CandleData();
        cd.setCategory(a);
        cd.setData(b);
        return cd;
    }
    public CandleData getLast30CandleData(String ts_code){
        List<CnStockDaily> list = this.getLast30CnStockDaily(ts_code);
        String[] a = new String[30];
        float[][] b = new float[30][4];
        int l = list.size();
        if (l>30)
                l=30;
        for(int i=0; i<l; i++){
            CnStockDaily cnStk = list.get(i);
            a[i] = cnStk.getTrade_date().toString();
            b[i][0] = cnStk.getOpen();
            b[i][1] = cnStk.getClose();
            b[i][2] = cnStk.getLow();
            b[i][3] = cnStk.getHigh();
        }
        CandleData cd = new CandleData();
        cd.setCategory(a);
        cd.setData(b);
        return cd;
    }
    
    public float get6DaysAfterClose(String symbol, Date date){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("symbol", symbol);
        map.put("trade_date", date);
        float[] c = cnStkDailyDao.select6DaysAfterClose(map);
        float r = -100;
        int l = c.length;
        if (l>=7){
            r = c[6];
        }
        return r;
        
    }
    
    public StockTrackingData[] getHistoryResult(String symbol){
        List<AnnPredictResult> rslist = annPreDao.selectResultBySymbolAll(symbol);
        StockTrackingData[] data = new StockTrackingData[rslist.size()];
        for(int i=0; i<rslist.size(); i++){
            StockTrackingData oneItem = new StockTrackingData();
            AnnPredictResult itemRes = rslist.get(i);
            CnStockItem itemDetail = cnStkDao.selectStockItemDetail(itemRes.getSymbol());
            oneItem.setSymbol(itemRes.getSymbol());
            oneItem.setName((itemDetail.getName()));
            oneItem.setResult(util.getKeepDigitals(itemRes.getResult()*100, 2));
            int days = cnStkDailyDao.selectDayCountsToToday(itemRes);
            float close = cnStkDailyDao.selectTradeDateClose(itemRes);
            float today_close = cnStkDailyDao.selectTodayClose(itemRes.getSymbol());
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
        List<AnnPredictResult> rslist = annPreDao.selectTop10ByDateCn(trade_date);
        for (int i=0; i<rslist.size(); i++){
            StockTrackingData oneItem = new StockTrackingData();
            AnnPredictResult itemRes = rslist.get(i);
            CnStockItem itemDetail = cnStkDao.selectStockItemDetail(itemRes.getSymbol());
            oneItem.setSymbol(itemRes.getSymbol());
            oneItem.setName((itemDetail.getName()));
            oneItem.setResult(util.getKeepDigitals(itemRes.getResult()*100, 2));
            int days = cnStkDailyDao.selectDayCountsToToday(itemRes);
            float close = cnStkDailyDao.selectTradeDateClose(itemRes);
            float today_close = cnStkDailyDao.selectTodayClose(itemRes.getSymbol());
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
            CnStockItem itemDetail = cnStkDao.selectStockItemDetail(itemRes.getSymbol());
            oneItem.setSymbol(itemRes.getSymbol()); 
            oneItem.setName((itemDetail.getName()));
            oneItem.setResult(util.getKeepDigitals(itemRes.getResult()*100, 2));
            int days = cnStkDailyDao.selectDayCountsToToday(itemRes);
            float close = cnStkDailyDao.selectTradeDateClose(itemRes);
            float today_close = cnStkDailyDao.selectTodayClose(itemRes.getSymbol());
            boolean ifUp = (today_close>=close);
            oneItem.setPastdays(days-1);
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
            CnStockItem itemDetail = cnStkDao.selectStockItemDetail(itemRes.getSymbol());
            oneItem.setSymbol(itemRes.getSymbol());
            oneItem.setName((itemDetail.getName()));
            oneItem.setResult(util.getKeepDigitals(itemRes.getResult()*100, 2));
            int days = cnStkDailyDao.selectDayCountsToToday(itemRes);
            float close = cnStkDailyDao.selectTradeDateClose(itemRes);
            float today_close = cnStkDailyDao.selectTodayClose(itemRes.getSymbol());
            boolean ifUp = (today_close>=close);
            oneItem.setPastdays(days-1);
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
        if(queryed_size<size)
            size = queryed_size;
        StockDisplayData[] rs = new StockDisplayData[size];
                for (int i=0; i<rl.size(); i++){
            AnnPredictResult r1 = rl.get(i);
            if (r1!=null){
                String symbol = r1.getSymbol();
                CnStockItem cnStk = cnStkDao.selectStockItemDetail(symbol);
                CandleData cd;
                if (i==0)
                    cd = this.getLast60CandleData(symbol);
                else
                    cd = this.getLast30CandleData(symbol);
                StockDisplayData dd = new StockDisplayData();
                dd.setArea(cnStk.getArea());
                dd.setCategory(util.arrayStrTojsonStr(cd.getCategory()));
                dd.setData(util.array2floatTojsonStr(cd.getData()));
                dd.setIndustry(cnStk.getIndustry());
                dd.setMarket(cnStk.getMarket());
                dd.setName(cnStk.getName());
                dd.setSector("-");
                dd.setSymbol(cnStk.getTs_code());
                dd.setTrade_date(r1.getTrade_date().toString());
                dd.setResult(util.getKeepDigitals(r1.getResult()*100, 2)+" %");
                dd.setExchange(cnStk.getExchange());
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
                CnStockItem cnStk = cnStkDao.selectStockItemDetail(symbol);
                CandleData cd;
                if (i==0)
                    cd = this.getLast60CandleData(symbol);
                else
                    cd = this.getLast30CandleData(symbol);
                StockDisplayData dd = new StockDisplayData();
                dd.setArea(cnStk.getArea());
                dd.setCategory(util.arrayStrTojsonStr(cd.getCategory()));
                dd.setData(util.array2floatTojsonStr(cd.getData()));
                dd.setIndustry(cnStk.getIndustry());
                dd.setMarket(cnStk.getMarket());
                dd.setName(cnStk.getName());
                dd.setSector("-");
                dd.setSymbol(cnStk.getTs_code());
                dd.setTrade_date(r1.getTrade_date().toString());
                dd.setResult(util.getKeepDigitals(r1.getResult()*100, 2)+" %");
                dd.setExchange(cnStk.getExchange());
                rs[i] = dd;
            }
            
        }
        return rs;
        
    }
        
    public CnStockOneMainTopData getOneMainTopData(String symbol){
        CnStockOneMainTopData data = new CnStockOneMainTopData();
        AnnPredictResult rs = annPreDao.selectResultBySymbol(symbol);
        CnStockItem item = cnStkDao.selectStockItemDetail(symbol);
        String description = cnStkCompanyDao.selectIntroductionBySymbol(symbol);
        String website = cnStkCompanyDao.selectWebsiteBySymbol(symbol);
        CnStockDaily daily = cnStkDailyDao.selectLast1BySymbol(symbol);
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
        data.setPct_chg(daily.getPct_chg());
        data.setScore(rs.getResult());
        data.setSymbol(symbol);
        data.setTrig_date(rs.getTrade_date());
        data.setVol(daily.getVol());
        data.setArea(item.getArea());
        data.setIndustry(item.getIndustry());
        data.setMarket(item.getMarket());
        data.setWebsite(website);
        return data;
    }
    
    public List<CnStockFina> getLast4FinaReport(String symbol){
        List<CnStockFina> dl = cnStkFinaDao.selectLatest4BySymbol(symbol);
        return dl;
    }
    public List<CnStockFina> getLast2FinaReport(String symbol){
        List<CnStockFina> dl = cnStkFinaDao.selectLatest2BySymbol(symbol);
        return dl;
    }
    

}

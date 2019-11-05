/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;
import java.util.List;
import java.util.HashMap;
import java.sql.Date;
import com.gina.model.CnStockDaily;
import com.gina.model.AnnPredictResult;

/**
 *
 * @author hanwang
 */
public interface cnStockDailyDao {
    
    List<CnStockDaily> selectLast60BySymbol(String ts_code);
    List<CnStockDaily> selectLast30BySymbol(String ts_code);
    CnStockDaily selectLast1BySymbol(String ts_code);
    float selectTradeDateClose(AnnPredictResult item);
    int selectDayCountsToToday(AnnPredictResult item);
    float selectTodayClose(String ts_code);
    float[] select6DaysAfterClose(HashMap map);
    List<CnStockDaily> selectDataOrderDesc(HashMap map);
    
}

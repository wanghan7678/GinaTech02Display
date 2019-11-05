/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;
import java.util.List;
import java.util.HashMap;
import java.sql.Date;
import com.gina.model.UsStockDaily;
import com.gina.model.AnnPredictResult;

/**
 *
 * @author hanwang
 */
public interface usStockDailyDao {
    
    List<UsStockDaily> selectLast60BySymbol(String symbol);
    List<UsStockDaily> selectLast30BySymbol(String symbol);
    float selectTradeDateClose(AnnPredictResult item);
    int selectDayCountsToToday(AnnPredictResult item);
    float selectTodayClose(String symbol);
    UsStockDaily selectLast1BySymbol(String symbol);
    float[] selectTradeDateLast2Close(HashMap map);
    List<UsStockDaily> selectDataOrderDesc(HashMap map);
    float[] select6DaysAfterClose(HashMap map);

}

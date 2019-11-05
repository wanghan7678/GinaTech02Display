/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;
import com.gina.model.AnnPredictResult;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author hanwang
 */
public interface usPredictResultDao {
    AnnPredictResult selectTheMostByDate(Date trade_date);
    List<AnnPredictResult> selectTop6ByDate(Date trade_date);
     List<AnnPredictResult> selectTop10ByDate(Date trade_date);
    
    AnnPredictResult selectTheMostOneLatest();
    List<AnnPredictResult> selectTop6Latest();
    List<AnnPredictResult> selectTopNLatest(int num);
    
    List<Date> selectTradeDateLast6();
    List<Date> selectTradeDateLast10();
    
    List<AnnPredictResult> selectTop15highscoures();
    List<AnnPredictResult> selectTop25highscoures();
    
    AnnPredictResult selectResultBySymbol(String symbol);
    List<AnnPredictResult> selectResultBySymbolAll(String symbol);
}

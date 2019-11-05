/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.dao;
import com.gina.model.AnnPredictResult;
import com.gina.model.SelectCnStockAnnPredict;
import java.util.List;
import java.sql.Date;
/**
 *
 * @author hanwang
 */
public interface cnPredictResultDao {
    AnnPredictResult selectTheMostByDateCn(Date trade_date);
    AnnPredictResult selectResultBySymbol(String symbol);
    List<AnnPredictResult> selectResultBySymbolAll(String symbol);
    List<AnnPredictResult> selectTop6ByDateCn(Date trade_date);
    List<AnnPredictResult> selectTop10ByDateCn(Date trade_date);

    
    AnnPredictResult selectTheMostOneLatest();
    List<AnnPredictResult> selectTop6Latest();
    List<AnnPredictResult> selectTopNLatest(int num);
    
    List<Date> selectTradeDateLast6();
    List<Date> selectTradeDateLast10();
    
    List<AnnPredictResult> selectTop15highscoures();
    List<AnnPredictResult> selectTop25highscoures();

    /*
    SelectCnStockAnnPredict gettheMostwithStokItem(Date trade_date);
    List<SelectCnStockAnnPredict> getTopwithStokItem(Date trade_date, int top_num);
    */
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.gina.model.AnnPredictResult;
import com.gina.model.CnStockItem;
import com.gina.model.CandleData;
import com.gina.model.StockDisplayData;
import com.gina.model.StockTrackingData;
import com.gina.model.CnStockOneMainTopData;
import com.gina.model.CnStockDaily;
import com.gina.model.CnStockFina;
import com.gina.model.StockCalData;
import com.gina.service.CnStockService;
import com.gina.service.StockTechCalService;
import com.gina.util.util;
import java.util.List;
import java.util.HashMap;

/**
 *
 * @author hanwang
 */
@Controller
public class mainframeController {
    @Autowired
    private CnStockService myservice;
    @Autowired
    private StockTechCalService calService;
    
    @RequestMapping(value="/chineseHome")
    public String index(Model model){
        
        StockDisplayData[] data = myservice.getTopNStockDisplayData(10);
        
        model.addAttribute("top", data[0]);
        
        StockDisplayData[] topother = new StockDisplayData[9];
        for (int i=0; i<data.length-1; i++){
            topother[i] = data[i+1];
        }
        model.addAttribute("topother", topother);
        
        StockTrackingData[] yTrk = myservice.getLastTracking(1);
        model.addAttribute("track1", yTrk);
        
        StockTrackingData[] y5Trk = myservice.getLastTracking(5);
        model.addAttribute("track5", y5Trk);
        
        StockTrackingData[] top15Trk = myservice.getHighest25Scores();
        model.addAttribute("trackTop15", top15Trk);
        
        return "/chineseHome";
    }
    
    @RequestMapping(value="/chineseOnePage")
    public String showOnePage(String ts_code, Model model){
        CnStockOneMainTopData dt = myservice.getOneMainTopData(ts_code);
        model.addAttribute("basic", dt);
        
        List<CnStockFina> finalist = myservice.getLast2FinaReport(ts_code);
        model.addAttribute("fina", finalist);
        
        StockCalData calData = calService.getStockCalData(ts_code, 80);
        String category = util.arrayDateTojsonStr(calData.getDate());
        
        double[] obv = calService.calculateObv(calData);
        String obvstr = util.array1doubleTojsonStr(obv);
        
        model.addAttribute("category", category);
        model.addAttribute("obvdata", obvstr);        
        
        HashMap<String, double[]> stochf = calService.calculateFaststc(calData);
        String fastk = util.array1doubleTojsonStr(stochf.get("fastk"));
        String fastd = util.array1doubleTojsonStr(stochf.get("fastd"));
        model.addAttribute("fastk", fastk);
        model.addAttribute("fastd", fastd);
        
        HashMap<String, double[]> boll = calService.calculateBoll(calData);
        String stup = util.array1doubleTojsonStr(boll.get("boll_upper"));
        String stmid = util.array1doubleTojsonStr(boll.get("boll_middle"));
        String stlow = util.array1doubleTojsonStr(boll.get("boll_lower"));
        model.addAttribute("boll_upper", stup);
        model.addAttribute("boll_middle", stmid);
        model.addAttribute("boll_lower", stlow);
        
        HashMap<String, double[]> dmi = calService.calculateDmi(calData);
        String str_adx = util.array1doubleTojsonStr(dmi.get("dmi_adx"));
        String str_pdi = util.array1doubleTojsonStr(dmi.get("dmi_pdi"));
        String str_mdi = util.array1doubleTojsonStr(dmi.get("dmi_mdi"));
        model.addAttribute("dmi_adx", str_adx);
        model.addAttribute("dmi_pdi", str_pdi);
        model.addAttribute("dmi_mdi", str_mdi);
 
        HashMap<String, double[]> wmsr = calService.calculateWMSR(calData);
        String str1= util.array1doubleTojsonStr(wmsr.get("wmsr_wr1"));
        String str2= util.array1doubleTojsonStr(wmsr.get("wmsr_wr2"));
        model.addAttribute("wmsr_wr1", str1);
        model.addAttribute("wmsr_wr2", str2);

        double[] mom = calService.calculateMOM(calData);
        String str_mom = util.array1doubleTojsonStr(mom);
        model.addAttribute("mom", str_mom);
        
        double[] sar = calService.calculateSAR(calData);
        String str_sar = util.array1doubleTojsonStr(sar);
        model.addAttribute("sar", str_sar);
        
        double[] ad = calService.calculateAD(calData);
        String str_ad = util.array1doubleTojsonStr(ad);
        model.addAttribute("ad", str_ad);
        
        double[] t3 = calService.calculateTrange(calData);
        String str_t3 = util.array1doubleTojsonStr(t3);
        model.addAttribute("t3", str_t3);
        
        List<CnStockDaily> last10 = myservice.getLastNumCnStockDailyDesc(ts_code, 10);
        model.addAttribute("last10", last10);
        
        StockTrackingData[] hist = myservice.getHistoryResult(ts_code);
        model.addAttribute("hist", hist);
        
        return "/chineseOnePage";
    }

    
    
}

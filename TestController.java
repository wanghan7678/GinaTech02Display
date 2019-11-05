/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gina.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.gina.model.AnnPredictResult;
import java.sql.Date;
import com.gina.dao.cnPredictResultDao;

/**
 *
 * @author hanwang
 */
@Controller
public class TestController {
    @Autowired
    private cnPredictResultDao annPreDao;
    
    
    public void test(){

    }
}

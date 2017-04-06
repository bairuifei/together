package com.together.controller;

import com.together.model.po.HistoryInfo;
import com.together.service.HistoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BRF on 2017-04-06.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private HistoryInfoService historyInfoService;

    @RequestMapping("saveInfo")
    public void saveInfo(HistoryInfo po){
        historyInfoService.saveHistoryInfo(po);
    }
}

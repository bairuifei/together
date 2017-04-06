package com.together.service.impl;

import com.together.dao.HistoryInfoDao;
import com.together.model.po.HistoryInfo;
import com.together.service.HistoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BRF on 2017-04-06.
 */
@Service("historyInfoService")
public class HistoryInfoServiceImpl implements HistoryInfoService {

    @Autowired
    private HistoryInfoDao historyInfoDao;

    @Override
    public int saveHistoryInfo(HistoryInfo po) {
        return historyInfoDao.saveHistoryInfo(po);
    }
}

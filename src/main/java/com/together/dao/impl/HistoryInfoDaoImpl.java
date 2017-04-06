package com.together.dao.impl;

import com.together.dao.HistoryInfoDao;
import com.together.mapper.HistoryInfoMapper;
import com.together.model.po.HistoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by BRF on 2017-04-06.
 */
@Repository
public class HistoryInfoDaoImpl implements HistoryInfoDao {

    @Autowired
    private HistoryInfoMapper historyInfoMapper;

    @Override
    public int saveHistoryInfo(HistoryInfo historyInfo) {
        return historyInfoMapper.insertSelective(historyInfo);
    }
}

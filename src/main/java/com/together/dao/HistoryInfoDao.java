package com.together.dao;

import com.together.model.po.HistoryInfo;

/**
 * Created by BRF on 2017-04-06.
 */
public interface HistoryInfoDao {
    /**
     * 保存历史状态
     * @param historyInfo
     * @return
     */
    int saveHistoryInfo(HistoryInfo historyInfo);
}

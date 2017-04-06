package com.together.service;

import com.together.model.po.HistoryInfo;

/**
 * Created by BRF on 2017-04-06.
 */
public interface HistoryInfoService {
    /**
     * 新增历史状态
     * @param po
     * @return
     */
    int saveHistoryInfo(HistoryInfo po);
}

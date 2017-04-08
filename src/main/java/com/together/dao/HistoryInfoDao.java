package com.together.dao;

import com.together.model.po.HistoryInfo;
import com.together.model.vo.HistoryInfoVo;

import java.util.List;

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

    /**
     * 查询我的历史状态
     * @param myId
     * @return
     */
    List<HistoryInfoVo> queryAllByMyId(int myId);
}

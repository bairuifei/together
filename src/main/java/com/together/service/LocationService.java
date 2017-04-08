package com.together.service;

import com.together.model.po.Location;
import com.together.model.vo.LocationVo;

/**
 * Created by BRF on 2017-04-08.
 */
public interface LocationService {
    /**
     * 保存位置信息
     * @param location
     * @return
     */
    int saveLocation(Location location);

    /**
     * 获取我的最新位置
     * @param myId
     * @return
     */
    LocationVo queryLocation(int myId);
}

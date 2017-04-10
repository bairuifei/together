package com.together.dao;

import com.together.model.po.InfoPic;

/**
 * Created by BRF on 2017-04-08.
 */
public interface InfoPicDao {
    /**
     * 保存状态图片
     * @param infoPic
     * @return
     */
    int saveInfoPic(InfoPic infoPic);
}

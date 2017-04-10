package com.together.dao.impl;

import com.together.dao.InfoPicDao;
import com.together.mapper.InfoPicMapper;
import com.together.model.po.InfoPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by BRF on 2017-04-08.
 */
@Repository
public class InfoPicDaoImpl implements InfoPicDao {

    @Autowired
    private InfoPicMapper infoPicMapper;

    @Override
    public int saveInfoPic(InfoPic infoPic) {
        return infoPicMapper.insertSelective(infoPic);
    }
}

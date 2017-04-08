package com.together.dao.impl;

import com.together.dao.LocationDao;
import com.together.mapper.LocationMapper;
import com.together.model.po.Location;
import com.together.model.vo.LocationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by BRF on 2017-04-08.
 */
@Repository
public class LocationDaoImpl implements LocationDao {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public int saveLocation(Location location) {
        return locationMapper.insertSelective(location);
    }

    @Override
    public LocationVo queryLocation(int myId) {
        return locationMapper.findByMyId(myId);
    }
}

package com.together.service.impl;

import com.together.dao.LocationDao;
import com.together.model.po.Location;
import com.together.model.vo.LocationVo;
import com.together.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by BRF on 2017-04-08.
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao locationDao;

    @Override
    public int saveLocation(Location location) {
        location.setCreatetime(new Date());
        return locationDao.saveLocation(location);
    }

    @Override
    public LocationVo queryLocation(int myId) {
        return locationDao.queryLocation(myId);
    }
}

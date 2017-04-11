package com.together.controller;

import com.together.model.ResultInfo;
import com.together.model.enumes.ServerMsgEnum;
import com.together.model.po.Location;
import com.together.model.vo.LocationVo;
import com.together.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BRF on 2017-04-11.
 */
@RestController
@RequestMapping("local")
public class LocalController {

    @Autowired
    private LocationService locationService;

    /**
     * 上传位置信息
     * @param location
     * @return
     */
    @RequestMapping("saveLocation")
    public int saveLocation(Location location){
        return locationService.saveLocation(location);
    }

    /**
     * 获取最新位置信息
     * @param myId
     * @return
     */
    @RequestMapping("queryLocation")
    public ResultInfo queryLocation(int myId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            LocationVo locationVo = locationService.queryLocation(myId);
            resultInfo.setData(locationVo);
            resultInfo.setResult(true);
            resultInfo.setServerCode(ServerMsgEnum.SUCCESS.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.SUCCESS.getServerMsg());
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

}
package com.together.dao.impl;

import com.together.dao.FriendApplyDao;
import com.together.mapper.FriendApplyMapper;
import com.together.model.po.FriendApply;
import com.together.model.vo.FriendApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BRF on 2017-04-06.
 */
@Repository
public class FriendApplyDaoImpl implements FriendApplyDao {

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Override
    public int saveFriendApply(FriendApply friendApply) {
        return friendApplyMapper.insertSelective(friendApply);
    }

    @Override
    public int checkExist(Integer toId, Integer fromId) {
        Map map = new HashMap();
        map.put("toId",toId);
        map.put("fromId",fromId);
        return friendApplyMapper.checkExist(map);
    }

    @Override
    public List<FriendApplyVo> findAllMyFriendApply(Integer toId) {
        return friendApplyMapper.findAllMyFriendApply(toId);
    }

    @Override
    public int changeApplyState(Integer toId, Integer fromId, Integer state) {
        Map map = new HashMap();
        map.put("state",state);
        map.put("toId",toId);
        map.put("fromId",fromId);
        return friendApplyMapper.changeApplyState(map);
    }

    @Override
    public int delApply(Integer toId, Integer fromId) {
        Map map = new HashMap();
        map.put("toId",toId);
        map.put("fromId",fromId);
        return friendApplyMapper.delApply(map);
    }

    @Override
    public int delBothApply(Integer toId, Integer fromId) {
        Map map = new HashMap();
        map.put("toId",toId);
        map.put("fromId",fromId);
        return friendApplyMapper.delBothApply(map);
    }
}

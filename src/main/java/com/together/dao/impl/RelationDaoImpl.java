package com.together.dao.impl;

import com.together.dao.RelationDao;
import com.together.mapper.RelationMapper;
import com.together.model.po.Relation;
import com.together.model.vo.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BRF on 2017-04-08.
 */
@Repository
public class RelationDaoImpl implements RelationDao {

    @Autowired
    private RelationMapper relationMapper;

    @Override
    public int saveRelation(Relation relation) {
        return relationMapper.insertSelective(relation);
    }

    @Override
    public boolean checkRelation(int myId, int friendId) {
        Map map = new HashMap();
        map.put("myId",myId);
        map.put("friendId",friendId);
        int count = relationMapper.findByMyIdAndFriendId(map);
        return count>0?true:false;
    }

    @Override
    public List<PersonVo> findAllByMyId(int myId) {
        return relationMapper.findByMyId(myId);
    }

    @Override
    public int delRelation(int myId, int friendId) {
        Map map = new HashMap();
        map.put("myId",myId);
        map.put("friendId",friendId);
        return relationMapper.delRelation(map);
    }
}

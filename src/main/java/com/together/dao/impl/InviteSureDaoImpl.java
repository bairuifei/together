package com.together.dao.impl;

import com.together.dao.InviteSureDao;
import com.together.mapper.InviteSureMapper;
import com.together.model.po.InviteSure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BRF on 2017-04-08.
 */
@Repository
public class InviteSureDaoImpl implements InviteSureDao {

    @Autowired
    private InviteSureMapper inviteSureMapper;

    @Override
    public int saveInviteSure(InviteSure inviteSure) {
        return inviteSureMapper.insertSelective(inviteSure);
    }

    @Override
    public int updateInviteSure(InviteSure inviteSure) {
        return inviteSureMapper.updateByPrimaryKeySelective(inviteSure);
    }

    @Override
    public InviteSure findByToIdAndYqId(int toId, int yqId) {
        Map map = new HashMap();
        map.put("toId",toId);
        map.put("yqId",yqId);
        return inviteSureMapper.findByToIdAndYqId(map);
    }
}

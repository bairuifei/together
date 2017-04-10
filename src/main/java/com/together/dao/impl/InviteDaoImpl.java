package com.together.dao.impl;

import com.together.dao.InviteDao;
import com.together.mapper.InviteMapper;
import com.together.model.enumes.InviteStatusEnum;
import com.together.model.po.Invite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BRF on 2017-04-08.
 */
@Repository
public class InviteDaoImpl implements InviteDao {

    @Autowired
    private InviteMapper inviteMapper;

    @Override
    public int saveInvite(Invite invite) {
        invite.setStatus(InviteStatusEnum.SENDED.getCode());
        return inviteMapper.insertSelective(invite);
    }

    @Override
    public int updateInvite(Invite invite) {
        return inviteMapper.updateByPrimaryKeySelective(invite);
    }

    @Override
    public int updateInviteDoing(int cause, int result) {
        Map map = new HashMap();
        map.put("cause",cause);
        map.put("result",result);
        return inviteMapper.updateInviteDoing(map);
    }

    @Override
    public int updateInviteDone(int cause, int result) {
        Map map = new HashMap();
        map.put("cause",cause);
        map.put("result",result);
        return inviteMapper.updateInviteDoing(map);
    }

    @Override
    public int findByStarttimeAndEndtime(Date starttime, Date endtime, int myId) {
        Map map = new HashMap();
        map.put("starttime",starttime);
        map.put("endtime",endtime);
        map.put("myId",myId);
        return inviteMapper.findByStarttimeAndEndtime(map);
    }
}

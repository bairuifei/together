package com.together.dao.impl;

import com.together.dao.InviteDao;
import com.together.mapper.InviteMapper;
import com.together.model.enumes.InviteStatusEnum;
import com.together.model.po.Invite;
import com.together.model.vo.InviteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public Invite findById(int id) {
        return inviteMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<InviteVo> findByFromId(int fromId) {
        return inviteMapper.findByFromId(fromId);
    }

    @Override
    public List<InviteVo> findByToIdAndSure(int toId, int status,int code) {
        Map map = new HashMap();
        map.put("toId",toId);
        map.put("status",status);
        map.put("code",code);
        return inviteMapper.findByToIdAndSure(map);
    }

    @Override
    public List<InviteVo> findJoin(int toId, int status) {
        Map map = new HashMap();
        map.put("toId",toId);
        map.put("status",status);
        return inviteMapper.findJoin(map);
    }
}

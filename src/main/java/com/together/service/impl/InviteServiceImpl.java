package com.together.service.impl;

import com.together.dao.InviteDao;
import com.together.dao.InviteSureDao;
import com.together.model.enumes.InviteStatusEnum;
import com.together.model.enumes.InviteSureStatusEnum;
import com.together.model.po.Invite;
import com.together.model.po.InviteSure;
import com.together.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by BRF on 2017-04-10.
 */
@Service
public class InviteServiceImpl implements InviteService {

    @Autowired
    private InviteDao inviteDao;
    @Autowired
    private InviteSureDao inviteSureDao;

    @Override
    @Transactional
    public int saveInvite(Invite invite, int... toIds) {
        //如果时间段内存在本人发起或参与的邀请则无法创建新的邀请
        int yqs = inviteDao.findByStarttimeAndEndtime(invite.getStarttime(),invite.getEndtime(),invite.getFromId());
        if(yqs>0){
            return 0;
        }
        int count = inviteDao.saveInvite(invite);
        for (int i : toIds){
            InviteSure inviteSure = new InviteSure();
            inviteSure.setYqId(invite.getId());
            inviteSure.setStatus(InviteSureStatusEnum.UNKNOW.getCode());
            inviteSure.setToId(i);
            inviteSureDao.saveInviteSure(inviteSure);
        }
        return count;
    }

    @Override
    public int cancelInvite(Invite invite) {
        int code = invite.getStatus().intValue();
        //已发出和进行中的邀请可被取消
        if(InviteStatusEnum.SENDED.getCode()==code || InviteStatusEnum.DOING.getCode()==code){
            invite.setStatus(InviteStatusEnum.CANCELED.getCode());
            return inviteDao.updateInvite(invite);
        }
        return 0;
    }

    @Override
    @Transactional
    public int joinInvite(Date starttime, Date endtime,int toId, int yqId) {
        //如果时间段内存在本人发起或参与的邀请则无法参加新的邀请
        int yqs = inviteDao.findByStarttimeAndEndtime(starttime,endtime,toId);
        if (yqs>0){
            return 0;
        }
        InviteSure inviteSure  = inviteSureDao.findByToIdAndYqId(toId,yqId);
        inviteSure.setStatus(InviteSureStatusEnum.JOINED.getCode());
        return inviteSureDao.updateInviteSure(inviteSure);
    }

    @Override
    public int unJoinInvite(int toId, int yqId) {
        InviteSure inviteSure  = inviteSureDao.findByToIdAndYqId(toId,yqId);
        inviteSure.setStatus(InviteSureStatusEnum.UNJOIN.getCode());
        return inviteSureDao.updateInviteSure(inviteSure);
    }

    @Override
    public int updateInviteDoing() {
        return inviteDao.updateInviteDoing(InviteStatusEnum.SENDED.getCode(),InviteStatusEnum.DOING.getCode());
    }

    @Override
    public int updateInviteDone() {
        return inviteDao.updateInviteDone(InviteStatusEnum.DOING.getCode(),InviteStatusEnum.DONE.getCode());
    }
}

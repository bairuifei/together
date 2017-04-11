package com.together.controller;

import com.together.model.po.Invite;
import com.together.model.vo.InviteVo;
import com.together.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by BRF on 2017-04-11.
 */
@RestController
@RequestMapping("invite")
public class InviteController {

    @Autowired
    private InviteService inviteService;

    /**
     * 保存邀请
     * @param invite
     * @param toIds
     * @return
     */
    @RequestMapping("saveInvite")
    public int saveInvite(Invite invite, int... toIds){
        return inviteService.saveInvite(invite,toIds);
    }

    /**
     * 取消邀请
     * @param invite
     * @return
     */
    @RequestMapping("cancelInvite")
    public int cancelInvite(Invite invite){
        return inviteService.cancelInvite(invite);
    }

    /**
     * 参加邀请
     * @param starttime
     * @param endtime
     * @param toId
     * @param yqId
     * @return
     */
    @RequestMapping("joinInvite")
    public int joinInvite(Date starttime, Date endtime, int toId, int yqId){
        return inviteService.joinInvite(starttime,endtime,toId,yqId);
    }

    /**
     * 不参加邀请
     * @param toId
     * @param yqId
     * @return
     */
    @RequestMapping("unJoinInvite")
    public int unJoinInvite(int toId,int yqId){
        return inviteService.unJoinInvite(toId,yqId);
    }

    /**
     * 已发出的邀请
     * @param fromId
     * @return
     */
    @RequestMapping("sendInvites")
    public List<InviteVo> sendInvites(int fromId){
        return inviteService.sendInvites(fromId);
    }

    /**
     * 已参加的邀请
     * @param toId
     * @return
     */
    @RequestMapping("joinInvites")
    public List<InviteVo> joinInvites(int toId){
        return inviteService.joinInvites(toId);
    }

    /**
     * 未参加的邀请
     * @param toId
     * @return
     */
    @RequestMapping("unJoinInvites")
    public List<InviteVo> unJoinInvites(int toId){
        return inviteService.unJoinInvites(toId);
    }

    /**
     * 未确认的邀请
     * @param toId
     * @return
     */
    @RequestMapping("unKnowInvites")
    public List<InviteVo> unKnowInvites(int toId){
        return inviteService.unKnowInvites(toId);
    }

}
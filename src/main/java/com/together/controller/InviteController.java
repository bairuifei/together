package com.together.controller;

import com.together.model.ResultInfo;
import com.together.model.enumes.ServerMsgEnum;
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
    public ResultInfo saveInvite(Invite invite, int... toIds){
        ResultInfo resultInfo = new ResultInfo();
        try {
            int count = inviteService.saveInvite(invite,toIds);
            if(count==1){
                resultInfo.setResult(true);
                resultInfo.setServerCode(ServerMsgEnum.INVITESAVED.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.INVITESAVED.getServerMsg());
                resultInfo.setData(count);
            }else{
                resultInfo.setResult(false);
                resultInfo.setServerCode(ServerMsgEnum.INVITEUNSAVE.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.INVITEUNSAVE.getServerMsg());
            }
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 取消邀请
     * @param invite
     * @return
     */
    @RequestMapping("cancelInvite")
    public ResultInfo cancelInvite(Invite invite){
        ResultInfo resultInfo = new ResultInfo();
        try {
            int count = inviteService.cancelInvite(invite);
            if(count==1){
                resultInfo.setResult(true);
                resultInfo.setServerCode(ServerMsgEnum.INVITECANCELED.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.INVITECANCELED.getServerMsg());
                resultInfo.setData(count);
            }else{
                resultInfo.setResult(false);
                resultInfo.setServerCode(ServerMsgEnum.INVITEUNCANCEL.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.INVITEUNCANCEL.getServerMsg());
            }
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
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
    public ResultInfo joinInvite(Date starttime, Date endtime, int toId, int yqId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            int count = inviteService.joinInvite(starttime,endtime,toId,yqId);
            if(count==1){
                resultInfo.setResult(true);
                resultInfo.setServerCode(ServerMsgEnum.INVITEJOINED.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.INVITEJOINED.getServerMsg());
                resultInfo.setData(count);
            }else{
                resultInfo.setResult(false);
                resultInfo.setServerCode(ServerMsgEnum.INVITEUNJOIN.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.INVITEUNJOIN.getServerMsg());
            }
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 不参加邀请
     * @param toId
     * @param yqId
     * @return
     */
    @RequestMapping("unJoinInvite")
    public ResultInfo unJoinInvite(int toId,int yqId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            int count = inviteService.unJoinInvite(toId,yqId);
            if(count==1){
                resultInfo.setResult(true);
                resultInfo.setServerCode(ServerMsgEnum.INVITEUNJOINED.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.INVITEUNJOINED.getServerMsg());
                resultInfo.setData(count);
            }else{
                resultInfo.setResult(false);
                resultInfo.setServerCode(ServerMsgEnum.INVITEUNUNJOIN.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.INVITEUNUNJOIN.getServerMsg());
            }
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 已发出的邀请
     * @param fromId
     * @return
     */
    @RequestMapping("sendInvites")
    public ResultInfo sendInvites(int fromId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            List<InviteVo> list = inviteService.sendInvites(fromId);
            resultInfo.setData(list);
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

    /**
     * 已参加的邀请
     * @param toId
     * @return
     */
    @RequestMapping("joinInvites")
    public ResultInfo joinInvites(int toId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            List<InviteVo> list = inviteService.joinInvites(toId);
            resultInfo.setData(list);
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

    /**
     * 未参加的邀请
     * @param toId
     * @return
     */
    @RequestMapping("unJoinInvites")
    public ResultInfo unJoinInvites(int toId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            List<InviteVo> list = inviteService.unJoinInvites(toId);
            resultInfo.setData(list);
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

    /**
     * 未确认的邀请
     * @param toId
     * @return
     */
    @RequestMapping("unKnowInvites")
    public ResultInfo unKnowInvites(int toId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            List<InviteVo> list = inviteService.unKnowInvites(toId);
            resultInfo.setData(list);
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
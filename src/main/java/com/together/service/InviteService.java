package com.together.service;

import com.together.model.po.Invite;

import java.util.Date;

/**
 * Created by BRF on 2017-04-10.
 */
public interface InviteService {

    /**
     * 创建邀请
     * @param invite
     * @param toIds 参与人id
     * @return
     */
    int saveInvite(Invite invite,int... toIds);

    /**
     * 取消邀请
     * @param invite
     * @return
     */
    int cancelInvite(Invite invite);

    /**
     * 参加邀请
     * @param toId
     * @param yqId
     * @return
     */
    int joinInvite(Date starttime, Date endtime, int toId, int yqId);

    /**
     * 不参加邀请
     * @param toId
     * @param yqId
     * @return
     */
    int unJoinInvite(int toId,int yqId);

    /**
     * 定时任务，每分钟确认邀请是否进行中
     * @return
     */
    int updateInviteDoing();

    /**
     * 定时任务，每分钟确认邀请是否已结束
     * @return
     */
    int updateInviteDone();
}

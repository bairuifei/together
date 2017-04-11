package com.together.service;

import com.together.model.po.Invite;
import com.together.model.vo.InviteVo;

import java.util.Date;
import java.util.List;

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
     * 发起的邀请（判定邀请状态）
     * @param fromId
     * @return
     */
    List<InviteVo> sendInvites(int fromId);

    /**
     * 参与的邀请（判定确认状态），此处与其他略有不同，发起必参与，发起人也会有相应的参与邀请列表，（无其他操作）
     * @param toId
     * @return
     */
    List<InviteVo> joinInvites(int toId);

    /**
     * 未参与的邀请（判定确认状态），（无其他操作）
     * @param toId
     * @return
     */
    List<InviteVo> unJoinInvites(int toId);

    /**
     * 未确认的邀请（判定确认状态），（可操作参加/不参加邀请），此时要判定邀请状态是否为已发出
     * @param toId
     * @return
     */
    List<InviteVo> unKnowInvites(int toId);

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

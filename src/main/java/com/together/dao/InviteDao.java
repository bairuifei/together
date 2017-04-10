package com.together.dao;

import com.together.model.po.Invite;

import java.util.Date;
import java.util.Map;

/**
 * Created by BRF on 2017-04-08.
 */
public interface InviteDao {
    /**
     * 创建邀请
     * @param invite
     * @return
     */
    int saveInvite(Invite invite);

    /**
     * 更新邀请
     * @param invite
     * @return
     */
    int updateInvite(Invite invite);

    /**
     * 定时任务，每分钟确认邀请是否进行中
     * @param cause
     * @param result
     * @return
     */
    int updateInviteDoing(int cause,int result);

    /**
     * 定时任务，每分钟确认邀请是否已结束
     * @param cause
     * @param result
     * @return
     */
    int updateInviteDone(int cause,int result);

    /**
     * 查询时间段内是否存在本人发起的邀请或参与的邀请
     * @param starttime
     * @param endtime
     * @param myId
     * @return
     */
    int findByStarttimeAndEndtime(Date starttime,Date endtime,int myId);
}

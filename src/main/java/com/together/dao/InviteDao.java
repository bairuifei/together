package com.together.dao;

import com.together.model.po.Invite;
import com.together.model.vo.InviteVo;

import java.util.Date;
import java.util.List;
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

    /**
     * 根据ID获得邀请
     * @param id
     * @return
     */
    Invite findById(int id);

    /**
     * 根据发起人ID获得邀请
     * @param fromId
     * @return
     */
    List<InviteVo> findByFromId(int fromId);

    /**
     * 根据参与人ID和状态码获得邀请
     * @param toId
     * @param status
     * @return
     */
    List<InviteVo> findByToIdAndSure(int toId,int status,int code);

    /**
     * 参与的邀请（专用），此处与其他SQL略有不同，发起必参与，发起人也会有相应的参与邀请列表
     * @param toId
     * @param status
     * @return
     */
    List<InviteVo> findJoin(int toId,int status);
}

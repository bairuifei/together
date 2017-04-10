package com.together.dao;

import com.together.model.po.InviteSure;

/**
 * Created by BRF on 2017-04-08.
 */
public interface InviteSureDao {

    /**
     * 保存邀请确认
     * @param inviteSure
     * @return
     */
    int saveInviteSure(InviteSure inviteSure);

    /**
     * 更新邀请确认
     * @param inviteSure
     * @return
     */
    int updateInviteSure(InviteSure inviteSure);

    /**
     * 根据参与人ID和邀请ID获取邀请确认
     * @param toId
     * @param yqId
     * @return
     */
    InviteSure findByToIdAndYqId(int toId,int yqId);
}

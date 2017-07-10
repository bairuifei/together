package com.together.dao;

import com.together.model.po.FriendApply;
import com.together.model.vo.FriendApplyVo;

import java.util.List;

/**
 * Created by BRF on 2017-04-06.
 */
public interface FriendApplyDao {
    /**
     * 保存好友申请
     * @param friendApply
     * @return
     */
    int saveFriendApply(FriendApply friendApply);

    int checkExist(Integer toId,Integer fromId);

    List<FriendApplyVo> findAllMyFriendApply(Integer toId);

    int changeApplyState(Integer toId,Integer fromId,Integer state);

    int delApply(Integer toId,Integer fromId);

    int delBothApply(Integer toId,Integer fromId);
}

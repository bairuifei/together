package com.together.dao;

import com.together.model.po.Relation;
import com.together.model.vo.PersonVo;

import java.util.List;

/**
 * Created by BRF on 2017-04-08.
 */
public interface RelationDao {
    /**
     * 保存好友关系
     * @param relation
     * @return
     */
    int saveRelation(Relation relation);

    /**
     * 判定是否存在好友关系
     * @param myId
     * @param friendId
     * @return
     */
    boolean checkRelation(int myId,int friendId);

    /**
     * 查询我的好友
     * @param myId
     * @return
     */
    List<PersonVo> findAllByMyId(int myId);

    /**
     * 解除好友关系
     * @param myId
     * @param friendId
     * @return
     */
    int delRelation(int myId,int friendId);
}

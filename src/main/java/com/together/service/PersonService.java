package com.together.service;

import com.together.model.po.*;
import com.together.model.vo.FriendApplyVo;
import com.together.model.vo.HistoryInfoVo;
import com.together.model.vo.PersonVo;

import java.util.List;

/**
 * Created by BRF on 2017-04-08.
 */
public interface PersonService {
    /**
     * 保存个人信息
     * @param person
     * @return
     */
    int savePerson(Person person);

    /**
     * 查询个人信息
     * @param id
     * @return
     */
    PersonVo queryPerson(int id);

    /**
     * 更新个人信息
     * @param person
     * @return
     */
    int updatePerson(Person person);

    /**
     * 查询我的历史状态
     * @param myId
     * @return
     */
    List<HistoryInfoVo> queryAllByMyId(int myId);

    /**
     * 查询我的所有好友历史状态
     * @param myId
     * @return
     */
    List<HistoryInfoVo> queryFriendInfoByMyId(int myId);

    /**
     * 保存历史状态
     * @param historyInfo
     * @param pics
     * @return
     */
    int saveHistroyInfo(HistoryInfo historyInfo,String... pics);

    /**
     * 保存好友关系
     * @param relation
     * @return
     */
    boolean saveRelation(Relation relation);

    /**
     * 保存好友申请
     * @param friendApply
     * @return
     */
    boolean saveFriendApply(FriendApply friendApply);

    /**
     * 判定是否存在好友关系
     * @param myId
     * @param friendId
     * @return
     */
    boolean checkRelation(int myId,int friendId);

    /**
     * 查询我的好友
     */
    List<PersonVo> findAllByMyId(int myId);

    /**
     * 解除好友关系
     * @param myId
     * @param friendId
     * @param delType 0 单方解除 1 双方解除
     * @return
     */
    boolean delRelation(int myId,int friendId,int delType);

    int checkExist(Integer toId,Integer fromId);

    PersonVo findInfoByMobile(String mobile);

    PersonVo login(String mobile,String password);

    List<FriendApplyVo> findAllMyFriendApply(Integer toId);

    int changeApplyState(Integer toId,Integer fromId,Integer state);
}

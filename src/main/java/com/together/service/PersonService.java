package com.together.service;

import com.together.model.po.HistoryInfo;
import com.together.model.po.Person;
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

    int saveHistroyInfo(HistoryInfo historyInfo);
}

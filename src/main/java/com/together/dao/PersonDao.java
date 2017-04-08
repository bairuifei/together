package com.together.dao;

import com.together.model.po.Person;
import com.together.model.vo.PersonVo;

/**
 * Created by BRF on 2017-04-08.
 */
public interface PersonDao {
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
}

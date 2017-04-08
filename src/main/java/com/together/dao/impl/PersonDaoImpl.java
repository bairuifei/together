package com.together.dao.impl;

import com.together.dao.PersonDao;
import com.together.mapper.PersonMapper;
import com.together.model.po.Person;
import com.together.model.vo.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by BRF on 2017-04-08.
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public int savePerson(Person person) {
        return personMapper.insertSelective(person);
    }

    @Override
    public PersonVo queryPerson(int id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePerson(Person person) {
        return personMapper.updateByPrimaryKeySelective(person);
    }
}

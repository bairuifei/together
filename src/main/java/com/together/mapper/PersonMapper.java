package com.together.mapper;

import com.together.model.po.Person;
import com.together.model.vo.PersonVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    PersonVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    int findByMyOrFriendId(Map map);

    PersonVo findInfoByMobile(String mobile);

    PersonVo login(Map map);
}
package com.together.mapper;

import com.together.model.po.Relation;
import com.together.model.vo.PersonVo;
import com.together.model.vo.RelationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Relation record);

    int insertSelective(Relation record);

    Relation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);

    int findByMyIdAndFriendId(Map map);

    List<PersonVo> findByMyId(int myId);

    int delRelation(Map map);
}
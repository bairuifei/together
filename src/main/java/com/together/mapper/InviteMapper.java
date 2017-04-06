package com.together.mapper;

import com.together.model.po.Invite;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InviteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Invite record);

    int insertSelective(Invite record);

    Invite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invite record);

    int updateByPrimaryKey(Invite record);
}
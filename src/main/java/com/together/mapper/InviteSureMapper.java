package com.together.mapper;

import com.together.model.po.InviteSure;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface InviteSureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InviteSure record);

    int insertSelective(InviteSure record);

    InviteSure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InviteSure record);

    int updateByPrimaryKey(InviteSure record);

    InviteSure findByToIdAndYqId(Map map);
}
package com.together.mapper;

import com.together.model.po.Location;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);
}
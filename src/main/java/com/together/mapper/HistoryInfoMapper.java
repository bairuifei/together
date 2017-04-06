package com.together.mapper;

import com.together.model.po.HistoryInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HistoryInfo record);

    int insertSelective(HistoryInfo record);

    HistoryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HistoryInfo record);

    int updateByPrimaryKey(HistoryInfo record);
}
package com.together.mapper;

import com.together.model.po.HistoryInfo;
import com.together.model.vo.HistoryInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HistoryInfo record);

    int insertSelective(HistoryInfo record);

    HistoryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HistoryInfo record);

    int updateByPrimaryKey(HistoryInfo record);

    List<HistoryInfoVo> findAllByMyId(int myId);
}
package com.together.mapper;

import com.together.model.po.InfoPic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InfoPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InfoPic record);

    int insertSelective(InfoPic record);

    InfoPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InfoPic record);

    int updateByPrimaryKey(InfoPic record);
}
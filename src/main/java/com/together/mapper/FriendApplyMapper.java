package com.together.mapper;

import com.together.model.po.FriendApply;
import com.together.model.vo.FriendApplyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FriendApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FriendApply record);

    int insertSelective(FriendApply record);

    FriendApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FriendApply record);

    int updateByPrimaryKey(FriendApply record);

    int checkExist(Map map);

    List<FriendApplyVo> findAllMyFriendApply(Integer toId);

    int changeApplyState(Map map);

    int delApply(Map map);

    int delBothApply(Map map);
}
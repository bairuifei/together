package com.together.mapper;

import com.together.model.po.Invite;
import com.together.model.vo.InviteVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InviteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Invite record);

    int insertSelective(Invite record);

    Invite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invite record);

    int updateByPrimaryKey(Invite record);

    int updateInviteDoing(Map map);

    int updateInviteDone(Map map);

    int findByStarttimeAndEndtime(Map map);

    List<InviteVo> findByFromId(int fromId);

    List<InviteVo> findByToIdAndSure(Map map);

    List<InviteVo> findJoin(Map map);
}
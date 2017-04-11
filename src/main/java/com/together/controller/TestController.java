package com.together.controller;

import com.together.model.po.*;
import com.together.model.vo.*;
import com.together.service.InviteService;
import com.together.service.LocationService;
import com.together.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by BRF on 2017-04-06.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private PersonService personService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private InviteService inviteService;

    @RequestMapping("savePerson")
    public int savePerson(Person person){
        return personService.savePerson(person);
    }

    @RequestMapping("queryPerson")
    public PersonVo queryPerson(int id){
        return personService.queryPerson(id);
    }

    @RequestMapping("updatePerson")
    public int updatePerson(Person person){
        return personService.updatePerson(person);
    }

    @RequestMapping("saveLocation")
    public int saveLocation(Location location){
        return locationService.saveLocation(location);
    }

    @RequestMapping("queryLocation")
    public LocationVo queryLocation(int myId){
        return locationService.queryLocation(myId);
    }

    @RequestMapping("saveHistroyInfo")
    public int saveHistroyInfo(HistoryInfo historyInfo,String... pic){
        return personService.saveHistroyInfo(historyInfo,pic);
    }

    @RequestMapping("queryAllByMyId")
    public List<HistoryInfoVo> queryAllByMyId(int myId){
        List<HistoryInfoVo> as = personService.queryAllByMyId(myId);
        return as;
    }

    @RequestMapping("saveRelation")
    public boolean saveRelation(Relation relation){
        return personService.saveRelation(relation);
    }

    @RequestMapping("checkRelation")
    public boolean checkRelation(int myId,int friendId){
        return personService.checkRelation(myId,friendId);
    }

    @RequestMapping("findAllByMyId")
    List<PersonVo> findAllByMyId(int myId){
        return personService.findAllByMyId(myId);
    }

    @RequestMapping("delRelation")
    boolean delRelation(int myId,int friendId,int delType){
        return personService.delRelation(myId,friendId,delType);
    }

    // TODO: 2017-04-10  完成邀请相关测试
    @RequestMapping("saveInvite")
    public int saveInvite(Invite invite,int... toIds){
        return inviteService.saveInvite(invite,toIds);
    }

    @RequestMapping("cancelInvite")
    public int cancelInvite(Invite invite){
        return inviteService.cancelInvite(invite);
    }

    @RequestMapping("joinInvite")
    public int joinInvite(Date starttime, Date endtime, int toId, int yqId){
        return inviteService.joinInvite(starttime,endtime,toId,yqId);
    }

    @RequestMapping("unJoinInvite")
    public int unJoinInvite(int toId,int yqId){
        return inviteService.unJoinInvite(toId,yqId);
    }

    @RequestMapping("sendInvites")
    public List<InviteVo> sendInvites(int fromId){
        return inviteService.sendInvites(fromId);
    }

    @RequestMapping("joinInvites")
    public List<InviteVo> joinInvites(int toId){
        return inviteService.joinInvites(toId);
    }

    @RequestMapping("unJoinInvites")
    public List<InviteVo> unJoinInvites(int toId){
        return inviteService.unJoinInvites(toId);
    }

    @RequestMapping("unKnowInvites")
    public List<InviteVo> unKnowInvites(int toId){
        return inviteService.unKnowInvites(toId);
    }

}

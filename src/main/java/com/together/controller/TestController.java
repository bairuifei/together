package com.together.controller;

import com.together.model.po.HistoryInfo;
import com.together.model.po.Location;
import com.together.model.po.Person;
import com.together.model.po.Relation;
import com.together.model.vo.HistoryInfoVo;
import com.together.model.vo.LocationVo;
import com.together.model.vo.PersonVo;
import com.together.service.LocationService;
import com.together.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

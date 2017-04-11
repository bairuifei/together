package com.together.controller;

import com.together.model.po.HistoryInfo;
import com.together.model.po.Person;
import com.together.model.po.Relation;
import com.together.model.vo.HistoryInfoVo;
import com.together.model.vo.PersonVo;
import com.together.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by BRF on 2017-04-11.
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * 保存个人信息
     * @param person
     * @return
     */
    @RequestMapping("savePerson")
    public int savePerson(Person person){
        return personService.savePerson(person);
    }

    /**
     * 查询个人信息
     * @param id
     * @return
     */
    @RequestMapping("queryPerson")
    public PersonVo queryPerson(int id){
        return personService.queryPerson(id);
    }

    /**
     * 更新个人信息
     * @param person
     * @return
     */
    @RequestMapping("updatePerson")
    public int updatePerson(Person person){
        return personService.updatePerson(person);
    }

    /**
     * 保存历史状态
     * @param historyInfo
     * @param pic
     * @return
     */
    @RequestMapping("saveHistroyInfo")
    public int saveHistroyInfo(HistoryInfo historyInfo, String... pic){
        return personService.saveHistroyInfo(historyInfo,pic);
    }

    /**
     * 查询本人所有历史状态
     * @param myId
     * @return
     */
    @RequestMapping("queryAllByMyId")
    public List<HistoryInfoVo> queryAllByMyId(int myId){
        List<HistoryInfoVo> as = personService.queryAllByMyId(myId);
        return as;
    }

    /**
     * 保存好友关系
     * @param relation
     * @return
     */
    @RequestMapping("saveRelation")
    public boolean saveRelation(Relation relation){
        return personService.saveRelation(relation);
    }

    /**
     * 检查好友关系是否存在
     * @param myId
     * @param friendId
     * @return
     */
    @RequestMapping("checkRelation")
    public boolean checkRelation(int myId,int friendId){
        return personService.checkRelation(myId,friendId);
    }

    /**
     * 查询本人好友列表
     * @param myId
     * @return
     */
    @RequestMapping("findAllByMyId")
    List<PersonVo> findAllByMyId(int myId){
        return personService.findAllByMyId(myId);
    }

    /**
     * 解除好友关系
     * @param myId
     * @param friendId
     * @param delType
     * @return
     */
    @RequestMapping("delRelation")
    boolean delRelation(int myId,int friendId,int delType){
        return personService.delRelation(myId,friendId,delType);
    }

}
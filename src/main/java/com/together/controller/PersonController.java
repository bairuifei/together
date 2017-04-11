package com.together.controller;

import com.together.model.ResultInfo;
import com.together.model.enumes.ServerMsgEnum;
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
    public ResultInfo savePerson(Person person){
        ResultInfo resultInfo = new ResultInfo();
        try {
            int count = personService.savePerson(person);
            if(count==1){
                resultInfo.setResult(true);
                resultInfo.setServerCode(ServerMsgEnum.PERSONSAVED.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.PERSONSAVED.getServerMsg());
                resultInfo.setData(count);
            }else{
                resultInfo.setResult(false);
                resultInfo.setServerCode(ServerMsgEnum.PERSONUNSAVE.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.PERSONUNSAVE.getServerMsg());
            }
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 查询个人信息
     * @param id
     * @return
     */
    @RequestMapping("queryPerson")
    public ResultInfo queryPerson(int id){
        ResultInfo resultInfo = new ResultInfo();
        try {
            PersonVo pv = personService.queryPerson(id);
            resultInfo.setData(pv);
            resultInfo.setResult(true);
            resultInfo.setServerCode(ServerMsgEnum.SUCCESS.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.SUCCESS.getServerMsg());
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 更新个人信息
     * @param person
     * @return
     */
    @RequestMapping("updatePerson")
    public ResultInfo updatePerson(Person person){
        ResultInfo resultInfo = new ResultInfo();
        try {
            int count = personService.updatePerson(person);
            if(count==1){
                resultInfo.setResult(true);
                resultInfo.setServerCode(ServerMsgEnum.PERSONUPDATED.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.PERSONUPDATED.getServerMsg());
                resultInfo.setData(count);
            }else{
                resultInfo.setResult(false);
                resultInfo.setServerCode(ServerMsgEnum.PERSONUNUPDATE.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.PERSONUNUPDATE.getServerMsg());
            }
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 保存历史状态
     * @param historyInfo
     * @param pic
     * @return
     */
    @RequestMapping("saveHistroyInfo")
    public ResultInfo saveHistroyInfo(HistoryInfo historyInfo, String... pic){
        ResultInfo resultInfo = new ResultInfo();
        try {
            int count = personService.saveHistroyInfo(historyInfo,pic);
            resultInfo.setResult(true);
            resultInfo.setServerCode(ServerMsgEnum.HISTORYSAVED.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.HISTORYSAVED.getServerMsg());
            resultInfo.setData(count);
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.HISTORYUNSAVE.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.HISTORYUNSAVE.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 查询本人所有历史状态
     * @param myId
     * @return
     */
    @RequestMapping("queryAllByMyId")
    public ResultInfo queryAllByMyId(int myId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            List<HistoryInfoVo> as = personService.queryAllByMyId(myId);
            resultInfo.setData(as);
            resultInfo.setResult(true);
            resultInfo.setServerCode(ServerMsgEnum.SUCCESS.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.SUCCESS.getServerMsg());
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 保存好友关系
     * @param relation
     * @return
     */
    @RequestMapping("saveRelation")
    public ResultInfo saveRelation(Relation relation){
        ResultInfo resultInfo = new ResultInfo();
        try {
            boolean isok = personService.saveRelation(relation);
            if(isok){
                resultInfo.setResult(true);
                resultInfo.setServerCode(ServerMsgEnum.RELATIONSAVED.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.RELATIONSAVED.getServerMsg());
                resultInfo.setData(isok);
            }else{
                resultInfo.setResult(false);
                resultInfo.setServerCode(ServerMsgEnum.RELATIONUNSAVE.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.RELATIONUNSAVE.getServerMsg());
            }
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 检查好友关系是否存在
     * @param myId
     * @param friendId
     * @return
     */
    @RequestMapping("checkRelation")
    public ResultInfo checkRelation(int myId,int friendId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            boolean isok = personService.checkRelation(myId,friendId);
            resultInfo.setData(isok);
            resultInfo.setResult(true);
            resultInfo.setServerCode(ServerMsgEnum.SUCCESS.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.SUCCESS.getServerMsg());
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 查询本人好友列表
     * @param myId
     * @return
     */
    @RequestMapping("findAllByMyId")
    ResultInfo findAllByMyId(int myId){
        ResultInfo resultInfo = new ResultInfo();
        try {
            List<PersonVo> list = personService.findAllByMyId(myId);
            resultInfo.setData(list);
            resultInfo.setResult(true);
            resultInfo.setServerCode(ServerMsgEnum.SUCCESS.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.SUCCESS.getServerMsg());
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    /**
     * 解除好友关系
     * @param myId
     * @param friendId
     * @param delType
     * @return
     */
    @RequestMapping("delRelation")
    ResultInfo delRelation(int myId,int friendId,int delType){
        ResultInfo resultInfo = new ResultInfo();
        try {
            boolean isok = personService.delRelation(myId,friendId,delType);
            if(isok){
                resultInfo.setResult(true);
                resultInfo.setServerCode(ServerMsgEnum.RELATIONDELED.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.RELATIONDELED.getServerMsg());
                resultInfo.setData(isok);
            }else{
                resultInfo.setResult(false);
                resultInfo.setServerCode(ServerMsgEnum.RELATIONUNDEL.getServerCode());
                resultInfo.setServerMsg(ServerMsgEnum.RELATIONUNDEL.getServerMsg());
            }
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FAIL.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FAIL.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

}
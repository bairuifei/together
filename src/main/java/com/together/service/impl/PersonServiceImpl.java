package com.together.service.impl;

import com.together.dao.*;
import com.together.model.enumes.FriendApplyStateEnum;
import com.together.model.po.*;
import com.together.model.vo.FriendApplyVo;
import com.together.model.vo.HistoryInfoVo;
import com.together.model.vo.PersonVo;
import com.together.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by BRF on 2017-04-08.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private HistoryInfoDao historyInfoDao;
    @Autowired
    private InfoPicDao infoPicDao;
    @Autowired
    private RelationDao relationDao;
    @Autowired
    private FriendApplyDao friendApplyDao;

    @Override
    @Transactional
    public int savePerson(Person person) {
        saveSign(person);
        person.setOnline(0);
        return personDao.savePerson(person);
    }

    @Override
    public PersonVo queryPerson(int id) {
        return personDao.queryPerson(id);
    }

    @Override
    @Transactional
    public int updatePerson(Person person) {
        PersonVo pv = personDao.queryPerson(person.getId());
        if (pv!=null && !pv.getSign().equals(person.getSign())) saveSign(person);
        return personDao.updatePerson(person);
    }

    private void saveSign(Person person) {
        //如果用户签名保存或修改且不为空
        if (!StringUtils.isEmpty(person.getSign())){
            HistoryInfo historyInfo = new HistoryInfo();
            historyInfo.setContent(person.getSign());
            historyInfo.setCreatetime(new Date());
            historyInfo.setLocation(null);
            historyInfo.setMyId(person.getId());
            historyInfoDao.saveHistoryInfo(historyInfo);
        }
    }

    @Override
    public List<HistoryInfoVo> queryAllByMyId(int myId) {
        return historyInfoDao.queryAllByMyId(myId);
    }

    @Override
    public List<HistoryInfoVo> queryFriendInfoByMyId(int myId) {
        return historyInfoDao.queryFriendInfoByMyId(myId);
    }

    @Override
    @Transactional
    public int saveHistroyInfo(HistoryInfo historyInfo,String... pics) {
        historyInfo.setCreatetime(new Date());
        historyInfoDao.saveHistoryInfo(historyInfo);
        int historyInfoId = historyInfo.getId();
        if(pics!=null){
            for (String pic : pics){
                InfoPic infoPic = new InfoPic();
                infoPic.setPic(pic);
                infoPic.setZtId(historyInfoId);
                infoPicDao.saveInfoPic(infoPic);
            }
        }
        return historyInfoId;
    }

    @Override
    @Transactional
    public boolean saveRelation(Relation relation) {
        if(relation.getMyId().intValue()==relation.getFriendId().intValue()) return false;
        boolean isok = personDao.findByMyOrFriendId(relation.getMyId(),relation.getFriendId());
        if (!isok) return isok;
        //判定我和好友是否存在，也要判定好友和我是否存在，如果不存在则保存，一般情况下会同时保存两条关系，除非两者中存在单方取消和对方的好友关系
        boolean exist_mf = relationDao.checkRelation(relation.getMyId(),relation.getFriendId());
        boolean exist_fm = relationDao.checkRelation(relation.getFriendId(),relation.getMyId());
        //不存在则保存
        if (!exist_mf) relationDao.saveRelation(relation);
        if (!exist_fm) relationDao.saveRelation(new Relation(relation.getFriendId(),relation.getMyId()));
        //接受好友申请修改申请状态为1
        friendApplyDao.changeApplyState(relation.getMyId(),relation.getFriendId(), FriendApplyStateEnum.ACCEPT.getCode());
        return true;
    }

    @Override
    public boolean saveFriendApply(FriendApply friendApply) {
        int count = friendApplyDao.saveFriendApply(friendApply);
        if(count==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkRelation(int myId, int friendId) {
        return relationDao.checkRelation(myId,friendId);
    }

    @Override
    public List<PersonVo> findAllByMyId(int myId) {
        return relationDao.findAllByMyId(myId);
    }

    @Override
    @Transactional
    public boolean delRelation(int myId, int friendId, int delType) {
        try {
            relationDao.delRelation(myId,friendId);
            if(delType==1){
                relationDao.delRelation(friendId,myId);
                //解除好友关系同时删除双方好友申请记录
                friendApplyDao.delBothApply(myId,friendId);
            }else{
                //解除好友关系删除单方好友申请记录
                friendApplyDao.delApply(friendId,myId);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int checkExist(Integer toId, Integer fromId) {
        return friendApplyDao.checkExist(toId,fromId);
    }

    @Override
    public PersonVo findInfoByMobile(String mobile) {
        return personDao.findInfoByMobile(mobile);
    }

    @Override
    public PersonVo login(String mobile, String password) {
        return personDao.login(mobile,password);
    }

    @Override
    public List<FriendApplyVo> findAllMyFriendApply(Integer toId) {
        return friendApplyDao.findAllMyFriendApply(toId);
    }

    @Override
    public int changeApplyState(Integer toId, Integer fromId, Integer state) {
        return friendApplyDao.changeApplyState(toId,fromId,state);
    }
}

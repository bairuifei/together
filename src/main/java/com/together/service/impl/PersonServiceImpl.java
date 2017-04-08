package com.together.service.impl;

import com.together.dao.HistoryInfoDao;
import com.together.dao.PersonDao;
import com.together.model.po.HistoryInfo;
import com.together.model.po.Person;
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

    @Override
    public int savePerson(Person person) {
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
        if (pv!=null && !pv.getSign().equals(person.getSign())){
            //如果用户签名修改且不为空
            if (!StringUtils.isEmpty(person.getSign())){
                HistoryInfo historyInfo = new HistoryInfo();
                historyInfo.setContent(person.getSign());
                historyInfo.setCreatetime(new Date());
                historyInfo.setLocation(null);
                historyInfo.setMyId(person.getId());
                historyInfoDao.saveHistoryInfo(historyInfo);
            }
        }
        return personDao.updatePerson(person);
    }

    @Override
    public List<HistoryInfoVo> queryAllByMyId(int myId) {
        return historyInfoDao.queryAllByMyId(myId);
    }

    @Override
    public int saveHistroyInfo(HistoryInfo historyInfo) {
        return 0;
    }
}

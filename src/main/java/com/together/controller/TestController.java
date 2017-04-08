package com.together.controller;

import com.together.model.po.Location;
import com.together.model.po.Person;
import com.together.model.vo.LocationVo;
import com.together.model.vo.PersonVo;
import com.together.service.LocationService;
import com.together.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

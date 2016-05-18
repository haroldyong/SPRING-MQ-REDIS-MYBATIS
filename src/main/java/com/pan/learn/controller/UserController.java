package com.pan.learn.controller;

import com.pan.learn.cache.BaseCache;
import com.pan.learn.meta.po.UserData;
import com.pan.learn.queue.producter.IMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by panhongwei on 2016/5/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IMessageSender messageSender;
    @Autowired
    private BaseCache baseCache;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Object getUser(Long userId){
        UserData userData = new UserData();
        userData.setUserId(1l);
        userData.setUserName("pan");
        messageSender.addUser(userData);
        return userData;
    }

    @RequestMapping(value = "/cache/add", method = RequestMethod.GET)
    @ResponseBody
    public Object cacheAddUser(Long userId,String userName){
        UserData userData = new UserData();
        userData.setUserId(userId);
        userData.setUserName(userName);
        baseCache.add("user_" + userId,userData);
        return userData;
    }

    @RequestMapping(value = "/cache/get", method = RequestMethod.GET)
    @ResponseBody
    public Object cacheGetUser(Long userId){

        return baseCache.get("user_" + userId);
    }
}

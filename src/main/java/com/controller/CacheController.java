package com.controller;

import com.bean.User;
import com.cache.UserCache;
import com.service.impl.TestInterFaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class CacheController {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginController.class);
    @Autowired
    private TestInterFaceImpl testInterFace;
    @Resource
    private UserCache userCache;

    @RequestMapping("setcache")
    public void setUserCache(){
        User user=new User();
        user.setId(1);
        userCache.saveUser(user);
    }

    @RequestMapping("getcache")
    public void getCache(){

        logger.info(userCache.getUser("1"));
    }

    @RequestMapping("putcache")
    public void putCache(){
        testInterFace.findUser(2,"wang");
    }


}

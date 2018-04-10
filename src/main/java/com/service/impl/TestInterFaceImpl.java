package com.service.impl;


import com.bean.User;
import com.dao.UserDao;

import com.service.interfaces.TestInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestInterFaceImpl implements TestInterFace {
    private static final Logger logger = LoggerFactory.getLogger(TestInterFaceImpl.class);
    @Autowired
    UserDao userDao;

    @Override
    public int testInterFace() {
        return 0;
    }


    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public void saveUser(String name,String pwd,String sex,String phone,String email,int userLevel) {
        userDao.saveUser(name,pwd,sex,phone, email,userLevel);
    }

    @Override
    public String findPassByName(String username) throws Exception {
        String pass=null;
        try {
             pass= userDao.findPassByName(username);
        }catch (Exception e){
            logger.info("dao层密码查询错误",e);
        }
        return pass;
    }

    @Override
    public int findIdByName(String name) throws Exception {
        String idstr="";
        try{
            idstr= userDao.findIdByName(name);
        }catch (Exception e){
            logger.info("dao层查询出错",e);
        }
        if (idstr==null){
            return 0;
        }else
            return Integer.valueOf(idstr);

    }
    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public User findUser(int id,String name){
        System.out.println("无缓存的时候调用这里");
        User user =new User();
        user.setId(id);
        user.setUsername(name);
        return user ;
    }



}

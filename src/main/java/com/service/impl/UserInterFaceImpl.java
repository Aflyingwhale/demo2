package com.service.impl;
import com.controller.LoginController;
import com.service.interfaces.SongListDao;
import com.dao.UserDao;
import com.service.interfaces.UserInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInterFaceImpl implements UserInterFace {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginController.class);
    @Autowired
    private SongListDao songListDao;
    @Autowired
    private UserDao userDao;
    @Override
    public boolean initUser(String name) {
        boolean flag=true;
        flag=songListDao.createSongList(userDao.findIdByName(name),null);
        return flag;
    }
}

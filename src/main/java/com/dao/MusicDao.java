package com.dao;

import com.bean.Music;
import com.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;
/*操作music表*/
@Mapper
public interface MusicDao extends MyMapper<Music>{
}

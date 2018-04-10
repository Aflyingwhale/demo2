package com.dao;

import com.bean.User;


import com.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/*操作users表*/
@Mapper
public interface UserDao extends MyMapper<User> {
    @Insert("insert into users(name,pwd,sex,email,user_level,phone_num) values(#{username},#{password},#{sex},#{email},#{userLevel},#{phone})")
    public void saveUser(@Param("username") String username,@Param("password") String password,@Param("sex")String sex,@Param("phone") String phone,
                         @Param("email")String email,@Param("userLevel")int userLevel);

    @Select("select pwd from users where name= #{username}")
    public String  findPassByName(@Param("username") String username);

    @Select("select id from users where name=#{username}")
    public String findIdByName(@Param("username")String username);
}

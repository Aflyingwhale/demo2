package com.service.interfaces;


import com.bean.User;


import java.util.List;

public interface TestInterFace {
    public int testInterFace();

    public List<User> selectAll();

    public void saveUser(String name,String pwd,String sex,String phone,String email,int userLevel);

    public String findPassByName(String name) throws Exception;
    //存在用户返回id,不存在则返回0.
    public int findIdByName(String name) throws Exception;
}

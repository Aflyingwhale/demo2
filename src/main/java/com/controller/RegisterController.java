package com.controller;

import com.bean.User;
import com.service.impl.TestInterFaceImpl;
import com.service.interfaces.TestInterFace;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    private TestInterFace testInterFace;

    @RequestMapping (value = "registerdeal",method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, @RequestParam(value = "username",required = true)String name, @RequestParam(value = "password",required = true) String pwd ,
                                 @RequestParam(value = "sex")String sex, @RequestParam("phone")String phone, @RequestParam("email")String email) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        int id=-1;
            try {
                id=testInterFace.findIdByName(name);
            }catch (Exception e){
                logger.info("Controller查询出错",e);
            }
            if (id==0){//不存在该用户名
                testInterFace.saveUser(name,pwd,sex,phone, email,new Integer(1));
                logger.info("注册成功");
                User user =new User(name,pwd,sex,phone,1,email);
                modelAndView.addObject(user);
                modelAndView.setViewName("/login");
                return modelAndView;
            }
        return new ModelAndView("/register");

    }

}

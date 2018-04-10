package com.controller;

import com.service.interfaces.TestInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginController.class);
    @Autowired
    private TestInterFace testInterFace;
    @GetMapping("log4j")
    public void test_log(){
        logger.info("log4j____testlog()");
    }

    @RequestMapping(value = "logindeal",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username")String name,@RequestParam("pwd")String pwd) throws Exception {
        if (name!=null){
           String password= testInterFace.findPassByName(name);
           if (password!=null){
               if (password.equals(pwd)){
                   logger.info("登录成功");
                   return new ModelAndView("/index");
               }else{
                   logger.info("密码错误");
                   return new ModelAndView("/login");
               }
           }else {
               logger.info("密码为空");
               return new ModelAndView("login");
           }
        }else {
            logger.info("用户姓名为空");
            return new ModelAndView("/login");
        }

    }
}

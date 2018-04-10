package com.controller;

import com.service.impl.TestInterFaceImpl;
import com.service.interfaces.TestInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller

public class IndexController {
    @Autowired
   private  TestInterFace testInterFace;

    //重定向测试
    @GetMapping("login1")
    public String login (HttpServletRequest request){

        return "redirect:/login.html";
    }
    @GetMapping("logintest")
    public String logintest(HttpServletRequest request) throws Exception {
        String name=request.getParameter("name");
        String password =request.getParameter("password");

        if (password!=null){
            String pass=testInterFace.findPassByName(name);
            if (password.equals(pass)){
                return "/success";
            }else {
                return "";
            }
        }else {

            return "redirect:login.html";
        }

    }


    //request,session thymeleaf测试
    @GetMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("name","lisi");
        return "/index";
    }

    @GetMapping("test1")
    public String test1(HttpServletRequest request){
        request.setAttribute("name","llj");
        HttpSession session=request.getSession();
        session.setAttribute("name","www");

        return "/test1";
    }
}

package com.controller;

import com.bean.User;
import com.service.interfaces.TestInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private TestInterFace testInterFace;



    @RequestMapping("/getall")
    @ResponseBody
    List<User> getall(){
        List<User> list=testInterFace.selectAll();
        return list;
    }



    @RequestMapping("logintest")
    @ResponseBody
    public String login(HttpServletRequest request) throws Exception {
        String name=request.getParameter("name");
        String password =request.getParameter("password");
        String pass=testInterFace.findPassByName(name);
        if (password!=null){
            if (password.equals(pass)){
                return "/success";
            }else {
                return pass;
            }
        }else {
            return "密码错误";
        }

    }

}

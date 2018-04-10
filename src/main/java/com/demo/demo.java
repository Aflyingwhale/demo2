package com.demo;


import com.service.interfaces.TestInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@EnableAutoConfiguration
public class demo {
    private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(demo.class);
    @Autowired
    private TestInterFace testInterFace;
    @RequestMapping("/")
    @ResponseBody
    int home(){
        int i=testInterFace.testInterFace();
        return i;
    }
}

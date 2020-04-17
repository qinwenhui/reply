package cn.qinwh.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
    * @Description: 
    * @Param: [name]
    * @return: java.lang.String
    * @Author: qinwh
    * @Date: 2020/4/15
    */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String name){
        return "hello " + name;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "{id:'P161713309', name:'覃文辉'}";
    }
}

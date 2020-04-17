package cn.qinwh.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public String test(@RequestHeader(value="Token") String token){
        //假设权限拦截器拦截到token，并且和redis确认了输入某个学生的请求，从redis中获取该学生的id
        System.out.println(token);
        if(token.equals("abc")){
            int userId = 1;
            return "{\"code\":0, \"msg\": \"登录成功\", \"data\": {\"id\":1, \"xuehao\":\"P161713309\", \"name\":\"覃文辉\", \"token\": \"abc\"}}";
        }else{
            return "{\"code\":1, \"msg\": \"登录信息失效\", \"data\": null}";
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password){
        if(username.equals("qinwh") && password.equals("1234")){
            return "{\"code\":0, \"msg\": \"登录成功\", \"data\": {\"id\":1, \"xuehao\":\"P161713309\", \"name\":\"覃文辉\", \"token\": \"abc\"}}";
        }else{
            return "{\"code\":1, \"msg\": \"账号或密码错误\", \"data\": null}";
        }
    }
}

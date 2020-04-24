package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.service.UserService;
import cn.qinwh.reply.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


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

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public BaseJson getUserInfo(@RequestHeader(value="Token") String token){
        //假设权限拦截器拦截到token，并且和redis确认了输入某个学生的请求，从redis中获取该学生的id
        BaseJson json = new BaseJson(1, "获取用户信息失败", null);
        if(token.equals("abc")){
            User user = userService.queryByPrimaryKey(1);
            user.setToken(token);
            if(token.equals(user.getToken())){
                json = new BaseJson(0, "获取用户信息成功", user);
            }
        }
        return json;
    }

    @RequestMapping("/login")
    @ResponseBody
    public BaseJson login(User loginUser){
        BaseJson json = new BaseJson(1, "登录失败", null);;
        User user = userService.login(loginUser);
        if(user != null){
            user.setToken("abc");
            json = new BaseJson(0, "登录成功", user);
        }
        return json;
    }

    @RequestMapping("/register")
    @ResponseBody
    public BaseJson register(User user){
        BaseJson json = null;
        User newUser = userService.register(user);
        if(newUser == null){
            //账号已存在
            json = new BaseJson(1, "账号已存在", null);
        }else{
            json = new BaseJson(1, "注册成功", newUser);
        }
        return json;
    }


    @RequestMapping("/test")
    @ResponseBody
    public BaseJson test(){

        BaseJson json = null;
        List<cn.qinwh.reply.pojo.User> users = userService.queryAll();
        json = new BaseJson(1, "成功", users);
        return json;
    }
}
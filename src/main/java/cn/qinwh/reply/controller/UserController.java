package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.Clazz;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.service.ClazzService;
import cn.qinwh.reply.service.UserService;
import cn.qinwh.reply.utils.BaseJson;
import cn.qinwh.reply.utils.CharacterUtils;
import cn.qinwh.reply.utils.ConstUtil;
import cn.qinwh.reply.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ClazzService clazzService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public BaseJson getUserInfo(HttpServletRequest request){
        //从request域中获取user
        User requestUser = (User) request.getAttribute("user");
        BaseJson json = new BaseJson(1, "获取用户信息失败", null);
        User user = userService.queryByPrimaryKey(requestUser.getId());
        json = new BaseJson(0, "获取用户信息成功", user);
        return json;
    }

    @RequestMapping("/getUserInfoById")
    @ResponseBody
    public BaseJson getUserInfoById(Integer id){
        BaseJson json = new BaseJson(1, "获取用户信息失败", null);
        User user = userService.queryByPrimaryKey(id);
        if(user != null){
            json = new BaseJson(0, "获取用户信息成功", user);
        }
        return json;
    }

    @RequestMapping("/login")
    @ResponseBody
    public BaseJson login(User loginUser){
        BaseJson json = new BaseJson(1, "登录失败", null);
        User user = userService.login(loginUser);
        if(user != null){
            String token = CharacterUtils.getRandomString(32)+"-"+user.getId();
            user.setToken(token);
            //存入redis
            RedisUtil.set(token, user, ConstUtil.TOKEN_SAVE_TIME);
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
            //注册成功,生成token放入redis
            String token = CharacterUtils.getRandomString(32)+"-"+newUser.getId();
            user.setToken(token);
            //存入redis
            RedisUtil.set(token, user, ConstUtil.TOKEN_SAVE_TIME);
            json = new BaseJson(0, "注册成功", newUser);
        }
        return json;
    }

    @RequestMapping("/getCurrentUserClass")
    @ResponseBody
    public BaseJson getCurrentUserClass(HttpServletRequest request){
        User requestUser = (User) request.getAttribute("user");
        BaseJson json = new BaseJson(1, "获取用户班级信息失败", null);
        User user = userService.queryByPrimaryKey(requestUser.getId());
        Clazz clazz = clazzService.queryByPrimaryKey(user.getClassId());
        if(clazz != null){
            json = new BaseJson(0, "获取班级信息成功", clazz);
        }
        return json;
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public BaseJson updateUser(User user){
        BaseJson json = new BaseJson(1, "修改失败", null);
        if(userService.updateSelective(user) >0 ){
            json = new BaseJson(0, "修改成功", null);
        }
        return json;
    }
    
    /**
    * @Description: 修改当前登录用户的信息
    * @Param: [request, user]
    * @return: cn.qinwh.reply.utils.BaseJson
    * @Author: qinwh
    * @Date: 2020/5/9
    */
    @RequestMapping("/updateCurrentUser")
    @ResponseBody
    public BaseJson updateCurrentUser(HttpServletRequest request, User user){
        User requestUser = (User) request.getAttribute("user");
        user.setId(requestUser.getId());
        BaseJson json =  new BaseJson(1, "修改失败", null);
        if(userService.updateSelective(user) >0 ){
            json = new BaseJson(0, "修改成功", null);
        }
        return json;
    }

    @RequestMapping("/test")
    @ResponseBody
    public BaseJson test(Date a){
        BaseJson json = null;
        User user = new User();
        user.setId(1);
        user.setUsername("abc");
        RedisUtil.set("a", user, 60l);
        User aa = RedisUtil.get("a", User.class);
        System .out.println(aa.getUsername());
        return json;
    }
}
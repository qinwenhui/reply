package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.ReplyinfoVo;
import cn.qinwh.reply.service.ReplyinfoService;
import cn.qinwh.reply.service.UserService;
import cn.qinwh.reply.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyinfoController {

    @Autowired
    ReplyinfoService replyinfoService;

    @Autowired
    UserService userService;

    @RequestMapping("/getCurrentUserReplyinfo")
    @ResponseBody
    public BaseJson getCurrentUserReplyinfo(@RequestHeader(value="Token") String token){
        //假设权限拦截器拦截到token，并且和redis确认了输入某个学生的请求，从redis中获取该学生的id
        BaseJson json = new BaseJson(1, "获取答辩信息失败", null);
        if(token.equals("abc")){
            User user = userService.queryByPrimaryKey(1);
            ReplyinfoVo replyinfoVo = replyinfoService.queryUserReplyinfoVo(user);
            json = new BaseJson(0, "获取答辩信息成功", replyinfoVo);
        }
        return json;
    }
}
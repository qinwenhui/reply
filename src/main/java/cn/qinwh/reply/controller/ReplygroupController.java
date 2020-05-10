package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.ReplygroupVo;
import cn.qinwh.reply.pojo.vo.ReplyinfoVo;
import cn.qinwh.reply.service.ReplygroupService;
import cn.qinwh.reply.service.UserService;
import cn.qinwh.reply.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/replygroup")
public class ReplygroupController {

    @Autowired
    ReplygroupService replygroupService;

    @Autowired
    UserService userService;

    @RequestMapping("/getCurrentUserReplygroup")
    @ResponseBody
    public BaseJson getCurrentUserReplyinfo(HttpServletRequest request){
        User requestUser = (User) request.getAttribute("user");
        BaseJson json = new BaseJson(1, "获取答辩组信息失败", null);
        User user = userService.queryByPrimaryKey(requestUser.getId());
        Replygroup replygroup = null;
        //先判断用户是老师还是学生
        if(user.getType() == 0){
            replygroup = replygroupService.queryByStudent(user);
        }else {
            replygroup = replygroupService.queryByTeacher(user);
        }
        if(replygroup != null){
            json = new BaseJson(0, "获取答辩组信息成功", replygroup);
        }
        return json;
    }

    @RequestMapping("/getReplygroupVoByUser")
    @ResponseBody
    public BaseJson getReplygroupVoByUser(User user){
        ReplygroupVo replygroupVo = null;
        BaseJson json = new BaseJson(1, "获取答辩组信息失败", null);
        //先判断用户是老师还是学生
        replygroupVo = replygroupService.queryReplygroupVoByUser(user);
        if(replygroupVo != null){
            json = new BaseJson(0, "获取答辩组信息成功", replygroupVo);
        }
        return json;
    }
}
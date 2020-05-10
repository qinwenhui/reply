package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.Feedback;
import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.service.FeedbackService;
import cn.qinwh.reply.service.ReplygroupService;
import cn.qinwh.reply.service.UserService;
import cn.qinwh.reply.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("/submitFeedback")
    @ResponseBody
    public BaseJson getCurrentUserReplyinfo(HttpServletRequest request, Feedback feedback){
        User requestUser = (User) request.getAttribute("user");
        BaseJson json = new BaseJson(1, "反馈失败", null);
        feedback.setUserId(requestUser.getId());
        if(feedbackService.saveSelect(feedback) > 0){
            json = new BaseJson(0, "反馈成功", feedback);
        }
        return json;
    }
}
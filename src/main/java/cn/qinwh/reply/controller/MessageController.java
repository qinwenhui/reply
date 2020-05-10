package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.Message;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.MessageVo;
import cn.qinwh.reply.service.MessageService;
import cn.qinwh.reply.utils.BaseJson;
import cn.qinwh.reply.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: reply
 * @description: 消息控制器
 * @author: qinwh
 * @create: 2020-04-17 22:01
 **/
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    MessageService messageService;

    @RequestMapping("/getSelfMessageList")
    @ResponseBody
    public BaseJson getSelfMessageList(HttpServletRequest request) {
        BaseJson json = new BaseJson(1, "查询失败", null);
        //获取当前用户
        User user = (User) request.getAttribute("user");
        if(user != null){
            Message where = new Message();
            where.setReceiverId(user.getId());
            List<MessageVo> messageVoList = messageService.queryMessageVoByWhere(where);
            json = new BaseJson(0, "查询成功", messageVoList);
        }
        return json;
    }

    @RequestMapping("/updateMessage")
    @ResponseBody
    public BaseJson updateMessage(Message message) {
        BaseJson json = new BaseJson(1, "更新失败", null);
        if(messageService.updateSelective(message) > 0){
            json = new BaseJson(0, "更新成功", null);
        }
        return json;
    }

    @RequestMapping("/sendMessage")
    @ResponseBody
    public BaseJson sendMessage(HttpServletRequest request, Message message) {
        BaseJson json = new BaseJson(1, "发送失败", null);
        //获取当前用户
        User user = (User) request.getAttribute("user");
        message.setSenderId(user.getId());
        if(messageService.saveSelect(message) > 0){
            json = new BaseJson(0, "发送成功", message);
        }
        return json;
    }
}

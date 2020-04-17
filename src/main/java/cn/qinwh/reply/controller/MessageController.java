package cn.qinwh.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: reply
 * @description: 消息控制器
 * @author: qinwh
 * @create: 2020-04-17 22:01
 **/
@Controller
@RequestMapping("/message")
public class MessageController {

    @RequestMapping("/getSelfMessageList")
    @ResponseBody
    public String getSelfMessageList() {
        return "[" +
                "{\"id\":1,\"img\":\"http://b-ssl.duitang.com/uploads/item/201410/09/20141009224754_AswrQ.jpeg\", \"name\":\"管理员\", \"content\":\"嗷嗷待食大所多食食大食大所多所多大食食大所多大所多所嗷待食大所多食食大食大所多所多大食食大所多大所多所多食大所多撒嗷待食大所多食食大食大所多所多大食食大所多大所多所多食大所多撒多食大所多撒大多\", \"date\":\"2020-04-17 20:12:46\", \"status\":1}," +
                "{\"id\":2,\"img\":\"http://b-ssl.duitang.com/uploads/item/201410/09/20141009224754_AswrQ.jpeg\", \"name\":\"管理员\", \"content\":\"嗷嗷待食大所多食食大食大所多所多大食食大所多大所多所嗷待食大所多食食大食大所多所多大食食大所多大所多所多食大所多撒嗷待食大所多食食大食大所多所多大食食大所多大所多所多食大所多撒多食大所多撒大多\", \"date\":\"2020-04-17 20:12:46\", \"status\":0}" +
                "]";
        //return "[]";
    }
}

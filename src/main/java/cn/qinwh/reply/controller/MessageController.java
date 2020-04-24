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
//        return "[" +
//                "{\"id\":1,\"img\":\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587218052432&di=9a34bf8d906d52605b6a45f6c4f9ec0e&imgtype=0&src=http%3A%2F%2Fpic1.zhimg.com%2F50%2Fv2-2f3dfd6f7da18983fd5a4e48747d7ee3_hd.jpg\", \"name\":\"答辩组长\", \"content\":\"你的论文怎么还没打印？等下就开始答辩了，请快点打印并提交到答辩小组！\", \"date\":\"2020-04-18 18:16:37\", \"status\":0}," +
//                "{\"id\":2,\"img\":\"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1587207908&di=cde189b5dc1c382bce102fdcc2ac50b1&src=http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg\", \"name\":\"系统通知\", \"content\":\"您的答辩即将开始，详情请查看答辩信息。\", \"date\":\"2020-04-17 20:12:46\", \"status\":1}," +
//                "{\"id\":5,\"img\":\"http://00imgmini.eastday.com/mobile/20180929/20180929145811_6be4201c978e69dac9a26201b1191274_3.jpeg\", \"name\":\"指导老师\", \"content\":\"有什么问题请及时反馈给我\", \"date\":\"2020-04-10 10:52:46\", \"status\":1}" +
//                "]";
        return "[]";
    }
}

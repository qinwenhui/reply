package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.FeedbackMapper;
import cn.qinwh.reply.pojo.Feedback;
import cn.qinwh.reply.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: message
 * @description: 反馈业务类
 * @author: qinwh
 * @create: 2020-04-25 20:05
 **/
@Service
public class FeedbackServiceImpl extends BaseServiceImpl<Feedback> implements FeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

}

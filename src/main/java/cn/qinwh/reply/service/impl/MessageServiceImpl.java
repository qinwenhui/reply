package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.MessageMapper;
import cn.qinwh.reply.pojo.Message;
import cn.qinwh.reply.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: message
 * @description: 消息业务类
 * @author: qinwh
 * @create: 2020-04-25 20:05
 **/
@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

    @Autowired
    MessageMapper messageMapper;

}

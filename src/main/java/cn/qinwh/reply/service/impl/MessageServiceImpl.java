package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.MessageMapper;
import cn.qinwh.reply.mapper.UserMapper;
import cn.qinwh.reply.pojo.Message;
import cn.qinwh.reply.pojo.vo.MessageVo;
import cn.qinwh.reply.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    UserMapper userMapper;

    @Override
    public List<MessageVo> queryMessageVoByWhere(Message where) {
        List<MessageVo> messageVoList = new ArrayList<>();
        List<Message> messageList = messageMapper.select(where);
        for (Message m : messageList){
            MessageVo vo = new MessageVo();
            vo.setMessage(m);
            int senderId = vo.getSenderId();
            int receiverId = vo.getReceiverId();
            vo.setSender(userMapper.selectByPrimaryKey(senderId));
            vo.setReceiver(userMapper.selectByPrimaryKey(receiverId));
            messageVoList.add(vo);
        }

        return messageVoList;
    }
}

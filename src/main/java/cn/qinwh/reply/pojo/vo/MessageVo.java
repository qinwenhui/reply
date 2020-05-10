package cn.qinwh.reply.pojo.vo;

import cn.qinwh.reply.pojo.Message;
import cn.qinwh.reply.pojo.User;

/**
 * @program: reply
 * @description: 消息包装类
 * @author: qinwh
 * @create: 2020-05-08 14:30
 **/
public class MessageVo extends Message {

    public void setMessage (Message message){
        setId(message.getId());
        setContent(message.getContent());
        setSenderId(message.getSenderId());
        setReceiverId(message.getReceiverId());
        setCreateTime(message.getCreateTime());
        setStatus(message.getStatus());
    }

    private User sender;
    private User receiver;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}

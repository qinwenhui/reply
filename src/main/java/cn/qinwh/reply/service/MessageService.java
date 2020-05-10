package cn.qinwh.reply.service;

import cn.qinwh.reply.pojo.Message;
import cn.qinwh.reply.pojo.vo.MessageVo;

import java.util.List;

public interface MessageService extends BaseService<Message> {

    List<MessageVo> queryMessageVoByWhere(Message where);
}

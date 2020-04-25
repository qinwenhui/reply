package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.ReplygroupMapper;
import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.service.ReplygroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: message
 * @description: 答辩组业务类
 * @author: qinwh
 * @create: 2020-04-25 20:05
 **/
@Service
public class ReplygroupServiceImpl extends BaseServiceImpl<Replygroup> implements ReplygroupService {

    @Autowired
    ReplygroupMapper replygroupMapper;

}

package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.ClazzMapper;
import cn.qinwh.reply.pojo.Clazz;
import cn.qinwh.reply.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: message
 * @description: 班级业务类
 * @author: qinwh
 * @create: 2020-04-26 01:25
 **/
@Service
public class ClazzServiceImpl extends BaseServiceImpl<Clazz> implements ClazzService {

    @Autowired
    ClazzMapper clazzMapper;

}

package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.ClazzMapper;
import cn.qinwh.reply.mapper.ScoreMapper;
import cn.qinwh.reply.pojo.Clazz;
import cn.qinwh.reply.pojo.Score;
import cn.qinwh.reply.service.ClazzService;
import cn.qinwh.reply.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: message
 * @description: 班级业务类
 * @author: qinwh
 * @create: 2020-04-26 01:25
 **/
@Service
public class ScoreServiceImpl extends BaseServiceImpl<Score> implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

}

package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.AppinfoMapper;
import cn.qinwh.reply.pojo.Appinfo;
import cn.qinwh.reply.service.AppinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: message
 * @description: 程序业务类
 * @author: qinwh
 * @create: 2020-04-25 20:05
 **/
@Service
public class AppinfoServiceImpl extends BaseServiceImpl<Appinfo> implements AppinfoService {

    @Autowired
    AppinfoMapper appinfoMapper;

}

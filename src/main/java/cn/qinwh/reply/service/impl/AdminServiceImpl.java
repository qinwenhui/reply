package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.*;
import cn.qinwh.reply.pojo.*;
import cn.qinwh.reply.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: admin
 * @description: 管理员信息service实现类
 * @author: qinwh
 * @create: 2020-04-25 17:26
 **/
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    @Autowired
    AdminMapper adminMapper;
}

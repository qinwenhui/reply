package cn.qinwh.reply.service;

import cn.qinwh.reply.pojo.User;

public interface UserService extends BaseService<User> {

    User register (User user);

    User login (User user);
}

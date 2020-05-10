package cn.qinwh.reply.mapper;

import cn.qinwh.reply.pojo.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    int insertUser(User user);
}
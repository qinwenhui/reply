package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.UserMapper;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @program: reply
 * @description: 用户业务类
 * @author: qinwh
 * @create: 2020-04-25 01:05
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User register(User user) {
        User newUser = null;
        //根据账号查询是否已经存在该用户
        if(user.getUsername() != null){
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", user.getUsername());
            User resultUser = userMapper.selectOneByExample(example);
            if(resultUser == null){
                //不存在该账号，可以注册
                switch (user.getType()){
                    case 0: user.setRoleId(3);break;
                    case 1: user.setRoleId(2);break;
                }
                if(userMapper.insertSelective(user) == 1){
                    newUser = user;
                }
            }
        }
        return newUser;
    }

    @Override
    public User login(User user) {
        User loginUser = null;
        if(user.getUsername() != null && user.getPassword() != null){
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", user.getUsername());
            criteria.andEqualTo("password", user.getPassword());
            loginUser = userMapper.selectOneByExample(example);
        }
        return loginUser;
    }
}

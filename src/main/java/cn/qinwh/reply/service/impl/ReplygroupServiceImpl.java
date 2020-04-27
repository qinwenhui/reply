package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.ReplygroupMapper;
import cn.qinwh.reply.mapper.ReplygroupStudentMapper;
import cn.qinwh.reply.mapper.ReplygroupTeacherMapper;
import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.pojo.ReplygroupStudent;
import cn.qinwh.reply.pojo.ReplygroupTeacher;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.service.ReplygroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    ReplygroupStudentMapper replygroupStudentMapper;
    @Autowired
    ReplygroupTeacherMapper replygroupTeacherMapper;

    @Override
    public Replygroup queryByStudent(User user) {
        //查询用户和答辩组关联表
        ReplygroupStudent where = new ReplygroupStudent();
        where.setStudentId(user.getId());
        List<ReplygroupStudent> replygroupStudentList = replygroupStudentMapper.select(where);
        //一个学生只对应一个答辩组，所以直接取第一条
        Replygroup replygroup = replygroupMapper.selectByPrimaryKey(replygroupStudentList.get(0).getReplygroupId());
        return replygroup;
    }
}

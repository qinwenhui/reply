package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.ReplygroupMapper;
import cn.qinwh.reply.mapper.ReplygroupStudentMapper;
import cn.qinwh.reply.mapper.ReplygroupTeacherMapper;
import cn.qinwh.reply.mapper.UserMapper;
import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.pojo.ReplygroupStudent;
import cn.qinwh.reply.pojo.ReplygroupTeacher;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.ReplygroupVo;
import cn.qinwh.reply.service.ReplygroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    UserMapper userMapper;
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

    @Override
    public Replygroup queryByTeacher(User user) {
        //查询用户和答辩组关联表
        ReplygroupTeacher where = new ReplygroupTeacher();
        where.setTeacherId(user.getId());
        List<ReplygroupTeacher> replygroupTeacherList = replygroupTeacherMapper.select(where);
        //目前老师也只对应一个答辩组)，所以直接取第一条
        Replygroup replygroup = replygroupMapper.selectByPrimaryKey(replygroupTeacherList.get(0).getReplygroupId());
        return replygroup;
    }

    @Override
    public ReplygroupVo queryReplygroupVoByUser(User user) {
        Replygroup group = null;
        if(user.getType() == 0){
            //学生
            ReplygroupStudent where = new ReplygroupStudent();
            where.setStudentId(user.getId());
            ReplygroupStudent replygroupStudent = replygroupStudentMapper.selectOne(where);
            group = replygroupMapper.selectByPrimaryKey(replygroupStudent.getReplygroupId());
        }
        if(user.getType() == 1){
            //老师
            ReplygroupTeacher where = new ReplygroupTeacher();
            where.setTeacherId(user.getId());
            ReplygroupTeacher replygroupTeacher = replygroupTeacherMapper.selectOne(where);
            group = replygroupMapper.selectByPrimaryKey(replygroupTeacher.getReplygroupId());
        }
        //老师列表
        ReplygroupTeacher where = new ReplygroupTeacher();
        where.setReplygroupId(group.getId());
        List<ReplygroupTeacher> replygroupTeacherList = replygroupTeacherMapper.select(where);
        List<User> teacherList = new ArrayList<>();
        for (ReplygroupTeacher t : replygroupTeacherList){
            teacherList.add(userMapper.selectByPrimaryKey(t.getTeacherId()));
        }

        //学生列表
        ReplygroupStudent where2 = new ReplygroupStudent();
        where.setReplygroupId(group.getId());
        List<ReplygroupStudent> replygroupStudentList = replygroupStudentMapper.select(where2);
        List<User> studentList = new ArrayList<>();
        for (ReplygroupStudent t : replygroupStudentList){
            studentList.add(userMapper.selectByPrimaryKey(t.getStudentId()));
        }

        if(group == null){
            return null;
        }
        ReplygroupVo replygroupVo = new ReplygroupVo();
        replygroupVo.setReplygroup(group);
        replygroupVo.setStudentList(studentList);
        replygroupVo.setTeacherList(teacherList);
        return replygroupVo;
    }
}

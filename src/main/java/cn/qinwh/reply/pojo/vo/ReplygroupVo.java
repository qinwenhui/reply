package cn.qinwh.reply.pojo.vo;

import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.pojo.User;

import java.util.List;

/**
 * @program: reply
 * @description: 答辩组包装类
 * @author: qinwh
 * @create: 2020-05-10 00:53
 **/
public class ReplygroupVo extends Replygroup {

    public void setReplygroup(Replygroup replygroup){
        setAddress(replygroup.getAddress());
        setCreateTime(replygroup.getCreateTime());
        setId(replygroup.getId());
        setLeaderId(replygroup.getLeaderId());
        setRemarks(replygroup.getRemarks());
        setName(replygroup.getName());
        setReplyTime(replygroup.getReplyTime());
    }

    private List<User> teacherList;

    private List<User> studentList;

    public List<User> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<User> teacherList) {
        this.teacherList = teacherList;
    }

    public List<User> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<User> studentList) {
        this.studentList = studentList;
    }
}

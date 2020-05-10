package cn.qinwh.reply.service;
import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.ReplygroupVo;

public interface ReplygroupService extends BaseService<Replygroup> {

    //根据学生用户查询答辩组信息
    Replygroup queryByStudent(User user);

    //根据老师用户查询答辩组信息
    Replygroup queryByTeacher(User user);

    //获取答辩组vo信息
    ReplygroupVo queryReplygroupVoByUser(User user);

}

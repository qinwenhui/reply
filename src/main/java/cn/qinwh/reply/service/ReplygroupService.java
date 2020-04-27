package cn.qinwh.reply.service;
import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.pojo.User;

public interface ReplygroupService extends BaseService<Replygroup> {

    //根据学生用户查询答辩组信息
    Replygroup queryByStudent(User user);

}

package cn.qinwh.reply.service;


import cn.qinwh.reply.pojo.Replygroup;
import cn.qinwh.reply.pojo.Replyinfo;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.ReplyinfoVo;

import java.util.List;

public interface ReplyinfoService extends BaseService<Replyinfo> {

    /**
    * @Description: 通过用户查询该用户的答辩信息包装类型（只查询最后一次答辩）
    * @Param: [user]
    * @return: cn.qinwh.reply.pojo.vo.ReplyinfoVo
    * @Author: qinwh
    * @Date: 2020/4/25
    */
    ReplyinfoVo queryUserReplyinfoVo(User user);

    /**
    * @Description: 查询所有答辩信息包装类
    * @Param: []
    * @return: java.util.List<cn.qinwh.reply.pojo.vo.ReplyinfoVo>
    * @Author: qinwh
    * @Date: 2020/4/25
    */
    List<ReplyinfoVo> queryReplyinfoVoList();

    /**
    * @Description: 查询某个答辩组的所有答辩信息Vo
    * @Param: [replygroup]
    * @return: java.util.List<cn.qinwh.reply.pojo.vo.ReplyinfoVo>
    * @Author: qinwh
    * @Date: 2020/4/25
    */
    List<ReplyinfoVo> queryReplyinfoVoListByGroup(Replygroup replygroup);
}

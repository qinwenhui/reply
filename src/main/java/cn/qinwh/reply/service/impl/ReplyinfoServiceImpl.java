package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.*;
import cn.qinwh.reply.pojo.*;
import cn.qinwh.reply.pojo.vo.ReplyinfoVo;
import cn.qinwh.reply.service.ReplyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: reply
 * @description: 答辩信息service实现类
 * @author: qinwh
 * @create: 2020-04-25 17:26
 **/
@Service
public class ReplyinfoServiceImpl extends BaseServiceImpl<Replyinfo> implements ReplyinfoService {

    @Autowired
    ReplyinfoMapper replyinfoMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ReplygroupMapper replygroupMapper;
    @Autowired
    ReplygroupStudentMapper replygroupStudentMapper;
    @Autowired
    ReplygroupTeacherMapper replygroupTeacherMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public ReplyinfoVo queryUserReplyinfoVo(User user) {
        ReplyinfoVo replyinfoVo = new ReplyinfoVo();
        Replyinfo replyinfo = new Replyinfo();
        replyinfo.setUserId(user.getId());
        List<Replyinfo> replyinfoList = replyinfoMapper.select(replyinfo);
        System.out.println(user.getId()+"-------------"+replyinfoList.size());
        if(replyinfoList.isEmpty()){
            //该用户不存在答辩信息
            return null;
        }
        if(replyinfoList.size() == 1){
            //只存在一次答辩，直接使用该答辩
            replyinfo = replyinfoList.get(0);
        }else{
            //需要获取的是最后一次答辩，所以要比较答辩信息的创建时间
            Date lastDate = replyinfoList.get(0).getCreateTime();
            for (Replyinfo temp : replyinfoList){
                if(temp.getCreateTime().after(lastDate)){
                    replyinfo = temp;
                }
            }
        }
        //判断答辩中的答辩日期是否在当前时间之前，仅限还未开始的答辩（status=0）
        Date current = new Date();
        if(replyinfo.getStatus() == 0 && replyinfo.getReplyTime().before(current)){
            //答辩时间在当前时间之前，所以现在是答辩期间，修改答辩信息的状态
            replyinfo.setStatus(1);
            //保存到持久化层
            replyinfoMapper.updateByPrimaryKeySelective(replyinfo);
        }
        //封装数据到Vo对象
        replyinfoVo.setReplyinfo(replyinfo);
        //获取和答辩信息关联的其他信息
        user = userMapper.selectByPrimaryKey(replyinfo.getUserId());
        replyinfoVo.setUser(user);
        Question question = questionMapper.selectByPrimaryKey(replyinfo.getQuestionId());
        replyinfoVo.setQuestion(question);
        Score score = scoreMapper.selectByPrimaryKey(replyinfo.getScoreId());
        replyinfoVo.setScorePo(score);
        //检测答辩成绩是否公开
        if(replyinfoVo.getScoreStatus() == 0){
            replyinfoVo.setScore(null);
        }
        return replyinfoVo;
    }

    @Override
    public List<ReplyinfoVo> queryReplyinfoVoList() {
        List<ReplyinfoVo> replyinfoVoList = new ArrayList<>();
        List<Replyinfo> replyinfoList = replyinfoMapper.selectAll();
        for(Replyinfo replyinfo : replyinfoList){
            ReplyinfoVo replyinfoVo = new ReplyinfoVo();
            replyinfoVo.setReplyinfo(replyinfo);
            User user = userMapper.selectByPrimaryKey(replyinfo.getUserId());
            replyinfoVo.setUser(user);
            Question question = questionMapper.selectByPrimaryKey(replyinfo.getQuestionId());
            replyinfoVo.setQuestion(question);
            Score score = scoreMapper.selectByPrimaryKey(replyinfo.getScoreId());
            replyinfoVo.setScorePo(score);
            replyinfoVoList.add(replyinfoVo);
        }
        return replyinfoVoList;
    }

    @Override
    public List<ReplyinfoVo> queryReplyinfoVoListByGroup(Replygroup replygroup) {
        List<ReplyinfoVo> replyinfoVoList = new ArrayList<>();
        //先查询关联表
        ReplygroupStudent replygroupStudent = new ReplygroupStudent();
        replygroupStudent.setReplygroupId(replygroup.getId());
        List<ReplygroupStudent> replygroupStudentList = replygroupStudentMapper.select(replygroupStudent);
        for (ReplygroupStudent temp : replygroupStudentList) {
            User user = userMapper.selectByPrimaryKey(temp.getStudentId());
            //调用上面的方法，通过用户查询该用户的答辩VO
            replyinfoVoList.add(queryUserReplyinfoVo(user));
        }
        return replyinfoVoList;
    }
}

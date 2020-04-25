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
        replyinfoVo.setReplyinfo(replyinfo);
        //获取和答辩信息关联的其他信息
        user = userMapper.selectByPrimaryKey(replyinfo.getUserId());
        replyinfoVo.setUser(user);
        Question question = questionMapper.selectByPrimaryKey(replyinfo.getQuestionId());
        replyinfoVo.setQuestion(question);
        Score score = scoreMapper.selectByPrimaryKey(replyinfo.getScoreId());
        replyinfoVo.setScorePo(score);
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

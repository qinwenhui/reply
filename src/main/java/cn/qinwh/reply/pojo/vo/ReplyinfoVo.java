package cn.qinwh.reply.pojo.vo;

import cn.qinwh.reply.pojo.Question;
import cn.qinwh.reply.pojo.Replyinfo;
import cn.qinwh.reply.pojo.Score;
import cn.qinwh.reply.pojo.User;

/**
 * @program: reply
 * @description: 答辩信息包装类
 * @author: qinwh
 * @create: 2020-04-25 17:07
 **/
public class ReplyinfoVo extends Replyinfo {

    public void setReplyinfo(Replyinfo replyinfo){
        setId(replyinfo.getId());
        setScore(replyinfo.getScore());
        setUserId(replyinfo.getUserId());
        setCreateTime(replyinfo.getCreateTime());
        setDescribe(replyinfo.getDescribe());
        setOtherFile(replyinfo.getOtherFile());
        setPpt(replyinfo.getPpt());
        setQuestionId(replyinfo.getQuestionId());
        setReplyTime(replyinfo.getReplyTime());
        setTitle(replyinfo.getTitle());
        setThesis(replyinfo.getThesis());
        setStatus(replyinfo.getStatus());
        setSpeechStatus(replyinfo.getSpeechStatus());
        setSpeech(replyinfo.getSpeech());
        setSort(replyinfo.getSort());
        setScoreId(replyinfo.getScoreId());
        setScoreStatus(replyinfo.getScoreStatus());
    }

    //用户外键对应的用户实体类
    private User user;

    //提问环节外键对应的提问环节类
    private Question question;

    //评分环节外键对应的评分环节类
    private Score scorePo;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Score getScorePo() {
        return scorePo;
    }

    public void setScorePo(Score scorePo) {
        this.scorePo = scorePo;
    }
}

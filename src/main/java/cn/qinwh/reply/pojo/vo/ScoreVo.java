package cn.qinwh.reply.pojo.vo;

import cn.qinwh.reply.pojo.Score;
import cn.qinwh.reply.pojo.User;

/**
 * @program: reply
 * @description: 成绩包装类
 * @author: qinwh
 * @create: 2020-05-10 09:52
 **/
public class ScoreVo extends Score {

    public void setScore(Score score){
        setReplyinfoId(score.getReplyinfoId());
        setDescribe(score.getDescribe());
        setId(score.getId());
        setQuestionScore(score.getQuestionScore());
        setSpeechScore(score.getSpeechScore());
        setThesisScore(score.getThesisScore());
        setTotalScore(score.getTotalScore());
        setUserId(score.getUserId());
    }
    private User teacher;

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}

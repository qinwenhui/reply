package cn.qinwh.reply.pojo.vo;

import cn.qinwh.reply.pojo.Question;
import cn.qinwh.reply.pojo.User;

/**
 * @program: reply
 * @description: 答辩问题VO
 * @author: qinwh
 * @create: 2020-05-05 21:54
 **/
public class QuestionVo extends Question {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setQuestion(Question question) {
        setContent(question.getContent());
        setContentFile(question.getContentFile());
        setCreateTime(question.getCreateTime());
        setId(question.getId());
        setReplyContent(question.getReplyContent());
        setReplyContentFile(question.getReplyContentFile());
        setReplyinfoId(question.getReplyinfoId());
        setStatus(question.getStatus());
        setUserId(question.getUserId());
    }
}

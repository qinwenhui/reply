package cn.qinwh.reply.service;

import cn.qinwh.reply.pojo.Question;
import cn.qinwh.reply.pojo.vo.QuestionVo;

import java.util.List;

public interface QuestionService extends BaseService<Question> {

    //通过答辩id获取问题Vo
    List<QuestionVo> queryQuestionVosByReplyinfoId(Integer replyinfoId);
}

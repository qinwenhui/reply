package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.QuestionMapper;
import cn.qinwh.reply.mapper.UserMapper;
import cn.qinwh.reply.pojo.Question;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.QuestionVo;
import cn.qinwh.reply.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: message
 * @description: 答辩提问问题业务类
 * @author: qinwh
 * @create: 2020-05-05 00:35
 **/
@Service
public class QuestionServiceImpl extends BaseServiceImpl<Question> implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<QuestionVo> queryQuestionVosByReplyinfoId(Integer replyinfoId) {
        List<QuestionVo> questionVoList = new ArrayList<>();
        Question where = new Question();
        where.setReplyinfoId(replyinfoId);
        List<Question> questions = questionMapper.select(where);
        for(Question q: questions){
            QuestionVo vo = new QuestionVo();
            vo.setQuestion(q);
            User user = userMapper.selectByPrimaryKey(vo.getUserId());
            vo.setUser(user);
            questionVoList.add(vo);
        }
        return questionVoList;
    }
}

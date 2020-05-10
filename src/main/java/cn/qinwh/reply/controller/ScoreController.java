package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.Feedback;
import cn.qinwh.reply.pojo.Score;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.ScoreVo;
import cn.qinwh.reply.service.FeedbackService;
import cn.qinwh.reply.service.ScoreService;
import cn.qinwh.reply.service.UserService;
import cn.qinwh.reply.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;
    @Autowired
    UserService userService;

    @RequestMapping("/addScore")
    @ResponseBody
    public BaseJson addScore(Score Score){
        BaseJson json = new BaseJson(1, "添加失败", null);
        if(scoreService.saveSelect(Score) > 0){
            json = new BaseJson(0, "添加成功", Score);
        }
        return json;
    }

    @RequestMapping("/queryScoreByReply")
    @ResponseBody
    public BaseJson queryScoreByReply(Integer replyinfoId){
        BaseJson json = new BaseJson(1, "查询失败", null);
        List<ScoreVo> scoreVoList = new ArrayList<>();
        Score score = new Score();
        score.setReplyinfoId(replyinfoId);
        List<Score> scoreList =  scoreService.queryListByWhere(score);
        if(scoreList != null){
            for (Score t : scoreList){
                ScoreVo scoreVo = new ScoreVo();
                User user = userService.queryByPrimaryKey(t.getUserId());
                scoreVo.setScore(t);
                scoreVo.setTeacher(user);
                scoreVoList.add(scoreVo);
            }
            json = new BaseJson(0, "查询成功", scoreVoList);
        }
        return json;
    }
}
package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.Question;
import cn.qinwh.reply.pojo.vo.QuestionVo;
import cn.qinwh.reply.service.QuestionService;
import cn.qinwh.reply.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @program: reply
 * @description: 答辩提问问题控制器
 * @author: qinwh
 * @create: 2020-05-05 00:37
 **/
@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("/getQuestionsByReply")
    @ResponseBody
    public BaseJson getQuestionsByReply(Integer replyinfoId) {
        List<QuestionVo> questionVoList = questionService.queryQuestionVosByReplyinfoId(replyinfoId);
        return  new BaseJson(0, "查询成功", questionVoList);
    }

    @RequestMapping("/replyQuestion")
    @ResponseBody
    public BaseJson replyQuestion(Integer questionId, String replyContent, @RequestParam MultipartFile replyBlob, HttpServletRequest req) throws Exception {
        Question question = new Question();
        question.setId(questionId);
        question.setReplyContent(replyContent);
        String replyContentFile = "";
        if (!replyBlob.isEmpty()) {
            //上传文件
            //文件上传的地址
            String path = ResourceUtils.getURL("classpath:").getPath()+"static/audio/question";
            String realPath = path.replace('/', '\\').substring(1,path.length());
            // 获取原文件名
            String fileName = CharacterUtils.getRandomString(10)+replyBlob.getOriginalFilename();
            // 创建文件实例
            File filePath = new File(realPath, fileName);
            // 如果文件目录不存在，创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录" + filePath);
            }
            // 写入文件
            try {
                replyBlob.transferTo(filePath);
            } catch (IOException e) {
                return  new BaseJson(500, "文件上传错误", e.getMessage());
            }
            replyContentFile = ConstUtil.getBasePath(req) + "static/audio/question/"+fileName;
        }
        question.setReplyContentFile(replyContentFile);
        question.setStatus(1);
        questionService.updateSelective(question);
        //获取文件，并且保存
        return  new BaseJson(0, "回复成功", replyContentFile);
    }

    @RequestMapping("/addQuestion")
    @ResponseBody
    public BaseJson addQuestion(Integer replyinfoId, Integer userId, String content, @RequestParam MultipartFile fileBlob, HttpServletRequest req) throws Exception {
        Question question = new Question();
        question.setReplyinfoId(replyinfoId);
        question.setContent(content);
        question.setUserId(userId);
        String contentFile = "";
        if (!fileBlob.isEmpty()) {
            //上传文件
            //文件上传的地址
            String path = ResourceUtils.getURL("classpath:").getPath()+"static/audio/question";
            String realPath = path.replace('/', '\\').substring(1,path.length());
            // 获取原文件名
            String fileName = CharacterUtils.getRandomString(10)+fileBlob.getOriginalFilename();
            // 创建文件实例
            File filePath = new File(realPath, fileName);
            // 如果文件目录不存在，创建目录`
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录" + filePath);
            }
            // 写入文件
            try {
                fileBlob.transferTo(filePath);
            } catch (IOException e) {
                return  new BaseJson(500, "文件上传错误", e.getMessage());
            }
            contentFile = ConstUtil.getBasePath(req) + "static/audio/question/"+fileName;
        }
        question.setContentFile(contentFile);
        questionService.saveSelect(question);
        //获取文件，并且保存
        return  new BaseJson(0, "提问成功", question);
    }

    /*
    语音识别
     */
    @RequestMapping("/audioToText")
    @ResponseBody
    public BaseJson audioToText(String fileUrl) throws Exception {
        BaiduAiUtil.BaiduResultBean bean = BaiduAiUtil.shibie(fileUrl);
        if(bean.getErr_no() == 0){
            //识别成功
            return  new BaseJson(0, "识别成功", bean.getResult());
        }
        return  new BaseJson(1, "识别失败", bean);
    }
}

package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.Replyinfo;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.pojo.vo.ReplyinfoVo;
import cn.qinwh.reply.service.ReplyinfoService;
import cn.qinwh.reply.service.UserService;
import cn.qinwh.reply.utils.BaiduAiUtil;
import cn.qinwh.reply.utils.BaseJson;
import cn.qinwh.reply.utils.CharacterUtils;
import cn.qinwh.reply.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyinfoController {

    @Autowired
    ReplyinfoService replyinfoService;

    @Autowired
    UserService userService;

    @RequestMapping("/getCurrentUserReplyinfo")
    @ResponseBody
    public BaseJson getCurrentUserReplyinfo(HttpServletRequest request){
        User requestUser = (User) request.getAttribute("user");
        BaseJson json = new BaseJson(1, "获取答辩信息失败", null);
        User user = userService.queryByPrimaryKey(requestUser.getId());
        ReplyinfoVo replyinfoVo = replyinfoService.queryUserReplyinfoVo(user);
        json = new BaseJson(0, "获取答辩信息成功", replyinfoVo);
        return json;
    }

    @RequestMapping("/getUserReplyinfo")
    @ResponseBody
    public BaseJson getUserReplyinfo( User user){
        BaseJson json = new BaseJson(1, "获取答辩信息失败", null);
        Replyinfo replyinfo = new Replyinfo();
        replyinfo.setUserId(user.getId());
        replyinfo = replyinfoService.queryOne(replyinfo);
        json = new BaseJson(0, "获取答辩信息成功", replyinfo);
        return json;
    }

    @RequestMapping("/getUserReplyinfoVo")
    @ResponseBody
    public BaseJson getUserReplyinfoVo( User user){
        BaseJson json = new BaseJson(1, "获取答辩信息失败", null);
        ReplyinfoVo replyinfoVo = replyinfoService.queryUserReplyinfoVo(user);
        json = new BaseJson(0, "获取答辩信息成功", replyinfoVo);
        return json;
    }

    @RequestMapping("/getUserReplyinfoVoByReply")
    @ResponseBody
    public BaseJson getUserReplyinfoVoByReply( Replyinfo replyinfo){
        BaseJson json = new BaseJson(1, "获取答辩信息失败", null);
        Replyinfo where = replyinfoService.queryOne(replyinfo);
        User userWhere = new User();
        userWhere.setId(where.getUserId());
        User user = userService.queryOne(userWhere);
        ReplyinfoVo replyinfoVo = replyinfoService.queryUserReplyinfoVo(user);
        json = new BaseJson(0, "获取答辩信息成功", replyinfoVo);
        return json;
    }

    @RequestMapping("/submitSpeech")
    @ResponseBody
    public BaseJson submitSpeech(Integer replyId, @RequestParam MultipartFile speechBlob, HttpServletRequest req) throws Exception {
        Replyinfo replyinfo = new Replyinfo();
        replyinfo.setId(replyId);
        String speechFile = "";
        if (!speechBlob.isEmpty()) {
            //上传文件
            //文件上传的地址
            String path = ResourceUtils.getURL("classpath:").getPath()+"static/audio/speech";
            String realPath = path.replace('/', '\\').substring(1,path.length());
            // 获取原文件名
            String fileName = CharacterUtils.getRandomString(10)+speechBlob.getOriginalFilename();
            // 创建文件实例
            File filePath = new File(realPath, fileName);
            // 如果文件目录不存在，创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录" + filePath);
            }
            // 写入文件
            try {
                speechBlob.transferTo(filePath);
            } catch (IOException e) {
                return  new BaseJson(500, "文件上传错误", e.getMessage());
            }
            speechFile = ConstUtil.getBasePath(req) + "static/audio/speech/"+fileName;
        }
        replyinfo.setSpeech(speechFile);
        replyinfo.setSpeechStatus(1);
        replyinfoService.updateSelective(replyinfo);
        //获取文件，并且保存
        return  new BaseJson(0, "上传成功", speechFile);
    }

    @RequestMapping("/updateReplyinfo")
    @ResponseBody
    public BaseJson updateReplyinfo( Replyinfo replyinfo){
        BaseJson json = new BaseJson(1, "修改失败", null);
        if(replyinfoService.updateSelective(replyinfo) > 0){
            json = new BaseJson(0, "修改成功", replyinfo);
        }
        return json;
    }
}
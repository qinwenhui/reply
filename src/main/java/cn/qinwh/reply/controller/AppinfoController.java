package cn.qinwh.reply.controller;

import cn.qinwh.reply.pojo.Appinfo;
import cn.qinwh.reply.service.AppinfoService;
import cn.qinwh.reply.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: reply
 * @description: 程序版本控制器
 * @author: qinwh
 * @create: 2020-04-17 22:01
 **/
@Controller
@RequestMapping("/appinfo")
public class AppinfoController {

    @Autowired
    AppinfoService appinfoService;

    @RequestMapping("/getFinalApp")
    @ResponseBody
    public BaseJson getFinalApp() {
        BaseJson json = null;
        List<Appinfo> appinfoList = appinfoService.queryAll();

        if(appinfoList.isEmpty()){
            json = new BaseJson(1, "暂无数据", null);
        }else{
            float maxVersion = appinfoList.get(0).getVersion();
            Appinfo finalApp = appinfoList.get(0);
            for(Appinfo app: appinfoList){
                if(app.getVersion() > maxVersion){
                    maxVersion = app.getVersion();
                    finalApp = app;
                }
            }
            json = new BaseJson(0, "查询成功", finalApp);
        }
        return json;
    }
}

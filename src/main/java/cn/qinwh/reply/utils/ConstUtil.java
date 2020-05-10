package cn.qinwh.reply.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: reply
 * @description: 常量类
 * @author: qinwh
 * @create: 2020-05-09 00:34
 **/
public class ConstUtil {

    public static final long TOKEN_SAVE_TIME = 60*60*24*7;

    public static String getBasePath(HttpServletRequest request){
        String path = request.getContextPath();
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    }
}

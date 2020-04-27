package cn.qinwh.reply.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: reply
 * @description: 时间日期工具类
 * @author: qinwh
 * @create: 2020-04-27 06:10
 **/
public class DateUtils {

    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

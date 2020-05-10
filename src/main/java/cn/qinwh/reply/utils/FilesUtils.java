package cn.qinwh.reply.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.xml.bind.DatatypeConverter;

/**
 * @program: reply
 * @description: 文件工具类
 * @author: qinwh
 * @create: 2020-05-09 12:48
 **/
public class FilesUtils {
    private static final Logger LOG = LoggerFactory.getLogger(FilesUtils.class);

//    public static void main(String[] args) throws Exception {
//        String base64 = getBase64FromFileUrl("http://localhost:8080/static/audio/88bR2uALUX1588997387000.wav");
//        System.out.println(base64);
//    }

    /*
    下载网络文件流
     */
    private static InputStream downloadFile(String fileUrl) throws MalformedURLException {

        URL url = new URL(fileUrl);
        InputStream inStream = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            inStream = conn.getInputStream();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inStream;
    }
    /**
     * 将inputstream转为Base64
     *
     * @param fileUrl
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getBase64FromFileUrl(String fileUrl) throws Exception {
        Map<String, Object> map = new HashMap<>();
        InputStream is = downloadFile(fileUrl);
        // 将文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取字节数组
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = is.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new Exception("输入流关闭异常");
                }
            }
        }
        map.put("base64", DatatypeConverter.printBase64Binary(data));
        map.put("len", data.length);
        return map;
    }
}

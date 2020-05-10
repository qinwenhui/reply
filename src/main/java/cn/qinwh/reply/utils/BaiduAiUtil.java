package cn.qinwh.reply.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @program: reply
 * @description: 百度AI平台接入工具
 * @author: qinwh
 * @create: 2020-05-09 12:19
 **/
public class BaiduAiUtil {

    public static final String appId = "19790510";
    public static final String apiKey = "p1I3wtwqYoCrlfHuqkc8RTyN";
    public static final String secretKey = "ExZlUXUfct2EMARyXnIyQRhW5lfQriud";
    public static final String GET_ACCESS_URL = "https://aip.baidubce.com/oauth/2.0/token";
    public static final String SHIBIE_URL = "http://vop.baidu.com/server_api";
    public static String access_token = "24.f27d975218ef7656ae9620388f80c617.2592000.1591590936.282335-19790510";

    public static void main(String[] args) throws Exception {
//        String param = "grant_type=client_credentials"+
//                "&client_id="+apiKey+
//                "&client_secret="+secretKey;
//        String result = post(GET_ACCESS_URL,param );
//        ObjectMapper mapper=new ObjectMapper();
//        try {
//            JsonNode node = mapper.readTree(result);
//            access_token = node.get("access_token").asText();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);
        BaiduResultBean b = shibie("http://localhost:8080/static/audio/88bR2uALUX1588997387000.wav");
        Map<String, Object> map =  FilesUtils.getBase64FromFileUrl("http://localhost:8080/static/audio/pFPHPwMivd1589004986000.wav");
        String base = map.get("base64").toString();
        decoderBase64File(base,"");
        System.out.println(map.get("len").toString());
    }
    public static void decoderBase64File(String base64Code, String targetPath)
            throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream("D://1.wav");
        out.write(buffer);
        out.close();

    }
    public static BaiduResultBean shibie(String fileUrl) throws Exception {
        BaiduAiUtil.BaiduResultBean bean = null;
        Map<String, Object> map =  FilesUtils.getBase64FromFileUrl(fileUrl);
        System.out.println(map.get("base64").toString());
        String param = "{ \"format\":\"wav\", \"rate\":16000, \"dev_pid\":1537, \"channel\":1, \"token\":\""+access_token+"\", \"cuid\":\"cn_qinwh\",\"len\":"+map.get("len").toString()+", \"speech\":\""+map.get("base64").toString()+"\"}";
        String result = post(SHIBIE_URL,param );
        System.out.println(result);
        ObjectMapper mapper=new ObjectMapper();
        bean = mapper.readValue(result, BaiduAiUtil.BaiduResultBean.class);
        return bean;
    }
    private static String post(String httpUrl, String param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);
            //请求头
            connection.setRequestProperty("Content-Type","application/json");
            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }


    public static class BaiduResultBean {
        private String corpus_no;
        private String err_msg;
        private Integer err_no;
        private String[] result;
        private String sn;

        public String getCorpus_no() {
            return corpus_no;
        }

        public void setCorpus_no(String corpus_no) {
            this.corpus_no = corpus_no;
        }

        public String getErr_msg() {
            return err_msg;
        }

        public void setErr_msg(String err_msg) {
            this.err_msg = err_msg;
        }

        public Integer getErr_no() {
            return err_no;
        }

        public void setErr_no(Integer err_no) {
            this.err_no = err_no;
        }

        public String[] getResult() {
            return result;
        }

        public void setResult(String[] result) {
            this.result = result;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }
    }
}



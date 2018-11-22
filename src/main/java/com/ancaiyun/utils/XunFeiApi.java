package com.ancaiyun.utils;

import net.sf.json.JSONObject;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.net.URLEncoder;

public class XunFeiApi {
    /**
     * ocr 接口地址 请求方式post
     */
    private static String OCR = "http://webapi.xfyun.cn/v1/service/v1/ocr/general";
    /**
     * 讯飞appkey
     */
    private static String APIKey = "faec616e54affa24f04d9fd12b4beec6";
    /**
     * 讯飞APPID
     */
    private static String APPID = "5b90e7a7";

    /**
     * 获取当前时间错
     * @return
     */
    public static String getCurrentTime(){
        Long timestamp = System.currentTimeMillis()/1000;
        return timestamp.toString();
    }

    /**
     * 生成令牌
     * @param apiKey
     * @param curTime
     * @param param
     * @return
     */
    public static String getToken(String apiKey,String curTime,String param){
        String str = apiKey+curTime+param;
        return MD5Util.encodeMD5Hex(str);
    }

//    public static void main(String[] args) throws IOException {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("language","en");
//        jsonObject.put("location","false");
//        String param = Base64Utils.encodeToUrlSafeString(jsonObject.toString().getBytes());
//        //System.out.println(Base64Utils.encodeToUrlSafeString(jsonObject.toString().getBytes()));
//        String currentTime = getCurrentTime();
//        String token = getToken(APIKey,currentTime,param);
//
//        CloseableHttpClient httpClient = HttpClients.custom().build();
//        HttpPost httpPost = new HttpPost(OCR);
//        httpPost.setHeader("X-Appid",APPID);
//        httpPost.setHeader("X-CurTime",currentTime);
//        httpPost.setHeader("X-Param",param);
//        httpPost.setHeader("X-CheckSum",token);
//        //httpPost.setHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
//        byte[] bytes = FileUtil.readFileByBytes("D:\\123456.png");
//        String image = Base64Utils.encodeToUrlSafeString(bytes);
//        String body = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(image, "UTF-8");
//        //String body = "image" + "=" + URLEncoder.encode(image, "UTF-8");
////        JSONObject jsonObjectNew = new JSONObject();
////        jsonObjectNew.put("image",image);
////        String body = URLEncoder.encode(jsonObjectNew.toString(),"UTF-8");
////        System.out.println("ooooooooooooooooooooooooooooooooooo"+body.toString());
//        httpPost.setEntity(new StringEntity(body));
//        //httpClient.execute(httpPost);
//        System.out.println(httpClient.execute(httpPost));
//    }

    public static void main(String[] args) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("language","en");
        jsonObject.put("location","false");
        String param = Base64Utils.encodeToUrlSafeString(jsonObject.toString().getBytes());
        //System.out.println(Base64Utils.encodeToUrlSafeString(jsonObject.toString().getBytes()));
        String currentTime = getCurrentTime();
        String token = getToken(APIKey,currentTime,param);

        CloseableHttpClient httpClient = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost("http://localhost:8080/back/v1/test000");
        httpPost.setHeader("X-Appid",APPID);
        httpPost.setHeader("X-CurTime",currentTime);
        httpPost.setHeader("X-Param",param);
        httpPost.setHeader("X-CheckSum",token);
        //httpPost.setHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
        byte[] bytes = FileUtil.readFileByBytes("D:\\123456.png");
        String image = Base64Utils.encodeToUrlSafeString(bytes);
        String body = URLEncoder.encode("haha", "UTF-8") + "=" + URLEncoder.encode(image, "UTF-8");
        httpPost.setEntity(new StringEntity(body));
        //httpClient.execute(httpPost);
        System.out.println(httpClient.execute(httpPost));
    }
}

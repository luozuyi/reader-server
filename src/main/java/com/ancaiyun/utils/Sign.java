package com.ancaiyun.utils;

import net.sf.json.JSONObject;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Random;

public class Sign {
    public static String OCR = "http://recognition.image.myqcloud.com/ocr/general";
    public static String SecretId = "AKID9AzgdR5hBYotnwj7Zu6FCyY7UPHyg1Tk";
    public static String SecretKey = "dLyKe2NcifRXYTGwQhnhw42sVL5dzABl";
    public static long APPID = 1256771096;
    /**
     * 生成 Authorization 签名字段
     *
     * @param appId
     * @param secretId
     * @param secretKey
     * @param bucketName
     * @param expired
     * @return
     * @throws Exception
     */
    public static String appSign(long appId, String secretId, String secretKey, String bucketName,
                                 long expired) throws Exception {
        long now = System.currentTimeMillis() / 1000;
        int rdm = Math.abs(new Random().nextInt());
        String plainText = String.format("a=%d&b=%s&k=%s&t=%d&e=%d&r=%d", appId, bucketName,
                secretId, now, now + expired, rdm);
        byte[] hmacDigest = HmacSha1(plainText, secretKey);
        byte[] signContent = new byte[hmacDigest.length + plainText.getBytes().length];
        System.arraycopy(hmacDigest, 0, signContent, 0, hmacDigest.length);
        System.arraycopy(plainText.getBytes(), 0, signContent, hmacDigest.length,
                plainText.getBytes().length);
        return Base64Encode(signContent);
    }

    /**
     * 生成 base64 编码
     *
     * @param binaryData
     * @return
     */
    public static String Base64Encode(byte[] binaryData) {
        String encodedstr = Base64.getEncoder().encodeToString(binaryData);
        return encodedstr;
    }

    /**
     * 生成 hmacsha1 签名
     *
     * @param binaryData
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] HmacSha1(byte[] binaryData, String key) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        mac.init(secretKey);
        byte[] HmacSha1Digest = mac.doFinal(binaryData);
        return HmacSha1Digest;
    }

    /**
     * 生成 hmacsha1 签名
     *
     * @param plainText
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] HmacSha1(String plainText, String key) throws Exception {
        return HmacSha1(plainText.getBytes(), key);
    }



    public static void main(String[] args) throws Exception {
        long expired = 60;
        String token = appSign(APPID, SecretId, SecretKey, null,expired);
        CloseableHttpClient httpClient = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost(OCR);
        httpPost.setHeader("host","recognition.image.myqcloud.com");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("authorization",token);

        byte[] bytes = FileUtil.readFileByBytes("D:\\6.jpg");
        String image = Base64Encode(bytes);
        JSONObject jsonObjectNew = new JSONObject();
        jsonObjectNew.put("image",image);
        jsonObjectNew.put("appid",APPID+"");
        httpPost.setEntity(new StringEntity(jsonObjectNew.toString()));
        //httpClient.execute(httpPost);
        //System.out.println(httpClient.execute(httpPost).getEntity());
        System.out.println("============"+EntityUtils.toString(httpClient.execute(httpPost).getEntity()));
    }

    /**
     * 文字识别
     * @param file
     * @return
     * @throws Exception
     */
    public static String wordsRecognition(MultipartFile file) throws Exception{
        String token = appSign(APPID, SecretId, SecretKey, null,0);
        CloseableHttpClient httpClient = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost(OCR);
        httpPost.setHeader("host","recognition.image.myqcloud.com");
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("authorization",token);
        byte[] bytes = file.getBytes();
        String image = Base64Encode(bytes);
        JSONObject jsonObjectNew = new JSONObject();
        jsonObjectNew.put("image",image);
        jsonObjectNew.put("appid",APPID+"");
        httpPost.setEntity(new StringEntity(jsonObjectNew.toString()));
        return EntityUtils.toString(httpClient.execute(httpPost).getEntity());
    }
}

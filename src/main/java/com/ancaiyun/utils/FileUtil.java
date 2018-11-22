package com.ancaiyun.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件读取工具类
 */
public class FileUtil {

    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } 

        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        } 

        StringBuilder sb = new StringBuilder((int) (file.length()));
        // 创建字节输入流  
        FileInputStream fis = new FileInputStream(filePath);  
        // 创建一个长度为10240的Buffer
        byte[] bbuf = new byte[10240];  
        // 用于保存实际读取的字节数  
        int hasRead = 0;  
        while ( (hasRead = fis.read(bbuf)) > 0 ) {  
            sb.append(new String(bbuf, 0, hasRead));  
        }  
        fis.close();  
        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
//    public static void main(String[] args) throws IOException {
//        String text = readFileAsString("C:\\Users\\mayn\\Desktop\\西厢记.txt");
//        //File file = new File("F:\\小说\\中国古典文学\\集部\\文论\\文心雕龙.txt");
//        //String s = txt2String(file);
//        text = text.replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "------------").replaceAll("^((\r\n)|\n)", "------------");
//        String[] ss = text.split("------------");
//        //System.out.println("length:"+ss.length);
//        for (int i = 0; i < ss.length; i++) {
//            if(i % 2 == 1){
//                System.out.println("章节标题为============:"+ss[i-1]+"-------章节内容为============："+ss[i]);
//            }
//        }
//    }
    /*public static void main(String[] args) {
        String str = "我的家在东北，善良宽厚idede";
        System.out.println(str.indexOf("善良宽"));
        System.out.println(str.lastIndexOf("善良宽"));
        System.out.println("善良宽".lastIndexOf(str));
    }*/
/*public static void main(String[] args) throws IOException, IllegalAccessException {
    String q = "侠客行";
    Integer count = 2;
    CloseableHttpClient httpClient = HttpClients.custom().build();
    String url = "https://api.douban.com/v2/book/search?q="+q+"&count="+count;
    HttpGet get = new HttpGet(url);
    httpClient.execute(get).getEntity();
    String str = EntityUtils.toString(httpClient.execute(get).getEntity());
    ObjectMapper objectMapper =new ObjectMapper();
    JSONObject map =objectMapper.readValue(str, JSONObject.class);
    if((Integer)map.get("total") > 0){
        //List<Object> objectList = (List<Object>) map.get("books");
        String jsonString = JSON.toJSONString(map.get("books"));
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        for (int i = 0; i <jsonArray.size() ; i++) {
            JSONObject jsonObject = JSONObject.parseObject(jsonArray.get(i).toString());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+jsonObject.get("image"));
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+jsonObject.get("author"));
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+jsonObject.get("title"));
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+jsonObject.get("title"));
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+jsonObject.get("isbn10"));
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+jsonObject.get("isbn13"));
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+jsonObject.get("url"));
            System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+jsonObject.get("price"));

        }
    }
}*/
    /**
     22      * 获取利用反射获取类里面的值和名称
     23      *
     24      * @param obj
     25      * @return
     26      * @throws IllegalAccessException
     27      */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }


    public static void main(String[] args) throws IOException {
        String url = "http://test.100estore.com/shop/speedSale.jspx";
        CloseableHttpClient httpClient = HttpClients.custom().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Cookie","sgsa_id=100estore.com|1537923966929657; Qs_lvt_179689=1538992664%2C1539582339%2C1539938066%2C1540259636%2C1542591755; Hm_lvt_68d75f6740c672cde3f373d0019844f6=1540259637,1542591756; Qs_pv_179689=4053049026327698000%2C1140758251182648600%2C852703462018067800%2C2377296536469261000%2C41270890483859630; clientlanguage=zh_CN; remember_me_cookie=Z2FvX3l1YW46MTU0MzgwMTY1NTkwNzpiM2Y2ZTg0MjRlMjQ2NjU3YTJkNmVkMTJkMmJiNjRlZjozODg3Ng; JSESSIONID=1150942bae4c4344ba41b0ae6cd79daa; username=Z2FvX3l1YW4");
        post.setHeader("Host","test.100estore.com");
        post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        post.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
        JSONObject jsonObjectNew = new JSONObject();
        jsonObjectNew.put("productId",500);
        post.setEntity(new StringEntity(jsonObjectNew.toString(),"utf-8"));
        System.out.println("xxxxxxxxxxxxxxxxxxx*********************"+httpClient.execute(post));
    }
}

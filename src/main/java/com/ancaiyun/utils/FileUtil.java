package com.ancaiyun.utils;

import java.io.*;

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
    public static void main(String[] args) {
        String str = "我的家在东北，善良宽厚idede";
        System.out.println(str.indexOf("善良宽"));
        System.out.println(str.lastIndexOf("善良宽"));
        System.out.println("善良宽".lastIndexOf(str));
    }
}

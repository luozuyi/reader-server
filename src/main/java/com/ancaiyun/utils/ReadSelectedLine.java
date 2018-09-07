package com.ancaiyun.utils;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadSelectedLine {
    // 读取文件指定行。
    static void readAppointedLineNumber(File sourceFile, int lineNumber)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        if (lineNumber <= 0 || lineNumber > getTotalLines(sourceFile)) {
            System.out.println("不在文件的行数范围(1至总行数)之内。");
            System.exit(0);
        }
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if((lines - lineNumber) == 0) {
                System.out.println(s);
                System.exit(0);
            }
        }
        reader.close();
        in.close();
    }
    static void readAppointedLineNumberNew(File sourceFile, int startNum,int endNum)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("e:/dianzishu1.txt")));
        String s = "";
        if (startNum <= 0 || startNum > getTotalLines(sourceFile)) {
            System.out.println("不在文件的行数范围(1至总行数)之内。");
            System.exit(0);
        }
        if (endNum <= 0 || endNum > getTotalLines(sourceFile)) {
            System.out.println("不在文件的行数范围(1至总行数)之内。");
            System.exit(0);
        }
        if (startNum > endNum) {
            System.out.println("开始页不能大于结束页。");
            System.exit(0);
        }
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if(lines >= startNum & lines <= endNum){
                System.out.println(s);
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            if(lines == endNum){
                break;
            }
        }
        reader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        in.close();
    }
    // 文件内容的总行数。
    static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    public static List<String> getTotalLinesList(List<String> list, File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        while (s != null) {
            list.add(s);
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return list;
    }

    public static List<String> readAppointedLineNumberNew(List<String> list,File sourceFile, int startNum,int endNum)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        reader.setLineNumber(startNum);
//        for(int i=startNum;i<=endNum;i++){
//            list.add(reader.readLine());
//        }
        String s = "";
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if(lines >= startNum & lines <= endNum){
                list.add(s);
            }
            if(lines == endNum){
                break;
            }
        }
        reader.close();
        in.close();
        return list;
    }

    public static int readCount(File sourceFile)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }
    public static List<String> readChapter(List<String>list,File sourceFile)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        while (s != null) {
            s = reader.readLine();
            if(s!=null && s.contains("------------")){
                for (int i = 0; i < 2 ; i++) {
                    s = reader.readLine();
                }
                list.add(s);
            }
        }
        reader.close();
        in.close();
        return list;
    }
    public static List<String> readChapterContent(List<String>list,File sourceFile,String chapter)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        while (s != null) {
            s = reader.readLine();
            if(s!=null && s.contains(chapter)){
                while(true){
                    list.add(s);
                    s = reader.readLine();
                    if(s!=null && s.contains("------------")){
                        list.add(s);
                        s = reader.readLine();
                        list.add(s);
                        break;
                    }
                }
                break;
            }
        }
        reader.close();
        in.close();
        return list;
    }
//    public static void main(String[] args) throws IOException {
//        readChapter(new ArrayList<>(),new File("e:/all.txt"));
//    }
    /**
     * 读取文件指定行。
     */
//    public static void main(String[] args) throws IOException {
//        // 指定读取的行号
//        int lineNumber = 2;
//        // 读取文件
//        File sourceFile = new File("e:/dianzishu.txt");
//        // 读取指定的行
//        //readAppointedLineNumber(sourceFile, lineNumber);
//        // 获取文件的内容的总行数
//        //System.out.println(getTotalLines(sourceFile));
//        readAppointedLineNumberNew(sourceFile, 1,5);
//    }
//    public static void main(String[] args) throws IOException {
//        Long begin = System.currentTimeMillis();
//        String str = "此时的叶揺，已经陷入到了狂喜之中，就连古清影什么时候出现在了他的后面都不知道。" ;
//        File sourceFile = new File("e:/all -1.txt");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
//        StringBuffer sb = new StringBuffer();
//        String readLine = "";
////        int line = 0;
//        while ((readLine = bufferedReader.readLine()) != null){
////            line ++;
//            sb.append(readLine);
////            if(readLine.indexOf(str) != -1){
////                System.out.println(line);
////            }
//        }
//        bufferedReader.close();
//        System.out.println("xxxxxxx:"+sb.indexOf(str));
//        System.out.println("总时间:"+(System.currentTimeMillis()-begin));
////        long pos = 563445;
////        String str1 = "";
////        RandomAccessFile randomAccessFile = new RandomAccessFile("e:/aaaa.txt", "r");
////        randomAccessFile.seek(pos);//将文件流的位置移动到pos字节处
////        while( (str1 = randomAccessFile.readLine()) != null)
////        {
////            System.out.println(new String(str1.getBytes("ISO-8859-1"),"utf-8"));
////        }
////        randomAccessFile.close();
//
//    }
   /* public static void main(String[] args) throws IOException {
        long pos = 853251;
        String str1 = "";
        RandomAccessFile randomAccessFile = new RandomAccessFile("e:/all -1.txt", "r");
        randomAccessFile.seek(pos);//将文件流的位置移动到pos字节处
        while( (str1 = randomAccessFile.readLine()) != null)
        {
            System.out.println(new String(str1.getBytes("ISO-8859-1"),"utf-8"));
        }
        randomAccessFile.close();
    }*/

    public static void analyze1(String filePath) throws IOException {
        String text = FileUtil.readFileAsString(filePath) ;
        //System.out.println(text);
        String [] paragraph = text.split("------------");
        System.out.println(paragraph.length);
        String tRegex = "------------(\\S*?)　";
        System.out.println();
        for(int i = 1 ; i<paragraph.length ; i++) {
            System.out.println(paragraph[i]);
            paragraph[i] ="------------"+paragraph[i];
            Pattern p = Pattern.compile(tRegex);
            Matcher m = p.matcher(paragraph[i]);
            if(m.find()) {
                System.out.println("======================="+m.group(1));
                String content = paragraph[i].replace("★"+m.group(1), "");
//                chaNum++ ;
//                chapter.setChaNm(chaNm);
//                chapter.setContent(content);
//                chapter.setChaNum(chaNum);
//                int flag= dao.insert(chapter) ;
                System.out.println("★★★★★★★★★★★★"+content);
            }
        }
    }

    /*public static void main(String[] args) throws IOException {
        analyze1("E:\\all.txt");
    }*/
    public static void read() throws FileNotFoundException {
        String fileNamedirs="F:\\小说\\中国古典文学\\历部\\别杂史等\\归田录.txt";
        try {
            // 编码格式
            String encoding = "GBK";
            // 文件路径
            File file = new File(fileNamedirs);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                // 输入流
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                Long count = (long) 0;
                boolean bflag=false;
                int n=0;
                String newStr=null;
                String titleName=null;
                String newChapterName = null;//新章节名称
                String substring=null;
                int indexOf=0;
                int indexOf1=0;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    count++;
                    // 正则表达式
                    Pattern p = Pattern.compile("(^\\s*第)(.{1,9})[章节卷集部篇回](\\s{1})(.*)($\\s*)");

                    Matcher matcher = p.matcher(lineTxt);
                    Matcher matcher1 = p.matcher(lineTxt);
                    newStr=newStr+lineTxt;

                    while (matcher.find()) {
                        titleName = matcher.group();
                        //章节去空
                        newChapterName = titleName.trim();
                        indexOf1=indexOf;
                        indexOf = newStr.indexOf(newChapterName);
                        //System.out.println(newChapterName + ":" + "第" + count + "行"); // 得到返回的章
                        if(bflag) {
                            bflag=false;
                            break;
                        }
                        if(n==0) {
                            indexOf1 = newStr.indexOf(newChapterName);
                        }
                        n=1;
                        bflag=true;
                    }
                    while(matcher1.find()) {
                        if(indexOf!=indexOf1) {
                            substring = newStr.substring(indexOf1, indexOf);
                            System.out.println(substring);
                        }

                    }
                }
                bufferedReader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        read();
    }
}

package com.ancaiyun.controller;

import com.ancaiyun.utils.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    /**
     * 分页查询内容
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "v1/auth/dianzishu",method = RequestMethod.GET)
    public Result listPage(Integer pageNum,Integer pageSize) throws IOException {
        File sourceFile = new File("e://all.txt");
        String code = Constants.FAIL;
        String msg = "初始化";
        Result result = null;
        try {
            result = new Result();
            //int totalCount = CountLine.readLine(sourceFile);
            //int totalCount = 45567;
            int totalCount = ReadSelectedLine.readCount(sourceFile);
            ListPageUtil page = new ListPageUtil(totalCount,pageNum,pageSize);
            //int startNum = page.getStartNum();
            //int endNum = page.getEndNum();
            int startNum = (pageNum-1)*pageSize+1;
            int endNum = startNum + pageSize-1;
            List<String> list = ReadSelectedLine.readAppointedLineNumberNew(new ArrayList<>(), sourceFile, startNum, endNum);
            page.setPageList(list);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            e.printStackTrace();
            code = Constants.ERROR;
            msg = "后台出错";
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 获取目录章节
     * @return
     */
    @RequestMapping(value = "v1/auth/read-chapter",method = RequestMethod.GET)
    public Result readChapter(){
        File sourceFile = new File("e://all.txt");
        String code = Constants.FAIL;
        String msg = "初始化";
        Result result = null;
        try {
            result = new Result();
            List<String> list = ReadSelectedLine.readChapter(new ArrayList<>(), sourceFile);
            result.setData(list);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            e.printStackTrace();
            code = Constants.ERROR;
            msg = "后台出错";
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 获取章节内容
     * @param chapter
     * @return
     */
    @RequestMapping(value = "v1/auth/read-chapter-content",method = RequestMethod.GET)
    public Result readChapterContent(String chapter){
        File sourceFile = new File("e://all.txt");
        String code = Constants.FAIL;
        String msg = "初始化";
        Result result = null;
        try {
            result = new Result();
            List<String> list = ReadSelectedLine.readChapterContent(new ArrayList<>(), sourceFile,chapter);
            result.setData(list);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            e.printStackTrace();
            code = Constants.ERROR;
            msg = "后台出错";
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

package com.ancaiyun.controller;

import com.ancaiyun.service.UploadService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * 分页查询上传列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/uploads/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize) {
        return uploadService.listPage(pageNum, pageSize);
    }

    /**
     * 上传文件
     * @param file 文件
     * @return
     */
    @RequestMapping(value = "v1/auth/uploads",method = RequestMethod.POST)
    public Result addOrUpdata(MultipartFile file) {
        return uploadService.addOrUpdate(file);
    }
}

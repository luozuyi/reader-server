package com.ancaiyun.service;

import com.ancaiyun.utils.Result;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * 分页查询上传文件
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize);

    /**
     * 后台添加或修改文件
     * @param file 文件
     * @return
     */
    Result addOrUpdate(MultipartFile file);
}

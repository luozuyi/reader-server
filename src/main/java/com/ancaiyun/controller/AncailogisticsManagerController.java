package com.ancaiyun.controller;

import com.ancaiyun.service.AncailogisticsService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AncailogisticsManagerController {

    @Autowired
    private AncailogisticsService ancailogisticsService;

    /**
     * 分页查询物流列表
     * @param pageNum 当前页数
     * @param pageSize 一页显示多少条
     * @return
     */
    @GetMapping("v1/auth/ancailogistics")
    public Result listPage(Integer pageNum, Integer pageSize){
        return ancailogisticsService.listPage(pageNum, pageSize);
    }
}

package com.ancaiyun.controller;

import com.ancaiyun.entity.Bank;
import com.ancaiyun.service.BankService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankManagerController {

    @Autowired
    private BankService bankService;

    /**
     * 分页查询所有银行
     * @param pageNum 当前页数
     * @param pageSize 每页显示多少条
     * @return
     */
    @GetMapping("v1/auth/banks")
    public Result pageList(Integer pageNum, Integer pageSize){
        return bankService.pageList(pageNum, pageSize);
    }

    /**
     * 添加银行
     * @param bank 银行
     * @return
     */
    @PostMapping("v1/auth/banks")
    public Result addBank(Bank bank){
        return bankService.addBank(bank);
    }

    /**
     * 修改银行查询信息
     * @param id
     * @return
     */
    @GetMapping("v1/auth/banks/detail")
    public Result toUpdateBank(String id){
        return bankService.getById(id);
    }

    /**
     * 修改银行
     * @param bank
     * @return
     */
    @PutMapping("v1/auth/banks")
    public Result updateBank(Bank bank){
        return bankService.updateBank(bank);
    }
}

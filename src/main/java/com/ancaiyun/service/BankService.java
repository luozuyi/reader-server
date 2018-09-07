package com.ancaiyun.service;

import com.ancaiyun.entity.Bank;
import com.ancaiyun.utils.Result;

public interface BankService {

    /**
     * 查询所有银行
     * @param pageNum 当前页数
     * @param pageSize 每页显示多少条
     * @return
     */
    Result pageList(Integer pageNum, Integer pageSize);

    /**
     * 添加银行
     * @param bank 银行
     * @return
     */
    Result addBank(Bank bank);

    /**
     * 根据id查询银行信息
     * @param id 主键id
     * @return
     */
    Result getById(String id);

    /**
     * 修改银行
     * @param bank 银行
     * @return
     */
    Result updateBank(Bank bank);
}

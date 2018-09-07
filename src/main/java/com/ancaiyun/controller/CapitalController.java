package com.ancaiyun.controller;

import com.ancaiyun.service.FreezeDetailService;
import com.ancaiyun.service.IncomeDetailService;
import com.ancaiyun.service.OfflineRemittanceService;
import com.ancaiyun.service.WithdrawService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CapitalController {

    @Autowired
    private OfflineRemittanceService offlineRemittanceService;

    @Autowired
    private WithdrawService withdrawService;

    @Autowired
    private IncomeDetailService incomeDetailService;

    @Autowired
    private FreezeDetailService freezeDetailService;

    /**
     * 分页条件查询线下充值记录
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参数
     * @return
     */
    @GetMapping("v1/auth/offline-remittances")
    public Result offlineRemittancePageList(Integer pageNo, Integer pageSize, @RequestParam Map<String, Object>params){
        return offlineRemittanceService.pageList(pageNo, pageSize, params);
    }

    /**
     * 根据id查询线下充值记录详情
     * @param id 主键id
     * @return
     */
    @GetMapping("v1/auth/offline-remittances/detail")
    public Result getofflineRemittance(String id){
        return offlineRemittanceService.getById(id);
    }

    /**
     * 审核线下充值
     * @param id 主键id
     * @param status 审核状态
     * @param token 用户携带token
     * @return
     */
    @PutMapping("v1/auth/offline-remittances")
    public Result approveOfflineRemittance(String id, String status, String token){
        return offlineRemittanceService.approve(id, status, token);
    }

    /**
     * 分页条件查询提现记录
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参数
     * @return
     */
    @GetMapping("v1/auth/withdraws")
    public Result withdrawPageList(Integer pageNo, Integer pageSize, @RequestParam Map<String, Object>params){
        return withdrawService.pageList(pageNo, pageSize, params);
    }

    /**
     * 审核提现
     * @param id 主键id
     * @param status 提现状态
     * @param note 提现备注
     * @param token 用户携带token
     * @return
     */
    @PutMapping("v1/auth/withdraws")
    public Result arrpoveWithdraw(String id, String status, String note, String token){
        return withdrawService.approve(id, status, note, token);
    }

    /**
     * 分页条件查询会员资金明细
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参赛
     * @return
     */
    @GetMapping("v1/auth/income-details")
    public Result incomeDetailPageList(Integer pageNo, Integer pageSize, @RequestParam Map<String, Object>params){
        return incomeDetailService.pageList(pageNo, pageSize, params);
    }

    /**
     * 分页条件查询会员冻结明细
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参赛
     * @return
     */
    @GetMapping("v1/auth/freeze-details")
    public Result freezeDetailPageList(Integer pageNo, Integer pageSize, @RequestParam Map<String, Object>params){
        return freezeDetailService.pageList(pageNo, pageSize, params);
    }
}

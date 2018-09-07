package com.ancaiyun.bid.controller;/**
 * <p>Title: StatementInvoiceController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 10:52
 */

import com.ancaiyun.bid.service.StatementInvoiceService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:StatementInvoiceController</p>
 * <p>Description: 发票Controller</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 10:52
 */
@RestController
public class StatementInvoiceController {

    @Autowired
    private StatementInvoiceService statementInvoiceService;

    /*
     * @Description 查看全部发票
     * @Date 11:26 2018/5/31
     * @Param
     * @return
     **/

    @RequestMapping(value = "v1/auth/statement-invoices", method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize, @RequestParam Map<String, Object> params) {
        return statementInvoiceService.getAll(pageNum, pageSize, params);
    }


    /*
     * @Description 查看发票详情
     * @Date 11:34 2018/5/31
     * @Param
     * @return
     **/

    @RequestMapping(value = "v1/auth/statement-invoices/detail", method = RequestMethod.GET)
    public Result getDetail(String id) {
        return statementInvoiceService.getDetail(id);
    }


    /*
     * @Description 删除发货单
     * @Date 10:46 2018/6/2
     * @Param
     * @return
     **/


    @RequestMapping(value = "v1/auth/statement-invoices", method = RequestMethod.DELETE)
    public Result delete(String id) {
        return statementInvoiceService.delete(id);
    }
}

package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Bank;
import com.ancaiyun.mapper.BankMapper;
import com.ancaiyun.service.BankService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankMapper bankMapper;

    @Override
    public Result pageList(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Bank> bankList = bankMapper.getList();
            PageInfo<Bank> pageInfo = new PageInfo<>(bankList);
            result.setData(pageInfo);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result addBank(Bank bank) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            Bank selectBank = bankMapper.getByBankName(bank.getBankName());
            if (selectBank == null){
                bank.setId(UUID.randomUUID().toString().replace("-", ""));
                bank.setCreateTime(new Date());
                bank.setDelFlag("0");
                bankMapper.insert(bank);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                code = "-3";
                msg = "该银行已添加";
            }
        } catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result getById(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            if (null != id){
                Bank bank = bankMapper.getById(id);
                result.setData(bank);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                msg = "请先选中银行";
            }
        } catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result updateBank(Bank bank) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            if (bank.getBankName() == null){
                code = "-3";
                msg = "银行名称不能为空";
            } else if (bank.getBankCode() == null){
                code = "-4";
                msg = "银行代码不能为空";
            } else {
                if (null != bank.getId()) {
                    Bank queryBank = bankMapper.getById(bank.getId());
                    queryBank.setBankName(bank.getBankName());
                    queryBank.setBankCode(bank.getBankCode());
                    queryBank.setBankImg(bank.getBankImg());
                    bankMapper.update(queryBank);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
        } catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

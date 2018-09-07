package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Admin;
import com.ancaiyun.entity.FreezeDetail;
import com.ancaiyun.entity.IncomeDetail;
import com.ancaiyun.entity.Member;
import com.ancaiyun.entity.User;
import com.ancaiyun.entity.Withdraw;
import com.ancaiyun.mapper.AdminMapper;
import com.ancaiyun.mapper.FreezeDetailMapper;
import com.ancaiyun.mapper.IncomeDetailMapper;
import com.ancaiyun.mapper.MemberMapper;
import com.ancaiyun.mapper.UserMapper;
import com.ancaiyun.mapper.WithdrawMapper;
import com.ancaiyun.service.WithdrawService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private WithdrawMapper withdrawMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private FreezeDetailMapper freezeDetailMapper;

    @Autowired
    private IncomeDetailMapper incomeDetailMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result pageList(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNo, pageSize);
            List<Withdraw> withdrawList = withdrawMapper.getList(params);
            PageInfo<Withdraw> pageInfo = new PageInfo<>(withdrawList);
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
    public Result approve(String id, String status, String note, String token) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            //String adminId = token.split("_")[1];
            String adminId = "81b51fcf65d2491db72ccc7a5d11ec11";
            Admin admin = adminMapper.selectByPrimaryKey(adminId);
            Withdraw withdraw = withdrawMapper.getById(id);
            if (status == null){
                code = "-2";
                msg = "审核状态不能为空";
            } else if (withdraw == null){
                code = "-3";
                msg = "该记录不存在";
            } else {
                withdraw.setApproveMan(admin.getAdminName());
                withdraw.setApproveTime(new Date());
                withdraw.setStatus(status);
                withdraw.setNote(note);
                withdrawMapper.update(withdraw);

                if ("0".equals(status)){
                    FreezeDetail freezeDetail = freezeDetailMapper.getByRelationIdAndFreezeType(withdraw.getId(), "0");
                    freezeDetail.setStatus("1");
                    freezeDetailMapper.update(freezeDetail);

                    IncomeDetail incomeDetail = new IncomeDetail();
                    incomeDetail.setId(UUID.randomUUID().toString().replace("-", ""));
                    incomeDetail.setCreateTime(new Date());
                    incomeDetail.setDelFlag("0");
                    incomeDetail.setFinanceType("1");
                    incomeDetail.setFlunflow("6");
                    incomeDetail.setMoneyType("2");
                    incomeDetail.setNum(freezeDetail.getFreezeMoney());
                    incomeDetail.setUsername(freezeDetail.getUserName());
                    incomeDetailMapper.insert(incomeDetail);

                    User user = userMapper.selectByUsername(freezeDetail.getUserName());
                    Member member = memberMapper.selectByUserId(user.getId());
                    Double freezeMoney = member.getFreezeMoney();
                    BigDecimal freezeMoneyBigDecimal = new BigDecimal(double2NotNullDouble(freezeMoney));
                    freezeMoneyBigDecimal = freezeMoneyBigDecimal.subtract(withdraw.getWithdrawMoney());
                    member.setFreezeMoney(freezeMoneyBigDecimal.doubleValue());
                    memberMapper.updateByPrimaryKey(member);
                } else if ("-1".equals(status)){
                    FreezeDetail freezeDetail = freezeDetailMapper.getByRelationIdAndFreezeType(withdraw.getId(), "0");
                    freezeDetail.setStatus("1");
                    freezeDetailMapper.update(freezeDetail);

                    IncomeDetail out = new IncomeDetail();
                    out.setId(UUID.randomUUID().toString().replace("-", ""));
                    out.setCreateTime(new Date());
                    out.setDelFlag("0");
                    out.setFinanceType("1");
                    out.setFlunflow("7");
                    out.setMoneyType("2");
                    out.setNum(freezeDetail.getFreezeMoney());
                    out.setUsername(freezeDetail.getUserName());
                    incomeDetailMapper.insert(out);

                    IncomeDetail in = new IncomeDetail();
                    in.setId(UUID.randomUUID().toString().replace("-", ""));
                    in.setCreateTime(new Date());
                    in.setDelFlag("0");
                    in.setFinanceType("0");
                    in.setFlunflow("7");
                    in.setMoneyType("0");
                    in.setNum(freezeDetail.getFreezeMoney());
                    in.setUsername(freezeDetail.getUserName());
                    incomeDetailMapper.insert(in);

                    User user = userMapper.selectByUsername(freezeDetail.getUserName());
                    Member member = memberMapper.selectByUserId(user.getId());
                    Double money = member.getMoney();
                    Double freezeMoney = member.getFreezeMoney();
                    BigDecimal memberMoneyBigDecimal = new BigDecimal(double2NotNullDouble(money));
                    BigDecimal freezeMoneyBigDecimal = new BigDecimal(double2NotNullDouble(freezeMoney));
                    memberMoneyBigDecimal = memberMoneyBigDecimal.add(withdraw.getWithdrawMoney());//可用余额退还
                    freezeMoneyBigDecimal = freezeMoneyBigDecimal.subtract(withdraw.getWithdrawMoney());//冻结资金减少
                    member.setFreezeMoney(freezeMoneyBigDecimal.doubleValue());
                    member.setMoney(memberMoneyBigDecimal.doubleValue());
                    memberMapper.updateByPrimaryKey(member);
                }
                code = Constants.SUCCESS;
                msg = "成功";
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

    public static Double double2NotNullDouble(Double i) {
        return i == null ? 0.0d : i;
    }
}

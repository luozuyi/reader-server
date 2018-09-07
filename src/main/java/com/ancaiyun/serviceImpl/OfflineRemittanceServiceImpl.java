package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Admin;
import com.ancaiyun.entity.IncomeDetail;
import com.ancaiyun.entity.Member;
import com.ancaiyun.entity.OfflineRemittance;
import com.ancaiyun.entity.User;
import com.ancaiyun.mapper.AdminMapper;
import com.ancaiyun.mapper.IncomeDetailMapper;
import com.ancaiyun.mapper.MemberMapper;
import com.ancaiyun.mapper.OfflineRemittanceMapper;
import com.ancaiyun.mapper.UserMapper;
import com.ancaiyun.service.OfflineRemittanceService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class OfflineRemittanceServiceImpl implements OfflineRemittanceService {

    @Autowired
    private OfflineRemittanceMapper offlineRemittanceMapper;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private IncomeDetailMapper incomeDetailMapper;

    @Override
    public Result pageList(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNo, pageSize);
            List<OfflineRemittance> offlineRemittanceList = offlineRemittanceMapper.getList(params);
            PageInfo<OfflineRemittance> pageInfo = new PageInfo<>(offlineRemittanceList);
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
    public Result getById(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            if (null != id){
                OfflineRemittance offlineRemittance = offlineRemittanceMapper.getById(id);
                result.setData(offlineRemittance);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                msg = "该记录不存在";
            }
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
    public Result approve(String id, String status, String token) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            //String adminId = token.split("_")[1];
            String adminId = "81b51fcf65d2491db72ccc7a5d11ec11";
            Admin admin = adminMapper.selectByPrimaryKey(adminId);
            if (null != id){
                OfflineRemittance offlineRemittance = offlineRemittanceMapper.getById(id);
                offlineRemittance.setApproveMan(admin.getAdminName());
                offlineRemittance.setApproveTime(new Date());
                offlineRemittance.setStatus(status);
                User user = userMapper.selectByUsername(offlineRemittance.getUserName());
                Member member = memberMapper.selectByUserId(user.getId());

                if ("0".equals(status)){
                    if (null == member.getMoney() || member.getMoney() == 0){
                        member.setMoney(Double.parseDouble(offlineRemittance.getRemittanceMoney()+""));
                    } else {
                        member.setMoney(member.getMoney()+(Double.parseDouble(offlineRemittance.getRemittanceMoney()+"")));
                    }
                    IncomeDetail incomeDetail = new IncomeDetail();
                    incomeDetail.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    incomeDetail.setCreateTime(new Date());
                    incomeDetail.setDelFlag("0");
                    incomeDetail.setFlunflow("0");
                    incomeDetail.setFinanceType("0");
                    incomeDetail.setNum(offlineRemittance.getRemittanceMoney());
                    incomeDetail.setUsername(offlineRemittance.getUserName());
                    incomeDetail.setMoneyType("0");
                    incomeDetailMapper.insert(incomeDetail);
                }
                memberMapper.updateByPrimaryKey(member);
                offlineRemittanceMapper.update(offlineRemittance);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                msg = "该记录不存在";
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

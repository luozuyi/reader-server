package com.ancaiyun.mapper;

import com.ancaiyun.entity.Bank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BankMapper {

    /**
     * 查询所有银行
     * @return
     */
    public List<Bank> getList();

    /**
     * 根据银行名称查询银行
     * @param bankName
     * @return
     */
    public Bank getByBankName(String bankName);

    /**
     * 添加银行
     * @param bank 银行
     * @return
     */
    public int insert(Bank bank);

    /**
     * 根据id查询银行
     * @param id 主键id
     * @return
     */
    public Bank getById(String id);

    /**
     * 修改银行
     * @param bank 银行
     * @return
     */
    public int update(Bank bank);
}

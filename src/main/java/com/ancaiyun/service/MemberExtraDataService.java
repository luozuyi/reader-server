package com.ancaiyun.service;

import com.ancaiyun.entity.MemberExtraData;
import com.ancaiyun.utils.Result;

public interface MemberExtraDataService {
    /**
     *审核企业信息是否通过
     * @param id 主键id
     * @param extraDataStatus 资料审核状态： 0：审核中 1：审核通过 2：审核失败
     * @return
     */
    Result updateMemberExtraDataStatus(String id,String extraDataStatus);

    /**
     * 修改企业资料
     * @param memberExtraData 要修改的对象
     * @return
     */
    Result updateMemberExtraData(MemberExtraData memberExtraData);
}

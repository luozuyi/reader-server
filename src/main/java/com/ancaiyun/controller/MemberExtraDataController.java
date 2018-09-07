package com.ancaiyun.controller;

import com.ancaiyun.entity.MemberExtraData;
import com.ancaiyun.service.MemberExtraDataService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberExtraDataController {
    @Autowired
    private MemberExtraDataService memberExtraDataService;

    /**
     * 资料审核
     * @param id 资料主键id
     * @param extraDataStatus 资料状态 资料审核状态： 0：审核中 1：审核通过 2：审核失败
     * @return
     */
    @RequestMapping(value = "v1/auth/member-extea-datas/aduition",method = RequestMethod.PATCH)
    public Result updateMemberExtraData(String id, String extraDataStatus) {
        return memberExtraDataService.updateMemberExtraDataStatus(id, extraDataStatus);
    }

    /**
     * 修改企业信息资料
     * @param memberExtraData 修改的资料
     *                        id必填
     * @return
     */
    @RequestMapping(value = "v1/auth/member-extea-datas",method = RequestMethod.PUT)
    public Result updateMemberExtraData(MemberExtraData memberExtraData) {
        return memberExtraDataService.updateMemberExtraData(memberExtraData);
    }
}

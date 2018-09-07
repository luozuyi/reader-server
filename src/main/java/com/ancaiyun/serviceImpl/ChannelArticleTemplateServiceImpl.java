package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.ChannelArticleTemplate;
import com.ancaiyun.mapper.ChannelArticleTemplateMapper;
import com.ancaiyun.service.ChannelArticleTemplateService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class ChannelArticleTemplateServiceImpl implements ChannelArticleTemplateService{
    @Autowired
    private ChannelArticleTemplateMapper channelArticleTemplateMapper;
    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<ChannelArticleTemplate> channelArticleTemplateList = channelArticleTemplateMapper.selectAll();
            PageInfo<ChannelArticleTemplate> page = new PageInfo<>(channelArticleTemplateList);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result addChannelArticleTemplate(String tplUrl, String type) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(type)){
                code = "-3";
                msg = "模板类型不能为空";
            }else if(StringUtils.isBlank(tplUrl)){
                code = "-4";
                msg = "名称不能为空";
            }else if(!"0".equals(type) && !"1".equals(type)){
                code = "-5";
                msg = "请选择模板类型";
            }else {
                if("0".equals(type)){
                    tplUrl = "admin/channelArticleTemplate/articleTemple/"+tplUrl;
                }else if("1".equals(type)){
                    tplUrl = "admin/channelArticleTemplate/channelTemple/"+tplUrl;
                }
                ChannelArticleTemplate channelArticleTemplate_db = channelArticleTemplateMapper.selectByTplUrl(tplUrl);
                if(channelArticleTemplate_db != null){
                    code = "-6";
                    msg = "该模板路径已经存在";
                }else{
                    ChannelArticleTemplate channelArticleTemplate = new ChannelArticleTemplate();
                    channelArticleTemplate.setId(UUID.randomUUID().toString().replace("-", ""));
                    channelArticleTemplate.setCreateTime(new Date());
                    channelArticleTemplate.setDelFlag("0");
                    channelArticleTemplate.setType(type);
                    channelArticleTemplate.setTplUrl(tplUrl);
                    channelArticleTemplateMapper.insertSelective(channelArticleTemplate);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result listPageBySelect(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            params.put("delFlag", "0");
            PageHelperNew.startPage(pageNum, pageSize);
            List<ChannelArticleTemplate> channelArticleTemplateList = channelArticleTemplateMapper.selectAllBySelect(params);
            PageInfo<ChannelArticleTemplate> page = new PageInfo<>(channelArticleTemplateList);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result delChannelArticleTemplate(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "请选择要删除的模板";
            }else{
                ChannelArticleTemplate channelArticleTemplate_db = channelArticleTemplateMapper.selectByPrimaryKey(id);
                if(channelArticleTemplate_db == null){
                    code = "-4";
                    msg = "删除的模板不存在";
                }else{
                    channelArticleTemplate_db.setDelFlag("1");
                    channelArticleTemplateMapper.updateByPrimaryKey(channelArticleTemplate_db);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Article;
import com.ancaiyun.entity.ArticleContent;
import com.ancaiyun.mapper.ArticleContentMapper;
import com.ancaiyun.service.ArticleContentService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ArticleContentServiceImpl implements ArticleContentService {
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<ArticleContent> articleContentList = articleContentMapper.selectAll();
            PageInfo<ArticleContent> page = new PageInfo<>(articleContentList);
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
}

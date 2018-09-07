package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Article;
import com.ancaiyun.entity.ArticleContent;
import com.ancaiyun.entity.Channel;
import com.ancaiyun.entity.ChannelArticleTemplate;
import com.ancaiyun.mapper.ArticleContentMapper;
import com.ancaiyun.mapper.ArticleMapper;
import com.ancaiyun.mapper.ChannelArticleTemplateMapper;
import com.ancaiyun.mapper.ChannelMapper;
import com.ancaiyun.service.ArticleService;
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
import java.util.UUID;

@Transactional
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private ChannelArticleTemplateMapper channelArticleTemplateMapper;
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Article> articleList = articleMapper.selectAll();
            PageInfo<Article> page = new PageInfo<>(articleList);
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
    public Result delById(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
           if(StringUtils.isBlank(id)){
               code = "-3";
               msg = "请选择要删除的对象";
           }else{
               Article article_db = articleMapper.selectByPrimaryKey(id);
               if(article_db == null){
                   code = "-4";
                   msg = "删除的对象不存在";
               }else{
                   article_db.setDelFlag("1");
                   articleMapper.updateByPrimaryKeySelective(article_db);
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
    public Result addArticle(Article article, String content) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(article.getChannelId())){
                code = "-3";
                msg = "栏目不能为空";
            }else if(StringUtils.isBlank(article.getChannelArticleTemplateId())){
                code = "-4";
                msg = "模板不能为空";
            }else{
                Channel channel = channelMapper.selectByPrimaryKey(article.getChannelId());
                ChannelArticleTemplate channelArticleTemplate = channelArticleTemplateMapper.selectByPrimaryKey(article.getChannelArticleTemplateId());
                if(channel == null){
                    code = "-5";
                    msg = "选择的栏目不存在";
                }else if(channelArticleTemplate == null){
                    code = "-6";
                    msg = "选择的模板不存在";
                }else if(StringUtils.isBlank(content)){
                    code = "-7";
                    msg = "内容不能为空";
                }else if(StringUtils.isBlank(article.getTitle())){
                    code = "-8";
                    msg = "标题不能为空";
                }else{
                    article.setId(UUID.randomUUID().toString().replace("-", ""));
                    article.setDelFlag("0");
                    article.setCreateTime(new Date());
                    String articleContentId = UUID.randomUUID().toString().replace("-", "");
                    article.setArticleContentId(articleContentId);
                    articleMapper.insertSelective(article);

                    ArticleContent articleContent = new ArticleContent();
                    articleContent.setId(articleContentId);
                    articleContent.setContent(content);
                    articleContentMapper.insertSelective(articleContent);

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
    public Result updateArticle(Article article, String content) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(article.getChannelId())){
                code = "-3";
                msg = "栏目不能为空";
            }else if(StringUtils.isBlank(article.getChannelArticleTemplateId())){
                code = "-4";
                msg = "模板不能为空";
            }else{
                Channel channel = channelMapper.selectByPrimaryKey(article.getChannelId());
                ChannelArticleTemplate channelArticleTemplate = channelArticleTemplateMapper.selectByPrimaryKey(article.getChannelArticleTemplateId());
                if(channel == null){
                    code = "-5";
                    msg = "选择的栏目不存在";
                }else if(channelArticleTemplate == null){
                    code = "-6";
                    msg = "选择的模板不存在";
                }else if(StringUtils.isBlank(content)){
                    code = "-7";
                    msg = "内容不能为空";
                }else if(StringUtils.isBlank(article.getTitle())){
                    code = "-8";
                    msg = "标题不能为空";
                }else if(StringUtils.isBlank(article.getId())){
                    code = "-9";
                    msg = "主键不能为空";
                }else{
                    Article article1_db = articleMapper.selectByPrimaryKey(article.getId());
                    if(article1_db == null){
                        code = "-10";
                        msg = "修改的文章对象不存在";
                    }else{
                        articleMapper.updateByPrimaryKeySelective(article1_db);
                        String articleContentId = article1_db.getArticleContentId();
                        ArticleContent articleContent = articleContentMapper.selectByPrimaryKey(articleContentId);
                        articleContent.setContent(content);
                        articleContentMapper.updateByPrimaryKeySelective(articleContent);
                        code = Constants.SUCCESS;
                        msg = "成功";
                    }
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

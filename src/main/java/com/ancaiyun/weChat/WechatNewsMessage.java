package com.ancaiyun.weChat;

import java.util.List;

/** 
 * 文本消息 
 *  
 * @author liufeng 
 * @date 2013-05-19 
 */  
public class WechatNewsMessage extends BaseWechatMessage {
	// 图文消息个数，限制为10条以内  
    private int ArticleCount;  
    // 多条图文消息信息，默认第一个item为大图  
    private List<Article> Articles;  
  
    public int getArticleCount() {  
        return ArticleCount;  
    }  
  
    public void setArticleCount(int ArticleCount) {  
        this.ArticleCount = ArticleCount;  
    }  
  
    public List<Article> getArticles() {  
        return Articles;  
    }  
  
    public void setArticles(List<Article> Articles) {  
        this.Articles = Articles;  
    }  
}

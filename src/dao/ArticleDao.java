package dao;

import pojo.Article;

import java.util.List;
import java.util.Map;

/**
 * 类<code>ArticleDao</code>用于:定义Article类相关操作所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
 */
public interface ArticleDao {
    public Article queryonearticle(int id);
    public List<Map<String, Object>>queryallarticle(int id) throws Exception;
    public void savearticle(String json) throws Exception;
    public int queryCommentCount(String title) throws Exception;
    public void updateCommentCount(String title,int commentCount);
    public int quertStudentNo(String title);
    public String queryArticleByAuthor(List<String> author);
}

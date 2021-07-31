package dao;

import pojo.Article;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
 */
public interface ArticleDao {
    public Article queryonearticle(String title,int _id);
    public Article queryallarticle(String title,int _id);
    public Article savearticle(String title,String body,int _id);
}

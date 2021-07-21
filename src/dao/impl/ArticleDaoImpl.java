package dao.impl;

import dao.ArticleDao;
import pojo.Article;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-21
 */
public class ArticleDaoImpl extends BaseDao implements ArticleDao {
    @Override
    public Article queryArticleById(int id) {
        String sql = "select `id`, `title`, `author`, `content` from article where id = ?";
        return queryForOne(Article.class, sql, id);
    }

    @Override
    public Article queryArticleByIdAndAuthor(int id, String author) {
        String sql = "select `id`, `title`, `author`, `content` from article where id = ? and author = ?";
        return queryForOne(Article.class, sql, id, author);
    }

    @Override
    public int saveArticle(Article article) {
        String sql = "insert into article(`title`,`author`,`content`) values(?,?,?)";
        return update(sql, article.getTitle(),article.getAuthor(),article.getContent());
    }
}

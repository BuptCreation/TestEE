package dao;

import pojo.Article;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-21
 */
public interface ArticleDao {


    /**
     * 根据文章id查询文章信息
     * @param id 文章id
     * @return 如果返回null,说明没有这个文章。反之亦然
     */


    public Article queryArticleById(int id);


    /**
     * 根据 作者和id查询文章信息
     * @param id
     * @param author
     * @return 如果返回null,说明author或者是id错误,反之亦然
     */


    public Article queryArticleByIdAndAuthor(int id, String author);


    /**
     * 保存文章信息
     * @param article
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */


    public int saveArticle(Article article);
}

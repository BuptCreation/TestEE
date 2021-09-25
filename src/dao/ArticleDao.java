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


    /**
     * 查找所有文章
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<Article> queryallarticle() throws Exception;

    /**
     * 更新文章评论数
     * @throws Exception
     */
    public void freshCommentCount(String textno) throws Exception;

    /**
     * 增加文章评论数，自增一
     *
     * @param textno
     */
    public void updateCommentCount(String textno) throws Exception;

    /**
     * 更新平均分
     *
     * @param textno
     * @param averagepoint
     * @throws Exception
     */
    public void updateAverageVocabularyPoint(String textno, double averagepoint) throws Exception;

    /**
     * 更新平均分
     * @param textno
     * @param averagepoint
     * @throws Exception
     */
    public void updateAverageFluentPoint(String textno,double averagepoint) throws Exception;
    /**
     * 更新平均分
     * @param textno
     * @param averagepoint
     * @throws Exception
     */
    public void updateAverageVarietyPoint(String textno,double averagepoint) throws Exception;
    /**
     * 更新平均分
     * @param textno
     * @param averagepoint
     * @throws Exception
     */
    public void updateAverageCompletePoint(String textno,double averagepoint) throws Exception;

    /**
     * 更新浏览次数
     * @param textno
     * @throws Exception
     */
    public void updateBrowseTimes(String textno) throws Exception;

    /**
     * 根据文章号查询小组号
     * @param textno
     * @return
     * @throws Exception
     */
    public String queryGroupidByTextno(String textno) throws Exception;
}

package dao;

import pojo.Comment;

import java.util.List;
import java.util.Map;

/**
 * 类<code>CommentDao</code>用于:定义Comment类相关操作所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public interface CommentDao {
    /**
     * 查找并显示所有的评论
     *
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> queryallcomment() throws Exception;

    /**
     * 保存评论
     *
     * @param comment
     * @throws Exception
     */
    public void saveComment(Comment comment) throws Exception;

    /**
     * 获取对应文章的评论个数
     *
     * @param textno
     * @return 评论个数
     */
    public int getCommentCount(String textno) throws Exception;

    /**
     * 获取一篇文章的所有vocabulary评分
     *
     * @param textno
     * @return
     */
    public int getAllvocabularypoints(String textno);

    /**
     * 获取一篇文章的所有fluent评分
     *
     * @param textno
     * @return
     */
    public int getAllfluentpoints(String textno);

    /**
     * 获取一篇文章的所有variety评分
     *
     * @param textno
     * @return
     */
    public int getAllvarietypoints(String textno);

    /**
     * 获取一篇文章的所有complete评分
     *
     * @param textno
     * @return
     */
    public int getAllcompletepoints(String textno);
}

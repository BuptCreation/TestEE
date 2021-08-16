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
    public List<Map<String, Object>> queryallcomment()throws Exception;
    public void savecomment(String json)throws Exception;
}

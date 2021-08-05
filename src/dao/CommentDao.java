package dao;

import pojo.Comment;

import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public interface CommentDao {
    public List<Map<String, Object>> queryallcomment()throws Exception;
    public void savecomment(String json)throws Exception;
}

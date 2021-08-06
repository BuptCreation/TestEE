package service;

import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-22
 */
public interface CommentService {
    public List<Map<String, Object>> getComments(String json) throws Exception;
}

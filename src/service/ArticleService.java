package service;

import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-16
 */
public interface ArticleService {
    public List<Map<String, Object>> getArticles() throws Exception;
}

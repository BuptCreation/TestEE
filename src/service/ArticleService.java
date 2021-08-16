package service;

import java.util.List;
import java.util.Map;

/**
 * 类<code>ArticleService</code>用于:定义Article类相关服务所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
 */
public interface ArticleService {
    public List<Map<String, Object>> getArticles() throws Exception;
}

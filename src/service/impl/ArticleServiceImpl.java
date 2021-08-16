package service.impl;

import com.mongodb.client.MongoDatabase;
import service.ArticleService;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.util.List;
import java.util.Map;

/**
 * 类<code>ArticleServiceImpl</code>用于:实现Article类相关服务所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
 */
public class ArticleServiceImpl implements ArticleService {
    @Override
    public List<Map<String, Object>> getArticles() throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        String table = "buptarticle";
        MongoDatabase db = MongoHelper.getMongoDataBase();
        List<Map<String, Object>> articles = mongoDao.queryAll(db,table);
        return articles;
    }
}

package test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.ArticleDao;
import dao.NewsDao;
import dao.impl.ArticleDaoImpl;
import dao.impl.NewsDaoImpl;
import org.junit.Test;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-14
 */
public class DataTest {
    @Test
    public void addNews() {
        for (int i = 1; i <= 10; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", "comment");
            jsonObject.addProperty("title", "test" + i);
            jsonObject.addProperty("content", "测试数据在此" + i);
            jsonObject.addProperty("isComment", false);
            jsonObject.addProperty("extraInfo", "搞快点，摸🐟者斩" + i);
            jsonObject.addProperty("studentNo", 123456);
            String json = new Gson().toJson(jsonObject);
            NewsDao newsDao = new NewsDaoImpl();
            newsDao.addNews(json);
        }
    }

    @Test
    public void addArticles() {
        for (int i = 1; i <= 10; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id",123456);
            jsonObject.addProperty("title","测试数据"+i);
            jsonObject.addProperty("author","student168");
            jsonObject.addProperty("content","我爱JavaWeb!我们JavaWeb真是太厉害啦！");
            jsonObject.addProperty("commentCount",0);
            String json = new Gson().toJson(jsonObject);
            ArticleDao articleDao = new ArticleDaoImpl();
            try {
                articleDao.savearticle(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

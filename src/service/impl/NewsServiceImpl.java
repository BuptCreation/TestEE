package service.impl;

import com.google.gson.Gson;
import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import pojo.News;
import service.NewsService;
import utils.JsonConverter;

import java.util.List;
import java.util.Map;

/**
 * 类<code>NewsServiceImpl</code>用于:实现News类相关服务所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
 */
public class NewsServiceImpl implements NewsService {
    @Override
    public String loadNews(String username) {
        NewsDao newsDao = new NewsDaoImpl();
        List<News> newsList = newsDao.getNews(username);
        return new Gson().toJson(newsList);
    }
}

package dao;

import pojo.News;

import java.util.List;
import java.util.Map;

/**
 * 类<code>NewsDao</code>用于:定义News类相关操作所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public interface NewsDao {
    /**
     * 根据用户名查找对应的消息
     * @param username
     * @return List<News>
     */
    public List<News> getNews(String username);

    /**
     * 添加消息
     * @param json
     */
    public void addNews(News news);

    /**
     * 删除消息
     */
    public void deleteNews(String username, String date);

    /**
     * 更新用户消息
     * @param studentno
     * @param count
     * @param title
     */
    public void updateNews(String studentno,int count,String title);

    /**
     * 生成消息
     * @param studentno
     */
    public void initNews(String studentno);
}

package dao;

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
    public List<Map<String, Object>> getNews(int studentNo);
    public void addNews(String json);
    public void deleteNews();
    public void updateNews(int studentNo,int count,String title);
    public void initNews(int studentNo);
}

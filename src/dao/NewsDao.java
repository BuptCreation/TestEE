package dao;

import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
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
}

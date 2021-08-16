package dao;

import pojo.Group;

import java.util.List;
import java.util.Map;

/**
 * 类<code>GroupDao</code>用于:定义Group类相关操作所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-07-13
 */
public interface GroupDao {
    public List<Map<String, Object>> queryGroup(String teacherName) throws Exception;
    public void saveGroup(String json) throws Exception;
    public void updateSpeeches(String json) throws Exception;
    public int querySpeeches(int id) throws Exception;
    public List<String> queryAuthor(String teachername);
}

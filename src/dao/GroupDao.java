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
    /**
     * 查找老师管理的所有小组
     * @param teacherName
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> queryGroup(String teacherName) throws Exception;

    /**
     * 保存小组
     * @param json
     * @throws Exception
     */
    public void saveGroup(String json) throws Exception;

    /**
     * 增加发言次数
     * @param json
     * @throws Exception
     */
    public void updateSpeeches(String json) throws Exception;

    /**
     * 查找发言次数
     * @param id
     * @return
     * @throws Exception
     */
    public int querySpeeches(String id) throws Exception;

    /**
     * 查找作者
     * @param teachername
     * @return
     */
    public List<String> queryAuthor(String teachername);

    /**
     * 根据学号查找对应小组
     * @param studentno
     * @return
     */
    public String queryGroupIdByNo(String studentno) throws Exception;

    /**
     * 随机分配小组进行评论打分
     * @param groupid
     * @return
     * @throws Exception
     */
    public List<String> RandomGroupId(String groupid,int times) throws Exception;

    /**
     * 用小组号查找对应的作者们
     * @param groupid
     * @return
     * @throws Exception
     */
    public List<String> queryAuthorByGroupId(String groupid) throws Exception;
}

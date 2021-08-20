package service;

import java.util.List;

/**
 * 类<code>GroupService</code>用于:定义Group类相关服务所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
 */
public interface GroupService {
    public String loadGroup(String teacherName);
    public List<String> queryGroupStudent(String username);
    public void deleteGroup(Integer groupId);
    public void deleteStudent(Integer studentsId,String studentsName, Integer groupId);
}

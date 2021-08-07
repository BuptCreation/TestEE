package service;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-07-14
 */
public interface GroupService {
    public String loadGroup(String teacherName);
    public void deleteGroup(Integer groupId);
    public void deleteStudent(Integer studentsId,String studentsName, Integer groupId);
}

package service;


import pojo.String;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(String user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public String login(String user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(java.lang.String username);

    /**
     * 查找学生所对应的小组好以及教师名字
     * @param studentId
     * @return 如果返回Null，说明没有找到
     */
    public java.lang.String queryGroupIdAndTeacherName(int studentId)throws Exception;
}

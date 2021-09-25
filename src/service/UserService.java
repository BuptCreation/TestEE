package service;


import pojo.User;
/**
 * 类<code>UserService</code>用于:定义User类相关服务所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);

    /**
     * 查找学生所对应的小组号以及教师名字
     * @param studentId
     * @return 如果返回Null，说明没有找到
     */
    public String queryGroupIdAndTeacherName(int studentId)throws Exception;

    /**
     * 查找学生所对应的小组号
     * @param studentId
     * @return
     * @throws Exception
     */
    public String queryGroupId(int studentId) throws Exception;
}

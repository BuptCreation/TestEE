package dao;


import pojo.User;

import java.util.List;
/**
 * 类<code>UserDao</code>用于:定义User类相关操作所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public interface UserDao {



    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null,说明没有这个用户。反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 根据 用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回null,说明用户名或密码错误,反之亦然
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存学生信息
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveStudent(User user);

    /**
     * 查找对应身份的用户
     * @param identity
     * @return
     */
    public List<User> querybyIdentity(String identity);

    /**
     * Mongo的保存用户
     * @param user
     */
    public void MongosaveUser(User user);

    /**
     * 保存教师信息
     * @param user
     * @return
     */
    public int saveTeacher(User user);
}

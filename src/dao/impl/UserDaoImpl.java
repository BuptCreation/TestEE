package dao.impl;


import dao.UserDao;
import pojo.User;

import java.util.List;

/**
 * 类<code>UserDaoImpl</code>用于：实现UserDao类接口
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`nickname`,`password`,`email`,`identity`,`studentNo` from user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`nickname`,`password`,`email`,`identity`,`studentNo` from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveStudent(User user) {
        String sql = "insert into user(`username`,`password`,`nickname`,`email`,`identity`,`studentNo`) values(?,?,?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getIdentity(), user.getStudentno());
    }

    @Override
    public List<User> querybyIdentity(String identity) {
        String sql = "select username from user where identity = ?";
        return queryForList(User.class, sql, identity);
    }

    @Override
    public int saveTeacher(User user) {
        String sql = "insert into user(`username`,`nickname`,`password`,`email`,`identity`) values(?,?,?,?)";
        return update(sql, user.getUsername(), user.getNickname(), user.getPassword(), user.getEmail(), user.getIdentity());
    }


}

package dao.impl;


import dao.UserDao;
import pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email`,`identity` from user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email`,`identity` from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(`username`,`password`,`email`,`identity`,`studentNo`) values(?,?,?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getIdentity(),user.getStudentNo());
    }

    @Override
    public List<User> querybyIdentity(String identity) {
        String sql = "select username from user where identity = ?";
        return  queryForList(User.class,sql,identity);
    }
}

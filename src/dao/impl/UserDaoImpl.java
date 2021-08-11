package dao.impl;


import dao.UserDao;
import pojo.String;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public String queryUserByUsername(java.lang.String username) {
        java.lang.String sql = "select `id`,`username`,`password`,`email`,`identity`,`studentNo` from user where username = ?";
        return queryForOne(String.class, sql, username);
    }

    @Override
    public String queryUserByUsernameAndPassword(java.lang.String username, java.lang.String password) {
        java.lang.String sql = "select `id`,`username`,`password`,`email`,`identity`,`studentNo` from user where username = ? and password = ?";
        return queryForOne(String.class, sql, username,password);
    }

    @Override
    public int saveUser(String user) {
        java.lang.String sql = "insert into user(`username`,`password`,`email`,`identity`,`studentNo`) values(?,?,?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getIdentity(),user.getStudentNo());
    }

    @Override
    public List<String> querybyIdentity(java.lang.String identity) {
        java.lang.String sql = "select username from user where identity = ?";
        return  queryForList(String.class,sql,identity);
    }
}

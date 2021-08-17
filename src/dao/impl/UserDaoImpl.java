package dao.impl;


import com.mongodb.client.MongoDatabase;
import dao.UserDao;
import org.bson.Document;
import pojo.User;
import utils.JsonConverter;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

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
        String sql = "select `id`,`username`,`password`,`email`,`identity`,`studentNo` from user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username,String password) {
        String sql = "select `id`,`username`,`password`,`email`,`identity`,`studentNo` from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int saveStudent(User user) {
        String sql = "insert into user(`username`,`password`,`email`,`identity`,`studentNo`) values(?,?,?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getIdentity(),user.getStudentNo());
    }

    @Override
    public List<User> querybyIdentity(String identity) {
        String sql = "select username from user where identity = ?";
        return  queryForList(User.class,sql,identity);
    }

    @Override
    public void MongosaveUser(User user) {
        String json = new JsonConverter().userJson(user);
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "user";
        Document document = Document.parse(json);
        try {
            mongoDao.insert(db, table, document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("插入成功！");
    }

    @Override
    public int saveTeacher(User user) {
        String sql = "insert into user(`username`,`password`,`email`,`identity`) values(?,?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getIdentity());
    }


}

package service.impl;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.bson.Document;
import pojo.User;
import service.UserService;
import utils.*;

import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(java.lang.String username) {

        if (userDao.queryUserByUsername(username) == null) {
           // 等于null,说明没查到，没查到表示可用
           return false;
        }

        return true;

    }

    @Override
    public java.lang.String queryGroupIdAndTeacherName(int studentId) throws Exception{
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        BasicDBObject studentIdObj = new BasicDBObject("id",studentId);
        java.lang.String table = "buptgroup";
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(studentIdObj);
        Map<java.lang.String, Object> jsonStrToMap = null;
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            java.lang.String jsonString = user.toJson();
            jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);// 这里用到我自己写的方法,主要是包json字符串转换成map格式,为后面做准备,方法放在后面
        }
        System.out.println(jsonStrToMap);
        java.lang.String json = new Gson().toJson(jsonStrToMap);
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        return jsonObject.get("groupId").getAsString() + jsonObject.get("teacherUsername").getAsString();
    }

}

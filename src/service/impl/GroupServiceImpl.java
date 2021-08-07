package service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import dao.GroupDao;
import dao.impl.GroupDaoImpl;
import pojo.Group;
import service.GroupService;
import utils.JsonConverter;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-07-14
 */
public class GroupServiceImpl implements GroupService {
    @Override
    public String loadGroup(String teacherName) {
        List<JsonArray> jsonArrayList = new ArrayList<JsonArray>();
        Gson gson = new Gson();
        try {
            GroupDaoImpl groupDao = new GroupDaoImpl();
            List<Map<String, Object>> groupList = groupDao.queryGroup(teacherName);
            String json = new JsonConverter().convertToJson(groupList);
            JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
            jsonArrayList.add(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(jsonArrayList);
    }

    @Override
    public void deleteGroup(Integer groupId) {
        BasicDBObject query = new BasicDBObject("groupId",groupId);
        MongoDaoImpl mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        try {
            mongoDao.delete(db,table,query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Integer studentsId, String studentsName, Integer groupId) {
        BasicDBObject studentsIdObj = new BasicDBObject("studentsId",studentsId);
        BasicDBObject studentsNameObj = new BasicDBObject("studentsName",studentsName);
        BasicDBObject groupIdObj = new BasicDBObject("groupId",groupId);
        BasicDBObject andObj = new BasicDBObject("$and", Arrays.asList(studentsNameObj,studentsIdObj,groupIdObj));
        MongoDaoImpl mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        try {
            mongoDao.delete(db,table,andObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

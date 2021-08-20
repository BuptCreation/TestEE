package service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import dao.GroupDao;
import dao.impl.GroupDaoImpl;
import org.bson.Document;
import pojo.Group;
import service.GroupService;
import utils.JsonConverter;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 类<code>GroupServiceImpl</code>用于:实现Group类相关服务所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
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
    public List<String> queryGroupStudent(String username) {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        List<String> result = new ArrayList<String>();
        String table = "buptgroup";
        BasicDBObject studentnameObj = new BasicDBObject("studentname", username);
        try {
            List<Map<String, Object>> querylist = mongoDao.queryByDoc(db, table, studentnameObj);
            System.out.println(querylist);
            int groupid = (int) querylist.get(0).get("groupid");
            BasicDBObject groupidObj = new BasicDBObject("groupid",groupid);
            List<Map<String, Object>> querylist2 = mongoDao.queryByDoc(db,table,groupidObj);
            for (int i = 0; i < querylist2.size(); i++) {
                String tempusername = querylist2.get(i).get("studentname").toString();
                result.add(tempusername);
            }
            result.remove(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void deleteGroup(Integer groupId) {
        BasicDBObject query = new BasicDBObject("groupid", groupId);
        MongoDaoImpl mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        try {
            mongoDao.delete(db, table, query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Integer studentsId, String studentsName, Integer groupId) {
        BasicDBObject studentsIdObj = new BasicDBObject("studentno", studentsId);
        BasicDBObject studentsNameObj = new BasicDBObject("studentname", studentsName);
        BasicDBObject groupIdObj = new BasicDBObject("groupid", groupId);
        BasicDBObject andObj = new BasicDBObject("$and", Arrays.asList(studentsNameObj, studentsIdObj, groupIdObj));
        MongoDaoImpl mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        try {
            mongoDao.delete(db, table, andObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int queryuserGroupid(String username) {
        int id = 0;
        BasicDBObject usernameObj = new BasicDBObject("studentname",username);
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            List<Map<String, Object>> list = mongoDao.queryByDoc(db,table,usernameObj);
            if(list.size()==0){
                return 0;
            }
            else {
                String json = new Gson().toJson(list.get(0));
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                id = jsonObject.get("groupid").getAsInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void updatelogins(String username) {
        BasicDBObject usernameObj = new BasicDBObject("studentname",username);
        BasicDBObject updateDoc = new BasicDBObject("logins",1);
        BasicDBObject doc = new BasicDBObject("$inc",updateDoc);
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        MongoCollection<Document> collection = db.getCollection(table);
        try {
            UpdateResult updateManyResult = collection.updateMany(usernameObj,doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

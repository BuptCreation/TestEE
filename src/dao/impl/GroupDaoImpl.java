package dao.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dao.GroupDao;
import org.bson.Document;
import pojo.Group;
import utils.JsonStrToMap;
import utils.MongoDao;
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
 * @date 2021-08-07-13
 */
public class GroupDaoImpl implements GroupDao {

    @Override
    public List<Map<String, Object>> queryGroup(String teacherName) throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        BasicDBObject teacherNameObj = new BasicDBObject("teacherUsername",teacherName);
        BasicDBObject groupIdObj = new BasicDBObject("groupId",1);
        String table = "buptgroup";
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(teacherNameObj).sort(groupIdObj);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            String jsonString = user.toJson();
            Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
            list.add(jsonStrToMap);
        }
        return list;
    }

    @Override
    public void saveGroup(String json) throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        Document document = Document.parse(json);
        mongoDao.insert(db, table, document);
        System.out.println("插入成功！");
    }

    @Override
    public void updateSpeeches(String json) throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        int speeches = jsonObject.get("count").getAsInt();
        int id = jsonObject.get("id").getAsInt();
        int total = speeches+querySpeeches(id);
        BasicDBObject query = new BasicDBObject("id",id);
        BasicDBObject updateObj = new BasicDBObject("speeches",total);
        mongoDao.updateOne(db,table,query,updateObj);
        System.out.println("更新成功！你本次说了： "+speeches+"句话。");
    }

    @Override
    public int querySpeeches(int id) throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        BasicDBObject query = new BasicDBObject("id",id);
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(query);
        Map<String, Object> jsonStrToMap = null;
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            String jsonString = user.toJson();
            jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);// 这里用到我自己写的方法,主要是包json字符串转换成map格式,为后面做准备,方法放在后面
        }
        String json = new Gson().toJson(jsonStrToMap);
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        return jsonObject.get("speeches").getAsInt();
    }


}
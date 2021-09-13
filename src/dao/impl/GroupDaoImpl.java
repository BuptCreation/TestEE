package dao.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.LazyDBList;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.GroupDao;
import org.bson.Document;
import utils.JsonStrToMap;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.util.*;

/**
 * 类<code>GroupDaoImpl</code>用于:实现Group类相关操作所需要的一系列基础函数
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
        BasicDBObject teacherNameObj = new BasicDBObject("teachername", teacherName);
        BasicDBObject groupIdObj = new BasicDBObject("groupId", 1);
        String table = "buptgroup";
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(teacherNameObj).sort(groupIdObj);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Document user : iterable) {
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
        String id = jsonObject.get("studentno").getAsString();
        int total = speeches + querySpeeches(id);
        BasicDBObject query = new BasicDBObject("studentno", id);
        BasicDBObject updateObj = new BasicDBObject("speeches", total);
        mongoDao.updateOne(db, table, query, updateObj);
        System.out.println("更新成功！你本次说了： " + speeches + "句话。");
    }

    @Override
    public int querySpeeches(String id) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        BasicDBObject query = new BasicDBObject("studentno", id);
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(query);
        Map<String, Object> jsonStrToMap = null;
        for (Document user : iterable) {
            String jsonString = user.toJson();
            jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);// 这里用到我自己写的方法,主要是包json字符串转换成map格式,为后面做准备,方法放在后面
        }
        String json = new Gson().toJson(jsonStrToMap);
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        return jsonObject.get("speeches").getAsInt();
    }

    @Override
    public List<String> queryAuthor(String teachername) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";

        BasicDBObject query = new BasicDBObject("teacherUsername", teachername);
        BasicDBObject groupIdObj = new BasicDBObject("groupid", 1);
        List<String> list = new ArrayList<String>();
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(query).projection(new BasicDBObject("studentname", 1)).sort(groupIdObj);
        for (Document user : iterable) {
            String jsonString = user.toJson();
            JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
            String studentname = jsonObject.get("studentname").getAsString();
            list.add(studentname);
        }
        return list;
    }

    @Override
    public String queryGroupIdByNo(String studentno) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        MongoDao mongoDao = new MongoDaoImpl();
        List<Map<String, Object>> list = new ArrayList<>();
        String table = "buptgroup";
        BasicDBObject studentnoObj = new BasicDBObject("studentno", studentno);
        list = mongoDao.queryByDoc(db, table, studentnoObj);
        if (list.size() == 1)
            return list.get(0).get("groupid").toString();
        else
            return null;
    }

    @Override
    public List<String> RandomGroupId(String groupid, int times) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "group";
        BasicDBObject groupidObj = new BasicDBObject("groupid", groupid);
        List<Map<String, Object>> list;
        List<String> resList = new ArrayList<>(); //所有小组
        List<Integer> randomList = new ArrayList<>(); //随机数
        MongoDao mongoDao = new MongoDaoImpl();
        list = mongoDao.queryByDoc(db, table, groupidObj);//所有组员
        for (int j = 0; j < list.size(); j++) {
            resList.add(list.get(j).get("groupid").toString());
        }
        Set<String> groupidset = new HashSet<>(resList);
        List<String> ultiList = new ArrayList<>(groupidset);
        ultiList.remove(groupid);
        Random random = new Random();//随机数
        int group = Integer.parseInt(groupid);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            int temp = random.nextInt(ultiList.size());
            stringList.add(ultiList.get(temp));
        }
        return stringList;
    }

    @Override
    public List<String> queryAuthorByGroupId(String groupid) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        List<String> list = new ArrayList<>();
        List<Map<String, Object>> mapList;
        BasicDBObject groupidObj = new BasicDBObject("groupid", Integer.parseInt(groupid));
        MongoDao mongoDao = new MongoDaoImpl();
        mapList = mongoDao.queryByDoc(db, table, groupidObj);
        for (int i = 0; i < mapList.size(); i++) {
            String author = mapList.get(i).get("studentname").toString();
            list.add(author);
        }
        return list;
    }
}

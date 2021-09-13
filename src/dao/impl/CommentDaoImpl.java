package dao.impl;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dao.CommentDao;
import org.bson.Document;
import pojo.Comment;
import utils.JsonStrToMap;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类<code>CommentDaoImpl</code>用于:实现Comment类相关操作所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Map<String, Object>> queryallcomment() throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "comment";
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find();

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
    public void saveComment(Comment comment) throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "comment";
        String Json = new Gson().toJson(comment);
        Document document = Document.parse(Json);
        try {
            if (mongoDao.insert(db, table, document))
                System.out.println("插入成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCommentCount(String textno) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "comment";
        BasicDBObject doc = new BasicDBObject("textno",textno);
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(doc);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Document user : iterable) {
            String jsonString = user.toJson();
            Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
            list.add(jsonStrToMap);
        }
        return list.size();
    }

    @Override
    public int getAllvocabularypoints(String textno) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "comment";
        int allpoints = 0;
        BasicDBObject doc = new BasicDBObject("textno",textno);
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(doc);
        for (Document user : iterable) {
            String jsonString = user.toJson();
            Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
            allpoints += Integer.parseInt(jsonStrToMap.get("vocabulary").toString());
        }
        return allpoints;
    }

    @Override
    public int getAllfluentpoints(String textno) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "comment";
        int allpoints = 0;
        BasicDBObject doc = new BasicDBObject("textno",textno);
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(doc);
        for (Document user : iterable) {
            String jsonString = user.toJson();
            Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
            allpoints += Integer.parseInt(jsonStrToMap.get("fluent").toString());
        }
        return allpoints;
    }

    @Override
    public int getAllvarietypoints(String textno) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "comment";
        int allpoints = 0;
        BasicDBObject doc = new BasicDBObject("textno",textno);
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(doc);
        for (Document user : iterable) {
            String jsonString = user.toJson();
            Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
            allpoints += Integer.parseInt(jsonStrToMap.get("variety").toString());
        }
        return allpoints;
    }

    @Override
    public int getAllcompletepoints(String textno) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "comment";
        int allpoints = 0;
        BasicDBObject doc = new BasicDBObject("textno",textno);
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(doc);
        for (Document user : iterable) {
            String jsonString = user.toJson();
            Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
            allpoints += Integer.parseInt(jsonStrToMap.get("complete").toString());
        }
        return allpoints;
    }

}

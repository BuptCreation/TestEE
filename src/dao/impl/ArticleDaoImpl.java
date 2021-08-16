package dao.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dao.ArticleDao;
import org.bson.Document;
import org.bson.types.ObjectId;
import pojo.Article;
import utils.*;

import java.util.*;

/**
 * 类<code>ArticleDaoImpl</code>用于:实现Article类相关操作所需要的一系列基础函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-04-22
 */
public class ArticleDaoImpl implements ArticleDao {

    @Override
    public Article queryonearticle(int id) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptarticle";
        MongoCollection<Document> collection = db.getCollection(table);
        Document document = collection.find(new BasicDBObject("id",id)).first();
        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(Collections.singletonList(document));
        Gson gson = new Gson();
        Article article = gson.fromJson(output, Article.class);
        return article;
    }

    @Override
    public List<Map<String, Object>> queryallarticle(int id) throws Exception{
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptarticle";
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(new BasicDBObject("id", id));
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
    public void savearticle(String json) throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptarticle";
        Document document = Document.parse(json);
        mongoDao.insert(db, table, document);
        System.out.println("插入成功！");
    }

    @Override
    public int queryCommentCount(String title) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptarticle";
        MongoCollection<Document> collection = db.getCollection(table);

        BasicDBObject titleObj = new BasicDBObject("title", title);

        FindIterable<Document> iterable = collection.find(titleObj);
        Map<String, Object> jsonStrToMap = null;
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            String jsonString = user.toJson();
            jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);// 这里用到我自己写的方法,主要是包json字符串转换成map格式,为后面做准备,方法放在后面
        }
        String json = new Gson().toJson(jsonStrToMap);
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        return jsonObject.get("commentCount").getAsInt();
    }

    @Override
    public void updateCommentCount(String title,int commentCount) {
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "buptarticle";

            BasicDBObject titleObj = new BasicDBObject("title", title);
            BasicDBObject updateObj = new BasicDBObject("commentCount",commentCount);

            mongoDao.updateOne(db,table,titleObj,updateObj);

            System.out.println("更新成功！文章现有评论为: " + commentCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int quertStudentNo(String title) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptarticle";
        MongoCollection<Document> collection = db.getCollection(table);

        BasicDBObject titleObj = new BasicDBObject("title", title);

        FindIterable<Document> iterable = collection.find(titleObj);
        Map<String, Object> jsonStrToMap = null;
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            String jsonString = user.toJson();
            jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);// 这里用到我自己写的方法,主要是包json字符串转换成map格式,为后面做准备,方法放在后面
        }
        String json = new Gson().toJson(jsonStrToMap);
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        return jsonObject.get("id").getAsInt();
    }

    @Override
    public String queryArticleByAuthor(List<String> author) {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptarticle";
        int size = author.size();
        MongoCollection<Document> collection = db.getCollection(table);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (String s : author) {
            BasicDBObject query = new BasicDBObject("author", s);
            FindIterable<Document> iterable = collection.find(query);
            for (Document user : iterable) {
                String jsonString = user.toJson();
                Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
                list.add(jsonStrToMap);
            }
        }
        return new Gson().toJson(list);
    }


}

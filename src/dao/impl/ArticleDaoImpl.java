package dao.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
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
    public List<Article> queryallarticle() throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "article";
        List<Map<String, Object>> list;
        List<Article> articleList = new ArrayList<>();
        list = mongoDao.queryAll(db, table);
        for (Map<String, Object> stringObjectMap : list) {
            String json = new Gson().toJson(stringObjectMap);
            Article temp = new Gson().fromJson(json, Article.class);
            articleList.add(temp);
        }
        return articleList;
    }


    @Override
    public void updateCommentCount(String textno) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "article";
        BasicDBObject whereDoc = new BasicDBObject("textno",textno);
        BasicDBObject updateDoc = new BasicDBObject("commentCount",1);
        BasicDBObject resDoc = new BasicDBObject("$inc",updateDoc);
        MongoCollection<Document> collection = db.getCollection(table);
        try {
            UpdateResult updateManyResult = collection.updateMany(whereDoc, resDoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAverageVocabularyPoint(String textno, double averagepoint) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "article";
        BasicDBObject whereDoc = new BasicDBObject("textno",textno);
        BasicDBObject updateDoc = new BasicDBObject("averagevocabularypoint",averagepoint);
        BasicDBObject resDoc = new BasicDBObject("$set",updateDoc);
        MongoCollection<Document> collection = db.getCollection(table);
        UpdateResult updateManyResult = collection.updateMany(whereDoc, resDoc);
    }

    @Override
    public void updateAverageFluentPoint(String textno, double averagepoint) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "article";
        BasicDBObject whereDoc = new BasicDBObject("textno",textno);
        BasicDBObject updateDoc = new BasicDBObject("averagefluentpoint",averagepoint);
        BasicDBObject resDoc = new BasicDBObject("$set",updateDoc);
        MongoCollection<Document> collection = db.getCollection(table);
        UpdateResult updateManyResult = collection.updateMany(whereDoc, resDoc);
    }

    @Override
    public void updateAverageVarietyPoint(String textno, double averagepoint) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "article";
        BasicDBObject whereDoc = new BasicDBObject("textno",textno);
        BasicDBObject updateDoc = new BasicDBObject("averagevarietypoint",averagepoint);
        BasicDBObject resDoc = new BasicDBObject("$set",updateDoc);
        MongoCollection<Document> collection = db.getCollection(table);
        UpdateResult updateManyResult = collection.updateMany(whereDoc, resDoc);
    }

    @Override
    public void updateAverageCompletePoint(String textno, double averagepoint) throws Exception {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "article";
        BasicDBObject whereDoc = new BasicDBObject("textno",textno);
        BasicDBObject updateDoc = new BasicDBObject("averagecompletepoint",averagepoint);
        BasicDBObject resDoc = new BasicDBObject("$set",updateDoc);
        MongoCollection<Document> collection = db.getCollection(table);
        UpdateResult updateManyResult = collection.updateMany(whereDoc, resDoc);
    }

    @Override
    public void updateBrowseTimes(String textno) throws Exception {
        BasicDBObject textnoObj = new BasicDBObject("textno", textno);
        BasicDBObject updateObj = new BasicDBObject("browsertimes", 1);
        BasicDBObject resObj = new BasicDBObject("$inc", updateObj);
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "article";
        MongoCollection<Document> collection = db.getCollection(table);
        try {
            UpdateResult updateManyResult = collection.updateMany(textnoObj, resObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String queryGroupidByTextno(String textno) throws Exception {
        String groupid = null;
        List<Map<String,Object>> list;
        BasicDBObject textnoObj = new BasicDBObject("textno",textno);
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "article";
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            list = mongoDao.queryByDoc(db,table,textnoObj);
            if(list.size() == 1){
                groupid = list.get(0).get("groupno").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupid;
    }
}

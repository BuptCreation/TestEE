package dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dao.NewsDao;
import org.bson.Document;
import utils.JsonStrToMap;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public class NewsDaoImpl implements NewsDao {
    @Override
    public List<Map<String, Object>> getNews(int studentNo) {
        List<Map<String, Object>> list = null;
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();

            BasicDBObject studentNoObj = new BasicDBObject("studentNo",studentNo);
            BasicDBObject isCommentObj = new BasicDBObject("isComment",true);
            BasicDBObject andObj = new BasicDBObject("$and", Arrays.asList(studentNoObj,isCommentObj));

            String table = "buptnews";
            list = mongoDao.queryByDoc(db,table,andObj);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addNews(String json) {
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "buptnews";
            Document document = Document.parse(json);
            mongoDao.insert(db, table, document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("插入成功！");
    }

    @Override
    public void deleteNews() {
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "buptnews";
            BasicDBObject isCommentObj = new BasicDBObject("isComment",true);
            mongoDao.delete(db,table,isCommentObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNews(int studentNo,int count,String title) {
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "buptnews";
            BasicDBObject studentNoObj = new BasicDBObject("studentNo",studentNo);
            BasicDBObject isCommentObj = new BasicDBObject("isComment",true).
                    append("extraInfo","您现在已经拥有: "+count+"条评论").
                    append("title","消息提醒").
                    append("content","您的文章"+title+"有评论");
            mongoDao.update(db,table,studentNoObj,isCommentObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

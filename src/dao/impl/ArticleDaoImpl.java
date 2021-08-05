package dao.impl;

import com.google.gson.Gson;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
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


}

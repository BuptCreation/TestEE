package service.impl;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pojo.Comment;
import service.CommentService;
import utils.JsonStrToMap;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-22
 */
public class CommentServiceImpl implements CommentService {
    @Override
    public List<Map<String, Object>> getComments(String json) throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        String table = "buptcomment";
        MongoDatabase db = MongoHelper.getMongoDataBase();
        MongoCollection<Document> collection = db.getCollection(table);
        Gson gson = new Gson();
        Comment comment = gson.fromJson(json,Comment.class);
        FindIterable<Document> iterable = collection.find(new BasicDBObject("title", comment.getTitle()));
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
}

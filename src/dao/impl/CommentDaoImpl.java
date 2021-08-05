package dao.impl;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dao.CommentDao;
import org.bson.Document;
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
 * @date 2021-08-05-21
 */
public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Map<String, Object>> queryallcomment() throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptcomment";
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
    public void savecomment(String json) throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptcomment";
        Document document = Document.parse(json);
        mongoDao.insert(db, table, document);
        System.out.println("插入成功！");
    }
}

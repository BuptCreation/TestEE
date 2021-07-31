package test;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-30-15
 */
public class MongodbTest {
    public static void main(String[] args) throws Exception {
        // 增加文档

        MongoDao mongoDao = new MongoDaoImpl();
        String table = "buptarticle";
        MongoDatabase db = MongoHelper.getMongoDataBase();
        //User user1 = new User(2,"kira","452663","551@bupy.com","student");
        //Gson gson = new Gson();
        //String userjsonstring = gson.toJson(user1);
        //Document document = Document.parse(userjsonstring);
        //mongoDao.insert(db, table, document);
        //Document document = new Document("title222", "MongoDB222").append("description", "database").append("likes", 100).append("by", "Fly");
        //mongoDao.insert(db, table, document);
        for (int i = 0; i < 6; i++) {
            List<Map<String, Object>> queryAll = mongoDao.queryAll(db,table);
            System.out.println(queryAll);
        }

    }

    private static void insertDoc(MongoDatabase db, MongoDao mongoDao, String table) throws Exception {
        Document document = new Document("title222", "MongoDB222").append("description", "database")
                .append("likes", 100).append("by", "Fly");
        mongoDao.insert(db, table, document);
    }
}

package test;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
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
    @Test
    public void testMongoUser(){
        
    }
    private static void insertDoc(MongoDatabase db, MongoDao mongoDao, String table) throws Exception {
        Document document = new Document("title222", "MongoDB222").append("description", "database")
                .append("likes", 100).append("by", "Fly");
        mongoDao.insert(db, table, document);
    }
}

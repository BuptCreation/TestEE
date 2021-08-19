package service.impl;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import service.MessageService;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-19-16
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public void saveMessage(String json) {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "chatmessage";
        Document document = Document.parse(json);
        try {
            mongoDao.insert(db, table, document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("插入成功！");
    }
}

package dao.impl;

import com.mongodb.client.MongoDatabase;
import dao.MissonDao;
import org.bson.Document;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-23
 */
public class MissonDaoImpl implements MissonDao {
    @Override
    public void savemissons(String json) throws Exception{
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptmisson";
        Document document = Document.parse(json);
        mongoDao.insert(db, table, document);
        System.out.println("插入成功！");
    }
}

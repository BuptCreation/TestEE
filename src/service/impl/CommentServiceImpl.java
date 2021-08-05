package service.impl;

import com.mongodb.client.MongoDatabase;
import service.CommentService;
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
 * @date 2021-08-05-22
 */
public class CommentServiceImpl implements CommentService {
    @Override
    public List<Map<String, Object>> getComments() throws Exception {
        MongoDao mongoDao = new MongoDaoImpl();
        String table = "buptcomment";
        MongoDatabase db = MongoHelper.getMongoDataBase();
        List<Map<String, Object>> comments = mongoDao.queryAll(db,table);
        return comments;
    }
}

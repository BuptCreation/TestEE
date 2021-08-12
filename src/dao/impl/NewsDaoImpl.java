package dao.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import dao.NewsDao;
import org.bson.Document;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 类<code>NewsDaoImpl</code>用于：实现NewsDao类接口
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public class NewsDaoImpl implements NewsDao {
    /**
     *
     * 用于得到用户消息，返回一个List,包含了消息相关数据
     * @param studentNo
     * @return
     */
    @Override
    public List<Map<String, Object>> getNews(int studentNo) {
        List<Map<String, Object>> list = null;
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();

            BasicDBObject studentNoObj = new BasicDBObject("studentNo", studentNo);
            //BasicDBObject isCommentObj = new BasicDBObject("isComment", true);
            //BasicDBObject andObj = new BasicDBObject("$and", Arrays.asList(studentNoObj, isCommentObj));

            String table = "buptnews";
            list = mongoDao.queryByDoc(db, table, studentNoObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 用于添加消息
     * @param json
     */
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

    /**
     * 用于删除用户消息
     */
    @Override
    public void deleteNews() {
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "buptnews";
            BasicDBObject isCommentObj = new BasicDBObject("isComment", true);
            mongoDao.delete(db, table, isCommentObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param studentNo
     * @param count
     * @param title
     *
     *  用于更新用户消息
     */
    @Override
    public void updateNews(int studentNo, int count, String title) {
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "buptnews";
            BasicDBObject studentNoObj = new BasicDBObject("studentNo", studentNo);
            BasicDBObject isCommentObj = new BasicDBObject("isComment", true).
                    append("extraInfo", "您现在已经拥有: " + count + "条评论").
                    append("title", "消息提醒").
                    append("content", "您的文章" + title + "有评论");
            mongoDao.update(db, table, studentNoObj, isCommentObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于初始化用户的消息模板
     * 模板暂为:评论文章（您被分配至xxx文章，请进行评论）、小组提示（您已被分配至xxx小组，组员有xxx等）、
     * 聊天室相关消息提醒（新消息提醒，回复@提醒）、被评论文章提醒（您的文章已经被评论，现有XXX条回复）
     *
     * @param studentNo
     */
    @Override
    public void initNews(int studentNo) {
        JsonArray jsonArray = new JsonArray();
        List<String> newsTypes = new ArrayList<String>() {{
            add("comment");//评论文章
            add("commentfinished");//被评论文章提醒
            add("chatroom");//聊天室相关消息提醒
            add("group");//小组提醒
        }};
        int size = newsTypes.size();
        for (int i = 0; i < size; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type",newsTypes.get(i));
            jsonObject.addProperty("title","暂无");
            jsonObject.addProperty("content","暂无");
            jsonObject.addProperty("iscomment",false);
            jsonObject.addProperty("extraInfo","暂无");
            jsonObject.addProperty("studentNo",studentNo);
            String json = new Gson().toJson(jsonObject);
            NewsDao newsDao = new NewsDaoImpl();
            newsDao.addNews(json);
        }
    }
}

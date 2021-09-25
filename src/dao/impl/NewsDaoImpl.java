package dao.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import dao.NewsDao;
import org.bson.Document;
import pojo.News;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.util.ArrayList;
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
     * 用于得到用户消息，返回一个List,包含了消息相关数据
     *
     * @param username
     * @return
     */
    @Override
    public List<News> getNews(String username) {
        List<Map<String, Object>> list;
        List<News> newslist = new ArrayList<>();
        News tempmessage = new News();//临时存储
        MongoDatabase db = MongoHelper.getMongoDataBase();
        MongoDao mongoDao = new MongoDaoImpl();
        BasicDBObject usernameObj = new BasicDBObject("username", "bupt2019211925");
        String table = "news";
        try {
            list = mongoDao.queryByDoc(db, table, usernameObj);
            for (Map<String, Object> map : list) {
                String Json = new Gson().toJson(map);
                tempmessage = new Gson().fromJson(Json, News.class);
                System.out.println("tempmessage:" + tempmessage);
                newslist.add(tempmessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newslist;
    }

    /**
     * 用于添加消息
     *
     * @param news
     */
    @Override
    public void addNews(News news) {
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "news";
            String json = new Gson().toJson(news);
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
    public void deleteNews(String username, String date) {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "news";
        BasicDBObject usernameObj = new BasicDBObject("username", username).append("date", date);
        BasicDBObject towhoObj = new BasicDBObject("towho", username).append("date", date);
        try {
            if (mongoDao.delete(db, table, usernameObj) || mongoDao.delete(db, table, towhoObj))
                System.out.println("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param studentNo
     * @param count
     * @param title     <p>
     *                  用于更新用户消息
     */
    @Override
    public void updateNews(String studentNo, int count, String title) {
        try {
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "news";
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
    public void initNews(String studentNo) {
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
            jsonObject.addProperty("type", newsTypes.get(i));
            jsonObject.addProperty("title", "暂无");
            jsonObject.addProperty("content", "暂无");
            jsonObject.addProperty("iscomment", false);
            jsonObject.addProperty("extraInfo", "暂无");
            jsonObject.addProperty("studentNo", studentNo);
            String json = new Gson().toJson(jsonObject);
            News news = new Gson().fromJson(json, News.class);
            NewsDao newsDao = new NewsDaoImpl();
            newsDao.addNews(news);
        }
    }
}

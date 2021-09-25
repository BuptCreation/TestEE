package test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoDatabaseImpl;
import com.mongodb.client.result.UpdateResult;
import dao.ArticleDao;
import dao.GroupDao;
import dao.NewsDao;
import dao.impl.ArticleDaoImpl;
import dao.impl.GroupDaoImpl;
import dao.impl.NewsDaoImpl;
import org.bson.Document;
import org.junit.Test;
import pojo.Article;
import pojo.News;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-14
 */
public class DataTest {
    @Test
    public void addNews() {
        for (int i = 1; i <= 10; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", "comment");
            jsonObject.addProperty("title", "test" + i);
            jsonObject.addProperty("content", "测试数据在此" + i);
            jsonObject.addProperty("isComment", false);
            jsonObject.addProperty("extraInfo", "搞快点，摸🐟者斩" + i);
            jsonObject.addProperty("studentNo", 123456);
            String json = new Gson().toJson(jsonObject);
            News news = new Gson().fromJson(json, News.class);
            NewsDao newsDao = new NewsDaoImpl();
            newsDao.addNews(news);
        }
    }

    @Test
    public void addArticles() {
        for (int i = 1; i <= 10; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", 123456);
            jsonObject.addProperty("title", "测试数据" + i);
            jsonObject.addProperty("author", "student168");
            jsonObject.addProperty("content", "我爱JavaWeb!我们JavaWeb真是太厉害啦！");
            jsonObject.addProperty("commentCount", 0);
            String json = new Gson().toJson(jsonObject);
            ArticleDao articleDao = new ArticleDaoImpl();
            try {
                //articleDao.savearticle(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void QueryTest1() {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";

        BasicDBObject query = new BasicDBObject("teacherUsername", "teacher168");
        BasicDBObject groupIdObj = new BasicDBObject("groupId", 1);
        List<String> list = new ArrayList<String>();
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(query).projection(new BasicDBObject("username", 1)).sort(groupIdObj);
        for (Document user : iterable) {
            String jsonString = user.toJson();
            JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
            String studentname = jsonObject.get("username").getAsString();
            list.add(studentname);
        }
        System.out.println(list);
    }

    @Test
    public void testEmoji() {
        System.out.println("😓");
    }

    @Test
    public void testGroup() {
        MongoDao mongoDao = new MongoDaoImpl();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        List<String> result = new ArrayList<String>();
        String table = "buptgroup";
        BasicDBObject studentnameObj = new BasicDBObject("studentname", "student168");
        try {
            List<Map<String, Object>> querylist = mongoDao.queryByDoc(db, table, studentnameObj);
            System.out.println(querylist);
            int groupid = (int) querylist.get(0).get("groupid");
            BasicDBObject groupidObj = new BasicDBObject("groupid", groupid);
            List<Map<String, Object>> querylist2 = mongoDao.queryByDoc(db, table, groupidObj);
            for (int i = 0; i < querylist2.size(); i++) {
                String tempusername = querylist2.get(i).get("studentname").toString();
                result.add(tempusername);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.remove("student168");
        System.out.println(result);
    }

    @Test
    public void dada() {
        int id = 0;
        BasicDBObject usernameObj = new BasicDBObject("studentname", "student168");
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            List<Map<String, Object>> list = mongoDao.queryByDoc(db, table, usernameObj);
            if (list.size() == 0) {
                System.out.println(0);
            } else {
                String json = new Gson().toJson(list.get(0));
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                id = jsonObject.get("groupid").getAsInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(id);
    }

    @Test
    public void TestUpdate() {
        BasicDBObject usernameObj = new BasicDBObject("studentname", "student168");
        BasicDBObject updateDoc = new BasicDBObject("logins", 1);
        BasicDBObject doc = new BasicDBObject("$inc", updateDoc);
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        MongoDao mongoDao = new MongoDaoImpl();
        MongoCollection<Document> collection = db.getCollection(table);
        try {
            UpdateResult updateManyResult = collection.updateMany(usernameObj, doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestA() throws Exception {
        ArticleDao articleDao = new ArticleDaoImpl();
        GroupDao groupDao = new GroupDaoImpl();
        List<Article> articleList;
        JsonArray jsonArray = new JsonArray();
        articleList = articleDao.queryallarticle();
        for (int i = 0; i < articleList.size(); i++) {
            String textno = articleList.get(i).getTextno();
            String groupid = articleDao.queryGroupidByTextno(textno);
            List<String> authorList = groupDao.queryAuthorByGroupId(groupid);
            String json = new Gson().toJson(articleList.get(i));
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            jsonObject.addProperty("writer", String.valueOf(authorList));
            jsonArray.add(jsonObject);
        }
        String finals = new Gson().toJson(jsonArray);
        System.out.println(finals);
    }

    @Test
    public void Test4() {
        ArticleDao articleDao = new ArticleDaoImpl();
        List<Article> list = null;
        try {
            list = articleDao.queryallarticle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0).getGroupno());
    }

    @Test
    public void Test5() {
        ArticleDao articleDao = new ArticleDaoImpl();
        GroupDao groupDao = new GroupDaoImpl();
        List<Article> articleList;
        List<Map<String, Object>> list;
        JsonArray jsonArray = new JsonArray();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        MongoDao mongoDao = new MongoDaoImpl();
        String table = "articlethreepartern";
        try {
            articleList = articleDao.queryallarticle();
            for (int i = 0; i < articleList.size(); i++) {

                String textno = articleList.get(i).getTextno();
                String groupid = articleDao.queryGroupidByTextno(textno);
                List<String> authorList = groupDao.queryAuthorByGroupId(groupid);

                list = mongoDao.queryByDoc(db, table, new BasicDBObject("textno", textno));
                System.out.println(list);
                String json = new Gson().toJson(articleList.get(i));
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

                for (int j = 0; j < list.size(); j++) {
                    String content = list.get(j).get("content").toString();
                    if (Objects.equals(list.get(j).get("partern").toString(), "1")) {
                        if (Objects.equals(content, " ")) {
                            boolean has1writed = false;
                            jsonObject.addProperty("has1writed", has1writed);
                        } else {
                            boolean has1writed = true;
                            jsonObject.addProperty("has1writed", has1writed);
                        }
                    } else if (Objects.equals(list.get(j).get("partern").toString(), "2")) {
                        if (Objects.equals(content, " ")) {
                            boolean has2writed = false;
                            jsonObject.addProperty("has2writed", has2writed);
                        } else {
                            boolean has2writed = true;
                            jsonObject.addProperty("has2writed", has2writed);
                        }
                    } else if (Objects.equals(list.get(j).get("partern").toString(), "3")) {
                        if (Objects.equals(content, " ")) {
                            boolean has3writed = false;
                            jsonObject.addProperty("has3writed", has3writed);
                        } else {
                            boolean has3writed = true;
                            jsonObject.addProperty("has3writed", has3writed);
                        }
                    }
                }

                jsonObject.addProperty("writer", String.valueOf(authorList));
                jsonArray.add(jsonObject);
            }
            String finals = new Gson().toJson(jsonArray);
            System.out.println(finals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test18() {
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "buptgroup";
        BasicDBObject dbObject = new BasicDBObject("studentno", 2019211924);
        try {
            List<Map<String, Object>> list = new MongoDaoImpl().queryByDoc(db, table, dbObject);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void Test19() {
        List<Map<String, Object>> list = null;
        List<News> newslist = null;
        News tempmessage;//临时存储
        MongoDatabase db = MongoHelper.getMongoDataBase();
        MongoDao mongoDao = new MongoDaoImpl();
        BasicDBObject usernameObj = new BasicDBObject("username", "bupt2019211925");
        String table = "news";
        try {
            list = mongoDao.queryByDoc(db, table, usernameObj);
            for (Map<String, Object> map : list) {
                String Json = new Gson().toJson(map);
                System.out.println(Json);
                tempmessage = new Gson().fromJson(Json, News.class);
                System.out.println("tempmessage:" + tempmessage);
                newslist.add(tempmessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(newslist);
    }
}

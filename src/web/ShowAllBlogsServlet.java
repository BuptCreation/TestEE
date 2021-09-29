package web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import dao.ArticleDao;
import dao.GroupDao;
import dao.impl.ArticleDaoImpl;
import dao.impl.GroupDaoImpl;
import pojo.Article;
import pojo.User;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
 * @date 2021-09-13-18
 */
@WebServlet("/showallblogsservlet")
public class ShowAllBlogsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ArticleDao articleDao = new ArticleDaoImpl();
        //登陆人
        User loginuser = (User)req.getSession().getAttribute("User");
        GroupDao groupDao = new GroupDaoImpl();
        List<Article> articleList;
        List<Map<String, Object>> list = new ArrayList<>();
        JsonArray jsonArray = new JsonArray();
        MongoDatabase db = MongoHelper.getMongoDataBase();
        MongoDao mongoDao = new MongoDaoImpl();
        String table = "articlethreepartern";
        try {
            articleList = articleDao.queryTextByTeacherName(loginuser.getUsername());
            for (int i = 0; i < articleList.size(); i++) {
                String textno = articleList.get(i).getTextno();
                String groupid = articleDao.queryGroupidByTextno(textno);
                articleDao.freshCommentCount(textno);
                List<String> authorList = groupDao.queryAuthorByGroupId(groupid);
                list = mongoDao.queryByDoc(db, table, new BasicDBObject("textno", textno));
                String json = new Gson().toJson(articleList.get(i));
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                for (int j = 0; j < list.size(); j++) {
                    String content = list.get(j).get("content").toString();
                    if (Objects.equals(list.get(j).get("partern").toString(), "1")) {
                        if (Objects.equals(content, " ")) {
                            boolean has1writed = false;
                            jsonObject.addProperty("has1writed", has1writed);
                        }
                        else{
                            boolean has1writed = true;
                            jsonObject.addProperty("has1writed", has1writed);
                        }
                    } else if (Objects.equals(list.get(j).get("partern").toString(), "2")) {
                        if (Objects.equals(content, " ")) {
                            boolean has2writed = false;
                            jsonObject.addProperty("has2writed", has2writed);
                        }
                        else{
                            boolean has2writed = true;
                            jsonObject.addProperty("has2writed", has2writed);
                        }
                    } else if (Objects.equals(list.get(j).get("partern").toString(), "3")) {
                        if (Objects.equals(content, " ")) {
                            boolean has3writed = false;
                            jsonObject.addProperty("has3writed", has3writed);
                        }
                        else{
                            boolean has3writed = true;
                            jsonObject.addProperty("has3writed", has3writed);
                        }
                    }
                }
                jsonObject.addProperty("writer", String.valueOf(authorList));
                jsonArray.add(jsonObject);
            }
            String finals = new Gson().toJson(jsonArray);
            out.print(finals);
            System.out.println(finals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

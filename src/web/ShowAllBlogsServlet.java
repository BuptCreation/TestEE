package web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.ArticleDao;
import dao.GroupDao;
import dao.impl.ArticleDaoImpl;
import dao.impl.GroupDaoImpl;
import pojo.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        GroupDao groupDao = new GroupDaoImpl();
        List<Article> articleList;
        JsonArray jsonArray = new JsonArray();
        try {
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

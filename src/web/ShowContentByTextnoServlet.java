package web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import dao.ArticleDao;
import dao.impl.ArticleDaoImpl;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-09-25-16
 */
@WebServlet("/showcontentbytextnoservlet")
public class ShowContentByTextnoServlet extends HttpServlet {
    public String json = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    req.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            //获取到的json字符串
            String acceptjson = sb.toString();
            json = acceptjson;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            //
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            String textno = jsonObject.get("textno").getAsString();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            MongoDao mongoDao = new MongoDaoImpl();
            String table = "article";
            BasicDBObject textnoObj = new BasicDBObject("textno",textno);
            List<Map<String ,Object>> list = mongoDao.queryByDoc(db,table,textnoObj);
            JsonObject jsonObject1 = JsonParser.parseString(list.get(0).toString()).getAsJsonObject();
            String jsonout = new Gson().toJson(jsonObject1);
            out.print(jsonout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

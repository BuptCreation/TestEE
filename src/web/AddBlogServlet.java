package web;

import com.google.gson.Gson;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pojo.Article;
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

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-25
 */

    @WebServlet("/addblogsevlet")
public class AddBlogServlet extends HttpServlet {

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
            //将json字符串转为jsonobject对象
            Gson gson = new Gson();
            //将jsonobject对象转为java对象
            Article article = gson.fromJson(acceptjson,Article.class);
            System.out.println(article);
            //Mongodb操作，将接收到的json转换为document存入collection中
            MongoDao mongoDao = new MongoDaoImpl();
            MongoDatabase db = MongoHelper.getMongoDataBase();
            String table = "buptarticle";
            Document document = Document.parse(acceptjson);
            mongoDao.insert(db, table, document);
            System.out.println("插入成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

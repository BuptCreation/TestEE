package web;

import com.google.gson.Gson;
import com.mongodb.client.MongoDatabase;
import dao.ArticleDao;
import dao.impl.ArticleDaoImpl;
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
 * 类<code>AddBlogServlet</code>用于:添加博客的servlet
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-25
 */

    @WebServlet("/addblogsevlet")
public class AddBlogServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //用于保存所获取到的数据流
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    req.getInputStream(), "utf-8"));
//            StringBuffer sb = new StringBuffer("");
//            String temp;
//            while ((temp = br.readLine()) != null) {
//                sb.append(temp);
//            }
//            br.close();
//            //获取到的json字符串
//            String acceptjson = sb.toString();
//            //保存
//            ArticleDaoImpl articleDao = new ArticleDaoImpl();
//            articleDao.savearticle(acceptjson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

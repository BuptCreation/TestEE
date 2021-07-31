package web;

import service.impl.ArticleServiceImpl;
import utils.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-14
 */
@WebServlet("/showblogsevlet")
public class ShowBlogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            List<Map<String,Object>> articles = new ArticleServiceImpl().getArticles();
            JsonConverter converter = new JsonConverter();
            String output = converter.convertToJson(articles);
            out.print(output);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

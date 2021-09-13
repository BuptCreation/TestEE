package web;

import dao.impl.ArticleDaoImpl;
import pojo.User;
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
 * 类<code>ShowBlogServlet</code>用于:展示博客的servlet
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
            User loginUser=(User)req.getSession().getAttribute("User");
            //连接数据库,获取文章
            //List<Map<java.lang.String,Object>> articles = new ArticleDaoImpl().queryallarticle(loginUser.getStudentNo());
            JsonConverter converter = new JsonConverter();
            //将文章转换为json类型
            String output = null;//converter.convertToJson(articles);
            out.print(output);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

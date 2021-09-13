package web;

import pojo.User;
import service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 类<code>ShowNewsServlet</code>用于:展示消息的servlet
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-14
 */
@WebServlet("/shownewsservlet")
public class ShowNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            User loginUser=(User)req.getSession().getAttribute("User");
            //连接数据库,获取消息
            java.lang.String NewsList = new NewsServiceImpl().loadNews(loginUser.getUsername());
            out.print(NewsList);
            System.out.println(NewsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

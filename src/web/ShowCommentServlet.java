package web;

import service.impl.CommentServiceImpl;
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
 * @date 2021-08-05-22
 */
@WebServlet("/showcommentservlet")
public class ShowCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            //连接数据库,获取评论
            List<Map<String,Object>> comments = new CommentServiceImpl().getComments();
            JsonConverter converter = new JsonConverter();
            //将文章转换为json类型
            String output = converter.convertToJson(comments);
            out.print(output);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

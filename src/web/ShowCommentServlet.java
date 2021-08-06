package web;

import dao.impl.ArticleDaoImpl;
import service.impl.CommentServiceImpl;
import utils.JsonConverter;

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
 * @date 2021-08-05-22
 */
@WebServlet("/showcommentservlet")
public class ShowCommentServlet extends HttpServlet {
    public String json;
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
            //连接数据库,获取评论
            List<Map<String,Object>> comments = new CommentServiceImpl().getComments(json);
            JsonConverter converter = new JsonConverter();
            //将文章转换为json类型
            String output = converter.convertToJson(comments);
            out.print(output);
            System.out.println("返回数据"+json);
            System.out.println("输出数据"+output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package web;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.impl.ArticleDaoImpl;
import dao.impl.GroupDaoImpl;

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

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-12-16
 */
@WebServlet("/showgroupblogservlet")
public class ShowGroupBlogServlet extends HttpServlet {
    String teacherName = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            //连接数据库,获取老师所管理的所有小组的学生姓名
            List<String> authors = new GroupDaoImpl().queryAuthor(teacherName);
            System.out.println(authors);
            //调用函数,查找作者所对应的所有文章
            String articales = new ArticleDaoImpl().queryArticleByAuthor(authors);
            out.print(articales);
            System.out.println(articales);
            System.out.println("查找成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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
            JsonObject jsonObject = JsonParser.parseString(acceptjson).getAsJsonObject();
            teacherName = jsonObject.get("teacherUsername").getAsString();
            System.out.println(teacherName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

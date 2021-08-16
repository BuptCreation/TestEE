package web;

import pojo.User;
import service.impl.GroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 类<code>ShowGroupServlet</code>用于:展示小组的servlet
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-07-16
 */
@WebServlet("/showgroupsservlet")
public class ShowGroupsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            User loginUser=(User)req.getSession().getAttribute("User");
            //连接数据库,获取小组
            java.lang.String groups = new GroupServiceImpl().loadGroup(loginUser.getUsername());
            out.print(groups);
            System.out.println(groups);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

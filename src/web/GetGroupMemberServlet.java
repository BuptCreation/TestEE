package web;

import com.google.gson.Gson;
import pojo.User;
import service.impl.GroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-19-09
 */
@WebServlet("/getgroupmemberservlet")
public class GetGroupMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User loginuser = (User) req.getSession().getAttribute("User");
            String username = loginuser.getUsername();
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            List<String> studentslist = new GroupServiceImpl().queryGroupStudent(username);
            Gson gson = new Gson();
            String json = gson.toJson(studentslist);
            out.print(json);
            System.out.println(studentslist);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

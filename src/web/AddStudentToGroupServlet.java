package web;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.impl.GroupDaoImpl;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 类<code>AddStudentToGroupServlet</code>用于:添加学生至小组的servlet
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-07-16
 */
@WebServlet("/addstudenttogroupservlet")
public class AddStudentToGroupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        //用于保存所获取到的数据流
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
            System.out.println(sb);
            String acceptjson = sb.toString();
            JsonObject jsonObject = JsonParser.parseString(acceptjson).getAsJsonObject();
            //保存到组中
            GroupDaoImpl groupDao = new GroupDaoImpl();
            groupDao.saveGroup(acceptjson);
            //保存用户数据
            User user = new User();
            user.setStudentNo(jsonObject.get("id").getAsInt());
            user.setUsername("bupt"+jsonObject.get("id").getAsString());
            user.setPassword("123456");
            //user.setEmail("123456");
            user.setIdentity("student");
            userService.registUser(user);
            String userinfo = new Gson().toJson(user);
            System.out.println("注册成功！"+"欢迎用户"+userinfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

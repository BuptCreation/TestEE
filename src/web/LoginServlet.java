package web;



import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            //   跳回登录页面
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        } else {
            // 登录 成功
            System.out.println("用户登陆成功");
            //将数据存储到session中
            req.getSession().setAttribute("User",loginUser);
            if (loginUser.getIdentity().equals("student")) {
                //跳到学生端欢迎登陆主页
                req.getRequestDispatcher("/pages/Student/Welcome.jsp").forward(req, resp);
            }else{
                //跳到教师端主页
                req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
            }
        }
    }
}

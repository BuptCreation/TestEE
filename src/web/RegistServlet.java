package web;



import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 类<code>RegistServlet</code>用于:用户注册的servlet
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-23
 */
@WebServlet(value = {"/regist"})
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String identity = req.getParameter("identity");
        //int studentNo = Integer.parseInt(req.getParameter("studentNo"));
//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
//        if ("abcde".equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");
//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                //      可用
//                调用Service保存到数据库
                System.out.println(nickname);
                userService.registUser(new User(null, username,nickname, password, email, identity));
                System.out.println("注册成功！");
//        跳到登录页面 login.html
                resp.sendRedirect("http://buptcw.cn/pages/user/login.html");
            }
//        }
//        else {
//            System.out.println("验证码[" + code + "]错误");
//            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
//        }
    }
}

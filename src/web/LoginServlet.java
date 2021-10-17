package web;


import dao.GroupDao;
import dao.impl.GroupDaoImpl;
import dao.impl.NewsDaoImpl;
import pojo.User;
import service.GroupService;
import service.UserService;
import service.impl.GroupServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 类<code>LoginServlet</code>用于:用户登录的servlet
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-23
 */
@WebServlet(value = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, null, password, null, null, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            //   跳到登录错误页面
            resp.sendRedirect("http://buptcw.cn/pages/user/login_error.jsp");
        } else {
            // 登录 成功
            System.out.println("用户登陆成功");
            //传送json数据给谁谁
            //将数据存储到session
            req.getSession().setAttribute("User", loginUser);
            try {
                if (loginUser.getIdentity().equals("student")) {
                    //跳到学生端欢迎登陆主页
                    System.out.println(loginUser);
                    int studentId = Integer.parseInt(loginUser.getStudentno());
                    System.out.println(studentId);
                    String KeyGroup = userService.queryGroupIdAndTeacherName(studentId);
                    String groupid = userService.queryGroupId(studentId);
                    GroupDao groupDao = new GroupDaoImpl();
                    List<String> groupmembers = groupDao.queryAuthorByGroupId(groupid);
                    //把groupid存到session中
                    req.getSession().setAttribute("Groupid", groupid);
                    //user->group 并且把groupid+teacherusername
                    req.getSession().setAttribute("KeyGroup", KeyGroup);
                    req.getSession().setAttribute("Groupmembers",groupmembers);
                    //判断消息是否为空,为空则初始化消息
                    //if (new NewsDaoImpl().getNews(loginUser.getUsername()).size() == 0)
                        //new NewsDaoImpl().initNews(String.valueOf(studentId));
                    GroupService groupService = new GroupServiceImpl();
                    groupService.updatelogins(loginUser.getUsername());
                    resp.sendRedirect("pages/Student/Welcome.jsp");
                } else {
                    //跳到教师端主页
                    resp.sendRedirect("pages/Teacher/Welcome.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

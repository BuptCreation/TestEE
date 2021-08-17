package web;


import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.RequestWrapper;
import java.io.IOException;

@WebServlet("/getUsername")
public class ChatRoomUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser=(User)req.getSession().getAttribute("User");
        String username=loginUser.getUsername();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(username);
    }
}


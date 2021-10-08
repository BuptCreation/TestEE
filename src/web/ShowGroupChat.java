package web;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import utils.MongoDaoImpl;
import utils.MongoHelper;

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
 * @date 2021-10-08-21
 */
@WebServlet("/showgroupchat")
public class ShowGroupChat extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String KeyGroup = req.getSession().getAttribute("KeyGroup").toString();
        List<Map<String, Object>> list;
        MongoDatabase db = MongoHelper.getMongoDataBase();
        String table = "chatmessage";
        BasicDBObject dbObject = new BasicDBObject("toName", KeyGroup);
        MongoDaoImpl mongoDao = new MongoDaoImpl();
        try {
            list = mongoDao.queryByDoc(db, table, dbObject);
            System.out.println(list);
            out.print(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

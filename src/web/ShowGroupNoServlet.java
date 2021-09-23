package web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import pojo.User;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-09-23-19
 */
public class ShowGroupNoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            User loginUser = (User) req.getSession().getAttribute("User");
            MongoDatabase db = MongoHelper.getMongoDataBase();
            MongoDao mongoDao = new MongoDaoImpl();
            String table = "buptgroup";
            BasicDBObject teacherObj = new BasicDBObject("teachername", loginUser);
            List<Map<String, Object>> list = mongoDao.queryByDoc(db, table, teacherObj);
            List<String> grouplist = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                String groupid = list.get(i).get("groupid").toString();
                grouplist.add(groupid);
            }
            List<String> result = new ArrayList<String>(grouplist.size());
            for (String str : grouplist) {
                if (!result.contains(str)) {
                    result.add(str);
                }
            }
            grouplist.clear();
            grouplist.addAll(result);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("group", grouplist.toString());
            String json = new Gson().toJson(jsonObject);
            out.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

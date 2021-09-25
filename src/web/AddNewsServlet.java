package web;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.GroupDao;
import dao.NewsDao;
import dao.impl.GroupDaoImpl;
import dao.impl.NewsDaoImpl;
import pojo.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-09-25-10
 */
@WebServlet("/addnewsservlet")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            String acceptjson = sb.toString();
            //转换为json对象
            JsonObject jsonObject = JsonParser.parseString(acceptjson).getAsJsonObject();
            //消息生成
            NewsDao newsDao = new NewsDaoImpl();
            //日期
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String times = format.format(date.getTime());
            //判断消息类型
            if (Objects.equals(jsonObject.get("type").getAsString(), "invite")) {
                //获取文章号，邀请小组，文章标题
                String textno = jsonObject.get("textno").getAsString();
                String title = jsonObject.get("title").getAsString();
                JsonArray groups = jsonObject.getAsJsonArray("inviteGroup");
                for (int i = 0; i < groups.size(); i++) {
                    //获取每个小组的作者名称
                    GroupDao groupDao = new GroupDaoImpl();
                    List<String> users = groupDao.queryAuthorByGroupId(groups.get(i).getAsString());
                    for (String user : users) {
                        News news = new News(jsonObject.get("type").getAsString(), title, user, textno,groups.get(i).getAsString(), date.toString(), times);
                        //插入消息
                        newsDao.addNews(news);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package web;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.ArticleDao;
import dao.CommentDao;
import dao.NewsDao;
import dao.impl.ArticleDaoImpl;
import dao.impl.CommentDaoImpl;
import dao.impl.NewsDaoImpl;
import pojo.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类<code>AddCommentServlet</code>用于:添加评论的servlet
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-20
 */
@WebServlet("/addcommentsevlet")
public class AddCommentServlet extends HttpServlet {
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
            ArticleDao articleDao = new ArticleDaoImpl();
            //获取到的json字符串
            String acceptjson = sb.toString();
            System.out.println("评论" + acceptjson);
            JsonObject jsonObject = JsonParser.parseString(acceptjson).getAsJsonObject();
            //取东西
            String textno = jsonObject.get("textno").getAsString();
            String title = jsonObject.get("title").getAsString();
            String nickname = jsonObject.get("user").getAsString();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String times = format.format(date.getTime());
            //插入评论
            Comment comment = new Comment(null, 0, jsonObject.get("content").getAsString(), jsonObject.get("textno").getAsString(), jsonObject.get("context").getAsString(), jsonObject.get("vocabulary").getAsInt(), jsonObject.get("fluent").getAsInt(), jsonObject.get("variety").getAsInt(), jsonObject.get("complete").getAsInt(), times);
            CommentDao commentDao = new CommentDaoImpl();
            commentDao.saveComment(comment);

            //对应文章评论数+1
            System.out.println("评论加一被调用了");
            articleDao.updateCommentCount(textno);

            //更新对应文章均分
            double vocabularypoint = commentDao.getAllvocabularypoints(textno);
            double fluentpoint = commentDao.getAllfluentpoints(textno);
            double varietypoint = commentDao.getAllvarietypoints(textno);
            double completepoint = commentDao.getAllcompletepoints(textno);
            double count = commentDao.getCommentCount(textno);
            DecimalFormat df2 = new DecimalFormat("###.00");
            double avervocabularypoint = vocabularypoint / count;
            double averfluentpoint = fluentpoint / count;
            double avervarietypoint = varietypoint / count;
            double avercompletepoint = completepoint / count;

            String aver = df2.format(avervocabularypoint);
            String aver1 = df2.format(averfluentpoint);
            String aver2 = df2.format(avervarietypoint);
            String aver3 = df2.format(avercompletepoint);

            double avervocabularypoints = Double.parseDouble(aver);
            double averfluentpoints = Double.parseDouble(aver1);
            double avervarietypoints = Double.parseDouble(aver2);
            double avercompletepoints = Double.parseDouble(aver3);
            articleDao.updateAverageVocabularyPoint(textno, avervocabularypoints);
            articleDao.updateAverageFluentPoint(textno, averfluentpoints);
            articleDao.updateAverageVarietyPoint(textno, avervarietypoints);
            articleDao.updateAverageCompletePoint(textno, avercompletepoints);

            //插入消息部分
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

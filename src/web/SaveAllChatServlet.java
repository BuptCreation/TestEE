//package web;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//import utils.MongoDao;
//import utils.MongoDaoImpl;
//import utils.MongoHelper;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
///**
// * 类<code>Doc</code>用于：TODO
// *
// * @author LuoSue
// * @version 1.0
// * @date 2021-08-19-11
// */
//@WebServlet("/saveallchatservlet")
//public class SaveAllChatServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //用于保存所获取到的数据流
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    req.getInputStream(), "utf-8"));
//            StringBuffer sb = new StringBuffer("");
//            String temp;
//            while ((temp = br.readLine()) != null) {
//                sb.append(temp);
//            }
//            br.close();
//            //获取到的json字符串
//            String acceptjson = sb.toString();
//            JsonObject jsonObject = new JsonObject();
//            jsonObject.addProperty("speak",acceptjson);
//            String json = new Gson().toJson(jsonObject);
//            MongoDao mongoDao = new MongoDaoImpl();
//            MongoDatabase db = MongoHelper.getMongoDataBase();
//            String table = "bupttest";
//            Document document = Document.parse(json);
//            mongoDao.insert(db, table, document);
//            System.out.println("插入成功！");
//            //保存
//            System.out.println("收到消息aq: " +acceptjson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//}

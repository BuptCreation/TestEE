package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pojo.Message;
import pojo.User;
import service.MessageService;
import service.impl.GroupServiceImpl;
import service.impl.MessageServiceImpl;
import utils.MessageUtils;
import utils.MongoDao;
import utils.MongoDaoImpl;
import utils.MongoHelper;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//相对于springboot缺少了Bean注入
@ServerEndpoint(value="/chat",configurator = GetHttpSessionConfigurator.class)
public class ChatEndpoint {

    //用来存储每个客户端对象对应的ChatEndpoint对象 string为用户名 ChatEndpoint对应一个终端
    private static Map<String,ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();
    //!!      用来存储各个组
    private static Map<String,Map<String,ChatEndpoint>> onlineGroups = new ConcurrentHashMap<>();
    //声明session对象 通过该对象可以发送消息给指定的用户，由于每一个ChatEndpoint都需要一个session
    private Session session;
    //声明小组用来存储该session属于哪一个组
    private String KeyGroup;
    //声明一个httpSession对象
    private HttpSession httpSession;
    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
            //将局部的session对象赋值给成员session
        try {
            this.session = session;
            //获取httpsession对象
            this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        System.out.println(httpSession.getAttribute("User"));
            //将当前对象存储到容器中
            User loginUser = (User) httpSession.getAttribute("User");
            //将登陆的用户加入group
            int groupid=1;
            KeyGroup=httpSession.getAttribute("KeyGroup").toString();//为了确定唯一的group,必须如此做，将id与用户名相加
            Map<String,ChatEndpoint> Group=onlineGroups.get(KeyGroup);
            if (Group==null) {
                //创建新的group
               Group =new ConcurrentHashMap<>();
            }
            //把当前用户放到他对应的组中
            Group.put(loginUser.getUsername(),this);
            //将Group与Key对应塞回onlineGroups
            onlineGroups.put(KeyGroup,Group);

            onlineUsers.put(loginUser.getUsername(), this);
            //然后将当前在线的该组的所有用户的用户名推送给所有用户
            //1.获取消息
            String Groupmessage=MessageUtils.getGroupMessage(true,KeyGroup,getGroupNames(KeyGroup),false,null,null,null) ;

//            String message = MessageUtils.getMessage(true, null, getNames());
            //2.调用方法进行系统推送
            System.out.println(onlineGroups.get(KeyGroup));
//            broadcastAllUsers(message);
            broadcastGroupUsers(Groupmessage,KeyGroup);
            System.out.println("推送"+KeyGroup+"登陆消息" + Groupmessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void broadcastAllUsers(String message){
        //要将该消息推送给所有客户端
        Set<String> names=onlineUsers.keySet();
        for (String name : names){
            ChatEndpoint chatEndpoint= onlineUsers.get(name);
            //Remote中有sendText方法可以用来传递数据
            try {
                chatEndpoint.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void broadcastGroupUsers(String message, java.lang.String KeyGroup){
        //小组成员
        Map<String,ChatEndpoint> Group=onlineGroups.get(KeyGroup);
        Set<String> names=Group.keySet();
        for (String name : names){
            ChatEndpoint chatEndpoint = Group.get(name);

            try {
                chatEndpoint.session.getBasicRemote().sendText(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private Set<String> getNames(){
        return onlineUsers.keySet();
    }
    private Set<String> getGroupNames(String KeyGroup){
        return onlineGroups.get(KeyGroup).keySet();
    }
    @OnMessage
    public void onMessage(String message, Session session){
        //将JSON数据message转换成message对象
        if (message=="ping"){

        }else {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Message mess = mapper.readValue(message, Message.class);
                if (mess.isat() == true) {
                    JsonObject jsonObject = new JsonObject();
                    String username = mess.getSender();
                    jsonObject.addProperty("groupid", new GroupServiceImpl().queryuserGroupid(username));
                    jsonObject.addProperty("toName", mess.getToName());
                    jsonObject.addProperty("message", mess.getMessage());
                    jsonObject.addProperty("isgroup", mess.isGroup());
                    jsonObject.addProperty("isat", mess.isat());
                    jsonObject.addProperty("sender", mess.getSender());
                    jsonObject.addProperty("atwhos", new Gson().toJson(mess.getAtwhos()));
                    jsonObject.addProperty("Time",new Gson().toJson(mess.getDate()));
                    //把上面的数据存到数据库相应位置中!
                    String json = new Gson().toJson(jsonObject);
                    MessageService messageService = new MessageServiceImpl();
                    messageService.saveMessage(json);
                } else {
                    JsonObject jsonObject = new JsonObject();
                    String username = mess.getSender();
                    jsonObject.addProperty("groupid", new GroupServiceImpl().queryuserGroupid(username));
                    jsonObject.addProperty("toName", mess.getToName());
                    jsonObject.addProperty("message", mess.getMessage());
                    jsonObject.addProperty("isgroup", mess.isGroup());
                    jsonObject.addProperty("isat", mess.isat());
                    jsonObject.addProperty("sender", mess.getSender());
                    jsonObject.addProperty("atwhos", new Gson().toJson(mess.getAtwhos()));
                    //把上面的数据存到数据库相应位置中!
                    String json = new Gson().toJson(jsonObject);
                    MessageService messageService = new MessageServiceImpl();
                    messageService.saveMessage(json);
                }
                System.out.println("收到数据" + mess.isGroup() + mess.getToName() + mess.isat() + mess.getAtwhos());
                if (false == mess.isGroup()) {
                    //不是群发消息
                    System.out.println("不是群发消息");
                    //获取要将数据发送给的指定用户
                    String toName = mess.getToName();
                    //获取消息数据
                    String data = mess.getMessage();
                    //获取当前登陆的用户
                    User loginUser = (User) httpSession.getAttribute("User");
                    String resultMessage = MessageUtils.getMessage(false, loginUser.getUsername(), data);
                    //获得对应的Session
                    System.out.println("发送给" + toName + "用户" + resultMessage);
                    onlineUsers.get(toName).session.getBasicRemote().sendText(resultMessage);
                } else {
                    //群发消息
                    System.out.println("是群发消息");
                    //获取要将数据发送给的指定小组
                    String KeyGroup = mess.getToName();
                    //获取消息
                    String data = mess.getMessage();
                    String resultMessage = MessageUtils.getGroupMessage(false, KeyGroup, data, mess.isat(), mess.getAtwhos(), mess.getSender(),mess.getDate());
                    System.out.println("发送给" + KeyGroup + "小组" + resultMessage + "有无at？" + mess.isat() + "at了谁？" + mess.getAtwhos());
                    //获取对应的session发送数据 sendToGroup
                    broadcastGroupUsers(resultMessage, KeyGroup);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @OnClose
    public void onClose(Session session){
            //从容器中删除指定用户
        //获取当前登陆的用户
        User loginUser = (User)httpSession.getAttribute("User");
        //根据名字删除
        onlineGroups.get(KeyGroup).remove(loginUser.getUsername());
        onlineUsers.remove(loginUser.getUsername());
        java.lang.String Groupmessage=MessageUtils.getGroupMessage(true,KeyGroup,getGroupNames(KeyGroup),false,null,null,null) ;

//            String message = MessageUtils.getMessage(true, null, getNames());
        //2.调用方法进行系统推送
        System.out.println(onlineGroups.get(KeyGroup));
//            broadcastAllUsers(message);
        broadcastGroupUsers(Groupmessage,KeyGroup);
    }

}

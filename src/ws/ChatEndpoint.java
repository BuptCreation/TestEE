package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Message;
import pojo.User;
import utils.MessageUtils;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//相对于springboot缺少了Bean注入
@ServerEndpoint(value="/chat",configurator = GetHttpSessionConfigurator.class)
public class ChatEndpoint {

    //用来存储每个客户端对象对应的ChatEndpoint对象 string为用户名 ChatEndpoint对应一个终端
    private static Map<String,ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();

    //声明session对象 通过该对象可以发送消息给指定的用户，由于每一个ChatEndpoint都需要一个session
    private Session session;

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

            onlineUsers.put(loginUser.getUsername(), this);
            //然后将当前在线的所有用户的用户名推送给所有用户
            //1.获取消息

            String message = MessageUtils.getMessage(true, null, getNames());
            //2.调用方法进行系统推送
            System.out.println(message);
            broadcastAllUsers(message);
            System.out.println("推送登陆消息" + message);
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


    private Set<String> getNames(){
        return onlineUsers.keySet();
    }
    @OnMessage
    public void onMessage(String message,Session session){
        //将JSON数据message转换成message对象
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message mess = mapper.readValue(message, Message.class);
            //获取要将数据发送给的指定用户
            String toName = mess.getToName();
            //获取消息数据
            String data = mess.getMessage();
            //获取当前登陆的用户
            User loginUser = (User)httpSession.getAttribute("User");
           String resultMessage = MessageUtils.getMessage(false,loginUser.getUsername(),data);
            //获得对应的Session
            onlineUsers.get(toName).session.getBasicRemote().sendText(resultMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @OnClose
    public void onClose(Session session){
            //从容器中删除指定用户
        //获取当前登陆的用户
        User loginUser = (User)httpSession.getAttribute("User");
        //根据名字删除
        onlineUsers.remove(loginUser.getUsername());
        String message = MessageUtils.getMessage(true,null,getNames());
        broadcastAllUsers(message);
    }

}

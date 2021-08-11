package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Message;
import pojo.String;
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
    private static Map<java.lang.String,ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();
    //!!      用来存储各个组
    private static Map<java.lang.String,Map<java.lang.String,ChatEndpoint>> onlineGroups = new ConcurrentHashMap<>();
    //声明session对象 通过该对象可以发送消息给指定的用户，由于每一个ChatEndpoint都需要一个session
    private Session session;
    //声明小组用来存储该session属于哪一个组
    private java.lang.String KeyGroup;
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
            String loginUser = (String) httpSession.getAttribute("User");
            //将登陆的用户加入group
            int groupid=1;
            java.lang.String groupteacherUsername="teacher168";
            KeyGroup=groupid+groupteacherUsername;//为了确定唯一的group,必须如此做，将id与用户名相加
            Map<java.lang.String,ChatEndpoint> Group=onlineGroups.get(KeyGroup);
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
            java.lang.String Groupmessage=MessageUtils.getGroupMessage(true,KeyGroup,getGroupNames(KeyGroup)) ;

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
    private void broadcastAllUsers(java.lang.String message){
        //要将该消息推送给所有客户端
        Set<java.lang.String> names=onlineUsers.keySet();
        for (java.lang.String name : names){
            ChatEndpoint chatEndpoint= onlineUsers.get(name);
            //Remote中有sendText方法可以用来传递数据
            try {
                chatEndpoint.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void broadcastGroupUsers(java.lang.String message, java.lang.String KeyGroup){
        //小组成员
        Map<java.lang.String,ChatEndpoint> Group=onlineGroups.get(KeyGroup);
        Set<java.lang.String> names=Group.keySet();
        for (java.lang.String name : names){
            ChatEndpoint chatEndpoint = Group.get(name);

            try {
                chatEndpoint.session.getBasicRemote().sendText(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private Set<java.lang.String> getNames(){
        return onlineUsers.keySet();
    }
    private Set<java.lang.String> getGroupNames(java.lang.String KeyGroup){
        return onlineGroups.get(KeyGroup).keySet();
    }
    @OnMessage
    public void onMessage(java.lang.String message, Session session){
        //将JSON数据message转换成message对象
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message mess = mapper.readValue(message, Message.class);
            System.out.println("收到数据"+mess.isGroup()+mess.getToName());
            if (false == mess.isGroup()) {
                //不是群发消息
                System.out.println("不是群发消息");
                //获取要将数据发送给的指定用户
                java.lang.String toName = mess.getToName();
                //获取消息数据
                java.lang.String data = mess.getMessage();
                //获取当前登陆的用户
                String loginUser = (String) httpSession.getAttribute("User");
                java.lang.String resultMessage = MessageUtils.getMessage(false, loginUser.getUsername(), data);
                //获得对应的Session
                System.out.println("发送给"+toName+"用户"+resultMessage);
                onlineUsers.get(toName).session.getBasicRemote().sendText(resultMessage);
            }else {
                //群发消息
                System.out.println("是群发消息");
                //获取要将数据发送给的指定小组
                java.lang.String KeyGroup = mess.getToName();
                //获取消息
                java.lang.String data = mess.getMessage();
                java.lang.String resultMessage = MessageUtils.getGroupMessage(false,KeyGroup,data);
                System.out.println("发送给"+KeyGroup+"小组"+resultMessage);
                //获取对应的session发送数据 sendToGroup
                broadcastGroupUsers(resultMessage,KeyGroup);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @OnClose
    public void onClose(Session session){
            //从容器中删除指定用户
        //获取当前登陆的用户
        String loginUser = (String)httpSession.getAttribute("User");
        //根据名字删除
        onlineGroups.get(KeyGroup).remove(loginUser.getUsername());
        onlineUsers.remove(loginUser.getUsername());
        java.lang.String Groupmessage=MessageUtils.getGroupMessage(true,KeyGroup,getGroupNames(KeyGroup)) ;

//            String message = MessageUtils.getMessage(true, null, getNames());
        //2.调用方法进行系统推送
        System.out.println(onlineGroups.get(KeyGroup));
//            broadcastAllUsers(message);
        broadcastGroupUsers(Groupmessage,KeyGroup);
    }

}

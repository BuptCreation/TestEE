package ws;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    @OnOpen
    public void onOpen(Session session, EndpointConfig config){

    }
    @OnMessage
    public void onMessage(String message,Session session){

    }
    @OnClose
    public void onClose(Session session){

    }

}

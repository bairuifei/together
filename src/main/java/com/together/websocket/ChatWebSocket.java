package com.together.websocket;

import com.together.util.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;

/**
 * Created by BRF on 2017-04-06.
 */
@ServerEndpoint("/chatWebSocket/{from}/{to}")
@Component
public class ChatWebSocket {
    Logger logger = LoggerFactory.getLogger(ChatWebSocket.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("from") String from,@PathParam("to") String to){
        SessionUtils.put(from,session);
        logger.debug("有新加入连接！当前在线人数为："+SessionUtils.clients.size());
        sendInfo(from+"已上线",from);
        //判断to是否在线
        boolean exist = SessionUtils.hasConnection(to);
        if(!exist){
            sendMessage(to+"不在线,请稍后联系",SessionUtils.get(from));
        }
    }

    @OnClose
    public void onClose(@PathParam("from") String from){
        SessionUtils.remove(from);
        logger.debug("有连接关闭！当前在线人数为："+SessionUtils.clients.size());
        sendInfo(from+"已下线",from);
    }

    @OnMessage
    public void onMessage(String msg,@PathParam("from") String from,@PathParam("to") String to){
        logger.debug("来自客户端消息："+msg);
        //判断to是否在线
        boolean exist = SessionUtils.hasConnection(to);
        if (exist){
            sendMessage(from+"："+msg,SessionUtils.get(to));
        }else{
            sendMessage(to+"不在线,请稍后联系",SessionUtils.get(from));
        }
    }

    @OnError
    public void onError(Session session, Throwable error,@PathParam("from") String from){
        SessionUtils.remove(from);
        logger.debug("发生错误");
        error.printStackTrace();
        sendInfo(from+"已下线",from);
    }

    public void sendMessage(String message,Session session) {
//        同步消息发送（可能会阻塞）
//        session.getBasicRemote().sendText(message);
//        异步消息发送（推荐）
        session.getAsyncRemote().sendText(message);
    }

    //    群发自定义消息
    public static void sendInfo(String message,String from){
        Map<String, Session> clients = SessionUtils.clients;
        for (Session session : clients.values()) {
            try {
                if(clients.get(from)!=session){
                    session.getAsyncRemote().sendText(message);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}

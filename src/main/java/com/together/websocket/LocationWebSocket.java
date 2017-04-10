package com.together.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by BRF on 2017-04-06.
 */
@ServerEndpoint("/locationWebSocket")
@Component
public class LocationWebSocket {
    Logger logger = LoggerFactory.getLogger(LocationWebSocket.class);
//    连接数量
    private static int linkCount = 0;
//    CopyOnWriteArraySet线程安全Set--http://ifeve.com/tag/copyonwritearrayset/，用来存放每个客户端对应的socket对象
    private static CopyOnWriteArraySet<LocationWebSocket> webSockets = new CopyOnWriteArraySet<LocationWebSocket>();
//    与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        webSockets.add(this);
        addOnlineCount();
        this.session = session;
        logger.info("有新加入连接！当前在线人数为："+getOnlineCount());
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        subOnlineCount();
        logger.info("有连接关闭，当前在线人数为："+getOnlineCount());
    }

    @OnMessage
    public void onMessage(String msg,Session session){
        logger.info("来自客户端消息："+msg);
    }

    @OnError
    public void onError(Session session, Throwable error){
        logger.info("发生错误");
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
//        同步消息发送（可能会阻塞）
//        this.session.getBasicRemote().sendText(message);
//        异步消息发送（推荐）
        this.session.getAsyncRemote().sendText(message);
    }

//    群发自定义消息
    public static void sendInfo(String message) throws IOException {
        for (LocationWebSocket item : webSockets) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized void addOnlineCount() {
        LocationWebSocket.linkCount++;
    }

    public static synchronized void subOnlineCount() {
        LocationWebSocket.linkCount--;
    }

    public static synchronized int getOnlineCount() {
        return linkCount;
    }
}
